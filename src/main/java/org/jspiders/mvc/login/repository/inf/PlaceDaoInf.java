package org.jspiders.mvc.login.repository.inf;

import java.util.List;

import org.jspiders.mvc.login.model.PlaceDTO;

public interface PlaceDaoInf {
	public List<String> getCountry();
	public List<PlaceDTO> getState(String country);
	public List<PlaceDTO> getCity(String Country,String State);
	public boolean addPlace(PlaceDTO dto);
	public boolean addListOfPlace(List<PlaceDTO> listDto);
	public List<PlaceDTO> getAllPlace();

}
