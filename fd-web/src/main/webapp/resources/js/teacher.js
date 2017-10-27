//获取新闻分类
function getTeachers(hid, type){
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/teacher/getTeachers',
        async:true,
        data : {
        	homeId : hid,
        	type : type,
        	pageSize : 50
        },
        success : function(res){
        	if(res.rescode == 100) {
        		var teachers = res.data;
        		var totalSize = res.totalSize;
        		if(teachers != null) {
        			if(type == 1){
                		var $html = '';
        				$.each(teachers, function(i, item){
        					$html += '<div class="col-md-3 col-xs-6">';
        					$html += '<div class="teacher-info border-radius teacher-type1">';
        					$html += '<img src="'+item.img+'?imageView2/4/w/260/h/300/format/jpg/q/75|imageslim"class="img-responsive zoom-img" alt="'+item.name+'">';
        					$html += '<div class="view-caption">';
        					$html += '<div class="teacher-head"><img src="'+item.icon+'?imageView2/4/w/100/h/100/format/jpg/q/75|imageslim"></div>';
        					$html += '<p class="lh15">' + item.detail + '</p>';
        					$html += '</div>';
        					$html += '<h5>'+ item.name +'</h5></div></div>';
            				
            			});
        				$('#teacher-type1-id').empty();
        				$('#teacher-type1-id').html($html);
        			} else if(type == 2) {
                		var $html = '';
                		$.each(teachers, function(i, item){
        					$html += '<div class="col-md-3 col-xs-6 mt20 mb10">';
        					$html += '<div class="teacher-info teacher-type2 teacher-detail border-radius">';
        					$html += '<img src="'+item.img+'?imageView2/4/w/260/h/300/format/jpg/q/75|imageslim"class="img-responsive zoom-img" alt="'+item.name+'">';
        					$html += '<h5>'+ item.name +'</h5>';
        					var brief = item.brief;
        					if(item.brief!=null ){
        						brief = item.brief.replace(new RegExp("<br/>","gm"),"");
        						brief = brief.replace(new RegExp("<br>","gm"),"");
        						if(brief.length > 54){
        							brief = brief.substring(0,53);
        						}
        					}
        					$html += '<div class="p5">'+ brief +'</div>';
        					$html += '<div class="view-caption">';
        					$html += '<div class="teacher-head"><img src="'+item.icon+'?imageView2/4/w/100/h/100/format/jpg/q/75|imageslim"></div>';
        					$html += '<p class="lh15">' + item.detail + '</p>';
        					$html += '</div></div></div>';
            				
            			});
        				$('#teacher-type2-id').empty();
        				$('#teacher-type2-id').html($html);
        				$('.teacher-detail').hover(function(){
            				$(this).find('.teacher-detail-info').toggleClass('techer-detail-show');
            			});
        			}
        			
        			
        		}
        	}
        }
	});
}