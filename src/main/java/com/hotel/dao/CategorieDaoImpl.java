package com.hotel.dao;

import java.util.List;

import com.hotel.models.Categorie;
import com.hotel.utils.Helpers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class CategorieDaoImpl implements Dao<Categorie> {
	
	//TODO: Check the name: is it Categorie or Categories
	public static final String SELECT_ALL = "SELECT obj FROM Categorie obj";
	private EntityManagerFactory factory;
	

	public CategorieDaoImpl() {
		factory = Helpers.getEntityManagerFactory();
	}

	@SuppressWarnings("unchecked")
	public List<Categorie> getAll() {
		EntityManager em = null;
		List<Categorie> obj = null;
		em = factory.createEntityManager();
		em.getTransaction().begin();
		obj = em.createQuery(SELECT_ALL).getResultList();
		em.getTransaction().commit();
		
		return obj;
	}

	public Categorie getById(int id) {
		Categorie obj;
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		obj = em.find(Categorie.class, id);
		em.getTransaction().commit();
		
		return obj;
	}

	public void create(Categorie obj) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}

	public void update(Categorie obj) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
	}

	public void delete(Categorie obj) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		if(em.contains(obj))
			obj = em.merge(obj);
		em.remove(obj);
		em.getTransaction().commit();
	}

}
