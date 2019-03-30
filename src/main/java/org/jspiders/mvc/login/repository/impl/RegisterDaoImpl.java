package org.jspiders.mvc.login.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jspiders.mvc.login.model.UserDTO;
import org.jspiders.mvc.login.repository.inf.RegisterDaoInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RegisterDaoImpl implements RegisterDaoInf {

	@Autowired
	private SessionFactory sf;

	public void save(UserDTO dto) {

		Session se = sf.getCurrentSession();
		se.save(dto);
	}
}
