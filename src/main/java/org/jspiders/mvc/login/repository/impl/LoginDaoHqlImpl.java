package org.jspiders.mvc.login.repository.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jspiders.mvc.login.model.UserDTO;
import org.jspiders.mvc.login.repository.inf.LoginDaoInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("hql")
public class LoginDaoHqlImpl implements LoginDaoInf {

	@Autowired
	SessionFactory sf;

	@Override
	public UserDTO login(String email, String password) {

		System.out.println("hql");
		Session se = sf.openSession();
		Query<UserDTO> qry = se.createQuery("From UserDTO dto where dto.email = :email and dto.password=:password");
		qry.setParameter("email", email);
		qry.setParameter("password", password);
		
		try {
			UserDTO dto=qry.uniqueResult();
			if(dto==null) {
				return new UserDTO();
			}
			return dto;

		} catch (HibernateException e) {
			e.printStackTrace();
			return new UserDTO();
		} finally {
			se.close();
		}
	}

}
