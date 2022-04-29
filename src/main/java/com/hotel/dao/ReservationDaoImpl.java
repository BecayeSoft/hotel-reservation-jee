package com.hotel.dao;

import java.util.List;

import com.hotel.models.Reservation;
import com.hotel.utils.Helpers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class ReservationDaoImpl implements Dao<Reservation> {
	
	//TODO: Check the name: is it Reservation or Reservations
	public static final String SELECT_ALL = "SELECT obj FROM Reservation obj";
	private EntityManagerFactory factory;
	

	public ReservationDaoImpl() {
		factory = Helpers.getEntityManagerFactory();
	}

	@SuppressWarnings("unchecked")
	public List<Reservation> getAll() {
		EntityManager em = null;
		List<Reservation> obj = null;
		em = factory.createEntityManager();
		em.getTransaction().begin();
		obj = em.createQuery(SELECT_ALL).getResultList();
		em.getTransaction().commit();
		
		return obj;
	}

	public Reservation getById(String id) {
		Reservation obj;
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		obj = em.find(Reservation.class, id);
		em.getTransaction().commit();
		
		return obj;
	}

	public void create(Reservation obj) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}

	public void update(Reservation obj) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
	}

	public void delete(Reservation obj) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		if(em.contains(obj))
			obj = em.merge(obj);
		em.remove(obj);
		em.getTransaction().commit();
	}

}
