/**
 * 
 */
$(function(){
	$('#nav li').mouseover(function(){
		$(this).addClass('active').siblings().removeClass('active');
		$('.contents').eq($(this).index()).addClass('active').siblings().removeClass('active');
	});
});

function addSpecial(id){
	$.ajax({
		url:"makeSpecial",
		data:{
			uid:id,
			token:"add"
		},
		success:function(data){
			if(data=="ok"){
				alert("添加成功!");
			}
			$("specialfriend_"+id).remove();
			$("usualfriend").append($("specialfriend_"+id).html());
		}
	});
}

function removeSpecial(id){
	$.ajax({
		url:"makeSpecial",
		data:{
			uid:id,
			token:"remove"
		},
		success:function(data){
			if(data=="ok"){
				alert("取消成功!");
			}
			$("uaualfriend_"+id).remove();
			$("specialfriend").append($("uaualfriend_"+id).html());
		}
	});
}


