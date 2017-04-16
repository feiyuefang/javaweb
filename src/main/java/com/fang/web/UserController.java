package com.fang.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fang.pojo.Talk;
import com.fang.pojo.TbUser;
import com.fang.service.impl.TalkServiceImpl;
import com.fang.service.impl.TbUserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private TbUserServiceImpl userServiceImpl;

	@Autowired
	private TalkServiceImpl talkServiceImpl;

	// /user/{uid}/friends/
	@RequestMapping(value = "/login")
	public String queryById(Model model, TbUser tbuser, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (tbuser.getAccountNumber() == null) {
			tbuser = (TbUser) session.getAttribute("tbuser");
		}
		TbUser user = userServiceImpl.queryTbUser(tbuser.getAccountNumber(), tbuser.getPassword());
		if (user != null) {
			request.getSession().setAttribute("tbuser", user);
			@SuppressWarnings("unchecked")
			List<Talk> list = (List<Talk>) session.getAttribute("talkList");
			list = talkServiceImpl.talkList(user, false);
			session.setAttribute("talkList", list);
			session.setAttribute("message", "publish");
			return "index";
		}
		session.removeAttribute("accountNumber");
		model.addAttribute("error", "’ÀªßªÚ√‹¬Î¥ÌŒÛ£°");
		return "login";
	}

	@RequestMapping(value = "checkUsername")
	public @ResponseBody String check(HttpServletRequest request) {
		String username = request.getParameter("username");
		boolean flag = userServiceImpl.check(username);
		if (flag == true) {
			return "ok";
		} else {
			return "no";
		}
	}

	@RequestMapping(value = "/registerForm")
	public String registerForm() {
		return "register";
	}

	@RequestMapping(value = "/Register")
	public String reg(Model model, HttpServletRequest request) {
		TbUser user=new TbUser();
		user.setNickname(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		userServiceImpl.insert(user);
		request.getSession().setAttribute("accountNumber", user.getAccountNumber());
		return "login";
	}
}
