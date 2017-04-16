<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="css/space.css">
<link rel="stylesheet" type="text/css" href="css/blue.css">
<link type="image/x-icon" href="favicon.ico" rel="Shortcut Icon">
</head>
<body>

	<!-- top文件引用 -->
	<jsp:include page="topfixed.jsp">
		<jsp:param name="blogId" value="${blog.id }" />
	</jsp:include>

	<%-- <div id="mainbox">
		<div class="lay_position">
			<!-- 头文件引用 -->
	      <jsp:include page="header.jsp">
			<jsp:param name="blogId" value="${blog.id }" />
			<jsp:param name="blogTitle" value="${blog.title }" />
		  </jsp:include>

		  <div id="LayPageContainer" class="lay_pageContainer">
			<div class="lay_lace_t"></div>
			  <div class="lay_lace_m">
			    <div id="pageContent" class="page_home_normal ">
				  <div id="QM_Main_Container" class="lay_grid clearfix lay_grid_13">
					<!-- 左  -->
					<div id="info">
						<div class="collet_box mod_wrap">
							<div class="mod_wrap_hd">
								<h3>
									<a href="PersonalShow?id=${blog.id}">个人信息</a>
								</h3>
							</div>
						<div class="box_bd mod_wrap_bd">
							<div class="fn_profile">
								<div class="avatarWrap">
									<a href="PersonalShow?id=${blog.id}" class="ui_avatar bgr3">
										<img alt="" src="images/figure_owner_f.jpg">
									</a>
								</div>
						        <div class="user_detail">
								  <h4 class="username">${blog.author.nickname}</h4>
								</div>
								<ul class="profile_detail">
									<li><a id="QM_Profile_Detail" class="right"
										href="PersonalShow?id=${blog.id}">详情</a> <span>${blog.author.bio}</span>
										<span>${blog.author.email}</span> <span>${blog.author.favouriteSection}</span>
									</li>
								</ul>
								<ul class="counter clearfix">
									<li class="rbor3" title="总访问：912 今天访问：0"><a
											id="_OwnerInfoApp_hv" href="javascript:void(0)">912</a>访问</li>
									<li class="rbor3 feeds"><a id="QM_Profile_Blog_Cnt"
													href="PostList?id=${blog.id}">${fn:length(blog.posts)}</a>日志
									</li>
									<li class="badge"><a id="QM_Profile_Photo_Cnt" href="#">53</a>照片
									</li>
								</ul>
							</div>
						</div>
						</div>
							<div class="collet_box mod_wrap">
							   <div class="mod_wrap_hd">
								   <h3>
									  <a href="#">日志留言</a>
									</h3>
								</div>
							<div class="box_bd mod_wrap_bd">
								<div class="fn_weibo">
									<div id="moodListc" class="mod_scroll_feed">
										<div class="feed_list">
											<ul id="moodList">
												<!-- 所有留言倒序 -->
									<c:forEach items="${commentList}" var="comment">
										<li class="bbor3">
											<div class="feed_cont">${comment.comment}</div>
										     <p class="feed_op">
											   <span> <a href="Post?id=${comment.post.id}#singleCommentDiv_${comment.id}">
															<fmt:formatDate value="${comment.createOn}"
																pattern="yyyy年MM月dd日 HH时mm分" />
													  </a>
											  </span>
										    </p>
										</li>
									</c:forEach>
												</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

							<!-- 右 -->
				<div id="bloglist">
					<div class="collet_box mod_wrap">
						<div class="box_inner mod_wrap_inner">
							<div class="box_hd mod_wrap_hd">
								<div class="box_hd">
								   <h3>
									  <a href="PostList?id=${blog.id}"">最新日志</a>
									</h3>
								</div>
							</div>
							<div class="box_bd mod_wrap_bd">
								<div id="blogListc">
									<div class="fn_blog_type2">
									   <div class="scroll_feed">
											<div class="list_comments_wrap">
												<ol class="blog_list">
									<c:forEach items="${blog.posts}" var="post">
										<li class="bbor3">
											<h4 class="textoverflow">
												<a class="ui_fontYahei title" href="Post?id=${post.id}"> ${post.subject} </a>
											</h4>
									        <div class="article">${post.body}</div>
										    <div class="op">
												<a class="ui_mr10" href="Post?id=${post.id}">查看全文»</a>
												<a class="ui_mr10" href="Post?id=${post.id}">阅读(${post.visit})</a>
												<a class="ui_mr10" href="Post?id=${post.id}#commentListContainer">评论(${fn:length(post.commentList)})</a>
											   <span class="c_tx3 ui_mr10">|</span>
											   <span class="date c_tx3"> 
											      <fmt:formatDate value="${post.createOn}" pattern="yyyy年MM月dd日 HH时mm分" />
											   </span>
										</div>
									</li>
								</c:forEach>
							                 </ol>
									   </div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="lay_lace_b"></div>
</div>



			<!-- 版权 -->
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
 --%>
</body>
</html>