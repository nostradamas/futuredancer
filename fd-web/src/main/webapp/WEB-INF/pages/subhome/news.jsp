<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="cn">
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<link href="${SERVER_PATH_resources}/css/news.css" rel="stylesheet" type="text/css">

<title>新闻资讯</title>
</head>
	<!-- 导航banner  -->
	<section>
		<div id="banner" >
			<div class="flexslider">
				<ul class="slides" id="banner-ul-id">
				</ul>
			</div>
		</div>
	</section>
	<!-- 新闻资讯 -->
	<section class="mt20 mb40 pb80 text-center">
		<div class="mt15 mb40 text-left">
			<div class="row">
				<div class="col-md-12">
					<ul class="news-navi" id="news-nav-id">
					</ul>
				</div>
			</div>
		</div>
		<div class="container-fluid text-left w95" id="news-content-id">
		</div>
		<div class="row mb40 text-center" id="page-nav-id">
		</div>
	</section>
	<!-- 轮播图 -->
	<script type="text/javascript" src="${SERVER_PATH_resources}/assets/plugins/flexslider/jquery.flexslider.js"></script>
	
	<script type="text/javascript" src="${SERVER_PATH_resources}/js/banner_slider.js"></script>
	<script type="text/javascript" src="${SERVER_PATH_resources}/js/common.js"></script>
	<script type="text/javascript" src="${SERVER_PATH_resources}/js/news.js"></script>
	<script type="text/javascript">
		$(window).load(function() {
			getBanners(1);
			getCategory(8);
			
			var top = $(window).height() - $('.index-header').height(); //获取某个元素距顶部的距离
	        $("body,html").animate({scrollTop:(top-20)+"px"},500);
		});
	</script>
</body>
</html>
