<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<aside class="main-sidebar"> 
	<section class="sidebar">
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">


			<li class="treeview">
				<a href="#">
					<i class="fa fa-info-circle"></i>
					<span class="menu-text">新闻发布</span>
					<span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu">
					<li>
						<a href="${SERVER_PATH}/admin/news/toNewCategoryMain" onclick="onClickMenu(this);"><i class="fa fa-tasks"></i>新闻栏目</a>
					</li>
					<li class="">
						<a href="${SERVER_PATH}/admin/news/toNewsMain" onclick="onClickMenu(this);"><i class="fa fa-pencil-square-o"></i>新闻管理</a>
					</li>
				</ul>
			</li>

			<li class="treeview">
				<a href="#">
					<i class="fa fa-info-circle"></i>
					<span class="menu-text">网站内容</span>
					<span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu">
					<li>
						<a href="${SERVER_PATH}/admin/home/toHomeMain" onclick="onClickMenu(this);"><i class="fa fa-tasks"></i>主页管理</a>
					</li>
					<li class="">
						<a href="${SERVER_PATH}/admin/pageContent/toPageHomeMain" onclick="onClickMenu(this);"><i class="fa fa-pencil-square-o"></i>子页面管理</a>
					</li>
					<li class="">
						<a href="${SERVER_PATH}/admin/banner/toBannerMain" onclick="onClickMenu(this);"><i class="fa fa-pencil-square-o"></i>Banner管理</a>
					</li>
					<li class="">
						<a href="${SERVER_PATH}/admin/banner/toBannerCodeMain" onclick="onClickMenu(this);"><i class="fa fa-pencil-square-o"></i>BanneCoder管理</a>
					</li>
					<li class="">
						<a href="${SERVER_PATH}/admin/link/toLinkMain" onclick="onClickMenu(this);"><i class="fa fa-pencil-square-o"></i>超链接管理</a>
					</li>
				</ul>
			</li>
			
			<li class="treeview">
	          <a href="#">
				  <i class="fa fa fa-user"></i>
				  <span class="menu-text">关于我们</span>
				  <span class="pull-right-container">
					  <i class="fa fa-angle-left pull-right"></i>
				  </span>
	          </a>
	          <ul class="treeview-menu">
	           		<li class="">
						<a href="${SERVER_PATH}/admin/aboutus/toAboutusMain" onclick="onClickMenu(this);"><i class="fa fa-pencil-square-o"></i>关于我们页面</a>
					</li>
					<li class="">
						<a href="${SERVER_PATH}/admin/aboutus/toCultureMain" onclick="onClickMenu(this);"><i class="fa fa-pencil-square-o"></i>公司文化</a>
					</li>
					<li class="">
						<a href="${SERVER_PATH}/admin/aboutus/toEnvironmentMain" onclick="onClickMenu(this);"><i class="fa fa-pencil-square-o"></i>证书、环境管理</a>
					</li>
				</ul>
			</li>
			
			<li class="treeview">
	          <a href="${SERVER_PATH}/admin/class/toClassMain" onclick="onClickMenu(this);">
				  <i class="fa fa fa-user"></i>
				  <span class="menu-text">课程管理</span>
	          </a>
	        </li>
	        <li class="treeview">
	          <a href="${SERVER_PATH}/admin/teacher/toTeacherMain" onclick="onClickMenu(this);">
				  <i class="fa fa fa-user"></i>
				  <span class="menu-text">教师管理</span>
	          </a>
	        </li>
	        <li class="treeview">
	          <a href="${SERVER_PATH}/admin/student/toStudentMain" onclick="onClickMenu(this);">
				  <i class="fa fa fa-user"></i>
				  <span class="menu-text">学生管理</span>
	          </a>
	        </li>
	        <li class="treeview">
	          <a href="${SERVER_PATH}/admin/footer/toFooterMain" onclick="onClickMenu(this);">
				  <i class="fa fa fa-user"></i>
				  <span class="menu-text">底部信息管理</span>
	          </a>
	        </li>
	        
		</ul>

	</section>
</aside>