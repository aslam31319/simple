package org.jspiders.mvc.login.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jspiders.mvc.login.model.PlaceDTO;
import org.jspiders.mvc.login.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestAPI {
	
	
	private static Logger log =LogManager.getLogger(RestAPI.class);
	@Autowired
	private PlaceService placeService;

	// Feching all data using Joson
	@RequestMapping(value = "rest/all", method = RequestMethod.POST)
	public @ResponseBody List<PlaceDTO> getAllPlace() {

		log.info("Fetching all place");
		return placeService.getAllPlace();
	}

	// Get Rest for getting all country Using normal String Array

	@RequestMapping(value = "rest", method = RequestMethod.POST)
	public @ResponseBody List<String> getCountry() {

		log.info("Fetching all country");
		return placeService.getCountry();
	}

	// Get Rest for getting State for provided Country
	@RequestMapping(value = "rest/{country}", method = RequestMethod.POST)
	public @ResponseBody List<PlaceDTO> getState(@PathVariable(value = "country") String country) {

		log.info("Fetching all State for"+country);
		return placeService.getState(country);
	}

	// Get Rest for getting City for provided State using Json
	@RequestMapping(value = "rest/{country}/{state}", method = RequestMethod.POST)
	public @ResponseBody List<PlaceDTO> getCity(@PathVariable(value = "country") String country,
			@PathVariable(value = "state") String state) {

		log.info("Fetching all city for"+country +" "+state );
		return placeService.getCity(country, state);
	}

	// Adding Place information to DB

	// Post Rest for adding single place
	@RequestMapping(value = "rest/add/{country}", consumes = { "application/json" }, method = RequestMethod.POST)
	public @ResponseBody String addPlace(@RequestBody PlaceDTO dto, @PathVariable String country) {

		log.info("Inserting single place");
		if (placeService.isAddPlace(dto)) {
			return "Added New Place";
		} else {
			System.out.println("faild");
			return "Faild to Add";
		}

	}

	// Post Rest for adding list of place
	@RequestMapping(value = "rest/add", consumes = { "application/json" }, method = RequestMethod.POST)
	public @ResponseBody String addListpalce(@RequestBody List<PlaceDTO> dto) {
		
		
		log.info("inserting list of place");
		if (placeService.isAddListPlace(dto)) {
			return "Added New List of Place";
		} else {
			System.out.println("faild");
			return "Faild to Add";
		}

	}

}
