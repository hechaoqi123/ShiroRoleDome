package com.hcq.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcq.dao.PowerDao;
import com.hcq.dao.RolePowerDao;
import com.hcq.dao.UserDao;
import com.hcq.dao.UserRoleDao;
import com.hcq.entity.Power;
import com.hcq.entity.Role;
import com.hcq.entity.RolePower;
import com.hcq.entity.User;
import com.hcq.entity.UserRole;
@Service
public class UserBizImpl implements UserBiz {
	@Autowired
	UserDao dao;
	@Autowired
	UserRoleDao urDao;
	@Autowired
	RolePowerDao rpDao;
	@Autowired
	PowerDao powerDao;
  //用户注册
	@Transactional
	public boolean register(User user) {
		try {
			dao.save(user);
			//盐值加密
			ByteSource salt=ByteSource.Util.bytes(user.getId().toString());
			SimpleHash simpleHash = new SimpleHash("MD5", user.getPassword(),salt, 1024);
			user.setPassword(simpleHash.toHex());
			System.out.println(simpleHash.toHex());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
  //用户登陆
	public void login(UsernamePasswordToken token){
		Subject subject=SecurityUtils.getSubject();
		subject.login(token);
	}
  //查询用户可访问资源
	@Override
	public Map<String, List> getPowers(String UserName) {
		User user=getUser(UserName);//获取用户信息
		List<Role> roles=getRoles(user);//获取用户角色
		Map<String, List> map=new HashMap<String, List>();
		for (Role role : roles) {//遍历用户角色
		   List<Power> menus=getMenu(role);//资源菜单
		   for (Power power : menus) {
			map.put(power.getRemark(), getList(power));
		 }
		}
		return map;
	}
	//通过用户名查询具体用户
    private User getUser(String name) {
	      User entity=new User();
	      entity.setName(name);
		 List<User> list= dao.findBy(entity);
		 if(list.isEmpty()){
			 return null;
		 }else{
			 return list.get(0);
		 }
	}
	//通过用户名查询用户角色
	private List<Role> getRoles(User user) {
		UserRole userRole=new UserRole(null, user);
		List<UserRole> list=urDao.findBy(userRole);
		List<Role> roles=new ArrayList();
		for (UserRole ur : list) {
			 roles.add(ur.getRole());
		}
		return roles;
	}
  //查询角色对应资源菜单
	private List<Power> getMenu(Role role) {
		DetachedCriteria criteria=DetachedCriteria.forClass(RolePower.class);
		criteria.add(Restrictions.eq("role.id", role.getId()));
		List<RolePower> list = rpDao.findByCritiria(criteria);
		List<Power> powers=new ArrayList();
		for (RolePower rolePower : list) {
			Power power=rolePower.getPower();
			if(power.getParent()==0){
				powers.add(power);
			}
		}
		return powers;
	}
  //查询资源菜单下的功能列表
	private List<Power> getList(Power menu){
		Power power=new Power();
		power.setParent(menu.getId());
		List list=powerDao.findBy(power);
		return 	list;
	}
}
