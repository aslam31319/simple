package org.jspiders.mvc.login.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jspiders.mvc.login.model.UserDTO;
import org.jspiders.mvc.login.repository.inf.LoginDaoInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


@Repository("hql")
@Transactional(isolation=Isolation.REPEATABLE_READ)
public class LoginDaoHqlImpl implements LoginDaoInf {

	@Autowired
	SessionFactory sf;

	@Override
	public UserDTO login(String email, String password) {

		System.out.println("hql");
		Session se = sf.getCurrentSession();
		Query<UserDTO> qry = se.createQuery("From UserDTO dto where dto.email = :email and dto.password=:password");
		qry.setParameter("email", email);
		qry.setParameter("password", password);
		
			UserDTO dto=qry.uniqueResult();
			return dto;

	}
	
	@Override
	public UserDTO login(String email) {
		System.out.println("hql");
		Session se = sf.getCurrentSession();
		Query<UserDTO> qry = se.createQuery("From UserDTO dto where dto.email = :email");
		qry.setParameter("email", email);
		
			UserDTO dto=qry.uniqueResult();
			return dto;
	}

}
