package com.fang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fang.entity.Users;

public interface UserDao {

	Users queryById(@Param("id")int id);
	
	void insert(Users users);
	
	List<Users> queryAll();
	
	//1.没有@Param("userName")  There is no getter for property named 'userName' in 'class java.lang.String' 
	//2.
	Users queryByName(@Param("userName")String userName);
}
