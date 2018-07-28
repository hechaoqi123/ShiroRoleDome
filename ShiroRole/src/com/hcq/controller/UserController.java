package com.hcq.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcq.entity.User;
import com.hcq.service.UserBiz;

@Controller
public class UserController {
	@Autowired
	UserBiz biz;
  //用户注册	
  @RequestMapping("register")
  public String register(User user){
	  if(biz.register(user)){
		  return "login"; 
	  }else{
		  return "Error";
	  }
  }
  //用户登陆
  @RequestMapping("login")
  public String login(User user){
	 Subject subject = SecurityUtils.getSubject();
	 String username = user.getName();
	 String password = user.getPassword();
	 UsernamePasswordToken token=new UsernamePasswordToken(username,password);
	 try {
	   subject.login(token);
	   return "forward:delegating";
	} catch (Exception e) {
		e.printStackTrace();
		return "Error";
	}
  }
  //查询
  @RequestMapping("delegating")
  public String delegating(Model model){
	  String userName=SecurityUtils.getSubject().getPrincipal().toString();
      Map<String, List> map = biz.getPowers(userName);
      model.addAttribute("menu", map);
      System.out.println(map);
	  return "Home";
  }
}
