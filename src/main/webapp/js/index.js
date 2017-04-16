/**
 * 总的index
 */
$(function() {
	var accountNumber =$("#accountNumber").val();
	if(accountNumber!=null){
		alert("请记住你的账号:"+accountNumber);
	}
	
	var message=$("#message").val();
	if(message=="publish"){
		$("#talks").siblings().hide();
	}else if(message=="special"){
		$("#myspecial").siblings().hide();
	}else if(message=="myold"){
		$("#myold").siblings().hide();
	}
	$(".lefts ul li a").click(function() {
		display($(this).attr("class"));
		ajax($(this).attr("class"));
	});
});

function display(cls) {
	$("#" + cls).show();
	$("#" + cls).siblings().hide();
}

function ajax(model) {
	if (model == "mycomm") {
		mycomm();
	}
	if(model=="mylike"){
		mylike();
	}
	/*if(model=="myspecial"){
		myspecial();
	}*/
}

function mycomm(){
	$.ajax({
		url : "commWithout",
		dataType : "json",
		success : function(data) {
			$(".mycomms").html("");
			$.each(data, function(index, entity) {
				$(".mycomms").append(
						"<div class='mycom'><div class='commtop'>"
								+ "<div class='head'>" + "<img src='"
								+ entity.user.headPortrait
								+ "'width='45px' height='45px'></div>"
								+ "<div class='commname'>"
								+ entity.user.nickname + "</div>"
								+ "<div class='commtime'>+"
								+ entity.comment.time + "</div>" + "</div>"
								+ "<div class='mycon'>&nbsp;&nbsp;"
								+ entity.comment.content + "</div>"
								+ "<div class='myc'>" + entity.talk.content
								+ "</div>");
			});
		}
	});
}

function mylike(){
	$.ajax({
		url : "likeWithout",
		dataType : "json",
		beforeSend:function(){
			$("#showMes").html('loading...');
			},
		success : function(data) {
			$(".mylikes").html("");
			$.each(data, function(index, entity) {
				$("#showMes").html('');
				$(".mylikes").append(
						"<div class='mycom'><div class='commtop'>"
								+ "<div class='head'>" + "<img src='"
								+ entity.user.headPortrait
								+ "'width='45px' height='45px'></div>"
								+ "<div class='commname'>"
								+ entity.user.nickname + "</div>"
								+ "<div class='commtime'>+"
								+ entity.like.time + "</div>" + "</div>"
								+ "<div class='mycon'>&nbsp;&nbsp;"
								+ "赞了我的说说" + "</div>"
								+ "<div class='myc'>" + entity.talk.content
								+ "</div>");
			});
		}
	});
}









