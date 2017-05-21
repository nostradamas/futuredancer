<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="cn">
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>${empty subHomeBean?'':subHomeBean.name}</title>

<link href="${SERVER_PATH_resources}/css/teacher.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<input type="hidden" value="${empty homeBean?'':homeBean.hid}"
		id="homeId" />
	<input type="hidden" value="${empty homeBean?'':homeBean.isLeaf}"
		id="isLeaf" />
	<input type="hidden" value="${empty homeBean?'':homeBean.parentId}"
		id="parentId" />
	<input type="hidden" value="${empty subHomeBean?'':subHomeBean.hid}"
		id="subHomeId" />
	<!-- 课程特色 -->
	<section class="bg art-class content-bg" id="leaf-spacial">
		<div class="content-img"></div>
		<div class="content-div">
			<div class="container">
				<div class="row">
					<div
						class="col-md-6  col-md-offset-3 col-sm-12 pt10 pb30 content-back-bg">
						<div class="text-center">
							<h3>课程特色</h3>
							<h4>Course Characteristics</h4>
							<p class="lh2"></p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- 课程介绍 -->
	<section class="mt15 pt40 pb60 bg-grey newslist mt5">
		<div class="container">
			<div class="row text-center" id="leaf-class">
				<h3>课程介绍</h3>
				<h4>Course Introduction</h4>
			</div>
			<div class="row pb20 mt20" id="leaf-class2">
				<div class="col-md-6 col-sm-6 text-center col-xs-12 pb20 mt60"
					id="leaf-class2-content">
					<span class="class-title"></span>
					<p class="lh15 mt40 text-left"></p>
					<a href="${BAIDU_SHANGQIAO}" title="免费参加" class="mr10 mt40 link-btn"> 免费参加<i
						class="iconfont icon-tiaozhuan"></i>
					</a>
				</div>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<div class="newsimg">
						<img src="" class="sub-Img-css fr">
					</div>
				</div>
			</div>
			<div class="row pt20" id="leaf-class3">
				<div class="col-md-6 col-sm-6 col-xs-12">
					<div class="newsimg">
						<img src="" class="sub-Img-css" />
					</div>
				</div>
				<div class="col-md-6 col-sm-6 text-center col-xs-12 pb20 mt60"
					id="leaf-class3-content">
					<span class="class-title"></span>
					<p class="lh15 mt40 text-left"></p>
					<a href="${BAIDU_SHANGQIAO}" title="免费参加" class="mr10 mt40 link-btn"> 免费参加<i
						class="iconfont icon-tiaozhuan"></i>
					</a>
				</div>
			</div>
		</div>
		<div class="container" id="stepId">
			<div class="row pb20">
				<h3 class="title  text-left">学员学习阶段</h3>
			</div>
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-centerr">
					<div class="stage-div" id="stepId-info">
						<div class="content-flex">
							<div class="content-flex-items ">
								<div class="stage1">第一周期：考察学员知识点，并由30余年顶尖舞蹈专家...</div>
							</div>
							<div class="content-flex-items ">
								<div class="stage-bottom">第二周期：根据调整完善规范的舞蹈意识，知识点，形态进行一个周期的训练...</div>
							</div>
							<div class="content-flex-items ">
								<div class="stage2">第一周期：这个阶段是承上启下的阶段，既要保障上个阶段开展的规范系统训练...</div>
							</div>
							<div class="content-flex-items ">
								<div class="stage-bottom">第二周期：开展：技巧组合编创，毯技加分项，即兴表演+模仿训练，明星...</div>
							</div>
							<div class="content-flex-items ">
								<div class="stage3">第一周期：到达本阶段的学员已经在基本功，舞蹈规范度，技术技巧组合，剧目，毯技，跳转反，自身能力素质，跳转翻上...</div>
							</div>
							<div class="content-flex-items ">
								<div class="stage-bottom">第二周期：本周期加入大量专家课，专家看课与班主任，任课教师，教学主...</div>
							</div>
							<div class="content-flex-items ">
								<div class="stage-end">本阶段学员已经临近考试，在课程设置上：加入大量模拟考试，不同场景，不同人群，教室，舞台</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row mt10 pb40 text-center">
				<a href="${BAIDU_SHANGQIAO}" title="我要测评" class="mr10 mt40 link-btn"> 我要测评<i
					class="iconfont icon-tiaozhuan"></i>
				</a>
			</div>

		</div>
	</section>
	<section class="mt40 pb40">
		<div class="container">
			<div class="row">
				<div class="col-md-12 mb20">
					<h4 class="title">
						其他学科课程包<span>Subject Curriculum</span>
					</h4>
				</div>
			</div>

			<div class="row subject-teacher text-center" id="expectsId"></div>
		</div>
	</section>
	<!-- 授课专家 -->
	<section class="pt40 pb100 bg-grey text-center">
		<div id="leaf-teacher">
			<h3>授课专家</h3>
			<h4>Teaching Experts</h4>
		</div>
		<div class="container mt30">
			<div class="row ">
				<div class="flexslider" id="teacherId"></div>
				<div class="col-md-12 mt40 pt40">
					<a class="mt30 mauto btn-sign" title="立刻报名" href="${BAIDU_SHANGQIAO}"
						target="_blank">立刻报名</a>
				</div>
			</div>
			<div class="row">
				<div
					class="content-flex  flex-space-between art-ask mt40 mb40 content-flex-wrap">
					<div class="w20 text-center connet-box">
						<i class="iconfont icon-zixun new-art-icon"></i>
						<h4>免费线上咨询</h4>
						<p>由北京舞蹈学院教授，英国皇家舞蹈学校专家，中央芭蕾舞团首席演员，</p>
						<a href="${BAIDU_SHANGQIAO}" target="_blank">前去咨询></a>
					</div>
					<div class="w20 text-center connet-box">
						<i class="iconfont icon-shiting new-art-icon"></i>
						<h4>免费试听</h4>
						<p>由北京舞蹈学院教授，英国皇家舞蹈学校专家，中央芭蕾舞团首席演员，</p>
						<a href="${BAIDU_SHANGQIAO}" target="_blank">前去咨询></a>
					</div>
					<div class="w20 text-center connet-box">
						<i class="iconfont icon-fukuan new-art-icon"></i>
						<h4>分期付款</h4>
						<p>由北京舞蹈学院教授，英国皇家舞蹈学校专家，中央芭蕾舞团首席演员，</p>
						<a href="${BAIDU_SHANGQIAO}" target="_blank">前去咨询></a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		$(window).load(function() {
			var hid = $('#homeId').val();
			var isLeaf = $('#isLeaf').val();
			var parentId = $('#parentId').val();
			var subHomeId = $('#subHomeId').val();
			// tab导航
			getSubHomeMenus(hid, isLeaf, parentId, subHomeId);
			// 菜单页
			getBanners(1, true);
			getItemContent(subHomeId);
			getTeacherLists(subHomeId, 'teacherId');
			getExperts(subHomeId);
			getStep(subHomeId);
		});
	</script>
</body>
</html>
