<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>学生所在主页</title>
<script type="text/javascript" src="${SERVER_PATH_resources}/js/decorators/default.js"></script>
</head>
<body>

<form class="form-horizontal" id="objectStudentForm" role="form">
	<div class="row">
		<input type="hidden" id="sid" name="id" value="${sid}">
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
		        <div class="checkbox">
		        	<label><input name="homeIds" type="checkbox" value="a07cb1d55f7442e9839265613e2a8835">首页</label>
			   	</div>
		        <div class="checkbox">
			    	<label><input name="homeIds" type="checkbox" value="d2cee8098dcd4e599e0cb376b9793aab">舞蹈艺考</label>
		        </div>
		        <div class="checkbox">
		        	<label><input name="homeIds" type="checkbox" value="2536e6905f984f1782cefae95d59f834">业余舞蹈</label>
		        </div>
		   	</div>
		</div>
	</div>
</form>
<script type="text/javascript">
	var homeIds = eval('(${homeIds})');
	$(':checkbox[name="homeIds"]').val(homeIds);
</script>
</body>
</html>