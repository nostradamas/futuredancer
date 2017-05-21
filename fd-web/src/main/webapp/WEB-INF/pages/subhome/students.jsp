<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="cn">
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>成果展示</title>

<link href="${SERVER_PATH_resources}/css/teacher.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 导航banner  -->
	<section>
		<div id="banner" >
			<div class="flexslider">
				<ul class="slides" id="banner-ul-id">
				</ul>
			</div>
		</div>
	</section>
	<!-- banner -->
	<input type="hidden" value="${targetId}" id="targetId"/>
	<section class="pt40 pb40 bg-lightyellow" id="banner-targetId">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 col-sm-12 text-center">
					<h3></h3>
					<p  class="lh15">
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- 优秀学员 -->
	<section class="mt40 mb40 pb80 text-center show-students">
		<h3>优秀学员</h3>
		<h4>Excellent Student</h4>
		<div class="container mt20 text-left">
			<div class="row" id="studentlistId">
			</div>
		</div>
		<div class="container mt20 text-center" id="studentlistId-page">
		</div>
	</section>
	<!-- 轮播图 -->
	<script type="text/javascript" src="${SERVER_PATH_resources}/assets/plugins/flexslider/jquery.flexslider.js"></script>
	
	<script type="text/javascript" src="${SERVER_PATH_resources}/js/banner_slider.js"></script>
	
	<script type="text/javascript"
		src="${SERVER_PATH_resources}/js/common.js"></script>
	<script type="text/javascript"
		src="${SERVER_PATH_resources}/js/student.js"></script>
	<script type="text/javascript">
		$(window).load(function() {
			getBanners(1);
			var hid = $('#homeId').val();
			getStudents(1, 16, 'studentlistId', true, hid);
			var tagetId = $('#targetId').val(); 
			getItemContent(tagetId);
			var top = $(window).height() - $('.index-header').height(); //获取某个元素距顶部的距离
	        $("body,html").animate({scrollTop:(top-20)+"px"},500);
		});
	</script>
</body>
</html>
