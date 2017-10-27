<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>banner信息</title>
<script type="text/javascript"
	src="${SERVER_PATH_resources}/js/decorators/default.js"></script>
</head>
<body>

	<form class="form-horizontal" id="objectDetailForm" role="form">
		<div class="row">

			<input type="hidden" id="id" name="bid" value="${bean.bid }">
			<input type="hidden" value="${uptoken}" id="uploadToken">
			<div class="form-group">
				<label class="col-sm-3 control-label" for="title">标题</label>
				<div class="col-sm-4">
					<input type="text" class="form-control required" id="title"
						name="title" placeholder="标题" value="${bean.title}">
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label" for="type">类型</label>
				<div class="col-sm-4">
					<select id="code" name="bannerCode"
						class="form-control col-xs-4 col-sm-4">
						<c:choose>
							<c:when test="${!empty codes}">
								<option></option>
								<c:forEach var="code" items="${codes}" varStatus="i">
									<option value="${code.bannerCode}"
										<c:if test="${!empty bean and !empty bean.bannerCode and code.bannerCode==bean.bannerCode}">selected="selected"</c:if>>${code.name }</option>
									
								</c:forEach>
							</select>
						</c:when>
						<c:otherwise>
								<option>无分类</option>
						</c:otherwise>
					</c:choose>
				</select>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="bannerImg">封面</label>
			<div class="col-sm-9">
                <div>
                	<c:choose>
                		<c:when test="${empty bean or empty bean.imgUrl}">
                			<ul class="ace-thumbnails clearfix hide" id="showImgUrl">
                		</c:when>
                		<c:otherwise>
                  		    <ul class="ace-thumbnails clearfix" id="showImgUrl">
                		</c:otherwise>
                	</c:choose>
                        <li>
                            <a href="#">
                                <img height="150" id="bannerImg" name="imgUrl" key="${bean.imgUrl}"  src="${bean.imgUrl}" />
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
					<span style="color: #DB5841;">建议图片大小长宽比例16:9</span>
				</span>
			</div>
		</div>

		<div class="form-group">
			<label  class="col-sm-3 control-label" for="attachment">链接地址</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="linkUrl" name="linkUrl" placeholder="链接" value="${bean.linkUrl }">
			</div>
		</div>
		<div class="form-group">
			<label  class="col-sm-3 control-label" for="sort">类型</label>
			<div class="col-sm-4">
				<form:select path="bean.type" id="type" name="type" cssClass="form-control" class="col-xs-4 col-sm-4">
					<form:option value="1">图片</form:option>
					<form:option value="2">视频</form:option>
				</form:select>
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
		title : "required",
		sort : 'digits'
	},
	messages : {
		title : "请输入名称",
		sort : '排序 必须为整数'
	}
});
</script>
</body>
</html>