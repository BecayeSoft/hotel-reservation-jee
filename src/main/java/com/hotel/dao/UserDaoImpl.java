package com.hotel.dao;

import com.hotel.models.User;
import com.hotel.utils.Helpers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class UserDaoImpl implements UserDao {
	
	public static final String SELECT_ALL = "SELECT obj FROM User obj";
	private EntityManagerFactory factory;
	

	public UserDaoImpl() {
		factory = Helpers.getEntityManagerFactory();
	}


	/**
	 * Create new user
	 * Sign up
	 */
	@Override
	public void saveUser(User user) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
	
	/**
	 * Login user
	 * Sign in
	 */
	@Override
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

	/**
	 * Get user by id
	 */
	/*
	@Override
	public User findUserById(int id) {
		User user;
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		user = em.find(User.class, id);
		em.getTransaction().commit();
		
		return user;
	}
	*/
}
