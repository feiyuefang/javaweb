package com.fang.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fang.pojo.TbUser;

public class ManageInterceptor extends HandlerInterceptorAdapter{

	Logger logger=LoggerFactory.getLogger(ManageInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		TbUser user = (TbUser) session.getAttribute("tbuser");
		StringBuffer s = request.getRequestURL();
		if (s.toString().contains("login")||s.toString().contains("registerForm")||s.toString().contains("Register")) {
			return true;
		} else {
		if(user==null){
			/*response.sendRedirect("jsp/login.jsp?error=timeout");*/
			return false;
		}
		return true;
		}
	}
	

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	
}
