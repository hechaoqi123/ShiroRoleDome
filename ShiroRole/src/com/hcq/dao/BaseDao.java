package com.hcq.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
  //增
	void save(T entity);
  //删
	void delete(T entity);
  //改 
	void update(T entity);
  //查询所有
	List<T> getAll();
  //单体查询
	T getOne(int id);
  //样例查询
	List<T> findBy(T entity);
  //条件查询
	List<T> findByCritiria(DetachedCriteria criteria);
}
