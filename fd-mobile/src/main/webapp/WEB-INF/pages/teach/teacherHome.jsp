<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>教师所在主页</title>
<script type="text/javascript" src="${SERVER_PATH_resources}/js/decorators/default.js"></script>
</head>
<body>

<form class="form-horizontal" id="objectTeacherForm" role="form">
	<div class="row">
		<input type="hidden" id="tid" name="id" value="${tid}">
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
		        <div class="checkbox">
		        	<label><input name="homeIds" type="checkbox" value="a07cb1d55f7442e9839265613e2a8835">首页</label>
			   	</div>
		        <div class="checkbox">
			    	<label><input name="homeIds" type="checkbox" value="d2cee8098dcd4e599e0cb376b9793aab">舞蹈艺考首页</label>
		        </div>
		        <div class="checkbox">
		        	<label><input name="homeIds" type="checkbox" value="380d768c4fe74ebea408f728c3a8f9db">普高生艺考</label>
		        </div>
		        <div class="checkbox">
		        	<label><input name="homeIds" type="checkbox" value="f14a9a876a2644958904f3284025d025">艺考生冲刺</label>
		        </div>
		        <div class="checkbox">
		        	<label><input name="homeIds" type="checkbox" value="a1b8bea9544444d990897286717873ff">应战附中</label>
		        </div>
		        <div class="checkbox">
		        	<label><input name="homeIds" type="checkbox" value="2536e6905f984f1782cefae95d59f834">业余舞蹈首页</label>
		        </div>
		        <div class="checkbox">
		        	<label><input name="homeIds" type="checkbox" value="4e22824e54874ac5bf395d7ef5623a54">少儿舞蹈-芭蕾舞</label>
		        </div>
		        <div class="checkbox">
		        	<label><input name="homeIds" type="checkbox" value="5c522b4e54874ac5bf395d7ef5623a54">少儿舞蹈-中国舞</label>
		        </div>
		        <div class="checkbox">
		        	<label><input name="homeIds" type="checkbox" value="92e25f54874ac5bf395d7ef5623a5446">少儿舞蹈-国标舞</label>
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