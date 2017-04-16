package com.fang.service;

import com.fang.pojo.TbUser;

public interface TbUserService {

	TbUser queryTbUser(String username, String paw);
	
	int updatePortrait(TbUser user);
	
}
