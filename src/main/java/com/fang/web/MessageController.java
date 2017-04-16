package com.fang.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fang.pojo.Message;
import com.fang.pojo.Talk;
import com.fang.pojo.TbUser;
import com.fang.service.impl.CommentServiceImpl;
import com.fang.service.impl.LikeServiceImpl;
import com.fang.service.impl.TalkServiceImpl;
import com.fang.service.impl.TbUserServiceImpl;

@Controller
public class MessageController {

	@Autowired
	private CommentServiceImpl commServiceImpl;

	@Autowired
	private LikeServiceImpl likeServiceImpl;
	
	@Autowired
	private TalkServiceImpl talkServiceImpl;
	
	@Autowired
	private TbUserServiceImpl tbUserServiceImpl;

	@RequestMapping(value = "commWithout")
	public @ResponseBody List<Message> commWithout(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("tbuser");
		List<Message> commMessages = commServiceImpl.getMassage(user);
		return commMessages;
	}

	@RequestMapping(value = "likeWithout")
	public @ResponseBody List<Message> likeWithout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("tbuser");
		List<Message> likeMessages = likeServiceImpl.likeMessage(user);
		return likeMessages;
	}

	@RequestMapping(value = "myspecial")
	public String myspecial(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("tbuser");
	    List<Talk> list = talkServiceImpl.talkList(user,true);
	    session.setAttribute("message", "special");
	    session.setAttribute("talkList", list);
	   //加载还未特别关注的人
	    List<TbUser> friendList=tbUserServiceImpl.friends(user,false);
	    session.setAttribute("friendList", friendList);
	    //已经关注的人
	    List<TbUser> specialList=tbUserServiceImpl.friends(user,true);
	    session.setAttribute("specialList", specialList);
		return "index";
	}
	@RequestMapping(value = "makeSpecial")
	public @ResponseBody String addSpecial(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("tbuser");
	    String toId=request.getParameter("uid");
	    String token = request.getParameter("token");
	    if("add".equals(token)){
	    	//加入/减除 特别关注
	    	tbUserServiceImpl.addSpecial(user, toId, true);
	    }else if("cancel".equals(token)){
	    	tbUserServiceImpl.addSpecial(user, toId, false);
	    }
		return "ok";
	}
	
	@RequestMapping(value = "myold")
	public String myold(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("tbuser");
	   //好友圈中的那年今日
		List<Talk> oldTalk=talkServiceImpl.old(user);
		session.setAttribute("talkList", oldTalk);
		session.setAttribute("message", "myold");
		return "index";
	}
	
	
}
