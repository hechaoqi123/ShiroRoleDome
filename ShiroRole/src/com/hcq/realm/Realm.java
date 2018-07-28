package com.hcq.realm;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.Md5CredentialsMatcher;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcq.dao.UserDao;
import com.hcq.entity.User;
@Component
public class Realm extends AuthenticatingRealm{
	@Autowired
	UserDao dao;
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken subject=(UsernamePasswordToken) token;
		String name=subject.getUsername();
		User user=new User();
		user.setName(name);
		List<User> list=dao.findBy(user);
		if(list.isEmpty()){
			return null;
		}else{
			String password=list.get(0).getPassword();
			String id=list.get(0).getId().toString();//ÑÎÖµ
			ByteSource salt=ByteSource.Util.bytes(id);
			SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(name,password,salt,this.getName());
			return info;
		}
	}

}
