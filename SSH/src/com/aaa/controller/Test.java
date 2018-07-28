package com.aaa.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Test {
   @RequestMapping()
   public String login(String name,String password,Model model){
	   System.out.println("*******************"+name+":"+password+"*********************");
	  //1.����subjectʵ��
	   Subject user=SecurityUtils.getSubject();
	  //2.�ж��û��Ƿ��¼
	   if(!user.isAuthenticated()){
		  UsernamePasswordToken token=new UsernamePasswordToken(name, password);
		  try {
			  user.login(token);
			  System.out.println("��¼�ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��¼ʧ��");
		}
	   }
	   return null;
	     //return "redirect:/unauthor";
   }
}
