var $saveObjectDetailUrl = SERVER_PATH + '/admin/footer/FooterSave';

$(function() {
	$("#submitBtn").click(function(){
		saveObjectDetail();
	});
	
});


function saveObjectDetail(){
	if (!myValidator.form()){
		return;
	}
	var childCode = $('#childCode').attr('key');
	var adultCode = $('#adultCode').attr('key');
	var saveurl= $saveObjectDetailUrl;
	var $objectDetailForm = $("#objectDetailForm"); //数据表单
	var data = $objectDetailForm.serialize() + '&adultCode='+ adultCode + '&childCode='+childCode;
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

