package com.fang.service;

import com.fang.pojo.Likes;
import com.fang.pojo.Talk;
import com.fang.pojo.TbUser;

public interface LikeService {

	int insertLike(Likes like);
	
	int deleteLike(Likes like);
	
	int eachLikeNumber(Talk talk);
	
	boolean likeOrNo(TbUser user,Talk talk);
}
