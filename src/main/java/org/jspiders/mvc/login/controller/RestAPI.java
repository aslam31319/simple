package org.jspiders.mvc.login.controller;

import java.util.List;

import org.jspiders.mvc.login.model.PlaceDTO;
import org.jspiders.mvc.login.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestAPI {

	@Autowired
	private PlaceService placeService;

	// Feching all data using Joson
	@RequestMapping(value = "rest/all", method = RequestMethod.POST)
	public @ResponseBody List<PlaceDTO> getAllPlace() {

		System.out.println("Fetching All Country");

		return placeService.getAllPlace();
	}

	// Get Rest for getting all country Using normal String Array

	@RequestMapping(value = "rest", method = RequestMethod.POST)
	public @ResponseBody List<String> getCountry() {

		System.out.println("Fetching All Rows");

		return placeService.getCountry();
	}

	// Get Rest for getting State for provided Country
	@RequestMapping(value = "rest/{country}", method = RequestMethod.POST)
	public @ResponseBody List<PlaceDTO> getState(@PathVariable(value = "country") String country) {

		System.out.println("Fetching State of : " + country);
		return placeService.getState(country);
	}

	// Get Rest for getting City for provided State using Json
	@RequestMapping(value = "rest/{country}/{state}", method = RequestMethod.POST)
	public @ResponseBody List<PlaceDTO> getCity(@PathVariable(value = "country") String country,
			@PathVariable(value = "state") String state) {

		System.out.println("Fetching City of : " + country + " & " + state);
		return placeService.getCity(country, state);
	}

	// Adding Place information to DB

	// Post Rest for adding single place
	@RequestMapping(value = "rest/add/{country}", consumes = { "application/json" }, method = RequestMethod.POST)
	public @ResponseBody String addPlace(@RequestBody PlaceDTO dto, @PathVariable String country) {
		System.out.println("Adding Place to DB of : " + country);

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
		System.out.println("Adding List of Place to DB");

		if (placeService.isAddListPlace(dto)) {
			return "Added New List of Place";
		} else {
			System.out.println("faild");
			return "Faild to Add";
		}

	}

}
