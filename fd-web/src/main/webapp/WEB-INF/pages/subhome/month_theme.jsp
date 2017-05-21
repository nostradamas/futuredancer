<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<c:set var="SERVER_PATH" value="${pageContext.request.contextPath}"></c:set>
<c:set var="SERVER_PATH_resources" value="${pageContext.request.contextPath}/resources"></c:set>
<c:set var="BAIDU_SHANGQIAO" value="http://p.qiao.baidu.com/im/index?siteid=10554150&ucid=22827257&cp=&cr=&cw="></c:set>
<!DOCTYPE html>
<html lang="cn">
<head>
<title>每月主题</title>

<link href="${SERVER_PATH_resources}/css/theme.css" rel="stylesheet" type="text/css">
</head>
<body>
	<input type="hidden" value="${homeId}" id="homeId" />
	<!-- 导航banner  -->
	<section>
		<div id="banner">
			<div class="flexslider">
				<ul class="slides" id="banner-ul-id">
				</ul>
			</div>
		</div>
	</section>
	<section class="bg-lightgreen strong-foot pb100">
		<div class="container text-left">
			<div class="row">
				<div class="col-md-12 mt40">
					<h4 class="title">最強活動<span>Strongest Activity</span></h4>
				</div>	
			</div>
			<div class="row">
				<div class="col-md-9 col-sm-12 mt40 mb60 strong-box">
					<h3>五月免費集訓三天</h3>
					<h4>每日超10小時課程，通過考核免學費培訓半年，直至考入名校。</h4>
					<div class="strong-box-div">
						參與集訓者，五月至七月期間繼續贈送20節一對一小課，隨時來上。                
					</div>
				</div>
			</div>
		</div>

	</section>
	<!-- 任课老师 -->
	<section class="bg-lightgrey pb60">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-left mt60">
					<h4 class="title">集訓營授課教師<span>Teachers</span></h4>
				</div>
			</div>
			<div id="teacher_id">
			</div>
			<div id="teacher_id2">
			</div>
			<div class="row">
				<div class="col-md-12 text-center">
					<a class="connet-btn" title="详细咨询" href="${BAIDU_SHANGQIAO}"target="_blank">详细咨询 </a>
				</div>
			</div>
		</div>
	</section>
	
	<section class="bg bg-orange bg-content">
		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<div class="class-content text-left fr pt40">
						<h4>课程内容</h4>
						<span>中国舞</span>
						<span>芭蕾舞</span>
						<span>国标舞</span>
						<span>编导舞</span>
						<div class="content-btn">
							<a class="connet-btn-red" title="详细咨询" href="${BAIDU_SHANGQIAO}"target="_blank">详细咨询 </a>
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<div class="col-md-7 text-left fl pt30 pb30">
					<ul class="content-table">
						<li class="content-table-title">每日包括：</li>
						<li>早功</li>
						<li>芭蕾及古典舞基訓課</li>
						<li>技術技巧</li>
						<li>技巧組合指導</li>
						<li>劇目課</li>
						<li>毯功課</li>
						<li>软度課</li>
						<li>晚功</li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	<!-- 成绩 -->
	<section class="bg-lightgrey pb40">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-left mt60 student-title">
					<h4 >去年成績</h4>
					<div>如果你还犹豫是否来参加，你将有可能错失孩子最理想成绩机会，未來舞者去年培訓了二十名藝考生均考入名校，
					我们只做最精品教学！擬定今年只招60名學生，並繼續保持最理想成績：全部考入名校！你想做未來舞者的六十分之六十，還是去給別人做嫁衣？   
					</div>
				</div>
			</div>
			<div id="student_id">
			</div>
			<div class="row">
				<div class="col-md-12 text-center">
					<a class="connet-btn" title="详细咨询" href="${BAIDU_SHANGQIAO}"target="_blank">详细咨询</a>
				</div>
			</div>
		</div>
	</section>

	<section class="bg callme-foot pt60 pb60">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center callme">
					<p>
						預約五一專家免費體驗營 <br/>
						請在後台留言：姓名 + 專業 + 聯繫方式。 
					</p>
					<span>咨询请致电：18601132287(赵老师)</span>
				</div>
			</div>
		</div>
	</section>

	<script type="text/javascript"
		src="${SERVER_PATH_resources}/assets/plugins/jquery.min.js"></script>
	<!-- bootstrap -->
	<script type="text/javascript"
		src="${SERVER_PATH_resources}/assets/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${SERVER_PATH_resources}/assets/plugins/flexslider/jquery.flexslider.js"></script>

	<script type="text/javascript" src="${SERVER_PATH_resources}/js/banner_slider.js"></script>
	
	<script type="text/javascript" src="${SERVER_PATH_resources}/js/recruit.js"></script>
	<script type="text/javascript">
		$(window).load(function() {
			var hid = $('#homeId').val();
			getBanners(1);
			getTirdEnvironment(2, 'environment');
			var top = $(window).height() - $('.index-header').height(); //获取某个元素距顶部的距离
			$("body,html").animate({
				scrollTop : (top - 60) + "px"
			}, 500);
			getTeachers('a07cb1d55f7442e9839265613e2a8835','teacher_id',1,30);
			getTeachers('a07cb1d55f7442e9839265613e2a8835','teacher_id2',2,30);
		    getStudents(1, 16, 'student_id', true, 'a07cb1d55f7442e9839265613e2a8835');
		});
	</script>
</body>
