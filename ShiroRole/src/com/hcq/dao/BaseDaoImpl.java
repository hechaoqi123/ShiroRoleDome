package com.hcq.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	
   private Class cla;
	{
		  ParameterizedType type= (ParameterizedType) this.getClass().getGenericSuperclass();
		  Type[] types=type.getActualTypeArguments();
		  cla=(Class) types[0];
	} 
	@Autowired
   private HibernateTemplate hibernateTemplate;
	
	@Override
	public void save(T entity) {
		hibernateTemplate.save(entity);
	}
	
	@Override
	public void delete(T entity) {
		hibernateTemplate.delete(entity);
	}
	
	@Override
	public void update(T entity) {
		hibernateTemplate.update(entity);
	}
	
	@Override
	public List<T> getAll() {
		DetachedCriteria criteria=DetachedCriteria.forClass(cla);
		return (List<T>) hibernateTemplate.findByCriteria(criteria);
	}
	
	@Override
	public T getOne(int id) {
		return (T) hibernateTemplate.get(cla, id);
	}
	
	public List<T> findBy(T entity){
		return hibernateTemplate.findByExample(entity);
	}

	@Override
	public List<T> findByCritiria(DetachedCriteria criteria) {
		List list= hibernateTemplate.findByCriteria(criteria);
		return list;
	}
	
}
