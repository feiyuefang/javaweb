<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我的空间</title>
<link rel="stylesheet" type="text/css" href="css/top.css">
<link rel="stylesheet" type="text/css" href="css/protrait.css">
<link rel="stylesheet" type="text/css" href="css/jquery.Jcrop.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" type="text/css" href="css/talk.css">
<link rel="stylesheet" type="text/css" href="css/mycomment.css">
<link rel="stylesheet" type="text/css" href="css/special.css">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/jquery.Jcrop.js"></script>
<script type="text/javascript" src="js/changeProtrait.js"></script>
<script type="text/javascript" src="js/talk.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/mycomm.js"></script>
<script type="text/javascript" src="js/special.js"></script>
</head>
<body>

	<c:import url="topfixed.jsp"></c:import>

	<div id="gray"></div>
	<input type="hidden" value="${accountNumber}" id="accountNumber">

	<div class="all">
		<div class="lefts">
			<ul>
				<li><a href="login" class="talks">好友动态</a></li>
				<li><a href="#" class="mycomm">我的评论</a></li>
				<li><a href="#" class="mylike">我的赞</a></li>
				<li><a href="myspecial" class="myspecial">特别关心</a> <input
					type="hidden" value="${message}" id="message"></li>
				<li><a href="#" class="mycollection">我的收藏</a></li>
				<li><a href="myold" class="myold">那年今日</a></li>
			</ul>
		</div>
		<div class="middles">
			<div id="talks">
				<c:import url="talk.jsp"></c:import>
			</div>
			<div id="mycomm">
				<c:import url="comment.jsp"></c:import>
			</div>
			<div id="mylike">
				<c:import url="like.jsp"></c:import>
			</div>
			<div id="myspecial">
				<c:import url="talk.jsp"></c:import>
			</div>
			<div id="myold">
				<c:import url="talk.jsp"></c:import>
			</div>
		</div>
	</div>
	<div class="rights">
		<div class="introduce"></div>
	</div>
	</div>
	<%-- <script type="text/javascript">
	var error =
     '<%=request.getParameter("error")%>'
		;
		if (error == 'timeout') {
			alert("登录超时，请重新登录！");
			window.location.href = "login.jsp";
		}
	</script> --%>
</body>
</html>