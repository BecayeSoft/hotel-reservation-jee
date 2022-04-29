package com.hotel.dao;

import java.util.List;

import com.hotel.models.User;
import com.hotel.utils.Helpers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class UserDaoImpl implements Dao<User>, UserDao {
	
	//TODO: Check the name: is it User or Personnes
	public static final String SELECT_ALL = "SELECT obj FROM User obj";
	private EntityManagerFactory factory;
	

	public UserDaoImpl() {
		factory = Helpers.getEntityManagerFactory();
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		EntityManager em = null;
		List<User> obj = null;
		em = factory.createEntityManager();
		em.getTransaction().begin();
		obj = em.createQuery(SELECT_ALL).getResultList();
		em.getTransaction().commit();
		
		return obj;
	}

	public User getById(String id) {
		User obj;
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		obj = em.find(User.class, id);
		em.getTransaction().commit();
		
		return obj;
	}

	/**
	 * Create user
	 * Sign up
	 */
	public void create(User obj) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}

	public void update(User obj) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
	}

	public void delete(User obj) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		if(em.contains(obj))
			obj = em.merge(obj);
		em.remove(obj);
		em.getTransaction().commit();
	}

	public void findUserById() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Login user
	 */
	public User loginUser(String username, String password) {
		EntityManager em = null;
		User user = null;
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("SELECT u from user WHERE u.username=:username and u.password = :password");
		query.setParameter("username", user);
		query.setParameter("username", password);
		
		return user;
	}

}
