<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="sp">
	<div class="mytitle">
		<div style="font-size: 14px; font-weight: bold;">ta的动态~</div>
	</div>
	<div class="specialLeft">
		<div id="tabs">
			<ul class="nav clearfloat" id="nav">
				<li class="active">添加关注</li>
				<li>我的关注</li>
			</ul>
			
			 <div class="contents">
			<!--  <div class="specialfriend"> -->
			   <c:forEach items="${friendList}" var="friend">
			     <div class="specialfriend_"+${friend.uuid}>
			      <div style="width: 60px; height: 60px; overflow: hidden;border-radius: 5px;">
					<img alt="头像" src="${friend.headPortrait}" width="60px" height="60px">
				  </div>
				  <div class="addspecial"><a href="#" onclick="javascript:addSpecial('${friend.uuid}');">+${friend.nickname}</a></div>
				  <div class="specialname"></div>
				  </div>
			   </c:forEach>
			  <!-- </div> -->
			</div>
			 
			<div class="contents active">
			<!-- <div class="usualfriend"> -->
			   <c:forEach items="${specialList}" var="friend">
			    <div class="usualfriend_"+${friend.uuid}>
			      <div style="width: 45px; height: 45px; overflow: hidden;">
					<img alt="头像" src="${friend.headPortrait}" width="45px" height="45px">
				  </div>
				  <div class="specialname">${friend.nickname}</div>
				  <div class="cancelspecial"><a href="javascript:removeSpecial('${friend.uuid}')">取消关注</a></div>
				 <div>
				 </div>
			   </c:forEach>
			   <!-- </div> -->
		</div>
	</div>
</div>
</div>