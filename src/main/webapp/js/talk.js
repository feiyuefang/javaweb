/**
 * 对说说的点赞，评论，转发等功能
 */
$(function() {
	/* $("#commentbutton").click(function() {}); */
});
function clicks(ids) {
	var comment = $("#comment_"+ids).val();
	console.log(comment);
	console.log(ids);
	$.ajax({
		url : "publishComment",
		data : {
			id : ids,
			content : comment
		},
		type:"post",
		success : function(data) {
			var comm = eval( '(' + data + ')' );
			$("#comment_"+ids).val("");
			/*$("#comm_" + ids).append(data.content).append("<br>");*/
			$("#comm_" + ids).append("<div style='width: 30px; height: 30px; border-radius: 50%; overflow: hidden;margin-left: 10px;'>" +
					"<img src='"+comm.photo+"' width='30px' height='30px'></div>");
			$("#comm_" + ids).append("<div style='color:blue;margin-left:-15px;'>"+comm.name+":</div>");
			$("#comm_" + ids).append("<div style='margin-left: -15px; font-weight: bold;'>"+comm.content+"</div>");
			$("#comm_" + ids).append("<div><span style='font-size:12px;color:gray'>"+comm.time+"</span></div>");
	
		}
	});

}
function dolike(id) {
	var number = parseInt($(".likeNumber_" + id).html());
	$.ajax({
		url : "dolike",
		data : {
			talkId : id
		},
		success : function(data) {
			if (data == "delete") {
				$(".zan_" + id).html("点赞").css("color", 'black');
				$(".likeNumber_" + id).html(number - 1);
			} else {
				$(".zan_" + id).html("已赞").css("color", 'red');
				$(".likeNumber_" + id).html(number + 1);
			}
		}
	});
}