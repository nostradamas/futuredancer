

// 获取banner
function getStudents(page, pageSize, contentId, setPage, homeId, atHome){
	console.log(homeId);
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/student/getStudents',
        data : {
        	homeId : typeof(homeId) != 'undefined' && homeId != 'undefined' ? homeId: '',
        	page : page,
        	pageSize : pageSize,
        	atHome :  typeof(atHome) != 'undefined' && atHome != 'undefined' ? atHome: 0
        },
        async:true,
        success : function(res){
        	if(res.rescode == 100) {
        		var students = res.data;
        		var totalSize = res.totalSize;
        		var $html = '';
        		if(students != null) {
        			$.each(students, function(i, item){
        				$html += '<div class="col-md-3 col-xs-6 mt20 mb30">';
        				$html += '  <div class="teacher-info border-radius student-box">';
        				$html += '  <img src="' + item.img + '" class="img-responsive zoom-img" alt="'+item.name+'">';
        				$html += '  <h4>' + item.name + '</h4>';
        				$html += '<div class="view-caption">';
    					$html += '<p class="lh15">' + item.detail + '</p>';
    					$html += '</div></div></div>';
        			});
        			$('#'+contentId).empty();
            		$('#'+contentId).html($html);
            		// 分页
        			if(setPage){
        				var allPage = Math.ceil(totalSize / pageSize);
        				if(allPage > 1) {
        					var pageLists = getPageLists(page, allPage, 4);// 总共显示五页
            				var $page = '<div class="row mt40 text-center"><nav aria-label="Page navigation"><ul class="pagination">';
            				if(page > 1){
            					$page += '<li> <a href="javascript:void(0)" onclick="getStudents('
            						+ Number(Number(page)-1) +',' + pageSize +',\''+contentId+'\','+setPage +',\'' + homeId + '\' )"> <span aria-hidden="true">上一页</span> </a> </li>';
            				}
                			for(var i = 0; i < pageLists.length; i++){
                				var active = Number(pageLists[i]) == page ? 'class="active"' :'';
                				$page += '<li ' + active + ' > <a href="javascript:void(0)"';
                				$page += active
                				$page +=' onclick="getStudents('+ Number(pageLists[i]) +',' + pageSize +',\''+contentId+'\','+setPage +',\'' + homeId + '\' )">';
                				$page +='<span aria-hidden="true">' + pageLists[i] + '</span> </a> </li>';
                			}
                			if(allPage != pageLists[pageLists.length-1]){
                				$page += '<li> <a href="javascript:void(0)" disabled="true"> <span >...</span> </a> </li>';
                				
                			}
                			if(allPage != page) {
                				$page += '<li> <a href="javascript:void(0)"  onclick="getStudents('
                					+ Number(Number(page)+1) +',' + pageSize +',\''+contentId + '\',' + setPage +',\'' + homeId + '\' )"> <span >下一页</span> </a> </li>';
                			}
                			$page += '</ul></nav></div>';
                			$('#'+contentId + '-page').empty();
                    		$('#'+contentId + '-page').html($page);
        				}
            			
            		}
        		}
        		
        	}
        }
	});
}

