<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="cn">
<head>
<%@ include file="/WEB-INF/pages/common/globa.jsp"%>
<title>新闻详情</title>
<link href="${SERVER_PATH_resources}/css/teacher.css" >
</head>
<body>
	<!-- 导航banner  -->
	<section>
		<div id="banner" >
			<div class="flexslider">
				<ul class="slides" id="banner-ul-id">
				</ul>
			</div>
		</div>
	</section>
	<!-- 往期回顾 -->
	<input type="hidden" value="${cid}" id="cid"/>
	<section class="mt40 mb40 pt20 text-center bg">
		<div class="container ">
			<div class="row">
				<div class="col-sm-1 col-xs-12 mt30">
					<a href="${SERVER_PATH}/home/toNewsMain" class="btn">返回新闻列表</a>
				</div>
			</div>
		</div>
		<h3>${empty newsBean ? '' : newsBean.title}</h3>
		<h4>${empty newsBean ? '' : newsBean.dateStr}</h4>
		<div class="container mt20 text-left news-content" >
			<div class="row" style="min-height:450px">
				<div class="col-md-8 col-md-offset-2 col-xs-12">
					<p class="lh15 ">
					${empty newsBean ? '' : newsBean.content}
					</p>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-1 col-sm-offset-10 col-xs-12 mt30">
					<a href="${SERVER_PATH}/home/toNewsMain" class="btn">返回新闻列表</a>
				</div>
			</div>
		</div>
	</section>
	<section class="mt20 mb40 pt20 text-center bg">
		<div class="container">
			<div class="col-md-10 col-md-offset-1 col-xs-12" >
				<ul id="news-list" class="news-list">
				</ul>
				<div class="clearfix"></div>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="${SERVER_PATH_resources}/assets/plugins/jquery.min.js"></script>
	<!-- bootstrap -->
	<script type="text/javascript" src="${SERVER_PATH_resources}/assets/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${SERVER_PATH_resources}/assets/plugins/flexslider/jquery.flexslider.js"></script>

	<script type="text/javascript" src="${SERVER_PATH_resources}/js/banner_slider.js"></script>
	<script type="text/javascript">
	$(window).load(function() {
		var hid = $('#homeId').val();
		getBanners(1);
		var top = $(window).height() - $('.index-header').height(); //获取某个元素距顶部的距离
        $("body,html").animate({scrollTop:(top-60)+"px"},500);
        getNewlists(1,8);
	});
	function getNewlists(page, pageSize){
		$.ajax({
	        type : 'GET',
	        url : SERVER_PATH + '/news/getNews',
	        data : {
	        	page : page,
	        	pageSize : pageSize
	        },
	        async:true,
	        success : function(res){
	        	if(res.rescode == 100) {
	        		var news = res.data;
	        		var $html = '';
	        		if(news != null) {
	        			$.each(news, function(i, item){
	        				$html += '<li><a href=' + SERVER_PATH + '/home/toNewsDetailMain?nid=' + item.nid + '>';
	        				$html += item.title + '</a>';
	        				$html += '<span>' + item.createTime + '</span>';
	        				$html += '</li>';
	        			});
	        			$('#news-list').empty();
	            		$('#news-list').html($html);
	        		}
	        	}
	        }
		});
	}
	</script>
</body>
</html>
