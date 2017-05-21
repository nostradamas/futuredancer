/** layer loading */
var layer_load_index;
function loading() {
	var index = layer.load(0, {
		shade : false
	});
	layer_load_index = index;
}
function closeLoading() {
	layer.close(layer_load_index);
}
function toast(content) {
	// 提示
	layer.open({
		content : content,
		skin : 'msg',
		time : 1
	// 1秒后自动关闭
	});
}
function toastWithSecond(content, second) {
	// 提示
	layer.open({
		content : content,
		skin : 'msg',
		time : second
	// second秒后自动关闭
	});
}
function toast_success(content){
	layer.msg(content, {
		icon : 1,
		time : 800
	});
}
function toast_fail(content){
	layer.msg(content, {
		icon : 2,
		time : 800
	});
}
function toast_question(content){
	layer.msg(content, {
		icon : 3,
		time : 800
	});
}
function toast_lock(content){
	layer.msg(content, {
		icon : 4,
		time : 800
	});
}
function unhappy(content){
	layer.msg(content, {
		icon : 5,
		time : 800
	});
}
function toast_happy(content){
	layer.msg(content, {
		icon : 6,
		time : 800
	});
}
function toast_waring(content){
	layer.msg(content, {
		icon : 7,
		time : 800
	});
}
function closeLoadingWithNetError() {
	layer.closeAll();
	toast("服务器异常！");
}


function isEmpty(value) {
	if (value == null) {
		return true;
	}
	if (value == undefined) {
		return true;
	}
	if (value == "") {
		return true;
	}
	if (value == '') {
		return true;
	}
	if (trim(value).length == 0) {
		return true;
	}
	return false;
}

function trim(str) { // 删除左右两端的空格
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

// jquery验证手机号码
function checkPhoneNum(phoneNum) {
	if (phoneNum == "") {
		return false;
	}
	if (!phoneNum.match(/^(((13[0-9]{1})|159|153)+\d{8})$/)) {
		return false;
	}
	return true;
}


//日期格式化将时间戳格式化为 yyyy-MM-dd
function formatDate(dateTime) {
	var time = new Date(dateTime);

	var y = time.getFullYear();
	var m = time.getMonth()+1;
	var d = time.getDate();
	var h = time.getHours();
	var mm = time.getMinutes();
	var s = time.getSeconds();

	m = m<10?'0'+m:m;
	d = d<10?'0'+d:d;

	return y+'-'+m+'-'+d; //+' '+add0(h)+':'+add0(mm)+':'+add0(s)
}



