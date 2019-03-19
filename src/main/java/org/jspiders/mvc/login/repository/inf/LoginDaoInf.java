package org.jspiders.mvc.login.repository.inf;

import org.jspiders.mvc.login.model.UserDTO;

public interface LoginDaoInf {

	default public UserDTO login(String id) {
		return null;
	}

	default public UserDTO login(String id, String password) {
		return null;
	}

}
