<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>教师信息管理</title>
</head>
<body>
	<section class="content custom-content">
		<div class="row custom-row">
			<div class="col-xs-12 custom-col-xs">
				<div class="box custom-box">
					<div class="box-body custom-box-body">
						<div id="divSearchForm">
							<form id="queryFrom">
								<div class="dataTables_filter">
									<label class="ml10">
										类型：
									</label>
									<label>
										<select name="type" class="form-control input-sm">
											<option></option>
											<option value="1">教育专家</option>
											<option value="2">金牌教师</option>
					                	</select>
									</label>
									<row>
										<button type="button" class="btn btn-primary btn-xs" onclick="searchForm('queryFrom');">
											<i class="ace-icon fa fa-search fa-lg white"></i> 搜索
										</button>
										<div class="widget-toolbar">
											<button type="button" class="btn btn-primary btn-xs" onclick="objectEdit('','${homeId}')">
												<i class="ace-icon fa fa-plus fa-lg white"></i> 新增
											</button>
											<button type="button" class="btn btn-primary btn-xs" name="dataReload">
												<i class="ace-icon fa fa-refresh fa-lg white"></i> 刷新
											</button>
											<button type="button" class="btn btn-primary btn-xs" id="backHome">
												<i class="ace-icon fa fa-refresh fa-lg white"></i> 返回管理
											</button>
										</div>
									</row>
				                </div>
								<div id="moreSearchDiv" style="display: none;">
								</div>
							</form>
						</div>
					</div>
					<input type="hidden" value="${homeId}" id="homeId"/>
					<div class="box-body box-body2-top custom-box-body">
						<table id="currentPageDataTable" class="table table-bordered table-hover">
							<thead>
							<tr>
								<th>tid</th>
								<th>姓名</th>
								<th>简介</th>
								<th>详情</th>
								<th>封面</th>
								<th>头像</th>
								<th>分类</th>
								<th>顺序</th>
								<th>显示在首页</th>
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
	<script src="${SERVER_PATH_resources }/js/teach/teacherMain.js"></script>
</body>
</html>