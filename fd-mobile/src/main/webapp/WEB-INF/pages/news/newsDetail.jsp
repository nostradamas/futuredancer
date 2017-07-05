<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>新闻信息</title>
<script type="text/javascript" src="${SERVER_PATH_resources}/js/decorators/default.js"></script>
</head>
<body>

<form class="form-horizontal" id="objectDetailForm" role="form">
	<div class="row">

		<input type="hidden" id="nid" name="nid" value="${bean.nid }">
		<input type="hidden" id="createCode" name="createCode" value="${bean.createCode }">
        <input type="hidden" value="${uptoken}" id="uploadToken">
		<div class="form-group">
			<label  class="col-sm-3 control-label" for="title">新闻标题</label>
			<div class="col-sm-4">
				<input type="text" class="form-control required"  id="title" name="title" placeholder="标题" value="${bean.title}">
			</div>
		</div>

		<div class="form-group">
			<label  class="col-sm-3 control-label" for="brief">简介</label>
			<div class="col-sm-4">
				<input type="text" class="form-control required" id="brief" name="brief" placeholder="简介" value="${bean.brief  }">
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-3 control-label" for="type">类型</label>
			<div class="col-sm-4">
				<select id="cid" name="cid" class="form-control col-xs-4 col-sm-4">
					<c:choose>
						<c:when test="${!empty cates}">
								<option></option>
								<c:forEach var="cate" items="${cates}" varStatus="i">
									<option value="${cate.cid}" <c:if test="${!empty bean and !empty bean.category and cate.cid==bean.category.cid}">selected="selected"</c:if>>${cate.name }</option>
									
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
			<label class="col-sm-3 control-label no-padding-right" for="newsImg">封面</label>
			<div class="col-sm-9">
                <div>
                	<c:choose>
                		<c:when test="${empty bean or empty bean.img}">
                			<ul class="ace-thumbnails clearfix hide" id="showImgUrl">
                		</c:when>
                		<c:otherwise>
                  		    <ul class="ace-thumbnails clearfix" id="showImgUrl">
                		</c:otherwise>
                	</c:choose>
                        <li>
                            <a href="#">
                                <img height="150" id="imgUrl" name="img" key="${bean.img}"  src="${bean.img}" />
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
					<span style="color: #DB5841;">建议图片大小长宽比例2:1，长600 x 宽300</span>
				</span>
			</div>
		</div>

		<%-- <div class="form-group">
			<label  class="col-sm-3 control-label" for="attachment">链接地址</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="linkUrl" name="linkUrl" placeholder="链接" value="${bean.linkUrl }">
			</div>
		</div> --%>
		<div class="form-group">
			<label  class="col-sm-3 control-label" for="sort">顺序</label>
			<div class="col-sm-4">
				<input type="text" class="form-control digits" id="sort" name="sort" placeholder="顺序" value="${bean.sort}">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="newsDetail">内容</label>
			<div class="col-sm-9">
				<textarea id="newsDetail" name="content" maxlength="2000"></textarea>
			</div>
		</div>
	</div>
</form>


<!-- 百度ueditor -->
<script src="${SERVER_PATH_resources }/plugs/ueditor/ueditor.config.js"></script>
<script src="${SERVER_PATH_resources }/plugs/ueditor/ueditor.all.min.js"></script>
<script src="${SERVER_PATH_resources }/plugs/ueditor/lang/zh-cn/zh-cn.js"></script>

<!-- 七牛上传 -->
<script src="${SERVER_PATH_resources }/plugs/plupload/js/plupload.full.min.js"></script>
<script src="${SERVER_PATH_resources }/plugs/plupload/js/plupload.min.js"></script>
<script src="${SERVER_PATH_resources }/plugs/qiniu/dist/qiniu.min.js"></script>

<script type="text/javascript">
var newsDetailUE;
$(function(){

	newsDetailUE = initUEditer('newsDetail');
	//对编辑器的操作最好在编辑器ready之后再做
	newsDetailUE.ready(function(){
		//设置编辑器的内容
		newsDetailUE.setContent('${bean.content }');
	});

	//上传图活动logo
	var imageName = new Date().getTime(); //设置上传图片的名称前缀
	var uploadBrowseBtnParent = 'uploadImgParent'; //这里是元素的id
	var uploadBrowseBtn = 'uploadImgBtn';  //这里是 元素的id
	var $collbackViewImage = $('#showImgUrl'); //这里是上传图片的回显，也保存这图片的key，然后保存到数据库中
	var uploadToken = $("#uploadToken").val(); //这里是上传的token
	var qiniuDomain=QINIU_DOMAIN+'/';  //七牛云外链
	qiniuuploadimage(imageName,uploadBrowseBtnParent,uploadBrowseBtn,$collbackViewImage,uploadToken,qiniuDomain, '?imageView2/0/w/600/h/300');
});
//校验
var myValidator = $("#objectDetailForm").validate({
	rules : {
		title : "required",
		sort:"digits"
	},
	messages : {
		title : "请输入名字",
		sort:"顺序是整数"
	}
});
</script>
</body>
</html>