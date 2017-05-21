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
<title>招生信息</title> 
<link href="${SERVER_PATH_resources}/css/recruit.css" rel="stylesheet" type="text/css">
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
	<section class="bg-lightyellow pb60">
		<div class="container text-left">
			<div class="row">
				<div class="col-md-12 mt40">
					<h4 class="title">未来舞者<span>Future Dancer</span></h4>
				</div>
			</div>
			<div class="row">
				<div class="col-md-9 col-sm-12 mt40">
					<p class="lh15">未来舞者是由国家级孵化基金投资，文化部艺术才人中心扶持的舞蹈教育公司，
						经世界舞蹈总会（WDC）授权认证，是国内唯一专业普及学校。
						未来舞者教育总监为北京舞蹈学院30余年教学经验专家担任，所有教员均毕业于北京舞蹈学院，舞龄均超过15年。</p>
				</div>
			</div>
		</div>

	</section>
	<!-- 任课老师 -->
	<section class="bg-lightgrey pb30">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-left mt100">
					<h4 class="title">少儿任课教员<span>Teachers</span></h4>
				</div>
			</div>
			<div id="teacher_id">
			</div>
		</div>
	</section>
	<section class="bg-lightyellow class-foot pb125">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-left  mt100">
					<h4 class="title">课程体系<span>Course System</span></h4>
					<h5 class="sub-title">再优秀的教师在没有教学规划下则等于零！我们的教学体系均有细致的教研</h5>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="content-flex flex-space-between mt30 content-flex-wrap">
				<div class="class-box">
					<div class="class-box-head">
						<h4>幼儿启蒙</h4>
					</div>
					<div class="class-box-content">
						采用北京舞蹈学院考级教学体系+英皇RAD启蒙体系，兴趣专业两手抓， 以童趣的方式培养孩子的舞蹈天性，更增加训练性，达到最佳的效果。
					</div>
					<div class="class-box-foot">
						<a
							href="${BAIDU_SHANGQIAO}"
							target="_blank">立即咨询 ></a>
					</div>
				</div>
				<div class="class-box">
					<div class="class-box-head">
						<h4>少儿考级</h4>
					</div>
					<div class="class-box-content">
						考级路线以中国最为权威的“北京舞蹈学院”考级体系为教学根基，
						通过考级得到由文化部认可的考级证书，未来舞者承诺，在教学中心学习的学员考级百分之百通过，不通过则全额退款！</div>
					<div class="class-box-foot">
						<a
							href="${BAIDU_SHANGQIAO}"
							target="_blank">立即咨询 ></a>
					</div>
				</div>
				<div class="class-box">
					<div class="class-box-head">
						<h4>专业之路</h4>
					</div>
					<div class="class-box-content">
						未来舞者全体教员及教学总监均来自于北京舞蹈学院，本套教学体系来自于“北京舞蹈学院附属中等舞蹈学校”最权威正统的1-7年级课堂组合，
						使在外学习的少儿能感受到专业院校的教学模式，适用于走专业艺术院校附中路线及名校附中的少儿。</div>
					<div class="class-box-foot">
						<a
							href="${BAIDU_SHANGQIAO}"
							target="_blank">立即咨询 ></a>
					</div>
				</div>

			</div>
		</div>

	</section>

	<section class="bg-lightgrey pb60">
		<div class="container">
			<div class="row">
				<div class="col-md-12 mt40">
					<h4 class="title">与世界最顶级舞蹈家<span>International Communication</span></h4>
				</div>
			</div>
			<div class="row news-div mt30">
				<div class="col-md-3 col-xs-6 mb20">
					<div class="news-box">
						<img src="http://on7cnn05g.bkt.clouddn.com/n1.png">
						<div class="lh15">未来舞者创始人与世界舞蹈总会主席 东尼-本斯先生</div>
					</div>
				</div>
				<div class="col-md-3 col-xs-6 mb20">
					<div class="news-box">
						<img src="http://on7cnn05g.bkt.clouddn.com/n2.png">
						<div class="lh15">未来舞者骨干教师与中国艺术研究院研究员，北京舞蹈学院研究生导师欧建平</div>
					</div>
				</div>
				<div class="col-md-3 col-xs-6 mb20">
					<div class="news-box">
						<img src="http://on7cnn05g.bkt.clouddn.com/n3.png">
						<div class="lh15">未来舞者创始人与北京舞蹈学院教授，研究生导师，国际标准舞学院派创始人张平教授</div>
					</div>
				</div>
				<div class="col-md-3 col-xs-6 mb20">
					<div class="news-box">
						<img src="http://on7cnn05g.bkt.clouddn.com/n4.png">
						<div class="lh15">未来舞者创始人与世界舞蹈总会秘书长汉纳斯先生</div>
					</div>
				</div>
			</div>
			<div class="row news-div mt20">
				<div class="col-md-3 col-xs-6 mb20">
					<div class="news-box">
						<img src="http://on7cnn05g.bkt.clouddn.com/world-dancer%20%284%29.png">
						<div class="lh15">未来舞者骨干教师与北京舞蹈学院专家曲学智老师</div>
					</div>
				</div>
				<div class="col-md-3 col-xs-6 mb20">
					<div class="news-box">
						<img src="http://on7cnn05g.bkt.clouddn.com/world-dancer%20%283%29.png">
						<div class="lh15">未来舞者创始人与世界舞蹈总会业余联盟主席萨米-斯托弗德先生</div>
					</div>
				</div>
				<div class="col-md-3 col-xs-6 mb20">
					<div class="news-box">
						<img src="http://on7cnn05g.bkt.clouddn.com/world-dancer%20%282%29.png">
						<div class="lh15">未来舞者骨干教师与北京舞蹈学院书记</div>
					</div>
				</div>
				<div class="col-md-3 col-xs-6 mb20">
					<div class="news-box">
						<img src="http://on7cnn05g.bkt.clouddn.com/world-dancer%20%281%29.png">
						<div class="lh15">未来舞者创始人与北京舞蹈学院芭蕾舞学科教授王健老师</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="bg-lightyellow pb60">
		<div class="container">
			<div class="row">
				<div class="col-md-12 mt40">
					<h4 class="title">环境设施<span>Environmental Facility</span></h4>
				</div>
			</div>
			<div class="row mt30 pb60">
				<div class="col-md-12">
					<div class="flexslider" id="environment"></div>
				</div>
			</div>
		</div>

	</section>


	<section class="bg mt5 mt100 mb100">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center telephone">
					<h4>致电可免费预约一节试听课</h4>
					<span>4006-125-925（未来舞者）</span>
					<span>教学主管：18601132287（赵老师）</span>
				</div>
			</div>
		</div>
	</section>


	<section class="bg-lightyellow pb100">
		<div class="container">
			<div class="row">
				<div class="col-md-12 mt40">
					<h4 class="title">三项保证<span>Teaching Guarantee</span></h4>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="content-flex flex-space-between mt30 content-flex-wrap">
				<div class="guarantee-box">
					<div class="num"><span>1</span></div> 
					<div>考级及培训：未来舞者采取签约授课，不通过考级或不达到高提升水平则无条件退款</div>
				</div>
				<div class="guarantee-box">
					<div class="num"><span>2</span></div> 
					<div>汇报展演：每年将在大型剧场邀请家长及亲朋观看学员登台表演，从小建立孩子自信心，树立良好品行，家长也可记录孩子点滴，家庭回忆更珍贵。</div>
				</div>
				<div class="guarantee-box">
					<div class="num"><span>3</span></div> 
					<div>最顶级比赛：未来舞者每年率学员参加世界上最顶级的比赛及活动，并提供助学基金，奖励最佳学员公费出国游学及比赛。</div>
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
			getTeachers('a07cb1d55f7442e9839265613e2a8835','teacher_id',null,16);
		});
	</script>
</body>
</html>
