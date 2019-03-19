package org.jspiders.mvc.login.repository.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jspiders.mvc.login.model.UserDTO;
import org.jspiders.mvc.login.repository.inf.LoginDaoInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("normal")
public class LoginDaoImpl implements LoginDaoInf {

	@Autowired
	private SessionFactory sf;

	public UserDTO login(String email) {
		Session se = sf.openSession();
		try {
			return se.get(UserDTO.class, email);

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			se.close();
		}
	}

}
