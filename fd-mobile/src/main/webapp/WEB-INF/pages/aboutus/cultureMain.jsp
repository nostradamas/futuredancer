<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>公司文化管理</title>
</head>
<body>
	<section class="content custom-content">
		<div class="row custom-row">
			<div class="col-xs-12 custom-col-xs">
				<div class="box custom-box">
					<div class="box-body custom-box-body">
						<div id="divSearchForm">
							<div class="dataTables_filter">
								<row>
									<div class="widget-toolbar">
										<button type="button" class="btn btn-primary btn-xs" onclick="objectEdit('')">
											<i class="ace-icon fa fa-plus fa-lg white"></i> 新增
										</button>
										<button type="button" class="btn btn-primary btn-xs" name="dataReload">
											<i class="ace-icon fa fa-refresh fa-lg white"></i> 刷新
										</button>
									</div>
								</row>
			                </div>
						</div>
					</div>
					<div class="box-body box-body2-top custom-box-body">
						<table id="currentPageDataTable" class="table table-bordered table-hover">
							<thead>
							<tr>
								<th>pid</th>
								<th>标题</th>
								<th>内容</th>
								<th>背景</th>
								<th>顺序</th>
								<th>操作</th>
							</tr>
							</thead>
							<tbody>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="/WEB-INF/pages/common/jslibs.jsp"%>
	<script src="${SERVER_PATH_resources }/js/aboutus/cultureMain.js"></script>
</body>
</html>