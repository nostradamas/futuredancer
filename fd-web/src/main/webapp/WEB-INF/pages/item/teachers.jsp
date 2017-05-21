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
	<input type="hidden" value="${empty homeBean?'':homeBean.hid}" id="homeId"/>
	<input type="hidden" value="${empty homeBean?'':homeBean.isLeaf}" id="isLeaf"/>
	<input type="hidden" value="${empty homeBean?'':homeBean.parentId}" id="parentId"/>
	<input type="hidden" value="${tabId}" id="tabId"/>
	
	<!-- 导航banner  -->
	<section>
		<div id="banner" >
			<div class="flexslider">
				<ul class="slides" id="banner-ul-id">
				</ul>
			</div>
		</div>
	</section>
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
		<h3>教育总监</h3>
		<h4>teachers</h4>
		<div class="container mt20">
			<div class="row" id="teacher-type1-id">
			</div>
		</div>
	</section>
	<!-- 舞蹈教员 -->
	<section class="mt40 mb40 pb80 text-center">
		<h3>舞蹈教员</h3>
		<h4>teachers</h4>
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
		var isLeaf = $('#isLeaf').val();
		var parentId = $('#parentId').val();
		var tabId = $('#tabId').val();
		// tab导航
		getSubHomeMenus(hid, isLeaf, parentId);
		getBanners(1);
		getSubNav(hid, tabId);
		getItemContent(tabId);
		var top = $(window).height() - $('.index-header').height(); //获取某个元素距顶部的距离
        $("body,html").animate({scrollTop:(top-60)+"px"},500);
		getTeachers(hid, 1);
		getTeachers(hid, 2);
	});
	</script>
 </body>
</html>
