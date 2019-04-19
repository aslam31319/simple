package org.jspiders.mvc.login.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jspiders.mvc.login.model.UserDTO;
import org.jspiders.mvc.login.repository.inf.ResetPasswordInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ResetPasswordImpl implements ResetPasswordInf {
	@Autowired
	private SessionFactory sf;
	
	
	public boolean resetPassword(String email,String password) {
		
		System.out.println(password);
		
		Session se = sf.getCurrentSession();
		Query<UserDTO> qry = se.createQuery("update UserDTO dto set dto.password=:password where dto.email = :email");
		qry.setParameter("password", password);
		qry.setParameter("email", email);
		
		int row=qry.executeUpdate();
		
		return true;
	}
}
