$(window).load(function() {
	getClasses(1, 8);
});
//获取课程分类
function getClasses(page, pageSize, hid){
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/class/getClasses',
        async:true,
        data : {
        	homeId : hid,
        	page : page,
        	pageSize :pageSize
        },
        success : function(res){
        	if(res.rescode == 100) {
        		var classes = res.data;
        		var totalSize = res.totalSize;
        		if(classes != null) {
        			var $html = '';
        			$.each(classes, function(i, item){
        				$html += '<div class="col-md-4 col-xs-6 mb40">';
    					$html += '<div class="teacher-info border-radius" onclick="showVideo(\''+item.cid+'\')">';
    					$html += '<img src="'+item.img+'?imageView2/4/w/360/h/230/format/jpg/q/75|imageslim"class="img-responsive zoom-img" alt="'+item.name+'">';
    					$html += '<div class="view-caption">';
    					$html += '<div class="video-play"><img src="http://on01whf2s.bkt.clouddn.com/play.png"></div>';
    					$html += '</div></div>';
    					$html += '<h4 class="pt10">'+ item.name +'</h4>';
    					var brief =  item.brief!=null && item.brief.length > 48 ? item.brief.substring(0,48) + '...' : item.brief;
    					$html += '<div title="'+item.brief+'"class="video-brief">'+ brief +'</div>';
    					$html += '</div>';
        			});
        			$('#videoId').empty();
        			$('#videoId').html($html);
        			$('.class-info').hover(function(){
        				$(this).find('.video-play').toggleClass('show');
        			});
        			var allPage = Math.ceil(totalSize / pageSize);
        			if(allPage > 1) {
        				var pageLists = getPageLists(page, allPage, 4);// 总共显示五页
        				var $page = '<div class="row mt40 text-center"><nav aria-label="Page navigation"><ul class="pagination">';
        				if(page > 1){
        					$page += '<li> <a href="javascript:void(0)" onclick="getClasses('+page +', '+pageSize+',\''+ hid+'\')"> <span aria-hidden="true">上一页</span> </a> </li>';
        				}
            			for(var i = 0; i < pageLists.length; i++){
            				var active = Number(pageLists[i]) == page ? 'class="active"' :'';
            				$page += '<li ' + active + ' > <a href="javascript:void(0)"';
            				$page += active
            				$page +=' onclick="getClasses('+page+', '+pageSize+', \''+hid+'\')">';
            				$page +='<span aria-hidden="true">' + pageLists[i] + '</span> </a> </li>';
            			}
            			if(allPage != pageLists[pageLists.length-1]){
            				$page += '<li> <a href="javascript:void(0)" disabled="true"> <span >...</span> </a> </li>';
            				
            			}
            			if(allPage != page) {
            				$page += '<li> <a href="javascript:void(0)"  onclick="getClasses('+page+', '+pageSize+',\' '+hid+'\')"> <span >下一页</span> </a> </li>';
            			}
            			$page += '</ul></nav></div>';
            			$('#video-page').empty();
                		$('#video-page').html($page);
        			}
        		}
        	}
        }
	});
}


//播放视频
function showVideo(id){
	$objectDetailDialog = BootstrapDialog.show({
		type : BootstrapDialog.TYPE_PRIMARY,
		size : BootstrapDialog.SIZE_WIDE,
		title: '网络课程',
		message: $('<div></div>').load( SERVER_PATH + '/home/toVideoPlayMain?cid='+id),
		buttons : [{
			icon: 'fa fa-close',
			label : '关闭',
			action : function(dialogRef){
				dialogRef.close();
			}
		}]
	});
}