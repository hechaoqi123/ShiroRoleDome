package com.aaa.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;
//Relam:访问数据库
public class Realm extends AuthenticatingRealm {
	/*
	 * 1.doGetAuthenticationInfo方法：获取认证信息，进行认证
	 * 
	 * 2.AuthenticationInfo接口：可以使用SimpleAuthenticationInfo实现类，封装用户信息
	 * 
	 * 3.AuthenticationToken参数：认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
           
		UsernamePasswordToken upToken=(UsernamePasswordToken) token;
		String username=upToken.getUsername();
		 //链接数据库进行查询
		  try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/first", "root", "root");
		   PreparedStatement pstm=conn.prepareStatement("select * from user where name=?");
		    pstm.setString(1, username); 
		    ResultSet rs=pstm.executeQuery();
		    if(rs.next()){
		    		Object principal=username;
			    	Object credentials=rs.getString(3);
			    	String relamName=this.getName();
			    	SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(principal,credentials,relamName);
			       return info;
		    }else{
		    	throw new RuntimeException("用户不存在");
		    }
		  } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
