//获取新闻分类
function getCategory(pageSize){
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/news/getCategories',
        async:true,
        success : function(res){
        	if(res.rescode == 100) {
        		var cats = res.data;
        		var totalSize = res.totalSize;
        		var $html = '';
        		if(cats != null) {
        			$.each(cats, function(i, item){
        				var active = '';
        				if(i == 0) {
        					getNews(1, pageSize, item.cid);
        					active = ' class="active" ';
        				}
        				$html += '<li  ' + active + ' ><a ' + active + ' href="javascript:void(0)" onclick="getNews(1, '+pageSize+', \''+item.cid+'\')">'+item.name+'</a></li>';
        				
        			});
        			$('#news-nav-id').empty();
        			$('#news-nav-id').html($html);
        			
        			$('#news-nav-id').find('li').click(function(){
        				$(this).siblings().removeClass('active');
        				$(this).addClass('active');
        				$(this).find('a').removeClass('active');
        			});
        		}
        	}
        }
	});
}

// 获取新闻
function getNews(page, pageSize, cid){
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/news/getNews',
        data : {
        	cid : cid,
        	page : page,
        	pageSize : pageSize
        },
        async:true,
        success : function(res){
        	if(res.rescode == 100) {
        		var news = res.data;
        		var totalSize = res.totalSize;
        		var $html = '';
        		if(news != null) {
        			$.each(news, function(i, item){
        				$html += '<div class="news-item" onclick="viewNews(\''+item.createCode+'\')">';
        				$html += '	<div class="news-item-img"><img src="' + item.img + '|imageView2/4/w/150/h/90|imageslim"></div>';
        				$html += '	<div class="news-item-content">';
        				$html += '   	<h3>' + item.title + '<span class="news-date">'+item.createTime+'</span><i class="clear"></i></h3>';
        				$html += '  	<div class="news-item-brief">'+item.brief+'</div>';
        				$html += '	</div></div>';
        			});
        			$('#news-content-id').empty();
            		$('#news-content-id').html($html);
            		// 分页
    				var allPage = Math.ceil(totalSize / pageSize);
    				$('#page-nav-id').empty();
    				if(allPage > 1) {
    					var pageLists = getPageLists(page, allPage, 10);// 总共显示4页
        				var $page = '<div class="row mt40 text-center"><nav aria-label="Page navigation"><ul class="pagination">';
        				if(page > 1){
        					$page += '<li> <a href="javascript:void(0)" onclick="getNews(' + Number(Number(page)-1) + ',' + pageSize + ',\'' + cid + '\')"> <span aria-hidden="true">上一页</span> </a> </li>';
        				} 
            			for(var i = 0; i < pageLists.length; i++){
            				var active = Number(pageLists[i]) == page ? 'class="active"' :'';
            				$page += '<li ' + active + ' > <a href="javascript:void(0)"';
            				$page += active
            				$page +=' onclick="getNews(' + pageLists[i] + ',' + pageSize + ',\'' + cid + '\')">';
            				$page +='<span aria-hidden="true">' + pageLists[i] + '</span> </a> </li>';
            			}
            			if(allPage != pageLists[pageLists.length-1]){
            				$page += '<li> <a href="javascript:void(0)"> <span >...</span> </a> </li>';
            				
            			}
            			if(allPage != page) {
            				$page += '<li> <a href="javascript:void(0)" onclick="getNews(' + Number(Number(page)+1) + ',' + pageSize + ',\'' + cid + '\')"> <span >下一页</span> </a> </li>';
            			}
            			$page += '</ul></nav></div>';
            			$('#page-nav-id').html($page);
    				}
        			
        		}
        		
        	}
        }
	});
}


function viewNews(createCode){
	window.location.href = SERVER_PATH + '/news/' + createCode;
}