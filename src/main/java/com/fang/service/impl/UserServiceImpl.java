package com.fang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fang.mapper.TbUserMapper;
import com.fang.pojo.TbUser;
import com.fang.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper userMapper;

	@Override
	public TbUser queryById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insert(TbUser users) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TbUser> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public TbUser queryByName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
