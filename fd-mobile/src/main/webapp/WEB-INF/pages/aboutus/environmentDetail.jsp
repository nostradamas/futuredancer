<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>证书信息</title>
<script type="text/javascript" src="${SERVER_PATH_resources}/js/decorators/default.js"></script>
</head>
<body>

<form class="form-horizontal" id="objectDetailForm" role="form">
	<div class="row">

		<input type="hidden" id="id" name="eid" value="${bean.eid }">
        <input type="hidden" value="${uptoken}" id="uploadToken">
		<div class="form-group">
			<label  class="col-sm-3 control-label" for="name">名称</label>
			<div class="col-sm-4">
				<input type="text" class="form-control required"  id="name" name="name" placeholder="名称" value="${bean.name}">
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="url">照片</label>
			<div class="col-sm-9">
                <div>
                	<c:choose>
                		<c:when test="${empty bean or empty bean.url}">
                			<ul class="ace-thumbnails clearfix hide" id="showImgUrl">
                		</c:when>
                		<c:otherwise>
                  		    <ul class="ace-thumbnails clearfix" id="showImgUrl">
                		</c:otherwise>
                	</c:choose>
                        <li>
                            <a href="#">
                                <img height="150" id="url" key="${bean.url}"  src="${bean.url}" />
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
			<label  class="col-sm-3 control-label" for="sort">类型</label>
			<div class="col-sm-4">
				<form:select path="bean.type" id="type" name="type" cssClass="form-control" class="col-xs-4 col-sm-4">
					<form:option value="1">证书</form:option>
					<form:option value="2">环境</form:option>
				</form:select>
			</div>
		</div>
		<div class="form-group">
			<label  class="col-sm-3 control-label" for="sort">顺序</label>
			<div class="col-sm-4">
				<input type="text" class="form-control digits" id="sort" name="sort" placeholder="顺序" value="${bean.sort}">
			</div>
		</div>
		<div class="form-group">
			<label  class="col-sm-3 control-label" for="sort">是否显示</label>
			<div class="col-sm-4">
				<form:select path="bean.isDel" id="isDel" name="isDel" cssClass="form-control" class="col-xs-4 col-sm-4">
					<form:option value="0">显示</form:option>
					<form:option value="1">不显示</form:option>
				</form:select>
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

	var imageName = new Date().getTime(); //设置上传图片的名称前缀
	var uploadBrowseBtnParent = 'uploadImgParent'; //这里是元素的id
	var uploadBrowseBtn = 'uploadImgBtn';  //这里是 元素的id
	var $collbackViewImage = $('#showImgUrl'); //这里是上传图片的回显，也保存这图片的key，然后保存到数据库中
	var uploadToken = $("#uploadToken").val(); //这里是上传的token
	var qiniuDomain=QINIU_DOMAIN+'/';  //七牛云外链
	qiniuuploadimage(imageName,uploadBrowseBtnParent,uploadBrowseBtn,$collbackViewImage,uploadToken,qiniuDomain, '');
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