<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>主页信息</title>
<script type="text/javascript" src="${SERVER_PATH_resources}/js/decorators/default.js"></script>
</head>
<body>

<form class="form-horizontal" id="objectDetailForm" role="form">
	<div class="row">

		<input type="hidden" id="hid" name="hid" value="${bean.hid }">
		<div class="form-group">
			<label  class="col-sm-3 control-label" for="name">主页名称</label>
			<div class="col-sm-4">
				<input type="text" class="form-control required"  id="name" name="name" placeholder="主页名称" value="${bean.name}">
			</div>
		</div>
		<div class="form-group">
			<label  class="col-sm-3 control-label" for="sort">顺序</label>
			<div class="col-sm-4">
				<input type="text" class="form-control digits" id="sort" name="sort" placeholder="顺序" value="${bean.sort}">
			</div>
		</div>
	</div>
</form>


<script type="text/javascript">
//校验
var myValidator = $("#objectDetailForm").validate({
	rules : {
		name : "required"
	},
	messages : {
		name : "请输入名称"
	}
});
</script>
</body>
</html>