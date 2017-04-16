package com.fang.service;

import java.util.List;

import com.fang.pojo.Comment;
import com.fang.pojo.Message;
import com.fang.pojo.Talk;
import com.fang.pojo.TbUser;

public interface CommentService {

	Comment insertComment(Comment comm);
	
	List<Message> getMassage(TbUser user);
	
	void deleteComment(Comment comment);
	
	int CommentNumber(Talk talk);
	
	List<Comment> getComments(Talk talk);
}
