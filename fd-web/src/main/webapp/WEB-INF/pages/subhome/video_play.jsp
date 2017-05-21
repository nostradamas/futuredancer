<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="cn">
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>查看课程</title>
<link href="${SERVER_PATH_resources}/css/video.css" rel="stylesheet" type="text/css">
<link href="${SERVER_PATH_resources}/assets/plugins/video/mediaelementplayer.min.css" rel="stylesheet" type="text/css">
<script src="${SERVER_PATH_resources}/assets/plugins/video/jquery.js"></script>
<script src="${SERVER_PATH_resources}/assets/plugins/video/mediaelement-and-player.min.js"></script>
<style>
	
</style>
</head>
<body>
	<input type="hidden" value="${cid}" id="cid"/>
	<section class="mt20 mb40 text-center" id="playvideo-id">
		<div class="text-left" >
			 <video playsinline  poster="${empty classBean ? '' : classBean.img}" style="width: 100%; height: 100%;" controls="controls">
                <!-- Pseudo HTML5 -->
                <source src="${empty classBean ? '' : classBean.videoUrl}" type="video/mp4">
             </video>
		</div>
	</section>
	<script type="text/javascript" src="${SERVER_PATH_resources}/assets/plugins/jquery.min.js"></script>
	<!-- bootstrap -->
	<script type="text/javascript" src="${SERVER_PATH_resources}/assets/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	$(window).load(function() {
		var cid = $('#cid').val();
        $('video').mediaelementplayer({pauseOtherPlayers: true });
	});
	</script>
</body>
</html>
