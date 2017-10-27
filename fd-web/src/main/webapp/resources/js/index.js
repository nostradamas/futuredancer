var $window = $(window), flexslider = { vars:{} };
	
$(window).load(function() {
	var hid = $('#homeId').val();
	// tab导航
	getHomeTabs(hid);
	getHomeContent(hid, false);
	// 菜单页
	getBanners(1);
	// 显示菜单
	getMenus(hid);
	getIndexTeachers(hid);
	getCLassLists(hid, 1, 10, 'index-video-slide');
    getStudents(1, 16, 'studentlistId', false, hid, 1);
	
});
$window.resize(function() {
    var gridSize = getGridSize();
    flexslider.vars.minItems = gridSize;
    flexslider.vars.maxItems = gridSize;
});

// 获取首页关联教师信息
function getIndexTeachers(hid){
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/teacher/getTeachers',
        async:true,
        data : {
        	homeId : hid,
        	page : 1,
        	pageSize : 30,
        	atHome : 1,// 显示在首页
        },
        success : function(res){
        	if(res.rescode == 100) {
        		var teachers = res.data;
        		var totalSize = res.totalSize;
        		if(teachers != null) {
            		var $html = '<li class="content-flex">';
            		var $caphtml = '';
    				$.each(teachers, function(i, item){
    					var j = 1; 
    					$html += '<div class="index-teacher-box">';
    					$html += '<div class="teacher-info border-radius teacher-type1">';
    					$html += '<img src="'+item.img+'?imageView2/4/w/280/h/290/format/jpg/q/75|imageslim"class="img-responsive zoom-img" alt="'+item.name+'">';
    					$html += '<h4>' + item.name + '</h4>';
    					$html += '<div class="view-caption">';
    					$html += '<div class="teacher-head"><img src="'+item.icon+'?imageView2/4/w/140/h/145/format/jpg/q/75|imageslim"></div>';
    					$html += '<p class="lh15">' + item.detail + '</p>';
    					$html += '</div>';
    					$html += '<h5>'+ item.brief +'</h5></div></div>';
        				if((i+1)%2==0){
        					$html += '</li>' + (i!=(teachers.length-1) ? '<li class="content-flex">' : '');
        					
        					$caphtml += '<li><a href="###">'+j+'</a></li>';
        					j ++;
        				}
        			});
    				$('#index-teacher-id').empty();
    				$('#index-teacher-id').html($html);
    				$('#index-teacher-capId').empty();
    				$('#index-teacher-capId').html($caphtml);
    				$('.teacher-slides').flexslider({
    					'animation': 'slide',
    					'direction': 'vertical',
    					'slideshowSpeed': 6000,
    					'directionNav' : false,
    					'pauseOnHover' : true,
    					'move' : 1,
    			        'manualControls' : '.slide-caption li',
			        	'manualControlEvent': 'hover'
    				});
    				$('#index-teacher-capId li').find('a').hover(function(){
  					   $(this).click();
	  				});
        		}
        	}
        }
	});
}

