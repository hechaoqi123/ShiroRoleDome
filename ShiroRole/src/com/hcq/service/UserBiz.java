package com.hcq.service;

import java.util.List;
import java.util.Map;

import com.hcq.entity.Power;
import com.hcq.entity.Role;
import com.hcq.entity.User;

public interface UserBiz {
  //�û�ע��
  public boolean register(User user);
  //��ѯ�û���Ӧ��Դ
  public Map<String,List> getPowers(String UserName);
}