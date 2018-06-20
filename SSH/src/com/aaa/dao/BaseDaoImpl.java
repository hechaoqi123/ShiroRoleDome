package com.aaa.dao;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public abstract class BaseDaoImpl<T> implements BaseDao<T>  {
	  @Autowired
	  private HibernateTemplate hibernateTemplate;
	  private Class<T> cla;
	  //获取泛型实参
	  {
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		Type types[]=type.getActualTypeArguments();//父类的真实参数
		cla=(Class) types[0];//将参数转换为Class
	  }
	@Override
	public void save(T entity){
		  hibernateTemplate.save(entity);
	  };
	@Override
	public void delete(T entity){
		  hibernateTemplate.delete(entity);
	  };
	@Override
	public void update(T entity){
		  hibernateTemplate.update(entity);
	  };
	@Override
	public T getOne(int id){
		return hibernateTemplate.get(cla, id);
		  
	  };
	@Override
	public List<T> getAll() {
		return (List<T>) hibernateTemplate.find("From "+cla.getSimpleName());
	  }
	  
}
