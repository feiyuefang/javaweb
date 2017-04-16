package com.fang.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fang.mapper.LikesMapper;
import com.fang.mapper.TalkMapper;
import com.fang.mapper.TbUserMapper;
import com.fang.pojo.Comment;
import com.fang.pojo.CommentExample;
import com.fang.pojo.Likes;
import com.fang.pojo.LikesExample;
import com.fang.pojo.LikesKey;
import com.fang.pojo.Message;
import com.fang.pojo.Talk;
import com.fang.pojo.TalkExample;
import com.fang.pojo.TbUser;
import com.fang.service.LikeService;
import com.fang.util.GetTime;
import com.fang.util.IDUtils;

@Service
public class LikeServiceImpl implements LikeService {

	Logger logger = Logger.getLogger(LikeServiceImpl.class);
	
	@Autowired
	private LikesMapper likeMapper;
	
	@Autowired
	private TbUserMapper tbUserMapper;
	
	@Autowired
	private TalkMapper talkMapper;

	@Override
	public int insertLike(Likes like) {
		like.setTime(GetTime.getNowTime());
		like.setLid((int)IDUtils.genItemId());
		like.setStatus(1);
		like.setFromUid(like.getFromUid());
		like.setToTalk(like.getToTalk());
		try{
			return likeMapper.insert(like);
		}catch(Exception e){
			return 0;
		}
		
	}

	@Override
	public int deleteLike(Likes like) {
		LikesKey key=new LikesKey();
		key.setFromUid(like.getFromUid());
		key.setToTalk(like.getToTalk());
		int i=likeMapper.deleteByPrimaryKey(key);
		return i;
	}

	@Override
	public int eachLikeNumber(Talk talk) {
		LikesExample example=new LikesExample();
		LikesExample.Criteria criteria = example.createCriteria();
		criteria.andToTalkEqualTo(talk.getId());
		return likeMapper.countByExample(example);
	}

	@Override
	public boolean likeOrNo(TbUser user, Talk talk) {
		LikesExample example=new LikesExample();
		LikesExample.Criteria criteria = example.createCriteria();
		criteria.andToTalkEqualTo(talk.getId());
		criteria.andFromUidEqualTo(user.getUuid());
		int i=likeMapper.countByExample(example);
		//0,没赞；1，已赞
		if(i==0){
			return false;
		}else{
			return true;
		}
	}
	
	public List<TbUser> likeUser(Talk talk){
		List<TbUser> list=new ArrayList<TbUser>();
		LikesExample example=new LikesExample();
		LikesExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause("time");
		criteria.andToTalkEqualTo(talk.getId());
		List<Likes> lk=likeMapper.selectByExample(example);
		for (Likes likes : lk) {
			list.add(tbUserMapper.selectByPrimaryKey(likes.getFromUid()));
		}
		return list;
	} 
	
	public List<Message> likeMessage(TbUser user){
		List<Message> list=new ArrayList<Message>();
		//用户的说说
		TalkExample talkExample=new TalkExample();
		talkExample.setOrderByClause("time");
		TalkExample.Criteria tc=talkExample.createCriteria();
		tc.andUserIdEqualTo(user.getUuid());
		List<Talk> talkList=talkMapper.selectByExample(talkExample);
		Message message=null;
		for (Talk talk : talkList) {
			LikesExample example=new LikesExample();
			example.setOrderByClause("time");
			LikesExample.Criteria criteria = example.createCriteria();
			criteria.andToTalkEqualTo(talk.getId());
			List<Likes> likeList=likeMapper.selectByExample(example);
			for (Likes likes : likeList) {
				message=new Message();
				message.setTalk(talk);
				message.setUser(user);
				likes.setsTime((GetTime.format(likes.getTime(),"mm-dd HH:MM")));
				message.setLike(likes);
				
				list.add(message);
			}
		}
		return list;
	
	}
}
