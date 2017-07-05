<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>关于我们内容信息</title>
<script type="text/javascript" src="${SERVER_PATH_resources}/js/decorators/default.js"></script>
</head>
<body>

<div class="container" style="padding-top:30px;background:#fff">
	<form class="form-horizontal" id="objectDetailForm" role="form">
		<div class="row">
			<input type="hidden" id="id" name="aid" value="${bean.aid }">
	        <input type="hidden" value="${uptoken}" id="uploadToken">
			<div class="form-group">
				<label  class="col-sm-3 control-label" for="aboutus">关于我们</label>
				<div class="col-sm-5">
					<textarea class="form-control" rows="6" placeholder="关于我们 " 
						id="aboutus" name="aboutus" >${bean.aboutus}</textarea>
				</div>
			</div>
			
			<div class="form-group">
				<label  class="col-sm-3 control-label" for="enlighten">启蒙级别</label>
				<div class="col-sm-5">
					<textarea class="form-control" rows="6" placeholder="授课模式-启蒙级别" 
						id="enlighten" name="enlighten" >${bean.enlighten}</textarea>
				</div>
			</div>
			<div class="form-group">
				<label  class="col-sm-3 control-label" for="popularize">普及级别</label>
				<div class="col-sm-5">
					<textarea class="form-control" rows="6" placeholder="授课模式-普及级别" 
						id="popularize" name="popularize" >${bean.popularize}</textarea>
				</div>
			</div>
			<div class="form-group">
				<label  class="col-sm-3 control-label" for="specialty">专家级别</label>
				<div class="col-sm-5">
					<textarea class="form-control" rows="6" placeholder="授课模式-专家级别" 
						id="specialty" name="specialty" >${bean.specialty}</textarea>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="modeImg">背景图片</label>
				<div class="col-sm-9">
	                <div>
	                	<c:choose>
	                		<c:when test="${empty bean or empty bean.modeImg}">
	                			<ul class="ace-thumbnails clearfix hide" id="showImgUrl">
	                		</c:when>
	                		<c:otherwise>
	                  		    <ul class="ace-thumbnails clearfix" id="showImgUrl">
	                		</c:otherwise>
	                	</c:choose>
	                        <li>
	                            <a href="#">
	                                <img height="150" id="modeImg" name="modeImg" key="${bean.modeImg}"  src="${bean.modeImg}" />
	                            </a>
	                        </li>
	                    </ul>
	                </div>
					<span class="input-icon" id="uploadImgParent">
						<a class="btn btn-default" id="uploadImgBtn" href="#" style="position: relative; z-index: 1;">
	                        <i class="glyphicon glyphicon-plus"></i>
	                        <span>选择图片</span>
	                    </a>
	                    <br/>
					</span>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="logo">Logo</label>
				<div class="col-sm-9">
	                <div>
	                	<c:choose>
	                		<c:when test="${empty bean or empty bean.logo}">
	                			<ul class="ace-thumbnails clearfix hide" id="logoUrl">
	                		</c:when>
	                		<c:otherwise>
	                  		    <ul class="ace-thumbnails clearfix" id="logoUrl">
	                		</c:otherwise>
	                	</c:choose>
	                        <li>
	                            <a href="#">
	                                <img height="150" id="logo" name="logo" key="${bean.logo}"  src="${bean.logo}" />
	                            </a>
	                        </li>
	                    </ul>
	                </div>
					<span class="input-icon" id="uploadLogoParent">
						<a class="btn btn-default" id="uploadLogoBtn" href="#" style="position: relative; z-index: 1;">
	                        <i class="glyphicon glyphicon-plus"></i>
	                        <span>选择图片</span>
	                    </a>
	                    <br/>
					</span>
				</div>
			</div>
			<div class="form-group text-center">
           		<button type="button" id="submitBtn" class="btn btn-primary">保存</button>
            </div>
		</div>
	</form>
</div>

<%@ include file="/WEB-INF/pages/common/jslibs.jsp"%>
<!-- 七牛上传 -->
<script src="${SERVER_PATH_resources }/plugs/plupload/js/plupload.full.min.js"></script>
<script src="${SERVER_PATH_resources }/plugs/plupload/js/plupload.min.js"></script>
<script src="${SERVER_PATH_resources }/plugs/qiniu/dist/qiniu.min.js"></script>

<script type="text/javascript">
$(function(){

	var imageName = new Date().getTime(); //设置上传图片的名称前缀
	var uploadBrowseBtnParent = 'uploadImgParent'; //这里是元素的id
	var uploadBrowseBtn = 'uploadImgBtn';  //这里是 元素的id
	var $collbackViewImage = $('#showImgUrl'); //这里是上传图片的回显，也保存这图片的key，然后保存到数据库中
	var uploadToken = $("#uploadToken").val(); //这里是上传的token
	var qiniuDomain=QINIU_DOMAIN+'/';  //七牛云外链
	qiniuuploadimage(imageName,uploadBrowseBtnParent,uploadBrowseBtn,$collbackViewImage,uploadToken,qiniuDomain, '');

	var logoName = 'logo-'+new Date().getTime(); //设置上传图片的名称前缀
	var uploadLogoBtnParent = 'uploadLogoParent'; //这里是元素的id
	var uploadLogoBtn = 'uploadLogoBtn';  //这里是 元素的id
	var $collbackViewLogo = $('#logoUrl'); //这里是上传图片的回显，也保存这图片的key，然后保存到数据库中
	qiniuuploadimage(logoName,uploadLogoBtnParent,uploadLogoBtn,$collbackViewLogo,uploadToken,qiniuDomain, '');
});
//校验
var myValidator = $("#objectDetailForm").validate({
	rules : {
		aboutus : "required",
		teachMode : 'required'
	},
	messages : {
		aboutus : "请输入关于我们内容",
		teachMode : '请输入授课模式内容'
	}
});
</script>

<script src="${SERVER_PATH_resources }/js/aboutus/aboutusMain.js"></script>
</body>
</html>