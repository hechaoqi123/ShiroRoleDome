package com.hcq.service;

import java.util.List;
import java.util.Map;

import com.hcq.entity.Power;
import com.hcq.entity.Role;
import com.hcq.entity.User;

public interface UserBiz {
  //用户注册
  public boolean register(User user);
  //查询用户对应资源
  public Map<String,List> getPowers(String UserName);
}