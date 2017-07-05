<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="cn">
<head>
	<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
	<title><sitemesh:write property='title'/> | 未来舞者官方网站-专业的舞蹈教育  </title>
	
	
	<sitemesh:write  property="head"/> 
	<sitemesh:head/>  
	<!-- 轮播图样式 -->
	<link href="${SERVER_PATH_resources}/assets/plugins/flexslider/flexslider.css" rel="stylesheet" type="text/css">
	<!-- 首页 CSS样式 -->
	<link href="${SERVER_PATH_resources}/css/index.css" rel="stylesheet" type="text/css">
	<link href="${SERVER_PATH_resources}/css/index-response.css" rel="stylesheet" type="text/css">
	<!-- 公共基本样式-->
	<link href="${SERVER_PATH_resources}/css/common.css" rel="stylesheet" type="text/css">
	<link href="${SERVER_PATH_resources}/css/common-response.css" rel="stylesheet" type="text/css">
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>            
<body>
	<header class="index-header mt10 mb10">
		<input type="hidden" value="${homeId}" id="homeId"/>
		<div class="container" >
			<div class="row">
				<div class="col-md-2 col-xs-2">
					<div class="logo">
						<a href="${SERVER_PATH}/"><img src="http://on7cnn05g.bkt.clouddn.com/logo.png" alt="logo" title="未来舞者"/></a>
					</div>
				</div>
				<div class="col-md-8 col-xs-10" id="index-tab-id">
					<ul class="index-header-ul" >
					</ul>	
				</div>
			</div>
		</div>
	</header>
	<section>
		<div class="header-nav">
			<ul class="navigation" id="menu-id" >
			</ul>
		</div>
	</section>
	<script type="text/javascript" src="${SERVER_PATH_resources}/assets/plugins/jquery.min.js"></script>
	<!-- bootstrap -->
	<script type="text/javascript" src="${SERVER_PATH_resources}/assets/bootstrap/js/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="${SERVER_PATH_resources}/js/get_data.js"></script>
	
	<script type="text/javascript">
		$(window).load(function() {
			var hid = $('#homeId').val();
			getMenus(hid, 1);
			// tab导航
			var thishid = getQueryString('hid');
			getHomeTabs('a07cb1d55f7442e9839265613e2a8835',thishid);
			// 显示菜单
		});
	</script>
	<sitemesh:write property='body'/>
	<script type="text/javascript">

	</script>
	<%@ include file="/WEB-INF/pages/common/footer.jsp"%>
</body>
</html>
