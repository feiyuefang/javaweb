<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="lay_headContainer">
	<c:if test="${blog.style=='blue'}">
		<div style="position: absolute; left: 0px; top: 0px; width: 100%; height: 220px; overflow: hidden;">
			<object id="swftitlebar" width="100%" height="220" type="application/x-shockwave-flash" data="css/blue/81812.swf">
				<param value="always" name="allowScriptAccess">
				<param value="all" name="allownetworking">
				<param value="true" name="allowFullScreen">
				<param value="transparent" name="wmode">
				<param value="false" name="menu">
				<param value="noScale" name="scale">
				<param value="1" name="salign">
			</object>
		</div>
	</c:if>
	
	<div class="fn_info ">
		<h1 id="top_head_title" class="title">
			<span class="text ui_mr10">${param.blogTitle}</span>
		</h1>
		<div class="description">
			<c:set var="url"
				value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/Blog?id=${param.blogId}"></c:set>
			<a class="url" href="${url}">${url}</a>
		</div>
	</div>
</div>

<!-- 导航 -->
<div class="lay_menuContainer">
	<ul>
		<li><a href="Blog?id=${param.blogId}">主页</a>
		</li>
		<li><a href="PostList?id=${param.blogId}">日志</a>
		</li>
		<li><a href="#">音乐</a>
		</li>
		<li><a href="#">留言板</a>
		</li>
		<li><a href="#">相册</a>
		</li>
		<li><a href="#">说说</a>
		</li>
		<li><a href="PersonalShow?id=${param.blogId}">个人档</a>
		</li>
		<li><a href="#">时光轴</a>
		</li>
		<li><a href="#">更多</a>
		</li>
	</ul>
</div>