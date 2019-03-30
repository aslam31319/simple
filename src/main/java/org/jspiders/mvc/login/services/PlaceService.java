package org.jspiders.mvc.login.services;

import java.util.List;

import org.jspiders.mvc.login.model.PlaceDTO;
import org.jspiders.mvc.login.repository.inf.PlaceDaoInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {

	@Autowired
	private PlaceDaoInf placeDao;

	public boolean isAddPlace(PlaceDTO dto) {
		return placeDao.addPlace(dto);
	}

	public boolean isAddListPlace(List<PlaceDTO> dto) {
		return placeDao.addListOfPlace(dto);
	}

	public List<String> getCountry() {
		return placeDao.getCountry();
	}

	public List<PlaceDTO> getState(String country) {
		System.err.println("inside getstate of service");
		return placeDao.getState(country);
	}
	public List<PlaceDTO> getCity(String country,String state) {
		return placeDao.getCity(country,state);
	}

	public List<PlaceDTO> getAllPlace() {
		return placeDao.getAllPlace();
	}
}
