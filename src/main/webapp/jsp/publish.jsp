<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="publish">
	<%
		String token = UUID.randomUUID().toString();
		session.setAttribute("token", token);
	%>
	<form action="publishTalk" method="post">
		<textarea rows="5" cols="67" placeholder="说点什么吧" name="talk"></textarea>
		<input type="submit" value="发表" id="button">
	</form>
	
		<span style="font-size: 14px; color: blue;">全部动态~</span> <span
			style="margin-top: 10px; margin-left: 100px;"><a href="#">刷新</a></span>
</div>
