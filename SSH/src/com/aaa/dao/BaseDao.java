package com.aaa.dao;

import java.util.List;

public interface BaseDao<T> {

	void save(T entity);

	void delete(T entity);

	void update(T entity);

	T getOne(int id);

	List<T> getAll();

}