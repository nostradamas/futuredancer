<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="cn">
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>网络课程</title>

<link href="${SERVER_PATH_resources}/css/teacher.css" rel="stylesheet" type="text/css">
<link href="${SERVER_PATH_resources}/css/video.css" rel="stylesheet" type="text/css">
<link href="${SERVER_PATH_resources}/css/video-response.css" rel="stylesheet" type="text/css">

<!-- bootstrap 插件对话框 -->
<link href="${SERVER_PATH_resources}/assets/plugins/bootstrap/dialog/bootstrap-dialog.css" rel="stylesheet" type="text/css" >
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

</head>
<body>
	<!-- 导航banner  -->
	<div id="container">
		<video id="background_video" loop muted controls="true"></video>
	    <div id="video_cover"></div>
	    <div id="overlay"></div>
	</div>
	<!-- 往期回顾 -->
	<section class="mt40 mb40 text-center">
		<h3>往期回顾</h3>
		<h4>Review Classes</h4>
		<div class="container mt20 text-left" >
			<div class="row" id="videoId"></div>
		</div>
	</section>
	<script type="text/javascript" src="${SERVER_PATH_resources}/assets/plugins/jquery.min.js"></script>
	<!-- bootstrap -->
	<script type="text/javascript"
		src="${SERVER_PATH_resources}/assets/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${SERVER_PATH_resources}/js/bideo.js"></script>
	<script type="text/javascript" src="${SERVER_PATH_resources}/js/videoMain.js"></script>
	<script type="text/javascript" src="${SERVER_PATH_resources}/js/video.js"></script>
	<!-- bootstrap 插件对话框 -->
	<script src="${SERVER_PATH_resources}/assets/plugins/bootstrap/dialog/bootstrap-dialog.min.js"></script>

</body>
</html>
