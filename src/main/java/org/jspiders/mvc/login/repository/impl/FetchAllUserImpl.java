package org.jspiders.mvc.login.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jspiders.mvc.login.model.UserDTO;
import org.jspiders.mvc.login.repository.inf.FetchAllUserInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Repository("fetch")
@Transactional(isolation=Isolation.REPEATABLE_READ)
public class FetchAllUserImpl implements FetchAllUserInf {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<UserDTO> fetchAll() {
		Session se= sf.getCurrentSession();
		Query<UserDTO> qry=se.createQuery("from UserDTO");
		return qry.list();
	}
	

}
