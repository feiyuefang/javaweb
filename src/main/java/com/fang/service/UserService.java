package com.fang.service;

import java.util.List;
import com.fang.pojo.TbUser;

public interface UserService {

	TbUser queryById(String id);

	void insert(TbUser users);

	List<TbUser> queryAll();

}
