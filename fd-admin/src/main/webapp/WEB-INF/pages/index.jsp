<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
  <title>泰安市公共技术信息服务平台</title>
  <link rel="stylesheet" type="text/css" href="${SERVER_PATH_resources}/assets/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" type="text/css" href="${SERVER_PATH_resources}/assets/font/css/font-awesome.min.css">

  <link rel="stylesheet" type="text/css" href="${SERVER_PATH_resources}/css/main-style.css" >

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->

</head>
<body>
	<!-- Header -->
	<div class="ptst-header">
		<div class="container">
			<div class="row">
				<div class="login">
					<a href="login.html">
					<img src="${SERVER_PATH_resources}/image/mini_pic2.png" class="login_icon">登录</a> 
						<span class="login_line">|</span> 
					<a><img src="${SERVER_PATH_resources}/image/mini_pic3.png" class="login_icon">注册</a>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="ptst-section-header">
					<div class="col-lg-3 col-md-3 col-sm-3">
						<hr>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-6">
						<h2 class="ptst-section-title">泰安市公共技术信息服务平台</h2>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-3">
						<hr>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- gray bg -->
	<section class="container ptst-home-section-1" id="more">
		<div class="section-margin-top">

			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<div class="ptst-tours-box-1">
					<img src="${SERVER_PATH_resources}/image/info.jpg" alt="image" class="img-responsive">

					<div class="ptst-tours-box-1-link">
						<div class="ptst-tours-box-1-link-left">信息服务中心</div>
						<a href="${SERVER_PATH}/admin/home/toInfoCenterMain" class="ptst-tours-box-1-link-right"> 进入 </a>
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<div class="ptst-tours-box-1">
					<img src="${SERVER_PATH_resources}/image/sc.jpg" alt="image" class="img-responsive">

					<div class="ptst-tours-box-1-link">
						<div class="ptst-tours-box-1-link-left">科技服务中心</div>
						<a href="${SERVER_PATH}/tech/index"
							class="ptst-tours-box-1-link-right"> 进入 </a>
					</div>
				</div>
			</div>
		</div>

	</section>
	<footer id="footer" style="width: 100%" class="ptst-footer-bg">
		<div class="container">
			<div class="row">
				<p class="ptst-copyright-text">单位地址：泰安市高新区高创中心 &nbsp; | &nbsp;
					网站支撑单位：山东融御中安信息安全有限公司</p>
			</div>
		</div>
	</footer>
	<!-- jQuery 2.2.0 -->
	<script src="${SERVER_PATH_resources}/assets/plugins/jQuery/jquery-2.2.3.min.js"></script>

	<script src="${SERVER_PATH_resources}/assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
