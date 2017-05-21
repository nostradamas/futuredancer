<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>banner分类信息</title>
</head>
<body>

<form class="form-horizontal" id="objectDetailForm" role="form">
	<div class="row">

		<input type="hidden" id="id" name="cid" value="${bean.cid }">
		<div class="form-group">
			<label  class="col-sm-3 control-label" for="name">分类名</label>
			<div class="col-sm-4">
				<input type="text" class="form-control required"  id="name" name="name" placeholder="分类名" value="${bean.name}">
			</div>
		</div>

		<div class="form-group">
			<label  class="col-sm-3 control-label" for="bannerCode">code</label>
			<div class="col-sm-4">
				<input type="text" class="form-control digits" id="bannerCode" name="bannerCode" placeholder="顺序" value="${bean.bannerCode}">
			</div>
		</div>
	</div>
</form>



<script type="text/javascript">
var myValidator = $("#objectDetailForm").validate({
	rules : {
		name : "required",
		sort : 'digits'
	},
	messages : {
		name : "请输入名字",
		sort : '排序 必须为证书'
	}
});
</script>
</body>
</html>