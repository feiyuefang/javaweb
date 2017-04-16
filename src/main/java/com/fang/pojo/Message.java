package com.fang.pojo;

public class Message {

	//谁评论的
	private TbUser user;
	
	//那条说说
	private Talk talk;
	
	//什么评论（内容）
	private Comment comment;
	
	private Likes like;
	
	public Likes getLike() {
		return like;
	}

	public void setLike(Likes like) {
		this.like = like;
	}

	public TbUser getUser() {
		return user;
	}

	public void setUser(TbUser user) {
		this.user = user;
	}

	public Talk getTalk() {
		return talk;
	}

	public void setTalk(Talk talk) {
		this.talk = talk;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
}
