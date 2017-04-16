package com.fang.dao;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fang.base.BaseTest;
import com.fang.entity.Users;

public class UserDaoTest extends BaseTest{
	private static Logger logger=LoggerFactory.getLogger(UserDaoTest.class);
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void queryById(){
		//userDao=new UserServiceImpl();
		Users users=userDao.queryById(1);
		logger.info(users.getPassword());
	}
	
	@Test
	public void insert(){
		Users user=new Users();
		user.setId(2);
		user.setUsername("张三");
		user.setPassword("12345678");
		userDao.insert(user);
	}
	
	@Test
	public void queryAll(){
		System.out.println("list:"+userDao.queryAll().size());
		logger.info("list:"+userDao.queryAll().size());
		logger.error("list:"+userDao.queryAll().size());
	}
	
	@Test
	public void queryByName(){
		logger.info(userDao.queryByName("张").getPassword());
	}
}
