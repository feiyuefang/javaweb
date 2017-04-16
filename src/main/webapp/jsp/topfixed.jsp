<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="main">
	<div class="left">
		<c:if test="${tbuser.accountNumber != null }">
			<div class="tc">
				<c:if test="${empty tbuser.headPortrait}">
					<div
						style="width: 40px; height: 40px; border-radius: 50%; overflow: hidden; margin-top: 5px;">
						<img alt="头像" src="images/defaultImage.jpg" width="40px"
							height="40px" style="margin-top: 5px">
					</div>
				</c:if>
				<div
					style="width: 40px; height: 40px; border-radius: 50%; overflow: hidden; margin-top: 5px;">
					<img alt="头像" src="${tbuser.headPortrait}" width="40px"
						height="40px" style="margin-top: 0px;">
				</div>
				</a> &nbsp;&nbsp; <a href="#" style="font-size: 12px;">${tbuser.nickname}</a>
			</div>
		</c:if>
	</div>
	<div class="tc">
		<a href="#">退出</a>
	</div>
	<div class="tc">
		<a href="#">个人中心</a>
	</div>
</div>

<!-- 对头像的上传和修改 -->

<a class="protrait"><img alt="头像" src="${tbuser.headPortrait}"
	width="100px" height="100px" style="margin-top: 50px;"></a>

<div
	style="height: 100px; padding-left: 30px; line-height: 100px; margin-top: -100px; margin-left: 300px;">
	<span style="font-size: 20px;">${tbuser.nickname}</span>
</div>
<div
	style="height: 100px; margin-top: -90px; margin-left: 400px; line-height: 150px; margin-bottom: 10px;">
	<span style=" font-size: 14px;font-weight: bold;"><span style="color: red;">签名：</span>许自己一个光明的未来</span>
</div>
<div class="lay_menuContainer">
	<ul>
		<li><a href="#">主页</a></li>
		<li><a href="#">日志</a></li>
		<li><a href="#">音乐</a></li>
		<li><a href="#">留言板</a></li>
		<li><a href="#">相册</a></li>
		<li><a href="#">说说</a></li>
		<li><a href="#">个人档</a></li>
		<li><a href="#">时光轴</a></li>
		<li><a href="#">更多</a></li>
	</ul>
</div>

<form name="form" id="popup"
	action="<%=request.getContextPath()%>/UploadDemo/uploadHeadImage"
	class="form-horizontal" method="post" enctype="multipart/form-data">
	<div class="modal-body text-center">
		<div class="zxx_main_con">
			<div class="zxx_test_list">
				<input class="photo-file" type="file" name="imgFile" id="fcupload"
					onchange="readURL(this);" /> <input type="submit" value="上传" /> <a
					href="javascript:display();" class="display">取消</a> <img alt=""
					src="" id="cutimg" /> <input type="hidden" id="x" name="x" /> <input
					type="hidden" id="y" name="y" /> <input type="hidden" id="w"
					name="w" /> <input type="hidden" id="h" name="h" />
			</div>
		</div>
	</div>
	<div id="preview-pane">
		<div class="preview-container">
			<img src="" class="jcrop-preview" alt="预览">
		</div>
	</div>
</form>




<script type="text/javascript">
	//定义一个全局api，这样操作起来比较灵活
	var api = null, boundx, boundy, $preview = $('#preview-pane'), $pcnt = $('#preview-pane .preview-container'), $pimg = $('#preview-pane .preview-container img'), xsize = $pcnt
			.width(), ysize = $pcnt.height();
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.readAsDataURL(input.files[0]);
			reader.onload = function(e) {
				$('#cutimg').removeAttr('src');
				$('#cutimg').attr('src', e.target.result);
				$pimg.removeAttr('src');
				$pimg.attr('src', e.target.result);

				api = $.Jcrop('#cutimg', {
					setSelect : [ 20, 20, 200, 200 ],
					aspectRatio : 1,
					onSelect : updateCoords,
					onChange : updateCoords
				});
				var bounds = api.getBounds();
				boundx = bounds[0];
				boundy = bounds[1];
				$preview.appendTo(api.ui.holder);
			};
			if (api != undefined) {
				api.destroy();
			}
		}
		function updateCoords(obj) {
			$("#x").val(obj.x);
			$("#y").val(obj.y);
			$("#w").val(obj.w);
			$("#h").val(obj.h);
			if (parseInt(obj.w) > 0) {
				var rx = xsize / obj.w;
				var ry = ysize / obj.h;
				$pimg.css({
					width : Math.round(rx * boundx) + 'px',
					height : Math.round(ry * boundy) + 'px',
					marginLeft : '-' + Math.round(rx * obj.x) + 'px',
					marginTop : '-' + Math.round(ry * obj.y) + 'px'
				});
			}
		}
		;
	}
</script>

