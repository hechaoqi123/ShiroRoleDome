package com.aaa.biz;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.StudentDao;
import com.aaa.entity.Student;
@Service
@Transactional
public class StudentBizImpl implements StudentBiz {
    @Autowired
    private StudentDao dao;
    public void save(Student stu){
    	dao.save(stu);
    	stu.setSname("oo");
    	dao.update(stu);
    	int a=1/0;
    	dao.delete(dao.getOne(stu.getSid()));
    	System.out.println("Êý¾ÝÁ¿:"+dao.getAll().size());
    	
    }
}
