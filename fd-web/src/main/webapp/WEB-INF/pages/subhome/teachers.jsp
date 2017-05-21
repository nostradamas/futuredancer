<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="cn">
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>名师配备</title>

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
	<input type="hidden" value="${homeId}" id="homeId"/>
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
	<!-- 教育总监 -->
	<section class="mt40 mb40 text-center">
		<h3>教育主管</h3>
		<h4>Education Supervisor</h4>
		<div class="container mt20">
			<div class="row" id="teacher-type1-id">
			</div>
		</div>
	</section>
	<!-- 舞蹈教员 -->
	<section class="mt40 mb40 pb80 text-center">
		<h3>金牌教师</h3>
		<h4>Gold Teachers</h4>
		<div class="container mt20 text-left">
			<div class="row" id="teacher-type2-id">
			</div>
		</div>
	</section>
		
	<!-- 轮播图 -->
	<script type="text/javascript" src="${SERVER_PATH_resources}/assets/plugins/flexslider/jquery.flexslider.js"></script>

	<script type="text/javascript" src="${SERVER_PATH_resources}/js/banner_slider.js"></script>
		
		
	<script type="text/javascript" src="${SERVER_PATH_resources}/js/teacher.js"></script>
	<script type="text/javascript">
	$(window).load(function() {
		var hid = $('#homeId').val();
		getBanners(1);
		getTeachers(hid, 1);
		getTeachers(hid, 2);
		var tagetId = $('#targetId').val(); 
		getItemContent(tagetId);
		var top = $(window).height() - $('.index-header').height(); //获取某个元素距顶部的距离
        $("body,html").animate({scrollTop:(top-60)+"px"},500);
	});
	</script>
 </body>
</html>
