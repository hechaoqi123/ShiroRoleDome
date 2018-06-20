package com.aaa.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaa.biz.StudentBiz;
import com.aaa.entity.Student;


@Controller
public class Contro {
	@Autowired
	private StudentBiz biz;
   @RequestMapping("hello")
   public String hello(Student stu,Model model){
	   System.out.println(biz);
	   biz.save(stu);
	   model.addAttribute("user", "hello world!");
	   System.out.println("hello world£¡");
	   return "index";
   }
}
