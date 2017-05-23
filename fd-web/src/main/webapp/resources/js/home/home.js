$(window).load(function() {
	var hid = $('#homeId').val();
	var isLeaf = $('#isLeaf').val();
	var parentId = $('#parentId').val();
	// tab导航
	getSubHomeMenus(hid, isLeaf, parentId);
	// 菜单页
	getBanners(1, true);
	getHomeContent(hid);
	getSubNav(hid);
	console.log(hid);
	getTeacherLists(hid, 'teacherId', 1, 30);
	getStudents(1, 8, 'studentlistId', false, hid, 1);
});
