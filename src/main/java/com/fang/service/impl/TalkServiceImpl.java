package com.fang.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fang.mapper.FriendMapper;
import com.fang.mapper.TalkMapper;
import com.fang.mapper.TbUserMapper;
import com.fang.pojo.Comment;
import com.fang.pojo.Friend;
import com.fang.pojo.FriendExample;
import com.fang.pojo.Talk;
import com.fang.pojo.TalkExample;
import com.fang.pojo.TbUser;
import com.fang.service.TalkService;
import com.fang.util.GetTime;
import com.fang.util.IDUtils;

@Service
public class TalkServiceImpl implements TalkService {

	@Autowired
	private TalkMapper talkMapper;

	@Autowired
	private FriendMapper friendMapper;

	@Autowired
	private TbUserMapper tbUserMapper;

	@Autowired
	private LikeServiceImpl likeServiceImpl;

	@Autowired
	private CommentServiceImpl commentServiceImpl;

	@Override
	public Talk insertTalk(Talk talk) {
		// jdk自动拆箱和装箱的功能
		int id = (int) IDUtils.genItemId();
		talk.setId(id);
		talk.setTime(GetTime.getNowTime());
		// 默认所有人可见
		talk.setState((byte) 1);
		if (talkMapper.insert(talk) == 1) {
			return talkMapper.selectByPrimaryKey(id);
		}
		return null;
	}

	// 自己和所有关注的人的说说
	@Override
	public List<Talk> talkList(TbUser user, boolean special) {
		// TODO Auto-generated method stub
		FriendExample friendExample = new FriendExample();
		FriendExample.Criteria criterias = friendExample.createCriteria();
		criterias.andFromUserEqualTo(user.getUuid());
		if (special == true) {
			criterias.andStateEqualTo((byte) 1);
		}
		// 获取所有自己的朋友
		List<Friend> frindList = friendMapper.selectByExample(friendExample);
		List<TbUser> userList = new ArrayList<TbUser>();
		userList.add(user);
		for (Friend friend : frindList) {
			TbUser u = tbUserMapper.selectByPrimaryKey(friend.getToUser());
			userList.add(u);
		}
		// 获取朋友列表的所有说说，compareTo()自动排序
		List<Talk> talkList = new ArrayList<Talk>();
		for (TbUser tbUser : userList) {
			TalkExample talkExample = new TalkExample();
			TalkExample.Criteria criteria = talkExample.createCriteria();
			criteria.andUserIdEqualTo(tbUser.getUuid());
			criteria.andStateEqualTo((byte) 1);
			List<Talk> list = talkMapper.selectByExample(talkExample);
			if (list.size()!=0) {
				TbUser u = tbUserMapper.selectByPrimaryKey(list.get(0).getUserId());
				for (Talk talk : list) {
					talk.setTbUser(u);
					// 每条说说点赞数量和‘已赞’
					int number = likeServiceImpl.eachLikeNumber(talk);
					talk.setLikeNumber(number);
					talk.setLikeOrNot(likeServiceImpl.likeOrNo(user, talk));
					// 根据时间排序点赞的用户
					talk.setLikeList(likeServiceImpl.likeUser(talk));
					// 每条说说的评论
					talk.setCommentNumber(commentServiceImpl.CommentNumber(talk));
					List<Comment> listComm = commentServiceImpl.getComments(talk);
					for (Comment comment : listComm) {
						comment.setTbuser(tbUserMapper.selectByPrimaryKey(comment.getFromUid()));
					}
					talk.setComms(listComm);
					talk.setStringTime(GetTime.format(talk.getTime(), "yyyy-MM-dd hh:mm:ss"));
					talkList.add(talk);
				}
			}
		}
		if (talkList.size() != 0) {
		}
		return talkList;
	}

	@SuppressWarnings("deprecation")
	public List<Talk> old(TbUser user) {
		Calendar now = Calendar.getInstance();
		int to_year=now.get(Calendar.YEAR);
		int to_day = now.get(Calendar.DAY_OF_MONTH);
		int to_mouth = now.get(Calendar.MONTH) + 1;
		List<Talk> list = talkList(user, false);
		List<Talk> oldList = new ArrayList<Talk>();
		for (Talk talk : list) {
			String[] times=GetTime.formatAll(talk.getTime()).split("-");
			//int year = talk.getTime().getYear();
			if(to_year>Integer.parseInt(times[0])){
				int mouth = Integer.parseInt(times[1]);
				int day = Integer.parseInt(times[2]);
				talk.setStringTime(GetTime.format(talk.getTime(), "yyyy-MM-dd hh:mm:ss"));
				if (to_day == day && to_mouth == mouth) {
					oldList.add(talk);
				}
			}
		}
		return oldList;
	}

	@Override
	public void deleteTalk(Talk talk) {
		// TODO Auto-generated method stub

	}

	@Override
	public Talk queryTalkById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
