package org.jspiders.mvc.login.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jspiders.mvc.login.model.UserDTO;
import org.jspiders.mvc.login.repository.inf.RegisterDaoInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RegisterDaoImpl implements RegisterDaoInf {

	@Autowired
	private SessionFactory sf;

	public boolean save(UserDTO dto) {

		Session se = sf.openSession();
		Transaction tx = se.beginTransaction();
		try {
			se.save(dto);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			se.close();
		}
	}
}
