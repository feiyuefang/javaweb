<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分享生活-留住感动</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<link type="image/x-icon" href="favicon.ico" rel="Shortcut Icon">
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>

</head>
<body>

<div class="lay_wrap" id="lay">
	<div class="lay_main clearfix">
		<div class="lay_inner">
			<div class="login_head">
				<h1>
					<i class="ui_icon icon_qzone_logo">
						<a href="Index"><span class="none">SPACE</span></a>
					</i>
				</h1>
			</div>
			<div class="login_img">
				<span class="img_slogan"></span>
			</div>
			<div class="login_wrap" id="normal_login">
				<form id="loginform" name="loginform" action="login" method="post" >
					<div class="login_form" id="web_login">
						<div class="form_item form_item_error" style="display:none" id="err_m"></div>
						<div class="form_item form_item_username">
							<input placeholder="用户名" value="" id="u" name="accountNumber" tabindex="2" class="ui_textinput" type="text">
							<div>${error}</div>
						</div>
						<div class="form_item form_item_password">
							<input placeholder="密码" maxlength="16" id="p" name="password" tabindex="3" class="ui_textinput" value="" type="password">
						</div>
						<div class="form_item form_item_btn">
							<button class="ui_btn btn_login" type="submit" id="subbtn"><span class="ui_hide">登录</span></button>
						</div>
					</div>
				</form>
				<div class="login_fast" id="qlogin"></div>
				<div class="login_option">
					<div class="option_item">
						<a href="http://aq.qq.com/cn/findpsw/findpsw_index" target="_blank">忘记密码</a><span class="ui_sep_line">|</span><a href="registerForm" >注册新账号</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="lay_foot">
		<div class="lay_inner">
			<div class="copyright">
				<p class="copyright_en">Copyright © 2011 - 2013 Beyond. All Rights Reserved.</p>
				<p class="copyright_cn">Beyond  版权所有</p>
			</div>
		</div>
	</div>
</div>

<div id="lay_bg" class="lay_background" style="width: 100%; height: 100%;">
<img id="lay_bg_img" class="lay_background_img lay_background_img_fade_out" alt="" src="images/upfile_1759896_1352170422.jpg" style="width: 100%; height: 100%;">
</div>
</body>
</html>