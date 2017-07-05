<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header class="main-header">
	<!-- Logo -->
	<a href="#" class="logo">
		<!-- mini logo for sidebar mini 50x50 pixels --> 
		<span class="logo-mini"> 
			<img alt="" src="${SERVER_PATH_resources}/assets/img/logo.png" width="40px" height="40px">
		</span>
		<span class="logo-lg">未来舞者网站管理</span>
	</a> 
	<!-- Header Navbar --> 
	<nav class="navbar navbar-static-top" role="navigation"> 
		<!-- Sidebar toggle button--> 
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"> 
			<span class="sr-only">Toggle navigation</span>
		</a>
	 	<!-- Navbar Right Menu -->
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<li>
					<a href="index.html"><i class="fa fa-home fa-lg"></i></a>
				</li>
				<!-- User Account: -->
				<li class="dropdown user user-menu">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
						<img src="${SERVER_PATH_resources}/assets/dist/img/user.png" class="user-image" alt="User Image">
						<span class="hidden-xs">系统管理员</span>
					</a>
					<ul class="dropdown-menu">
						<!-- User image -->
						<li class="user-header">
							<img id="user-header" src="${SERVER_PATH_resources}/assets/dist/img/user.png" class="img-circle" alt="User Image">
							<p>系统管理员</p>
						</li>
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a id="systemsettingBtn" href="javascript:void(0)" class="btn btn-default btn-flat">修改密码</a>
							</div>
							<div class="pull-right">
								<a href="login.html" class="btn btn-default btn-flat">注销</a>
							</div>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</nav> 
</header>