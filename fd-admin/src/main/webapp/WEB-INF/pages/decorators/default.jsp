<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
		<title><sitemesh:write property='title'/> | 未来舞者网站管理后台</title>

		<!-- Bootstrap 3.3.5 -->
		<link rel="stylesheet" type="text/css" href="${SERVER_PATH_resources}/assets/bootstrap/css/bootstrap.min.css">
		<!-- Font Awesome -->
		<link rel="stylesheet" type="text/css" href="${SERVER_PATH_resources}/assets/font/css/font-awesome.min.css">
		<!-- Theme style -->
		<link rel="stylesheet" type="text/css" href="${SERVER_PATH_resources}/assets/dist/css/AdminLTE.css">
		<!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
		<link rel="stylesheet" type="text/css" href="${SERVER_PATH_resources}/assets/dist/css/skins/_all-skins.min.css">
		
		<!-- jQuery 2.2.0 -->
		<script src="${SERVER_PATH_resources}/assets/plugins/jQuery/jquery-2.2.3.min.js"></script>
		<script src="${SERVER_PATH_resources}/plugs/jquery/cookie/jquery.cookie.js"></script>
		
		<!-- jQuery UI 1.11.4 -->
		<script src="${SERVER_PATH_resources}/assets/plugins/jQueryUI/jquery-ui.min.js"></script>
		<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
		
		<!-- Bootstrap 3.3.6 -->
		<script src="${SERVER_PATH_resources}/assets/bootstrap/js/bootstrap.min.js"></script>
		
		<!--datatable-->
		<script src="${SERVER_PATH_resources}/assets/plugins/datatables/jquery.dataTables.min.js"></script>
		<script src="${SERVER_PATH_resources}/assets/plugins/datatables/dataTables.bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${SERVER_PATH_resources}/assets/plugins/datatables/dataTables.bootstrap.css">
		
		<!-- AdminLTE App -->
		<script src="${SERVER_PATH_resources}/assets/dist/js/app.min.js"></script>
		
		<!-- 自定义 -->
		<script type="text/javascript" src="${SERVER_PATH_resources}/js/decorators/default.js"></script>
		<link rel="stylesheet" type="text/css" href="${SERVER_PATH_resources}/css/decorators/default.css">
		<script src="${SERVER_PATH_resources}/assets/plugins/layer-v2.4/layer.js"></script>
		<link rel="stylesheet" href="${SERVER_PATH_resources }/assets/plugins/layer-v2.4/skin/layer.css" />
		<script type="text/javascript" src="${SERVER_PATH_resources}/js/utils.js"></script>
		<script type="text/javascript" src="${SERVER_PATH_resources}/js/api_url.js"></script>
		
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		  <![endif]-->
		  
		  <sitemesh:write  property="head"/>
	</head>
	<body class="hold-transition skin-blue sidebar-mini">
		<div class="wrapper">
			
			<%@ include file="/WEB-INF/pages/common/header.jsp" %>
	
			<%@ include file="/WEB-INF/pages/common/menu.jsp" %>
	
			<div class="content-wrapper">
				<%--<section class="content-header">
					<h1 id="navMenuName"></h1>
					<ol class="breadcrumb">
					</ol>
				</section>--%>
				<sitemesh:write property='body'/>
			</div>
	
			<footer class="main-footer"> 
				<center>未来舞者（北京）教育科技有限公司 | 北京市海淀区广源闸5号广源大厦4层8418室未来舞者</center>
			</footer>
			<div class="control-sidebar-bg"></div>
		</div>
		
	</body>
</html>