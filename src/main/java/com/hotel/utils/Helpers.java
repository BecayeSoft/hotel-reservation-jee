package com.hotel.utils;


import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Helpers {

	private static EntityManagerFactory factory = null;

	public static EntityManagerFactory getEntityManagerFactory() {
		
		if (factory == null) {
			Map<String, String> props = new HashMap<String, String>();
			props.put("eclipselink.jdbc.user", "root");
			props.put("eclipselink.jdbc.password", "");
			props.put("eclipselink.jdbc.driver", "com.mysql.cj.jdbc.Driver");
			props.put("eclipselink.jdbc.url", "jdbc:mysql://localhost/hotel-jee");
			props.put("eclipselink.ddl-generation", "create-or-extend-tables");
			props.put("eclipselink.ddl-generation.output-mode", "database");
			
			factory = Persistence.createEntityManagerFactory("hotel_unit", props);
		}
		
		return factory;
	}
}
