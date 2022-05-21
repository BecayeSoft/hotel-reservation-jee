package com.hotel.dao;

import java.util.List;

import com.hotel.models.Categorie;
import com.hotel.models.Chambre;
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
		List<User> obj = null;
		
		em = factory.createEntityManager();
		Query query = em.createQuery("SELECT u FROM User u WHERE u.username=:username AND u.password=:password");
		query.setParameter("username", username); 
		query.setParameter("password", password); 
		
		obj = query.getResultList();
		
		if (obj.size() == 0) {
			System.out.println("User not found");
			return null;
		}
		
		System.out.println("\n-----------------------\nUserDao->Results\n");
		obj.forEach(System.out::println);
		
		return obj.get(0);
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
