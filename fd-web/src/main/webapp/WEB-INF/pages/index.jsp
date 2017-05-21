<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="cn">
<head>
	<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
	<title>未来舞者官方网站-专业的舞蹈教育</title>
	
	
	<!-- 轮播图样式 -->
	<link href="${SERVER_PATH_resources}/assets/plugins/flexslider/flexslider.css" rel="stylesheet" type="text/css">
	<!-- 首页 CSS样式 -->
	<link href="${SERVER_PATH_resources}/css/index.css" rel="stylesheet" type="text/css">
	<link href="${SERVER_PATH_resources}/css/index-response.css" rel="stylesheet" type="text/css">
	<!-- 公共基本样式-->
	<link href="${SERVER_PATH_resources}/css/common.css" rel="stylesheet" type="text/css">
	<link href="${SERVER_PATH_resources}/css/common-response.css" rel="stylesheet" type="text/css">
	
	<link href="${SERVER_PATH_resources}/css/teacher.css" rel="stylesheet" type="text/css">
	
	<!-- bootstrap 插件对话框 -->
	<link href="${SERVER_PATH_resources}/assets/plugins/bootstrap/dialog/bootstrap-dialog.css" rel="stylesheet" type="text/css" >
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	<style>
		#studentlistId .teacher-info {
		    border-radius: 20px;
		    overflow: hidden;
		}
		
		#content-aid.content-bg{
			background-position: -100px 0;
		}
	</style>
</head>            
<body>
	<header class="index-header mt10 mb10">
		<input type="hidden" value="${homeId}" id="homeId"/>
		<div class="container" >
			<div class="row">
				<div class="col-md-2 col-xs-2">
					<div class="logo">
						<a href="${SERVER_PATH}/" title="首页"><img src="http://on01whf2s.bkt.clouddn.com/logo.png" alt="logo" /></a>
					</div>
				</div>
				<div class="col-md-8 col-xs-10" id="index-tab-id">
					<ul class="index-header-ul" >
					</ul>	
				</div>
			</div>
		</div>
	</header>
	<!-- 导航banner  -->
	<section>
		<div class="header-nav">
			<ul class="navigation" id="menu-id" >
			</ul>
		</div>
		<div id="banner">
			<div class="flexslider">
				<ul class="slides" id="banner-ul-id">
				</ul>
			</div>
		</div>
	</section>
	<!-- 关于我们 -->
	<section class="content-bg bg mt25" id="content-aid">
		<div class="content-img">
			<img src=""/>
		</div>
		<div class="content-div">
			<div class="container ">
				<div class="row" >
					<div class="col-md-4 text-left content-back-bg">
						<h3 class="title"></h3>
						<p class="lh2 mt20" id="content-aid-content">
						</p>
						<div class="aboutus-right">
							<div class="link-div">
								<a href="#" title="关于我们"><img class="link-img" src="http://on01whf2s.bkt.clouddn.com/link.png" alt="link"/> </a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- 名师配置 -->
	<section class="pt40 pb40 mt5">
		<div class="container">
			<div class="row" id="content-tid">
				<div class="col-md-4 col-sm-6 col-xs-12 index-teacher"  >
					<h3 class="title">名师配置</h3>
					<p class="lh15 mt20" id="content-tid-content">
					</p>
					<a href="#" title="查看更多" class="mr10 mt40 fr link-btn">
						查看更多<i class="iconfont icon-tiaozhuan"></i>
					</a>
					<div class="clear"></div>
				</div>
				<div class="col-md-7 col-md-offset-1 col-xs-12" id="slider-id">
					<div class="teacher-slides ">
						<ul class="slides teacher-slides-ul" id="index-teacher-id">
						</ul>
						 <ul class="slide-caption" id="index-teacher-capId">
					        <li><a href="###">1</a></li>
					        <li><a href="###">2</a></li>
					        <li><a href="###">3</a></li>
					        <li><a href="###">4</a></li>
					    </ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- 成果展示 -->
	<section class="bg pt20 pb30 bg-lightyellow" id="content-sid">
		<div class="container text-left">
			<div class="row">
				<div class="col-md-4 col-sm-6 col-xs-12" >
					<h3 class="title">成果展示</h3>
					<p class="mb20 lh15" id="content-sid-content">
					</p>
				</div>
			</div>
		</div>
		<div class="container mt20 text-left">
			<div class="row" id="studentlistId">
			</div>
		</div>
		<div class="container mt10 text-center">
			<div class="row">
				<a href="#" class="mr10 mt10 link-btn">
					查看更多<i class="iconfont icon-tiaozhuan"></i>
				</a>
			</div>
		</div>
					
	</section>
	<!-- 新闻咨询 -->
	<section class="mt40 mb40 newslist mt5 " id="content-nid">
		<div class="container">
			<div class="row">
				<div class="col-md-5 col-sm-6 col-xs-12 mt60 pb60" id="content-nid-content">
					<h3 class="title">新闻资讯</h3>
					<p class="lh15 mt30">
					</p>
					<a href="#" class="mr10 mt40 link-btn fr">
						查看更多<i class="iconfont icon-tiaozhuan"></i>
					</a>
					<div class="clear"></div>
				</div>
				<div class="col-md-7 col-sm-6 col-xs-12 mt60 pb60">
					<div class="newsimg">
						<img src="" class="sub-Img-css fr" alt="news"/>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
	</section>
	<!-- 网络云课堂 -->
	<section class="pt40 pb80 bg-grey">
		<div class="container" id="content-cid">
			<div class="row">
				<div class="col-md-5 col-sm-12">
					<h3 class="title">网络云课堂</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 col-sm-12" >
					<p class="lh15 mt20" id="content-cid-content">
					</p>
					<a href="#" class="mt20 link-btn">
						查看更多<i class="iconfont icon-tiaozhuan"></i>
					</a>
				</div>
			</div>
		</div>
		<div class="container mt40 mb40">
			<div class="flexslider" id="index-video-slide">
			</div>
		</div>
	</section>
	<!-- footer -->
	<%@ include file="/WEB-INF/pages/common/footer.jsp"%>
	<script type="text/javascript" src="${SERVER_PATH_resources}/assets/plugins/jquery.min.js"></script>
	<!-- bootstrap -->
	<script type="text/javascript" src="${SERVER_PATH_resources}/assets/bootstrap/js/bootstrap.min.js"></script>
	<!-- 轮播图 -->
	<script type="text/javascript" src="${SERVER_PATH_resources}/assets/plugins/flexslider/jquery.flexslider.js"></script>
	<!-- bootstrap 插件对话框 -->
	<script src="${SERVER_PATH_resources}/assets/plugins/bootstrap/dialog/bootstrap-dialog.min.js"></script>
	
	<script type="text/javascript" src="${SERVER_PATH_resources}/js/banner_slider.js"></script>
	
	<script type="text/javascript" src="${SERVER_PATH_resources}/js/get_data.js"></script>
	<script type="text/javascript" src="${SERVER_PATH_resources}/js/student.js"></script>
	<script type="text/javascript" src="${SERVER_PATH_resources}/js/index.js"></script>
	<script type="text/javascript" src="${SERVER_PATH_resources}/js/video.js"></script>
		
</body>
</html>
