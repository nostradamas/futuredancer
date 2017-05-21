<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="cn">
<head>
	<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
	<title>${empty homeBean?'':homeBean.name}</title>
	
	<link href="${SERVER_PATH_resources}/css/teacher.css" rel="stylesheet" type="text/css">
	<style>
		.classimg .sub-Img-css{
			width:500px;
			height:300px;
			border-radius: 20px;
		    box-shadow: 0 10px 20px 10px rgba(0, 0, 0, .1);
		}
		#studentlistId .teacher-info{
			border-radius: 20px;
			overflow: hidden;
		}
		#studentlistId .col-md-3{
			padding-left:10px !important;
			padding-right:10px !important;
		}
	</style>
</head>            
<body>
	<input type="hidden" value="${empty homeBean?'':homeBean.hid}" id="homeId"/>
	<input type="hidden" value="${empty homeBean?'':homeBean.isLeaf}" id="isLeaf"/>
	<input type="hidden" value="${empty homeBean?'':homeBean.parentId}" id="parentId"/>
	<!-- 课程介绍 -->
	<section class="bg bg-lightyellow pb60" >
		<div class="container">
			<div class="row" id="content-classId">
				<div class="col-md-6 mt20 text-center">
					<h3 class="title text-left">课程特色<span>Course Features</span></h3>
				</div>
			</div>
			<div class="content-flex flex-space-between content-flex-wrap">
				<div class="class-box" id="content-featureId1">
					<div class="class-box-head">
						<h3>特色一</h3>
					</div>
					<p class="class-box-content">
					</p>
					<div class="class-box-foot">
						<a href="${BAIDU_SHANGQIAO}" title="立即咨询" target="_blank">立即咨询 &gt;</a>
					</div>
				</div>
				<div class="class-box" id="content-featureId2">
					<div class="bg-blue class-box-head ">
						<h3>特色二</h3>
					</div>
					<p class="class-box-content">
					</p>
					<div class="bg-blue class-box-foot">
						<a href="${BAIDU_SHANGQIAO}" title="立即咨询"  target="_blank">立即咨询 &gt;</a>
					</div>
				</div>
				<div class="class-box" id="content-featureId3">
					<div class="class-box-head bg-red">
						<h3>特色三</h3>
					</div>
					<p class="class-box-content">
					</p>
					<div class="bg-red class-box-foot ">
						<a href="${BAIDU_SHANGQIAO}" title="立即咨询"  target="_blank">立即咨询 &gt;</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- 授课名师 -->
	<section class="bg art-class" id="content-techId"> 
		<div class="container pt40 p40">
			<div class="row" >
				<div class="col-md-8 col-md-offset-2 col-sm-12 text-center">
					<h3>授课名师</h3>
					<h4>teacher</h4>
					<p>
					</p>
				</div>
			</div>
			<div class="row pt40 ">
				<div class="col-md-12 text-center">
					<div class="flexslider" id="teacherId">
					</div>
				</div>
			</div>
			<div class="row text-center pt40">
				<a href="${BAIDU_SHANGQIAO}" title="查看详情" class="mr10 mt40 link-btn">
					查看详情<i class="iconfont icon-tiaozhuan"></i>
				</a>
			</div>
		</div>
	</section>
	
	<!-- 学员成绩 -->
	<section class="bg bg-overyellow pb80" id="content-studentId">
		<div class="container  pt40 p40">
			<div class="row">
				<div class="col-md-6 mt20 text-center">
					<h3 class="title text-left">学员成绩<span>Subject Curriculum</span></h3>
					<p class="mt40 text-left"">
						由北京舞蹈学院教授，英国皇家舞蹈学校专家，中央芭蕾舞团首席演员，
						中国歌剧舞剧院首席演员等国内外舞蹈专家联合担任教学总监，是一家与国际接轨正统专业的舞蹈素质教育中心 
					</p>
					<a href="${BAIDU_SHANGQIAO}" title="查看详情" class="mr10 mt40 link-btn">
						查看详情<i class="iconfont icon-tiaozhuan"></i>
					</a>
				</div>
				<div class="col-md-6 col-sm-6 col-xs-12 mt40 " >
					<div class="classimg sub-Img-css">
						<img src="" class="sub-Img-css fr">
					</div>
				</div>
			</div>
		</div>
		<div class="container mt20" id="studentlistId">
		</div>
		<div class="container text-center">
			<a href="${BAIDU_SHANGQIAO}" title="了解更多" class="mb40 link-btn">
				了解更多<i class="iconfont icon-tiaozhuan"></i>
			</a>
		</div>
	</section>
	
	<script type="text/javascript" src="${SERVER_PATH_resources}/assets/plugins/flexslider/jquery.flexslider.js"></script>
	<script type="text/javascript" src="${SERVER_PATH_resources}/js/student.js"></script>
	
	<script type="text/javascript" src="${SERVER_PATH_resources}/js/common.js"></script>
	<script type="text/javascript" src="${SERVER_PATH_resources}/js/home/home.js"></script>
	<script>
		var $window = $(window), flexslider = { vars:{} };
	 	$window.resize(function() {
		    var gridSize = getGridSize();
		    flexslider.vars.minItems = gridSize;
		    flexslider.vars.maxItems = gridSize;
		});
	</script>
</body>
</html>
