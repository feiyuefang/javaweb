package com.fang.service;

import java.util.List;

import com.fang.pojo.Talk;
import com.fang.pojo.TbUser;

public interface TalkService {

	Talk insertTalk(Talk talk);
	
	List<Talk> talkList(TbUser user,boolean special);
	
	void deleteTalk(Talk talk);
	
	Talk queryTalkById(int id);
}
