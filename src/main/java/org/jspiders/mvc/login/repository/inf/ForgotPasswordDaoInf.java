package org.jspiders.mvc.login.repository.inf;

public interface ForgotPasswordDaoInf {
	default public String getUser(String email) {
		return null;
	}
}
