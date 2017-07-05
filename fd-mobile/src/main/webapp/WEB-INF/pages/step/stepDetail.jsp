<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>学生信息</title>
<script type="text/javascript" src="${SERVER_PATH_resources}/js/decorators/default.js"></script>
</head>
<body>

<form class="form-horizontal" id="objectDetailForm" role="form">
	<div class="row">

		<input type="hidden" id="sid" name="sid" value="${bean.sid }">
		<input type="hidden" id="hid" name="hid" value="${bean.hid }">
		<input type="hidden" id="typeId" name="typeId" value="${bean.typeId }">
		<div class="form-group">
			<label  class="col-sm-3 control-label" for="step2">阶段一</label>
			<div class="col-sm-4">
				<input type="text" class="form-control required"  id="step2" name="step2" placeholder="阶段一" value="${bean.step2}">
			</div>
		</div>
		<div class="form-group">
			<label  class="col-sm-3 control-label" for="step2">阶段二</label>
			<div class="col-sm-4">
				<input type="text" class="form-control required"  id="step2" name="step2" placeholder="阶段二" value="${bean.step2}">
			</div>
		</div>
		<div class="form-group">
			<label  class="col-sm-3 control-label" for="step2">阶段三</label>
			<div class="col-sm-4">
				<input type="text" class="form-control required"  id="step2" name="step2" placeholder="阶段三" value="${bean.step2}">
			</div>
		</div>
		<div class="form-group">
			<label  class="col-sm-3 control-label" for="step2">阶段四</label>
			<div class="col-sm-4">
				<input type="text" class="form-control required"  id="step2" name="step2" placeholder="阶段四" value="${bean.step2}">
			</div>
		</div>
		<div class="form-group">
			<label  class="col-sm-3 control-label" for="step2">阶段五</label>
			<div class="col-sm-4">
				<input type="text" class="form-control required"  id="step2" name="step2" placeholder="阶段五" value="${bean.step2}">
			</div>
		</div>
		<div class="form-group">
			<label  class="col-sm-3 control-label" for="step2">阶段六</label>
			<div class="col-sm-4">
				<input type="text" class="form-control required"  id="step2" name="step2" placeholder="阶段六" value="${bean.step2}">
			</div>
		</div>
		<div class="form-group">
			<label  class="col-sm-3 control-label" for="step2">总结</label>
			<div class="col-sm-4">
				<input type="text" class="form-control required"  id="step2" name="step2" placeholder="总结" value="${bean.step2}">
			</div>
		</div>
		<div class="form-group">
			<label  class="col-sm-3 control-label" for="isHide">类型</label>
			<div class="col-sm-4">
				<form:select path="bean.isHide" id="isHide" name="isHide" cssClass="form-control" class="col-xs-4 col-sm-4">
					<form:option value="1">显示</form:option>
					<form:option value="2">隐藏</form:option>
				</form:select>
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
		name : "请输入名称",
		sort : '排序 必须为整数'
	}
});
</script>
</body>
</html>