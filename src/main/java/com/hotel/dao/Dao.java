package com.hotel.dao;

import java.util.List;

public interface Dao<T> {

	List<T> getAll();
	
	T getById(int id);
	
	void create(T obj);

    void update(T obj);

    void delete(T obj);
    
}
