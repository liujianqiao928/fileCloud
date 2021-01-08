package com.custchina.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.custchina.dao.UserDao;
import com.custchina.pojo.User;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao ud;
	@Override
	public User findUser(String usercode, String password) {
		// TODO Auto-generated method stub
		User user = ud.findUser(usercode, password);
		
		return user;
	}
	@Override
	public int addUser(String usercode, String password, String email ,Integer state) {
		// TODO Auto-generated method stub
		int user = ud.addUser(usercode, password, email,state);
		return user;
	}
	@Override
	public int updateUser(String usercode, String password) {
		// TODO Auto-generated method stub
		return ud.updateUser(usercode, password);
	}


	

}
