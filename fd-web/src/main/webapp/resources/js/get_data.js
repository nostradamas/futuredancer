$(function(){
	$('i.close').click(function(){
		$('.show-tab').addClass('move-in');
	});
	
	$('i.ballerina-back').click(function(){
		$('.show-tab').removeClass('move-in');
	});
	$('.poster-close').click(function(){
		$('.poster-div').hide();
	});
	$('#back-top').click(function(){
		$("html, body").animate({ scrollTop : 0 } , 1000);
	});
	getFooter();
	getPoster();
	$.ajax({
	    type : 'GET',
	    url : SERVER_PATH + '/link/getLinkLists',
	    async:true,
	    success : function(res){
	    	if(res.rescode == 100) {
	    		var tabs = res.data;
	    		var size = res.totalSize;
	    		$('#link-id').empty();
	    		var $html = '';
	    		$.each(tabs, function(i, item){
	    			$html += '<li class="link-flex-item"><a target="_blank" title="'+item.linkName+'" href="'+item.linkUrl+'">'+item.linkName+'</a></li>'
	    		});0
	    		$html += '';
	    		$('#link-id').html($html);
	    	}
	    }
	});
	
});
//　首页导航
function getHomeTabs(hid, thisId){
	
	$.ajax({
	    type : 'GET',
	    url : SERVER_PATH + '/home/getHomeTabs',
	    data : {
	    	homeId : hid,
	    	thisId : thisId
	    },
	    async:true,
	    success : function(res){
	    	if(res.rescode == 100) {
	    		var tabs = res.data;
	    		var size = res.totalSize;
	    		$('#index-tab-id').empty();
	    		var $html = '<ul class="index-header-ul">';
	    		$.each(tabs, function(i, item){
	    			$html += '<li class="header-tab">';
	    			var hasSub = (item.subTabs != null && item.subTabs.length > 0);
	    			
	    			var href = hasSub 
	    					? (item.subTabs!=null && item.subTabs.length>0 ? SERVER_PATH+'/subHome/toIndexMain?hid=' + item.subTabs[0].hid : 'javascript:void(0)') 
	    					: SERVER_PATH+'/subHome/toIndexMain?hid=' + item.hid;
	    			var active = item.active==1 ? 'class="active"' : '';
	    		    $html += '<a '+active+' href="'+ href + '"><span>';
	    			$html += item.name + '</span></a>';
	    			if(hasSub) {
	    				$html += '<ul class="sub_tab">'
	    				$.each(item.subTabs, function(j, sitem){
	    					var subHref = sitem.isVoid == 1? SERVER_PATH+'/subHome/toIndexMain?hid=' + sitem.hid : 'javascript:void(0)';
	    					$html += '<li>';
	    	    		    $html += '<a  href="'+ subHref +'"><span>';
	    	    		    $html += sitem.name + '</span></a>';
	    					$html += '</li>';
	    					
	    				});
	    				$html += '</ul>'
	    			}
	        		$html += '</li>'
	    		});
	    		$html += '</ul>';
	    		$('#index-tab-id').html($html);
	    		$('.header-tab').hover(function(){
	    			$(this).find('.sub_tab').toggleClass('on');
	    		});
	    	}
	    }
	});
}


//舞蹈艺考，业余舞蹈 菜单
function getSubHomeMenus(hid, isLeaf, parentId, subHomeId){
	var homeId = isLeaf==1 ? parentId : hid;
	var thisId = typeof(subHomeId) != 'undefined' && subHomeId != '' ? subHomeId : hid;
	$.ajax({
	    type : 'GET',
	    url : SERVER_PATH + '/home/getHomeTabs',
	    data : {
	    	homeId : homeId
	    },
	    async:true,
	    success : function(res){
    		if(res.rescode == 100) {
        		var menus = res.data;
        		var size = res.totalSize;
        		var $menu = '';
    			$.each(menus, function(i, item){
        			var active = '';
        			var url = SERVER_PATH + '/subHome/toItemMain?hid=' + item.hid;// 每一项详情的页面
        			if(thisId == item.hid){
        				active = ' class="active" '
        			}
        			if(isLeaf==1){
        				url = SERVER_PATH+'/subHome/toIndexMain?hid=' + item.hid;
        			}
        			if(item.isVoid==2){
        				url = 'javascript:void(0)';
        			}
    				$menu += '<li>';
    				$menu += '<a  '+active+'  href="' + url +'">' + item.name + '</a>';
        		});
        		
    			$('#menu-id').empty();
    			$('#menu-id').html($menu);
        	}
	    }
	});
}
    

// 获取banner
function getBanners(code, isSub){
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/home/getBanners',
        data : {
        	code : code
        },
        async:true,
        success : function(res){
        	if(res.rescode == 100) {
        		var banners = res.data;
        		var size = res.totalSize;
        		$('#banner-ul-id').empty();
        		var $html = '';
        		$.each(banners, function(i, item){
        			var click = '';
        			if(typeof(item.linkUrl) != 'undefined' && item.linkUrl != null){
        				click = 'onclick="location=\''+SERVER_PATH + item.linkUrl+'\'"';
        			}
        			$html += '<li '+click+' style="background-image: url(' + item.imgUrl + ');">';
            		$html += '</li>';
        		});
        		$html += '</ul>';
        		$('#banner-ul-id').html($html);
        		if(!isMobile.any()){
        			fullHeight(isSub);
            		sliderMain(isSub);
        		} else {
        			$('#banner .flexslider').flexslider({
						animation: "slide",
						slideshow: true,    
						animationLoop: true,
						move: 1,
        		    });
        			$('.flex-control-nav li').find('a').hover(function(){
        				$(this).click();
        			});
        		}
        	}
        }
	});
}

//获取 首页menu
function getMenus(homeId){
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/home/getIndexContents',
        data : {
        	homeId : homeId
        },
        async:true,
        success : function(res){
        	if(res.rescode == 100) {
        		var menus = res.data;
        		var size = res.totalSize;
        		var $menu = '';
        		var url = GetUrlRelativePath();
    			$.each(menus, function(i, item){
        			var active = '';
        			if(url.indexOf(item.url) != -1){
        				active = ' class="active" '
    			　　}
    				$menu += '<li>';
    				$menu += '<a  '+active+'  href="' + SERVER_PATH + '/'+ item.url +'?targetId='+item.mid+'">' + item.name + '</a>';
					$menu += '</li>';
        		});
    			$('#menu-id').empty();
    			$('#menu-id').html($menu);
        	}
        }
	});
}

// 子页面二级导航
function getSubNav(homeId, tabId){
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/home/getSubTabs',
        data : {
        	homeId : homeId,
        	tid : tabId
        },
        async:true,
        success : function(res){
        	if(res.rescode == 100) {
        		var tabs = res.data;
        		var size = res.totalSize;
        		var $tabs = '';
    			$.each(tabs, function(i, item){
    				var url = ''
    				var active = item.on?' active ' : '';
    				var type = item.type;
    				$tabs += ' <div class="col-xs-4">';
    				
    				$tabs += ' <a href="' + SERVER_PATH + item.url +'?hid=' + homeId + '&tabId='+item.tid+'&type='+type+'" class="portfolio-box' + active + ' ">';
    				$tabs += ' <div class="portfolio-box-caption">';
    				$tabs += ' <div class="portfolio-box-caption-content">';
    				$tabs += ' <div class="project-category text-faded">';
    				$tabs += ' <i class="tab-icon" style="background-image:url('+item.icon+')"></i>';
    				$tabs += ' </div>';
    				$tabs += ' <div class="project-name">' + item.name + ' </div>';
    				$tabs += ' </div></div></a></div>';
        		});
				$('#submenu-id').empty();
				$('#submenu-id').html($tabs);
    			
        	}
        }
	});
}

//获取 项目页面内容（艺考冲刺，普高艺考，应战附中，芭蕾舞，中国舞）+ 教师 + 学生
function getItemContent(homeId){
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/home/getItemContents',
        data : {
        	homeId : homeId
        },
        async:true,
        success : function(res){
        	if(res.rescode == 100) {
        		var menus = res.data;
        		var size = res.totalSize;
        		var url = GetUrlRelativePath();
    			$.each(menus, function(i, item){
    				$('#'+item.contentId).find('h3').text(item.title);
    				$('#'+item.contentId).find('h4').text(item.subTitle);
    				if(!isMobile.any()){
    					if($('#'+item.contentId+' .content-img').find('img').length > 0){
        					$('#'+item.contentId+' .content-img').find('img').attr('src',item.background);
        				} else {
        					$('#'+item.contentId).css('background-image','url('+item.background+')');
        				}
    				} else {
    					$('#'+item.contentId+' .content-img').hide();
    					$('#'+item.contentId).css('background-image','url('+item.background+')');
    				}
    				
            		$('#'+item.contentId).find('p').html(item.content);
            		$('#'+item.contentId+'-content').find('p').html(item.content);
            		$('#'+item.contentId+'-content').find('.class-title').html(item.title);
            		
            		if(item.pic!=null){

            			$('#'+item.contentId +'-center').find('.mauto').attr('src', item.pic);
            			$('#'+item.contentId).find('.sub-Img-css').attr('src', item.pic);
            		}
            		if(item.type == 1) {
            			$('#'+item.contentId).find('span').html(item.title);
            			$('#'+item.contentId).find('div').html(item.content);
            			
            		}
        		});
        	}
        }
	});
}

// 填充首页内容
function getHomeContent(homeId, isclick){
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/home/getIndexContents',
        data : {
        	homeId : homeId
        },
        async:true,
        success : function(res){
        	if(res.rescode == 100) {
        		var menus = res.data;
        		var size = res.totalSize;
    			$.each(menus, function(i, item){
    				if($('#'+item.contentId).find('h4').length > 0){
    					if(item.subName!=null){
                			$('#'+item.contentId).find('h4').html(item.subName);
                		}
    					$('#'+item.contentId).find('h3').html(item.name);
    				} else {
    					var title = item.name ;
    					if(item.subName!=null){
            				title +=  '<span>' + item.subName + '</span>';
    					}
    					$('#'+item.contentId).find('h3').html(title);
    				}
            		$('#'+item.contentId + '-content').find('img').attr('src',item.pic);
            		$('#'+item.contentId).find('p').html(item.brief);
            		if(item.subImg!=null){
            			$('#'+item.contentId).find('.sub-Img-css').attr('src',item.subImg);
            		}
            		if(item.icon!=null){
            			$('#'+item.contentId).find('i.art-icon').css('background-image','url('+item.icon+')');
            		}
    				
    				if(!isMobile.any()){
    					if($('#'+item.contentId).find('img').length > 0){
        					$('#'+item.contentId +' .content-img').find('img').attr('src',item.background);
        					$('#'+item.contentId +' .content-img-1').find('img').attr('src',item.background);
        				} else {
        					$('#'+item.contentId).css('background-image','url('+item.background+')');
        				}
    				} else {
    					$('#'+item.contentId+' .content-img').hide();
    					$('#'+item.contentId).css('background-image','url('+item.background+')');
    				}
            		var type = '&type=' +  item.contentType ;
            		
            		if(item.url!=null){
            			if(item.hiBaidu==2){
            				$('#'+item.contentId).find('a').attr('href',BAIDU_SHANGQIAO);
            				$('#'+item.contentId).find('a').attr('target','_blank');
            			} else {
            				$('#'+item.contentId).find('a').attr('href',SERVER_PATH + '/' + item.url +'?hid=' + homeId + '&tabId='+item.mid + type );
            			}
            		}
            		/*if(typeof(isclick) == 'undefined' || isclick){
            			
            			$('#'+item.contentId).click(function(){
        					window.location.href =  SERVER_PATH + '/' + item.url +'?hid=' + homeId + '&tabId='+item.mid + type;
        				});
            		}
            		*/
        		});
        		
        	}
        }
	});
}





//获取 环境
function getEnvironment(type, objId){
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/home/getEnvironments',
        data: {type:type},
        async:true,
        success : function(res){
        	if(res.rescode == 100) {
        		var environments = res.data;
        		var size = res.totalSize;
        		var url = GetUrlRelativePath();
        		var $html = '<ul class="slides">';
    			$.each(environments, function(i, item){
					$html += '<li>';
					$html += '  <img src="' + item.url + '" class="img-responsive zoom-img" alt="'+item.name+'">';
					$html += '</li>';
        		});
    			$html += '</ul>'
    			$('#'+objId).empty();
				$('#'+objId).html($html);
				$('#'+objId).flexslider({
			      animation: "slide",
			      slideshow: true,    
			      animationLoop: true,
			      itemWidth: 200,
			      itemMargin: 10,
				  move : 1,
			      minItems: getGridSize(), // use function to pull in initial value
			      maxItems: getGridSize() // use function to pull in initial value
			    });
				$('.flex-control-nav li').find('a').hover(function(){
					  $(this).click();
				  });
				$('a.flex-prev').hover(function(){
				  $(this).click();
			  	});
				$('a.flex-next').hover(function(){
					  $(this).click();
				});
			  
        	}
        }
	});
}


function getGridSize() {
    return (window.innerWidth < 600) ? 2 :
           (window.innerWidth < 900) ? 3 : 4;
 }

function GetUrlRelativePath(){
　　var url = location.href;
　　var arrUrl = url.split("//");
　　var start = arrUrl[1].indexOf("/");
　　var relUrl = arrUrl[1].substring(start);//stop省略，截取从start开始到结尾的所有字符

　　if(relUrl.indexOf("?") != -1){
　　　　relUrl = relUrl.split("?")[0];
　　}
　　return relUrl;
}


function getQueryString(name) {
    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
}

function getTeacherLists(hid, contentId, atHome, pageSize){
	var isHome = typeof(atHome)=='undefined'? 0 : atHome;
	var pageSize = typeof(pageSize)=='undefined'? 10 : pageSize;
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/teacher/getTeachers',
        async:true,
        data : {
        	homeId : hid,
        	atHome : isHome,
        	pageSize : pageSize
        },
        success : function(res){
        	if(res.rescode == 100) {
        		var teachers = res.data;
        		var totalSize = res.totalSize;
        		if(teachers != null) {
                		var $html = '<ul class="slides">';
        				$.each(teachers, function(i, item){
        					$html += '<li><div class="border-radius">';
        					$html += '<div class="teacher-info">';
        					$html += '<img src="'+item.img+'"class="img-responsive zoom-img" alt="'+item.name+'">';
        					$html += '<h4 class="text-left">'+ item.name +'</h4>';
        					$html += '<div class="view-caption">';
        					$html += '<div class="teacher-head"><img src="'+item.icon+'"></div>';
        					$html += '<p class="lh15">' + item.detail + '</p>';
        					$html += '</div></div>';
        					$html += '<h5 class="text-left">'+ item.brief +'</h5></div></li>';
            				
            			});
        				$html += '</ul>';
        				$('#'+contentId).empty();
        				$('#'+contentId).html($html);
        				$('#'+contentId).flexslider({
              		      animation: "slide",
              		      slideshow: true,    
              		      animationLoop: true,
              		      itemWidth: 200,
              		      itemMargin: 10,
              		      move: 1,
              		      minItems: getGridSize(), // use function to pull in initial value
              		      maxItems: getGridSize() // use function to pull in initial value
              		    });
        				$('.flex-control-nav li').find('a').hover(function(){
        					  $(this).click();
        				  });
        				$('a.flex-prev').hover(function(){
      					  $(this).click();
      				  	});
        				$('a.flex-next').hover(function(){
        					  $(this).click();
        				});
        			
        		}
        	}
        }
	});
}

// 课程包
function getExperts(hid){
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/coursePack/getCoursePackLists',
        async:true,
        data : {
        	start:0,
        	pageSize:2,
        	homeId : hid
        },
        success : function(res){
        	if(res.rescode == 100) {
        		var teachers = res.data;
        		var totalSize = res.totalSize;
        		if(teachers != null) {
                		var $html = '';
        				$.each(teachers, function(i, item){
        					var title = item.name;
        					$html += '<div class="col-md-6 col-xs-12">';
        					$html += '  <div class="subject-box">';
        					$html += '   <img src="'+item.img+'" alt="'+item.name+'">';
        					$html += '   <div class="subject-foot"><h3><span class="subject-title">'+item.name+'</span>主讲人：'+item.teacher+'</h3>';
        					$html += '   <p class="l15">'+item.brief+'</p></div>';
        					$html += '  </div>';
        					$html += '</div>';
            				
            			});
        				$('#expectsId').empty();
        				$('#expectsId').html($html);
        		}
        	}
        }
	});
}

function getStudentLists(homeId, page, pageSize, contentId, atHome){
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/student/getStudents',
        data : {
        	homeId : typeof(homeId) != 'undefined' && homeId != 'undefined' ? homeId: '',
        	page : page,
        	pageSize : typeof(pageSize)=='undefined'  && pageSize != 'undefined' ? 10 : pageSize,
        	atHome :  typeof(atHome) != 'undefined' && atHome != 'undefined' ? atHome: 0
        },
        async:true,
        success : function(res){
        	if(res.rescode == 100) {
        		var students = res.data;
        		var totalSize = res.totalSize;
        		var $html = '<ul class="slides">';
        		if(students != null) {
        			$.each(students, function(i, item){
        				$html += '<li>';
        				$html += '  <div class="teacher-info teacher-detail border-radius">';
        				$html += '  <img src="' + item.img + '" class="img-responsive zoom-img" alt="'+item.name+'">';
        				$html += '  <h5>' + item.name + '</h5>';
        				$html += '  <div>' + item.brief + '</div>';
        				$html += '  <div class="view-caption">';
    					$html += '    <p class="lh15">' + item.detail + '</p>';
    					$html += '  </div></div></li>';
        			});
        			$html += '</ul>'
        			$('#'+contentId).empty();
            		$('#'+contentId).html($html);
            		$('#'+contentId).flexslider({
        		      animation: "slide",
        		      slideshow: true,    
        		      animationLoop: true,
        		      itemWidth: 200,
        		      itemMargin: 10,
          		      move: 1,
        		      minItems: getGridSize(), // use function to pull in initial value
        		      maxItems: getGridSize() // use function to pull in initial value
        		    });
            		$('.flex-control-nav li').find('a').hover(function(){
    					  $(this).click();
  	  				  });
  	  				$('a.flex-prev').hover(function(){
  						  $(this).click();
  					  	});
  	  				$('a.flex-next').hover(function(){
  	  					  $(this).click();
  	  				});
        		}
        		
        	}
        }
	});
}

function getCLassLists(hid, page, pageSize, contentId, atHome){
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/class/getClasses',
        async:true,
        data : {
        	homeId : hid,
        	page : page,
        	pageSize :pageSize,
        	atHome : atHome
        },
        success : function(res){
        	if(res.rescode == 100) {
        		var classes = res.data;
        		var totalSize = res.totalSize;
        		if(classes != null) {
        			var $html = '<ul class="slides">';
        			$.each(classes, function(i, item){
        				$html += '<li>';
    					$html += '<div class="teacher-info border-radius" onclick="showVideo(\''+item.cid+'\')">';
    					$html += '<img src="'+item.img+'"class="img-responsive zoom-img" alt="'+item.name+'">';
    					$html += '<div class="view-caption">';
    					$html += '<div class="video-play"><img src="http://on01whf2s.bkt.clouddn.com/play.png"></div>';
    					$html += '</div></div>';
    					$html += '<h4>'+ item.name +'</h4></li>';
        			});
        			$html += '</ul>';
        			$('#'+contentId).empty();
        			$('#'+contentId).html($html);
        			$('.class-info').hover(function(){
        				$(this).find('.video-play').toggleClass('show');
        			});
        			$('#'+contentId).flexslider({
        			      animation: "slide",
        			      slideshow: true,    
        			      animationLoop: true,
        			      itemWidth: 200,
        			      itemMargin: 10,
              		      move: 1,
        			      minItems: getGridSize(), // use function to pull in initial value
        			      maxItems: getGridSize() // use function to pull in initial value
        			});
        			$('.flex-control-nav li').find('a').hover(function(){
  					  $(this).click();
	  				  });
	  				$('a.flex-prev').hover(function(){
						  $(this).click();
					  	});
	  				$('a.flex-next').hover(function(){
	  					  $(this).click();
	  				});
        		}
        	}
        }
	});
}

//获取 环境
function getTirdEnvironment(type, objId){
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/home/getEnvironments',
        data: {type:type},
        async:true,
        success : function(res){
        	if(res.rescode == 100) {
        		var environments = res.data;
        		var size = res.totalSize;
        		var url = GetUrlRelativePath();
        		var $html = '<ul class="slides">';
    			$.each(environments, function(i, item){
					$html += '<li>';
					$html += '  <img src="' + item.url + '" class="img-responsive zoom-img" alt="'+item.name+'">';
					$html += '</li>';
        		});
    			$html += '</ul>'
    			$('#'+objId).empty();
				$('#'+objId).html($html);
				$('#'+objId).flexslider({
			      animation: "slide",
			      slideshow: true,    
			      animationLoop: true,
			      itemWidth: 200,
			      itemMargin: 10,
				  move : 1,
			      minItems: getTirdGridSize(), // use function to pull in initial value
			      maxItems: getTirdGridSize() // use function to pull in initial value
			    });
				$('.flex-control-nav li').find('a').hover(function(){
					  $(this).click();
				  });
				$('a.flex-prev').hover(function(){
				  $(this).click();
			  	});
				$('a.flex-next').hover(function(){
					  $(this).click();
				});
					 
        	}
        }
	});
}


function getTirdGridSize() {
    return (window.innerWidth < 600) ? 2 : 3;
 }
function setCookie(name, value) {
	document.cookie = name + "=" + escape(value);
}
// 获取广图
function getPoster(){
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/home/getPoster',
        async:true,
        success : function(res){
        	if(res.rescode == 100) {
        		var poster = res.data;
        		$('#posterId').attr('src', poster.img);
        	}
        }
	});
}
//获取footer
function getFooter(){
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/home/getFooter',
        async:true,
        success : function(res){
        	if(res.rescode == 100) {
        		var footer = res.data;
        		if(footer!=null){
        			if(footer.title!=null){
        				$('#footer-title').text(footer.title);
        			}
        			var html ='';
        			html += '<p>'+(footer.company!=null?footer.company:'')+'</p>';
        			html += '<p>咨询电话：' + (footer.phoneNum!=null?footer.phoneNum:'') 
        				+ '&nbsp;&nbsp;&nbsp;&nbsp;' + (footer.telephone!=null?footer.telephone:'') + '</p>';
        			html += '<p>地址：'+ (footer.address!=null?footer.address:'')+'</p>';
        			html += '<p>'+(footer.record!=null?footer.record:'')+'</p>';
        			$('#footer-info').html(html);
        			
        			var code ='';
        			var childCode = SERVER_PATH_Resources + '/img/code-child.png';
        			var adultCode = SERVER_PATH_Resources + '/img/code-future.png';
        			code += '<div class="content-flex-items"><img src="'+(footer.childCode!=null?footer.childCode:childCode)+'" />';
        			code += '<h5>' + (footer.childCodeTitle!=null?footer.childCodeTitle:'少儿咨询') +'</h5></div>';
        			code += '<div class="content-flex-items"><img src="'+(footer.adultCode!=null?footer.adultCode:adultCode)+'" />';
        			code += '<h5>' + (footer.adultCodeTitle!=null?footer.adultCodeTitle:'艺考咨询') +'</h5></div>';
        			$('#footer-code').html(code);
        		}
        	}
        }
	});
}

//获取 阶段
function getStep(hid){
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/home/getSteps',
        data: {hid:hid},
        async:true,
        success : function(res){
        	if(res.rescode == 100) {
        		var steps = res.data;
				if(steps!=null){
					$.each(steps, function(i, item){
						if(item.isHide==2){
							$('#'+item.typeId).hide();
						} else {
							$('#'+item.typeId).show();
							$('#'+item.typeId+'-info').empty();
							var html = '<div class="content-flex">';
							html += '  <div class="content-flex-items "><div class="stage1">'+ item.step1 + '</div></div>';
							html += '  <div class="content-flex-items "><div class="stage-bottom">'+ item.step2 + '</div></div>';
							html += '  <div class="content-flex-items "><div class="stage2">'+ item.step3 + '</div></div>';
							html += '  <div class="content-flex-items "><div class="stage-bottom">'+ item.step4 + '</div></div>';
							html += '  <div class="content-flex-items "><div class="stage3">'+ item.step5 + '</div></div>';
							html += '  <div class="content-flex-items "><div class="stage-bottom">'+ item.step6 + '</div></div>';
							html += '  <div class="content-thin-items "><div class="stage-end">'+ item.end + '</div></div>';
							html += '</div>';
							$('#'+item.typeId+'-info').html(html);
						}
					});
				}
        	}
        }
	});
}
