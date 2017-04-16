/**
 * 
 */
$(function(){
	alert("111");
	$("#username").blur(function(){
		checkUsername();
	});
})

function txtBlur(element) {
	var psw = $("#password").val();
	var pswagain = $("#password_again").val();
	if (psw != pswagain) {
		$("#password_again_info").html("密码不一致请重新输入");
		$("#password_again").val("");
	} else {
		$("#password_again_info").html("*").css("color", "green");
	}
}

function checkUsername() {
	alert("123");
	var username=$("#username").val();
	$.ajax({
		url:"checkUsername",
		data:{
			username:username
		},
		success:function(data){
			if(data=="ok"){
				$("#username_info").html("*").css("color","green");
				$("#submit").prop("disabled",false).css("color","black");
			}else if(data=="no"){
				$("#username_info").html("该昵称已经存在");
				$("#submit").prop("disabled",true).css("color","gray");
			}
		}
	});
}


function showUsernameTip() {
	var username = document.f1.username;
	var infoId = username.id + "_info";
	var info = document.getElementById(infoId);
	info.className = "tip";
	info.innerHTML = "请输入昵称";
}
