package com.hotel.dao;

import java.util.List;

import com.hotel.models.Categorie;
import com.hotel.models.Chambre;
import com.hotel.models.Reservation;
import com.hotel.models.User;
import com.hotel.utils.Helpers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

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

	public Reservation getById(int id) {
		Reservation obj;
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		obj = em.find(Reservation.class, id);
		em.getTransaction().commit();
		
		return obj;
	}
	
	public List<Reservation> getByUser(int id) {
		EntityManager em = null;
		List<Reservation> obj = null;
	
		User user = new UserDaoImpl().findUserById(id);
		
		em = factory.createEntityManager();
		Query query = em.createQuery("SELECT r FROM Reservation r WHERE r.user.id=:id");
		query.setParameter("id", user.getId()); 
		obj = query.getResultList();

		System.out.println("\n\n------------------\nReservations by user\n------------------");
		obj.forEach(System.out::println);
		
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
		Reservation current = null;
		if (!em.contains(obj)) {
		    current = em.merge(obj);
		}
		
		em.remove(current);
		em.getTransaction().commit();
	}

}
