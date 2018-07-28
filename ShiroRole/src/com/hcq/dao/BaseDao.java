package com.hcq.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
  //��
	void save(T entity);
  //ɾ
	void delete(T entity);
  //�� 
	void update(T entity);
  //��ѯ����
	List<T> getAll();
  //�����ѯ
	T getOne(int id);
  //������ѯ
	List<T> findBy(T entity);
  //������ѯ
	List<T> findByCritiria(DetachedCriteria criteria);
}
