package org.jspiders.mvc.login.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jspiders.mvc.login.repository.inf.ForgotPasswordDaoInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ForgotPasswordDaoImpl implements ForgotPasswordDaoInf {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public String getUser(String email) {
		Session se=sf.getCurrentSession();
		String hql="select P.password from UserDTO P where email=:email";
		Query<String> qry=se.createQuery(hql);
		qry.setParameter("email", email);
		String pass=qry.uniqueResult();
		return pass;
	}

}
