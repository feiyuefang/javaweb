package com.fang.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fang.mapper.CommentMapper;
import com.fang.mapper.TalkMapper;
import com.fang.pojo.Comment;
import com.fang.pojo.CommentExample;
import com.fang.pojo.Message;
import com.fang.pojo.Talk;
import com.fang.pojo.TalkExample;
import com.fang.pojo.TbUser;
import com.fang.service.CommentService;
import com.fang.util.GetTime;
import com.fang.util.IDUtils;
@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private TalkMapper talkMapper;
	
	@Override
	public Comment insertComment(Comment comm) {
		comm.setCid((int)IDUtils.genItemId());
		comm.setTime(GetTime.getNowTime());
		if( commentMapper.insert(comm)==1){
			Comment c= commentMapper.selectByPrimaryKey(comm.getCid());
			c.setDates(GetTime.format(c.getTime(),"MM-dd hh:mm"));
			return c;
		}
		return null;
	}

	@Override
	public List<Comment> getComments(Talk talk) {
		CommentExample example=new CommentExample();
		CommentExample.Criteria criteria = example.createCriteria();
		criteria.andToTalkEqualTo(talk.getId());
		example.setOrderByClause("time");
		 List<Comment> list=commentMapper.selectByExample(example);
		 for (Comment comment : list) {
			 comment.setDates(GetTime.format(comment.getTime(),"MM-dd hh:mm"));
		}
		 return list;
	}

	@Override
	public void deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int CommentNumber(Talk talk) {
		CommentExample example=new CommentExample();
		CommentExample.Criteria criteria = example.createCriteria();
		criteria.andToTalkEqualTo(talk.getId());
		return commentMapper.countByExample(example);
	}
	
	//获取所有的评论
	public List<Message> getMassage(TbUser user){
		List<Message> list=new ArrayList<Message>();
		//用户的说说
		TalkExample talkExample=new TalkExample();
		talkExample.setOrderByClause("time");
		TalkExample.Criteria tc=talkExample.createCriteria();
		tc.andUserIdEqualTo(user.getUuid());
		List<Talk> talkList=talkMapper.selectByExample(talkExample);
		Message message=null;
		for (Talk talk : talkList) {
			CommentExample example=new CommentExample();
			example.setOrderByClause("time");
			CommentExample.Criteria criteria = example.createCriteria();
			criteria.andToTalkEqualTo(talk.getId());
			List<Comment> commList=commentMapper.selectByExample(example);
			for (Comment comment : commList) {
				message=new Message();
				message.setTalk(talk);
				message.setUser(user);
				comment.setDates(GetTime.format(comment.getTime(),"mm-dd HH:MM"));
				message.setComment(comment);
				list.add(message);
			}
		}
		return list;
	}

}
