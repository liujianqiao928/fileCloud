package com.custchina.dao;

import org.apache.ibatis.annotations.Param;

import com.custchina.pojo.User;

public interface UserDao {
	public User findUser(@Param("usercode") String usercode,
            @Param("password") String password);
	public int addUser(@Param("usercode") String usercode,@Param("email") String email,
            @Param("password") String password,@Param("state") Integer state);
	
	public int updateUser(@Param("usercode") String usercode, @Param("password") String password);
}
