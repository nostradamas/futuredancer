//获取新闻分类
function getTeachers(hid, contentId, type, pageSize){
	var pageSize = typeof(pageSize) != 'undefined' && pageSize != '' ? pageSize : 16;
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/teacher/getTeachers',
        async:true,
        data : {
        	homeId : hid,
        	type : type,
        	pageSize : pageSize
        },
        success : function(res){
        	if(res.rescode == 100) {
        		var teachers = res.data;
        		var totalSize = res.totalSize;
        		if(teachers != null) {
        			if(type == 1){
                		var $html = '<div class="row teacher-div  mt20 ">';
        				$.each(teachers, function(i, item){
        					$html += '<div class="col-md-3 col-xs-6">';
        					$html += '<div class="teacher-info border-radius teacher-type1">';
        					$html += '<img src="'+item.img+'"class="img-responsive zoom-img" alt="'+item.name+'">';
        					$html += '<h4>' + item.name + '</h4>';
        					$html += '<div class="view-caption">';
        					$html += '<div class="teacher-head"><img src="'+item.icon+'"></div>';
        					$html += '<p class="lh15">' + item.detail + '</p>';
        					$html += '</div>';
        					$html += '<h5>'+ item.brief +'</h5></div></div>';
            				
            			});
        				$html += '</div>';
        				$('#'+contentId).empty();
        				$('#'+contentId).html($html);
        			} else{
        				var $html = '<div class="row teacher-div  mt20 ">';
        				$.each(teachers, function(i, item){
        					$html += '<div class="col-md-3 col-xs-6">';
        					$html += '<div class="teacher-box border-radius">';
        					$html += '<img src="'+item.img+'"class="img-responsive zoom-img" alt="'+item.name+'">';
        					$html += '<h4>' + item.name + '</h4>';
        					$html += '<p class="lh15">' + item.brief + '</p>';
        					$html += '<div class="view-caption">';
        					$html += '<div class="teacher-head"><img src="'+item.icon+'"></div>';
        					$html += '<p class="lh15">' + item.detail + '</p>';
        					$html += '</div></div></div>';
        					if((i+1)%4 == 0) {
        						$html += '</div><div class="row teacher-div">';
        					} 
            			});
        				$html += '</div>';
        				$('#'+contentId).empty();
        				$('#'+contentId).html($html);
        			}
    				
        		}
        	}
        }
	});
}

function getStudents(page, pageSize, contentId, setPage, homeId, atHome){
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
        		var $html = '<div class="row teacher-div  mt20 ">';
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
    				$html += '</div>';
        			$('#'+contentId).empty();
            		$('#'+contentId).html($html);
            		// 分页
        		}
        		
        	}
        }
	});
}