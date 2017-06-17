<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="cn">
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>课程介绍</title>

<link href="${SERVER_PATH_resources}/css/teacher.css" rel="stylesheet" type="text/css">
<link href="${SERVER_PATH_resources}/css/dance.css" rel="stylesheet" type="text/css">
<style>
	.btn-sign{
	    margin: 30px 0;
	    display: inline-block;
	}
	
</style>
</head>
<body>
	<input type="hidden" value="${empty homeBean?'':homeBean.hid}" id="homeId"/>
	<input type="hidden" value="${empty homeBean?'':homeBean.isLeaf}" id="isLeaf"/>
	<input type="hidden" value="${empty homeBean?'':homeBean.parentId}" id="parentId"/>
	<input type="hidden" value="${tabId}" id="tabId"/>
	<input type="hidden" value="${menuId}" id="MenuId"/>
	
	<!-- 导航banner  -->
	<section>
		<div id="banner" >
			<div class="flexslider">
				<ul class="slides" id="banner-ul-id">
				</ul>
			</div>
		</div>
	</section>
	<section >
		<div class="">
			<div class="row">
				<div class="col-md-12">
					<c:if test="${!empty homeBean}">
						<ul class="news-navi" >
							<c:forEach items="${classMenu}" var="menu" varStatus="status">
								<li <c:if test="${menu.cid == menuId}">class="active"</c:if>>
									<a href="javascript:void(0)" title="${menu.name}" onclick="getClassContens('${menu.cid}',this)">${menu.name}</a>
								</li>
							</c:forEach>
						</ul>
					</c:if>
				</div>
			</div>
		</div>
	</section>
	
	<!-- 课程特色 -->
	<section class="content-bg bg mt5" id="leaf-spacial">
		<div class="content-img">
			<img src="#"/>
		</div>
		<div class="content-div">
			<div class="container">
				<div class="row">
					<div class="col-md-6  col-md-offset-3 col-sm-12 pt10 pb30 content-back-bg">
						<div class="text-center">
							<h3 >课程特色</h3>
							<h4 >Course Characteristics</h4>
							<p class="lh2">
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- 课程介绍 -->
	<section class="mt40 mb40 mt5">
		<div class="container">
			<div class="row">
				<div class="col-md-12 pb20 text-center" id="leaf-class">
					<h3>授课模式</h3>
					<h4>Teaching Mode</h4>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="content-flex flex-space-between mt10 mb20 ">
				<div style="flex:5" class="mode-box text-center" id="leaf-class1">
					<span class="span-title bg-yellow mauto">启蒙级别</span>
					<div class="text-left mt30">
					</div>
				</div>
				<div style="flex:1"></div>
				<div style="flex:5" class="mode-box text-center" id="leaf-class2">
					<span class="span-title bg-blue">普及级别</span>
					<div class="text-left mt30">
					</div>
				</div>
			</div>
		</div>
		<div class="container mt20 mb20" >
			<div class="row">
				<div class="col-md-12 text-center" id="leaf-class-center">
					<img src="" class="mauto" style="width:350px;"alt="谭璐女士"/>
				</div>
			</div>
			<div class="row mt20">
				<div class="col-md-10 col-md-offset-1 text-center" >
					<div class="mode-box text-center" id="leaf-class3">
						<span class="span-title bg-red">专家级别</span>
						<div class="text-left mt30">
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- 授课专家 -->
	<section class="pt40 pb80 bg-grey text-center" >
		<div id="leaf-teacher">
			<h3>授课专家</h3>
			<h4>Teaching Experts</h4>
		</div>
		<div class="container mt40">
			<div class="row">
				<div class="flexslider" id="teacherId">
				</div>
				<div class="col-md-12 pt30 mt40">
					<a href="${BAIDU_SHANGQIAO}" class="mt30 mauto btn-sign" title="立刻报名" target="_blank">立刻报名></a>
				</div>
			</div>
			<div class="row">
				<div class="content-flex  flex-space-between art-ask mt40 mb40 content-flex-wrap">
					<div class="w20 text-center connet-box">
						<i class="iconfont icon-zixun new-art-icon"></i>
						<h4>免费线上咨询</h4>
						<p>由北京舞蹈学院教授，英国皇家舞蹈学校专家，中央芭蕾舞团首席演员，</p>
						<a href="${BAIDU_SHANGQIAO}" title="前去咨询" target="_blank">前去咨询></a>
					</div>
					<div class="w20 text-center connet-box">
						<i class="iconfont icon-shiting new-art-icon"></i>
						<h4>免费试听</h4>
						<p>由北京舞蹈学院教授，英国皇家舞蹈学校专家，中央芭蕾舞团首席演员，</p>
						<a href="${BAIDU_SHANGQIAO}" title="前去咨询" target="_blank">前去咨询></a>
					</div>
					<div class="w20 text-center connet-box">
						<i class="iconfont icon-fukuan new-art-icon"></i>
						<h4>分期付款</h4>
						<p>由北京舞蹈学院教授，英国皇家舞蹈学校专家，中央芭蕾舞团首席演员，</p>
						<a href="${BAIDU_SHANGQIAO}" title="前去咨询" target="_blank">前去咨询></a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">
	$(window).load(function() {
		var top = $(window).height() - $('.index-header').height(); //获取某个元素距顶部的距离
        $("body,html").animate({scrollTop:(top-60)+"px"},500);
		var hid = $('#homeId').val();
		var isLeaf = $('#isLeaf').val();
		var parentId = $('#parentId').val();
		var tabId = $('#tabId').val();
		// tab导航
		getSubHomeMenus(hid, isLeaf, parentId);
		getBanners(1);
		getSubNav(hid, tabId);
		var top = $(window).height() - $('.index-header').height(); //获取某个元素距顶部的距离
        $("body,html").animate({scrollTop:(top-60)+"px"},500);
        getItemContent($('#MenuId').val());
        getTeacherLists($('#MenuId').val(), 'teacherId', null);
	});
	
	function getClassContens(menuId){
		var hid = $('#homeId').val();
		var tabId = $('#tabId').val();
		window.location.href = SERVER_PATH + '/subHome/toClassesMain?hid='+hid+'&tabId='+tabId+'&type=2&menuId='+menuId;         
	}

	</script>
	
</body>
</html>
