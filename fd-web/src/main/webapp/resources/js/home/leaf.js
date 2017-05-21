$(window).load(function() {
	$('.teacher-expert').hover(function(){
		$(this).find('.teacher-info').toggleClass('teacher-show');
	});
	var hid = $('#homeId').val();
	var parentid = $('#parentId').val();
	// tab导航
	getTabs(false, parentid, true);
	// 菜单页
	getBanners(1);
	// 显示菜单
	getLeafMenus(hid);
	
});

