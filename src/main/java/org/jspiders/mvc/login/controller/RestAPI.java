package org.jspiders.mvc.login.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jspiders.mvc.login.model.PlaceDTO;
import org.jspiders.mvc.login.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest")
public class RestAPI {

	private static Logger log = LogManager.getLogger(RestAPI.class);
	@Autowired
	private PlaceService placeService;

	// Feching all data
	@GetMapping("/all")
	public List<PlaceDTO> getAllPlace() {

		log.info("Fetching all place");
		return placeService.getAllPlace();
	}

	// Get Rest for getting all country
	@GetMapping("/")
	public List<String> getCountry() {

		log.info("Fetching all country");
		return placeService.getCountry();
	}

	// Get Rest for getting State for provided Country
	@GetMapping("/{country}")
	public List<PlaceDTO> getState(@PathVariable(value = "country") String country) {

		log.info("Fetching all State for" + country);
		return placeService.getState(country);
	}

	// Get Rest for getting City for provided State
	@GetMapping("/{country}/{state}")
	public List<PlaceDTO> getCity(@PathVariable(value = "country") String country,
			@PathVariable(value = "state") String state) {

		log.info("Fetching all city for" + country + " " + state);
		return placeService.getCity(country, state);
	}

	// Adding Place information to DB

	// Post Rest for adding single place
	@PostMapping(path = "/add/{country}", consumes = "application/json")
	public String addPlace(@RequestBody PlaceDTO dto, @PathVariable String country) {

		log.info("Inserting single place");
		if (placeService.isAddPlace(dto)) {
			return "Added New Place";
		} else {
			System.out.println("faild");
			return "Faild to Add";
		}

	}

	// Post Rest for adding list of place
	@PostMapping(path = "/add", consumes = "application/json")
	public String addListpalce(@RequestBody List<PlaceDTO> dto) {

		log.info("inserting list of place");
		if (placeService.isAddListPlace(dto)) {
			return "Added New List of Place";
		} else {
			System.out.println("faild");
			return "Faild to Add";
		}

	}

}
