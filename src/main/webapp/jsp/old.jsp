<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="old">
	<div class="mytitle">
		<div style="font-size: 14px; font-weight: bold;">那年今日~他们说了什么</div>
	</div>
	<c:if test="${empty talkList}">
		<span style="font-size: 14px; font-weight: bold;">你的回忆暂时为空...</span>
	</c:if>
</div>
