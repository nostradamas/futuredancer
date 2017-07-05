<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>内容信息</title>
<script type="text/javascript" src="${SERVER_PATH_resources}/js/decorators/default.js"></script>
</head>
<body>

<form class="form-horizontal" id="objectDetailForm" role="form">
	<div class="row">

		<input type="hidden" id="pid" name="pid" value="${bean.pid }">
        <input type="hidden" id="targetId" name="targetId" value="${bean.targetId }">
       <input type="hidden" value="${uptoken}" id="uploadToken">
		<div class="form-group">
			<label  class="col-sm-3 control-label" for="title">名称</label>
			<div class="col-sm-4">
				<input type="text" class="form-control required"  id="title" name="title" placeholder="名称" value="${bean.title}">
			</div>
		</div>
		<div class="form-group">
			<label  class="col-sm-3 control-label" for="subTitle">英文名称</label>
			<div class="col-sm-4">
				<input type="text" class="form-control"  id="subTitle" name="subTitle" placeholder="英文名称" value="${bean.subTitle}">
			</div>
		</div>
		<div class="form-group">
			<label  class="col-sm-3 control-label" for="content">内容</label>
			<div class="col-sm-5">
				<textarea class="form-control" rows="6" placeholder="内容" 
					id="brief" name="content" >${bean.content}</textarea>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="pic">内容图片</label>
			<div class="col-sm-9">
                <div>
                	<c:choose>
                		<c:when test="${empty bean or empty bean.pic}">
                			<ul class="ace-thumbnails clearfix hide" id="showImgUrl">
                		</c:when>
                		<c:otherwise>
                  		    <ul class="ace-thumbnails clearfix" id="showImgUrl">
                		</c:otherwise>
                	</c:choose>
                        <li>
                            <a href="#">
                                <img height="150" id="pic" key="${bean.pic}"  src="${bean.pic}" />
                            </a>
                        </li>
                    </ul>
                </div>
				<span class="input-icon" id="uploadImgParent">
					<a class="btn btn-default" id="uploadImgBtn" href="#" style="position: relative; z-index: 1;">
                        <i class="glyphicon glyphicon-plus"></i>
                        <span>选择图片</span>
                    </a>
                    <a class="btn btn-default" id="removeImgBtn" href="#" style="position: relative; z-index: 1;">
                        <i class="glyphicon glyphicon-remove"></i>
                        <span>删除图片</span>
                    </a>
                    <br/>
				</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="background">背景</label>
			<div class="col-sm-9">
                <div>
                	<c:choose>
                		<c:when test="${empty bean or empty bean.background}">
                			<ul class="ace-thumbnails clearfix hide" id="logoUrl">
                		</c:when>
                		<c:otherwise>
                  		    <ul class="ace-thumbnails clearfix" id="logoUrl">
                		</c:otherwise>
                	</c:choose>
                        <li>
                            <a href="#">
                                <img height="150" id="background" name="background" key="${bean.background}"  src="${bean.background}" />
                            </a>
                        </li>
                    </ul>
                </div>
				<span class="input-icon" id="uploadLogoParent">
					<a class="btn btn-default" id="uploadLogoBtn" href="#" style="position: relative; z-index: 1;">
                        <i class="glyphicon glyphicon-plus"></i>
                        <span>选择图片</span>
                    </a>
                    <a class="btn btn-default" id="removeLogoBtn" href="#" style="position: relative; z-index: 1;">
                        <i class="glyphicon glyphicon-remove"></i>
                        <span>删除图片</span>
                    </a>
                    <br/>
				</span>
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


<!-- 七牛上传 -->
<script src="${SERVER_PATH_resources }/plugs/plupload/js/plupload.full.min.js"></script>
<script src="${SERVER_PATH_resources }/plugs/plupload/js/plupload.min.js"></script>
<script src="${SERVER_PATH_resources }/plugs/qiniu/dist/qiniu.min.js"></script>

<script type="text/javascript">
$(function(){

	var imageName = 'content-' + new Date().getTime(); //设置上传图片的名称前缀
	var uploadBrowseBtnParent = 'uploadImgParent'; //这里是元素的id
	var uploadBrowseBtn = 'uploadImgBtn';  //这里是 元素的id
	var $collbackViewImage = $('#showImgUrl'); //这里是上传图片的回显，也保存这图片的key，然后保存到数据库中
	var uploadToken = $("#uploadToken").val(); //这里是上传的token
	var qiniuDomain=QINIU_DOMAIN+'/';  //七牛云外链
	qiniuuploadimage(imageName,uploadBrowseBtnParent,uploadBrowseBtn,$collbackViewImage,uploadToken,qiniuDomain, '');
	
	var logoName = 'background-'+new Date().getTime(); //设置上传图片的名称前缀
	var uploadLogoBtnParent = 'uploadLogoParent'; //这里是元素的id
	var uploadLogoBtn = 'uploadLogoBtn';  //这里是 元素的id
	var $collbackViewLogo = $('#logoUrl'); //这里是上传图片的回显，也保存这图片的key，然后保存到数据库中
	qiniuuploadimage(logoName,uploadLogoBtnParent,uploadLogoBtn,$collbackViewLogo,uploadToken,qiniuDomain, '');

	$('#removeImgBtn').click(function(){
		$collbackViewImage.addClass('hide');
		$collbackViewImage.find('img').attr({src: "", key: ""});
	});
	$('#removeLogoBtn').click(function(){
		$collbackViewLogo.addClass('hide');
		$collbackViewLogo.find('img').attr({src: "", key: ""});
	});
	
});
//校验
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