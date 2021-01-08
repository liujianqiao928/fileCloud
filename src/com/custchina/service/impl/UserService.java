package com.custchina.service.impl;

import com.custchina.pojo.User;

public interface UserService {
	public User findUser(String usercode,String password);
	public int addUser(String usercode,String password,String email, Integer state);
	public int updateUser(String usercode,String password);
}
