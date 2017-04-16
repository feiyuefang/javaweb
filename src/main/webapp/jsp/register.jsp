<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MYSPACE注册</title>
<link rel="stylesheet" type="text/css" href="css/g_form.css">
<link rel="stylesheet" type="text/css" href="css/g.css">
<link type="image/x-icon" href="favicon.ico" rel="Shortcut Icon">
<!-- <script type="text/javascript" src="js/tools.js"></script> -->
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/register.js"></script>
</head>
<body>

<div class="bg">
	<div class="container">
		<div class="header">
			<a href="Index"><span class="none">MYSPACE注册</span></a>
		</div>
		<div class="content">
			
			<div class="right">
				
				<div>
				<!-- begin -->
					<form name="f1" action="Register" method="post" onsubmit="return checkForm()" > 
						
						<div class="box box_3" style="z-index:0">
							<label class="item" for="nick">你的昵称</label>
							<div class="ipt_box nick_ipt_box">
								<div id="username_bg" class="bg_txt">
								<input type="text" class="new_txt" id="username" name="username" maxlength="24"/>
								</div>
							</div>
							<div class="info"><table><tr><td id="username_info"></td></tr></table></div>
						</div>
						<div class="box box_4">
							<label class="item" for="password">密码</label>
							<div class="ipt_box">
								<div id="password_bg" class="bg_txt">
								<input  type="password" class="new_txt" id="password" name="password" maxlength="16" />
								</div>
							</div>

							</div>
						</div>
						<div class="box box_5">
							<label class="item" for="password_again">确认密码</label>
							<div class="ipt_box">
								<div id="password_again_bg" class="bg_txt">
								<input onblur="txtBlur(this)" type="password" class="new_txt" name="password_again" id="password_again" maxlength="16" />
								</div>
							</div>
							<div class="info"><table><tr><td id="password_again_info" style="color:red;"></td></tr></table></div>
						</div>
						
						<div class="box box_10" id="qzone_box">
                            <div class="item"></div>
                            <div class="ipt_box qzone_box nopadding">
                            	<!--<a class="checked" name="qzone" id="qzone">同时开通QQ空间</a>-->
                            	<input id="myspace" name="myspace" type="checkbox" checked="checked"/>&nbsp;同时开通空间
                            </div>
                           
                        </div>
						<div class="box box_11">
							<div class="item"></div>
							<div class="ipt_box">
								<div class="agree_box"> 
									<!--<a name="agree" class="a_1 checked" id="agree">我已阅读并同意相关服务条款</a>-->
									<div style="float: left;">
									<input id="agree" name="agree" type="checkbox" checked="checked" onclick="agreeServe(this)" />&nbsp;我已阅读并同意相关服务条款
									</div>
                           
									<div id="x_box" class="x_box">
										<div id="x_switcher" title="点击查看用户协议" onclick="showServe()"></div>
									</div>
									<div class="clear"></div>
									<div id="x_box1" class="x_box1" style="display: none;" >
										<iframe src="serve.html" width="730px" height="300px" frameborder="0"></iframe>
									</div>
								</div>
								<div class="submit">
									<input class="" type="submit" value="立即注册" title="立即注册" id="submit"/>
								</div>
							</div>
							<div class="info"></div>
						</div>
					</form>
				<!-- end -->
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</div>
<div class="footer">Copyright © 2011 - 2013 Beyond. All Rights Reserved. Beyond版权所有</div>

</body>
</html>
