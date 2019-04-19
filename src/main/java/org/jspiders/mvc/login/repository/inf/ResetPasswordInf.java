package org.jspiders.mvc.login.repository.inf;

public interface ResetPasswordInf {
	
	default public boolean resetPassword(String email , String password) {
		return false;
	}
}
