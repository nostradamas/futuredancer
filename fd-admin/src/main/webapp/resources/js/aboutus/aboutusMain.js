var $saveObjectDetailUrl = SERVER_PATH + '/admin/aboutus/aboutusSave';

$(function() {
	$("#submitBtn").click(function(){
		saveObjectDetail();
	});
	
});


function saveObjectDetail(){
	if (!myValidator.form()){
		return;
	}
	var img = $('#modeImg').attr('key');
	var logo = $('#logo').attr('key');
	var saveurl= $saveObjectDetailUrl;
	var $objectDetailForm = $("#objectDetailForm"); //数据表单
	var data = $objectDetailForm.serialize() + '&modeImg='+ img + '&logo='+logo;
	loading();
	$.ajax({
		type : 'POST',
		url : saveurl,
		data : data,
		success : function(data){
			closeLoading();
			if (data.rescode == 100) {
				toast_success(data.msg);
				window.location.reload();
			}else{
				toast_fail(data.msg);
			}
		},error:function(resp,bbb,ccc) {
			closeLoading();
			$objectDetailDialog.close();
			toast_fail('发生错误，请联系管理员！');
		}
	});
}

