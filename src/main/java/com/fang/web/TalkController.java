package com.fang.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.fang.pojo.CommItem;
import com.fang.pojo.Comment;
import com.fang.pojo.Likes;
import com.fang.pojo.Talk;
import com.fang.pojo.TbUser;
import com.fang.service.impl.CommentServiceImpl;
import com.fang.service.impl.LikeServiceImpl;
import com.fang.service.impl.TalkServiceImpl;
import com.fang.util.GetTime;

@Controller
public class TalkController {

	@Autowired
	private TalkServiceImpl talkServiceImpl;
	
	@Autowired
	private LikeServiceImpl likeServiceImpl;
	
	@Autowired
	private CommentServiceImpl commentServiceImpl;

	@RequestMapping(value = "/publishTalk")
	public String insertTalk(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String talk = request.getParameter("talk");
		TbUser user = (TbUser) session.getAttribute("tbuser");
		List<Talk> list = (List<Talk>) session.getAttribute("talkList");
		String token = (String) session.getAttribute("token");
		if (list == null) {
			list = talkServiceImpl.talkList(user,false);
		}
		if (!token.equals("") || token != null) {
			Talk t = new Talk();
			t.setUserId(user.getUuid());
			t.setContent(talk);
			Talk ta = talkServiceImpl.insertTalk(t);
			if (ta != null) {
				list.add(ta);
			}
		}
		session.setAttribute("message", "index");
		session.setAttribute("talkList", list);
		return "index";
	}

	@RequestMapping(value = "dolike")
	public void dolike(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		TbUser user = (TbUser) session.getAttribute("tbuser");
		int id=Integer.parseInt(request.getParameter("talkId"));
		Likes like=new Likes();
		like.setFromUid(user.getUuid());
		like.setToTalk(id);
		int i=likeServiceImpl.insertLike(like);
		if(i==0){
			likeServiceImpl.deleteLike(like);
			out.print("delete");
		}else{
			out.print("insert");
		}
	}
	
	@RequestMapping(value = "publishComment")
	public void publishComment(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session=request.getSession();
		/*response.setContentType("application/json");*/
		PrintWriter out = response.getWriter();
		TbUser user=(TbUser) session.getAttribute("tbuser");
		String content=request.getParameter("content");
		System.out.println(content);
		int id=Integer.parseInt(request.getParameter("id"));
		Comment comm=new Comment();
		comm.setContent(content);
		comm.setFromUid(user.getUuid());
		comm.setToTalk(id);
		Comment comment=commentServiceImpl.insertComment(comm);
		CommItem commItem=new CommItem();
		commItem.setContent(comment.getContent());
		commItem.setName(user.getNickname());
		commItem.setPhoto(user.getHeadPortrait());
		commItem.setTime(GetTime.format(comment.getTime(),"MM-dd hh:mm"));
	    Object com = JSONObject.toJSON(commItem);
		if(comment!=null){
			//评论之后，返回一个comment对象
			out.write(com.toString());
		}
	}
	
}






















