<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${message == 'publish'}">
	<c:import url="publish.jsp"></c:import>
</c:if>
<c:if test="${message == 'special'}">
	<c:import url="special.jsp"></c:import>
</c:if>
<c:if test="${message == 'myold'}">
	<c:import url="old.jsp"></c:import>
</c:if>

<!-- 所有的说说共有的部分 -->
<c:if test="${not empty talkList}">
	<c:forEach items="${talkList}" var="talk">
		<div class="talk">
			<div class="ttop">
				<div
					style="width: 45px; height: 45px; border-radius: 50%; overflow: hidden; margin-top: 10px;">
					<img alt="头像" src="${talk.tbUser.headPortrait}" width="45px"
						height="45px" style="margin-top: 0px;">
				</div>
				<div
					style="margin-top: 10px; margin-left: -15px; font-size: 14px; font-weight: bold;">${talk.tbUser.nickname}</div>
				<div class="talkTime">${talk.stringTime}</div>	
			</div>
			<div class="tmiddle">${talk.content}</div>
			<div class="tbottom">
				<ul>
					<li><a href="javascript:dolike('${talk.id}');"> <c:if
								test="${talk.likeOrNot == false}">
								<span class="zan_${talk.id}" style="color: black;">点赞</span> 
								( <span class="likeNumber_${talk.id}">${talk.likeNumber}</span> )
							</c:if> <c:if test="${talk.likeOrNot == true}">
								<span class="zan_${talk.id}" style="color: red;">已赞</span> 
								( <span class="likeNumber_${talk.id}">${talk.likeNumber}</span> )
							</c:if>
					</a></li>
					<li><a href="#">评论</a></li>
					<li><a href="#">转发</a></li>
				</ul>
			</div>
			<div class="likeUser">
				<c:if test="${talk.likeNumber !=0}">
					<c:forEach items="${talk.likeList}" var="user">
						<span style="font-size: 12px; color: black;">${user.nickname}&nbsp;</span>
					</c:forEach>
					<span style="font-size: 12px; color: black;">${talk.likeNumber}人觉得很赞</span>
				</c:if>
			</div>
			<div class="comments">
				<!-- 遍历所有说说的评论 -->
				<div id="comm_${talk.id}">
					<c:forEach items="${talk.comms}" var="comm">
						<div class="comm">
							<div
								style="width: 30px; height: 30px; border-radius: 50%; overflow: hidden;">
								<img alt="头像" src="${comm.tbuser.headPortrait}" width="30px"
									height="30px" style="">
							</div>
							<div style="color: blue; margin-left: -10px;">${comm.tbuser.nickname}:</div>
							<div style="margin-left: -15px; font-weight: bold;">${comm.content}</div>
							<div>
								<span style="font-size: 12px; color: gray;">${comm.dates}</span>
							</div>
						</div>
					</c:forEach>
				</div>
				<div>
					<input name="" type="text"
						style="width: 380px; height: 25px; font-size: 12px;"
						id="comment_${talk.id}" placeholder="我来说点什么..." /> <input
						type="button" id="commentbutton" value="发送"
						onclick="javascript:clicks('${talk.id}');" />
				</div>
			</div>
		</div>
	</c:forEach>
</c:if>