<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>底部内容信息</title>
<script type="text/javascript" src="${SERVER_PATH_resources}/js/decorators/default.js"></script>
</head>
<body>

<div class="container" style="padding-top:30px;background:#fff">
	<form class="form-horizontal" id="objectDetailForm" role="form">
		<div class="row">
			<input type="hidden" id="id" name="fid" value="${bean.fid }">
	        <input type="hidden" value="${uptoken}" id="uploadToken">
			<div class="form-group">
				<label  class="col-sm-3 control-label" for="title">标题</label>
				<div class="col-sm-4">
					<input type="text" class="form-control required"  id="title" name="title" placeholder="标题" value="${bean.title}">
				</div>
			</div>
			
			<div class="form-group">
				<label  class="col-sm-3 control-label" for="company">公司</label>
				<div class="col-sm-4">
					<input type="text" class="form-control"  id="company" name="company" placeholder="公司" value="${bean.company}">
				</div>
			</div>
			
			<div class="form-group">
				<label  class="col-sm-3 control-label" for="telephone">手机</label>
				<div class="col-sm-4">
					<input type="text" class="form-control"  id="telephone" name="telephone" placeholder="手机" value="${bean.telephone}">
				</div>
			</div>
			
			<div class="form-group">
				<label  class="col-sm-3 control-label" for="phoneNum">电话</label>
				<div class="col-sm-4">
					<input type="text" class="form-control"  id="phoneNum" name="phoneNum" placeholder="电话" value="${bean.phoneNum}">
				</div>
			</div>
			
			<div class="form-group">
				<label  class="col-sm-3 control-label" for="address">地址</label>
				<div class="col-sm-4">
					<input type="text" class="form-control"  id="address" name="address" placeholder="地址" value="${bean.address}">
				</div>
			</div>
			<div class="form-group">
				<label  class="col-sm-3 control-label" for="record">备案号</label>
				<div class="col-sm-4">
					<input type="text" class="form-control"  id="record" name="record" placeholder="备案号" value="${bean.record}">
				</div>
			</div>
			
			<div class="form-group">
				<label  class="col-sm-3 control-label" for="childCodeTitle">少儿咨询</label>
				<div class="col-sm-4">
					<input type="text" class="form-control"  id="childCodeTitle" name="childCodeTitle" placeholder="少儿咨询" value="${bean.childCodeTitle}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="childCode">少儿咨询二维码</label>
				<div class="col-sm-9">
	                <div>
	                	<c:choose>
	                		<c:when test="${empty bean or empty bean.childCode}">
	                			<ul class="ace-thumbnails clearfix hide" id="showImgUrl">
	                		</c:when>
	                		<c:otherwise>
	                  		    <ul class="ace-thumbnails clearfix" id="showImgUrl">
	                		</c:otherwise>
	                	</c:choose>
	                        <li>
	                            <a href="#">
	                                <img height="150" id="childCode" name="childCode" key="${bean.childCode}"  src="${bean.childCode}" />
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
				<label  class="col-sm-3 control-label" for="adultCodeTitle">艺考咨询</label>
				<div class="col-sm-4">
					<input type="text" class="form-control"  id="adultCodeTitle" name="adultCodeTitle" placeholder="艺考咨询" value="${bean.adultCodeTitle}">
				</div>
			</div>
			
			
			
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="adultCode">艺考咨询二维码</label>
				<div class="col-sm-9">
	                <div>
	                	<c:choose>
	                		<c:when test="${empty bean or empty bean.adultCode}">
	                			<ul class="ace-thumbnails clearfix hide" id="logoUrl">
	                		</c:when>
	                		<c:otherwise>
	                  		    <ul class="ace-thumbnails clearfix" id="logoUrl">
	                		</c:otherwise>
	                	</c:choose>
	                        <li>
	                            <a href="#">
	                                <img height="150" id="adultCode" name="adultCode" key="${bean.adultCode}"  src="${bean.adultCode}" />
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

	var imageName =  'child-'+new Date().getTime(); //设置上传图片的名称前缀
	var uploadBrowseBtnParent = 'uploadImgParent'; //这里是元素的id
	var uploadBrowseBtn = 'uploadImgBtn';  //这里是 元素的id
	var $collbackViewImage = $('#showImgUrl'); //这里是上传图片的回显，也保存这图片的key，然后保存到数据库中
	var uploadToken = $("#uploadToken").val(); //这里是上传的token
	var qiniuDomain=QINIU_DOMAIN+'/';  //七牛云外链
	qiniuuploadimage(imageName,uploadBrowseBtnParent,uploadBrowseBtn,$collbackViewImage,uploadToken,qiniuDomain, '');

	var logoName = 'adult-'+new Date().getTime(); //设置上传图片的名称前缀
	var uploadLogoBtnParent = 'uploadLogoParent'; //这里是元素的id
	var uploadLogoBtn = 'uploadLogoBtn';  //这里是 元素的id
	var $collbackViewLogo = $('#logoUrl'); //这里是上传图片的回显，也保存这图片的key，然后保存到数据库中
	qiniuuploadimage(logoName,uploadLogoBtnParent,uploadLogoBtn,$collbackViewLogo,uploadToken,qiniuDomain, '');
});
//校验
var myValidator = $("#objectDetailForm").validate({
	rules : {
		title : "required"
	},
	messages : {
		title : "请输入关于我们内容"
	}
});
</script>

<script src="${SERVER_PATH_resources }/js/footer/footerMain.js"></script>
</body>
</html>