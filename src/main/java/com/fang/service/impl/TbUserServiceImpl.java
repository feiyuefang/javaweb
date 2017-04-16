package com.fang.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fang.mapper.FriendMapper;
import com.fang.mapper.TbUserMapper;
import com.fang.pojo.Friend;
import com.fang.pojo.FriendExample;
import com.fang.pojo.Talk;
import com.fang.pojo.TbUser;
import com.fang.pojo.TbUserExample;
import com.fang.service.TbUserService;
import com.fang.util.IDUtils;

@Service
public class TbUserServiceImpl implements TbUserService {

	@Autowired
	private TbUserMapper tbUserMapper;

	@Autowired
	private FriendMapper friendMapper;

	@Override
	public TbUser queryTbUser(String accountNumber, String paw) {
		// TODO Auto-generated method stub
		TbUserExample userExample = new TbUserExample();
		TbUserExample.Criteria criteria = userExample.createCriteria();
		criteria.andAccountNumberEqualTo(accountNumber);
		criteria.andPasswordEqualTo(paw);
		List<TbUser> users = tbUserMapper.selectByExample(userExample);
		if (users.size() != 0) {
			return users.get(0);
		}
		return null;
	}

	// 获取已获得的
	public List<TbUser> friends(TbUser user,boolean flag) {
		List<TbUser> userList = null;
		FriendExample example = new FriendExample();
		FriendExample.Criteria cr = example.createCriteria();
		cr.andFromUserEqualTo(user.getUuid());
		List<Friend> friends;
		//为特别关注
		if(flag==false){
			cr.andStateEqualTo((byte)0);
			friends= friendMapper.selectByExample(example);
		}else{
			cr.andStateEqualTo((byte)1);
		     friends = friendMapper.selectByExample(example);
		}
		if (friends != null) {
			for (Friend friend : friends) {
				TbUserExample userExample = new TbUserExample();
				TbUserExample.Criteria criteria = userExample.createCriteria();
				criteria.andUuidEqualTo(friend.getToUser());
				userList = tbUserMapper.selectByExample(userExample);
			}
		}
		return userList;
	}
	
	public void addSpecial(TbUser fromUser,String toId,boolean add){
		FriendExample example = new FriendExample();
		FriendExample.Criteria cr = example.createCriteria();
		cr.andFromUserEqualTo(fromUser.getUuid());
		cr.andToUserEqualTo(toId);
		List<Friend> list=friendMapper.selectByExample(example);
		if(list!=null){
			Friend friend=list.get(0);
			if(add==true){
				friend.setState((byte)1);
			}else{
				friend.setState((byte)0);
			}
			friendMapper.updateByPrimaryKey(friend);  
		}
	}
	
	@Override
	public int updatePortrait(TbUser user) {
		System.out.println("tbUserService...");
		return tbUserMapper.updateByPrimaryKey(user);
	}
	/**
	 * 
	*@time 2017年4月16日,下午8:39:42
	*@Description: TODO 
	 @param username
	 @return true,未注册；false,已注册
	 */
	public boolean check(String username){
		TbUserExample userExample = new TbUserExample();
		TbUserExample.Criteria criteria = userExample.createCriteria();
		criteria.andNicknameEqualTo(username);
		List<TbUser> list=tbUserMapper.selectByExample(userExample);
		if(list.size()==0){
			return false;
		}
		return true;
	}
	
	public TbUser insert(TbUser user){
		user.setUuid(String.valueOf(IDUtils.genItemId()));
		user.setAccountNumber(String.valueOf(IDUtils.tbUserId()));
		user.setHeadPortrait("images/uploadPortrait/default.jpg");
		tbUserMapper.insert(user);
		return user;
	}

}
