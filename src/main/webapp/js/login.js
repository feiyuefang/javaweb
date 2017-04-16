/**
 * 
 */
$(function(){
	$("#subbtn").click(function(){
		var username = $("#u");
		var password = $("#p");
		if(username==null || password==null){
			alert("账户或密码不能为空");
		}
	});
});
