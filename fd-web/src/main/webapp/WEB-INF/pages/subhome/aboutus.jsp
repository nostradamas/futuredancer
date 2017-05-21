<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="cn">
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>关于我们</title>
<style>
	.content-bg{
		background-position: -100px 0;
	}
</style>
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
	<!-- 关于我们 -->
	<section class="content-bg bg mt5"  id="content-id">
		<div class="content-img">
			<img src="${!empty aboutusBean ? aboutusBean.modeImg : ''}" id="aboutusImg"/>
		</div>
		<div class="content-div mt100">
			<div class="container">
				<div class="row">
					<div class="col-md-10  col-md-offset-1 col-sm-12">
						<div class="text-center">
							<h3>关于我们</h3>
							<h4>About Us</h4>
							<p class="lh2">
								<c:if test="${!empty aboutusBean}">
								<% 
							    	request.setAttribute("vEnter", "\n"); 
							    %> 
							    ${fn:replace(aboutusBean.aboutus,vEnter,"<br/>")}
								</c:if>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- 授课模式 -->
	<section class="bg-lightyellow class-foot pb125">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-left mt100">
					<h4 class="title">授课模式<span>Teaching Mode</span></h4>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="content-flex flex-space-between content-flex-wrap">
				<div class="class-box">
					<div class="class-box-head">
						<h4>启蒙级别</h4>
					</div>
					<div class="class-box-content">
						${!empty aboutusBean?aboutusBean.enlighten:''}
					</div>
					<div class="class-box-foot">
						<a
							href="${BAIDU_SHANGQIAO}"
							target="_blank" title="立即咨询">立即咨询 ></a>
					</div>
				</div>
				<div class="class-box">
					<div class="bg-blue class-box-head ">
						<h4>普及级别</h4>
					</div>
					<div class="class-box-content">
						${!empty aboutusBean?aboutusBean.popularize:''}
					</div>
					<div class="bg-blue class-box-foot">
						<a
							href="${BAIDU_SHANGQIAO}"
							target="_blank" title="立即咨询">立即咨询 ></a>
					</div>
				</div>
				<div class="class-box">
					<div class="class-box-head bg-red">
						<h4>专家级别</h4>
					</div>
					<div class="class-box-content">
							${!empty aboutusBean?aboutusBean.specialty:''}
					</div>
					<div class="bg-red class-box-foot ">
						<a
							href="${BAIDU_SHANGQIAO}"
							target="_blank" title="立即咨询">立即咨询 ></a>
					</div>
				</div>
			</div>
		</div>

	</section>
	<!-- 企业文化 -->
	<section class="bg mt5">
		<div class="container-fluid">
			<div class="row text-left">
				<div class="col-md-12 mt40">
					<h4 class="title">经营理念<span>Operation Principle</span></h4>
				</div>
			</div>
			<div class="content-flex">
			<div class="row" >
				<div class="col-md-12 ">
					 <div class="four-face">
					 	<c:if test="${!empty aboutusBean and !empty cultures}">
					 		<c:if test="${fn:length(cultures) > 0}">
					   			 <div class="column content-flex-wrap">
						 			<c:forEach var="cu" items="${cultures}" varStatus="status">
						 				<div class="pos-relative culture-img ">
									    	<img src="${cu.background}" class="img-responsive zoom-img" >
									    	<div class="cuture-div">
												<div class="text-left">
													<h3 class="cluture-title">${cu.title} </h3>
													<p class="mb20 lh15">
														${cu.content}
													</p>
												</div>
									    	</div>
								    	</div>
								    	<c:if test="${status.index==1}">
								    		</div>
					    					<div class="column content-flex-wrap">
								    	</c:if>
						 			</c:forEach>
					 			</div>
					 		</c:if>
					 	</c:if>
					 	<c:if test="${!empty aboutusBean}">
						  <div class="culture-logo">
							<img src="${aboutusBean.logo}" alt="logo" class="mauto">	
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
		
	</section>
	<section class="mt10 mb40 pb80">
		<div class="container">
			<div class="row text-center mt40 mb40">
				<h3>认证授权、资源优势</h3>
				<h4>Authentication and Authorization</h4>
			</div>
			<div class="flexslider" id="about-content-id">
			</div>
			<div class="row text-center mt40 mb40 ">
				<h3>环境设施</h3>
				<h4>Environmental Facilities</h4>
			</div>
			<div class="flexslider" id="about-content-id2">
			</div>
		</div>
	</section>
	<!-- 轮播图 -->
	<script type="text/javascript" src="${SERVER_PATH_resources}/assets/plugins/flexslider/jquery.flexslider.js"></script>
	
	<script type="text/javascript" src="${SERVER_PATH_resources}/js/banner_slider.js"></script>
	<script type="text/javascript">
		var $window = $(window), flexslider = { vars:{} };
		$(window).load(function() {
			setBackground();
			getBanners(1);
			var top = $(window).height() - $('.index-header').height(); //获取某个元素距顶部的距离
			$("body,html").animate({
				scrollTop : (top - 60) + "px"
			}, 500);
	        getEnvironment(1,'about-content-id');
	        getTirdEnvironment(2,'about-content-id2');
		});
		 $window.resize(function() {
		    var gridSize = getGridSize();
		    flexslider.vars.minItems = gridSize;
		    flexslider.vars.maxItems = gridSize;
		});
		 
		 function setBackground(){
			 var background = '';
			 if(!isMobile.any()){
				 background = '';
			 } else {
				 background = $('#aboutusImg').attr('src');
				 $('#content-id').css('background-image','url('+background+')');
				 $('#content-id .content-img').hide();
			 }
		 }
	</script>
</body>
</html>
