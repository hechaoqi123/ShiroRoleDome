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
//Relam:�������ݿ�
public class Realm extends AuthenticatingRealm {
	/*
	 * 1.doGetAuthenticationInfo��������ȡ��֤��Ϣ��������֤
	 * 
	 * 2.AuthenticationInfo�ӿڣ�����ʹ��SimpleAuthenticationInfoʵ���࣬��װ�û���Ϣ
	 * 
	 * 3.AuthenticationToken��������֤��Ϣ
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
           
		UsernamePasswordToken upToken=(UsernamePasswordToken) token;
		String username=upToken.getUsername();
		 //�������ݿ���в�ѯ
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
		    	throw new RuntimeException("�û�������");
		    }
		  } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
