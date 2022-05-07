package com.hotel.dao;

import java.util.List;

import com.hotel.models.Categorie;
import com.hotel.models.Chambre;
import com.hotel.utils.Helpers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class ChambreDaoImpl implements Dao<Chambre> {

	public static final String SELECT_ALL = "SELECT obj FROM Chambre obj";
	private EntityManagerFactory factory;
	

	public ChambreDaoImpl() {
		factory = Helpers.getEntityManagerFactory();
	}

	@SuppressWarnings("unchecked")
	public List<Chambre> getByCategory(int id) {
		EntityManager em = null;
		List<Chambre> obj = null;
		
		CategorieDaoImpl catDao = new CategorieDaoImpl();
		Categorie categorie = catDao.getById(id);
		
		em = factory.createEntityManager();
		Query query = em.createQuery("SELECT c FROM Chambre c WHERE c.categorie.id=:id");
		query.setParameter("id", categorie.getId()); 
		obj = query.getResultList();

		System.out.println("\n\n------------------\nChambres by categories\n------------------");
		obj.forEach(chambre -> System.out.println(chambre));
		//obj.forEach(System.out::println);
		
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public List<Chambre> getAll() {
		EntityManager em = null;
		List<Chambre> obj = null;
		em = factory.createEntityManager();
		em.getTransaction().begin();
		obj = em.createQuery(SELECT_ALL).getResultList();
		em.getTransaction().commit();
		
		return obj;
	}

	public Chambre getById(int id) {
		Chambre obj;
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		obj = em.find(Chambre.class, id);
		em.getTransaction().commit();
		
		return obj;
	}

	public void create(Chambre obj) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}

	public void update(Chambre obj) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
	}

	public void delete(Chambre obj) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		if(em.contains(obj))
			obj = em.merge(obj);
		em.remove(obj);
		em.getTransaction().commit();
	}

}
