package org.jspiders.mvc.login.repository.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jspiders.mvc.login.model.PlaceDTO;
import org.jspiders.mvc.login.repository.inf.PlaceDaoInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PlaceDaoImpl implements PlaceDaoInf {

	@Autowired
	private SessionFactory sf;

	@Override
	public List<String> getCountry() {
		Session se = sf.openSession();
		String hqlQry = "select distinct P.country from PlaceDTO P";
		Query<String> qry = se.createQuery(hqlQry);
		List<String> placeList = qry.list();
		return placeList;
	}

	@Override
	public List<PlaceDTO> getState(String country) {
		Session se = sf.openSession();
		String hqlQry = "select distinct P.state from PlaceDTO P where P.country= :country";
		Query<PlaceDTO> qry = se.createQuery(hqlQry);
		qry.setParameter("country", country);
		return qry.list();
	}

	@Override
	public List<PlaceDTO> getCity(String country, String state) {

		Session se = sf.openSession();
		String hqlQry = "select distinct P.city from PlaceDTO P where P.country= :country and P.state= :state";
		Query<PlaceDTO> qry = se.createQuery(hqlQry);
		qry.setParameter("country", country);
		qry.setParameter("state", state);
		return qry.list();
	}

	@Override
	public boolean addPlace(PlaceDTO dto) {

		Session se = sf.openSession();
		Transaction tx = se.beginTransaction();
		try {
			se.save(dto);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			se.close();
		}

	}

	public boolean addListOfPlace(List<PlaceDTO> listDto) {

		Session se = sf.openSession();
		Transaction tx = se.beginTransaction();
		try {
			for (PlaceDTO place : listDto) {
				se.save(place);
			}
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			se.close();
		}

	}

	@Override
	public List<PlaceDTO> getAllPlace() {
		Session se = sf.openSession();
		String hqlQry = "from PlaceDTO";
		Query<PlaceDTO> qry = se.createQuery(hqlQry);
		return qry.list();
	}

}
