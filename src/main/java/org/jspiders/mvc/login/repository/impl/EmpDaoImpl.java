package org.jspiders.mvc.login.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jspiders.mvc.login.model.EmpDTO;
import org.jspiders.mvc.login.repository.inf.EmpDaoInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(isolation=Isolation.REPEATABLE_READ)
public class EmpDaoImpl implements EmpDaoInf {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<EmpDTO> getAllEmp() {
		Session se=sf.getCurrentSession();
		Query<EmpDTO> qry=se.createQuery("From EmpDTO");
		return qry.list();
	}

}
