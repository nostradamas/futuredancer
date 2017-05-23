
var $currentPageDataTables;
var $currentPageDataSelector = "#currentPageDataTable";
var tableTitle = "学生信息";
var dataTablesDataUrl = SERVER_PATH + '/admin/student/getStudentLists'; //数据url
var $toObjectDetailUrl = SERVER_PATH+'/admin/student/toStudentDetail';//
var $saveObjectDetailUrl = SERVER_PATH + '/admin/student/studentSave';
var $deleteObjectUrl = SERVER_PATH + '/admin/student/studentDelete';
var $objectDetailDialog;
var $toChooseHomeUrl = SERVER_PATH + '/admin/student/toChooseHome';//设置主页
var $saveHomeIdUrl = SERVER_PATH + '/admin/student/saveHomeId';
$(function() {
	var colsBindData = [
        {"data" : "sid"},
        {"data" : "name"},
        {"data" : "brief"},
        {"data" : "detail"},
		{"data" : "img", render:function(data,type,row,meta){
        	var img = '<img src="'+data+'" alt="'+ row.name + '" style="width:100px;"/>';
        	return img;
        }},
        {"data" : "sort"},
        {"data" : "state",render:function(data,type,row,meta){
			var operate = '';

			operate+='<button type="button" class="btn btn-primary btn-sm" onclick="objectEdit(\''+row.sid+'\',\''+$('#homeId').val()+'\')">' +
					'<i class="ace-icon fa fa-align-justify fa-lg white"></i> 编辑' +
				'</button>';
			operate+='&nbsp;<button type="button" class="btn btn-primary btn-sm" onclick="objectDelete(\''+row.sid+'\')">' +
				'<i class="ace-icon fa fa-align-justify fa-lg white"></i> 删除' +
				'</button><br/>';
			operate+='&nbsp;<button type="button" class="btn btn-primary btn-sm mt5" onclick="toChooseHome(\''+row.sid+'\')">' +
				'<i class="ace-icon fa fa-align-justify fa-lg white"></i>选择显示页面' +
				'</button>';
        	return operate;
        }}
    ];
	var colsDefs = [
       {targets:0,visible:false},//第1列隐藏
    ];
	var appendReqParms = {homeId : $('#homeId').val()};
	$currentPageDataTables = createCurrentPageDefaultDataTables($currentPageDataSelector,tableTitle,dataTablesDataUrl,appendReqParms,colsBindData,colsDefs);
	
	$("button[name='dataReload']").click(function(){
		var url = $currentPageDataTables.ajax.url(dataTablesDataUrl+"?reloadRequest=123").load();
	});
	$("#backHome").click(function(){
		window.location.href =  SERVER_PATH + '/admin/pageContent/toPageHomeMain';
	});
	
});


function searchForm(formid) {
	var queryString = $('#'+formid).formSerialize();
	var newurl = dataTablesDataUrl + '?'+queryString;
	$currentPageDataTables.ajax.url(newurl).load();
}

function objectEdit(id){
	$objectDetailDialog = BootstrapDialog.show({
		type : BootstrapDialog.TYPE_PRIMARY,
		size : BootstrapDialog.SIZE_WIDE,
		title: tableTitle,
        message: $('<div></div>').load( $toObjectDetailUrl + '?id='+id + '&homeId='+homeId),
        buttons : [{
	    	   icon: 'fa fa-save',
	    	   label : '保存',
	    	   cssClass : 'btn-primary',
	    	   action : function(dialog){
	    		   saveObjectDetail();
	    	   }
	       },{
	    	   icon: 'fa fa-close',
	    	   label : '取消',
	    	   action : function(dialogRef){
	    		   dialogRef.close();
	    	   }
	       }]
    });
	
}

function saveObjectDetail(){
	if (!myValidator.form()){
		return;
	}
	var img = $('#img').attr('key');
	var saveurl= $saveObjectDetailUrl;
	var $objectDetailForm = $("#objectDetailForm"); //数据表单
	var data = $objectDetailForm.serialize() + '&img='+ img;
	loading();
	$.ajax({
		type : 'POST',
		url : saveurl,
		data : data,
		success : function(data){
			closeLoading();
			if (data.rescode == 100) {
				$currentPageDataTables.ajax.reload();
				$objectDetailDialog.close();
				toast_success(data.msg);
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

function objectDelete(id){
	layer.confirm('是否删除？', {
		icon : 3,
		title : '信息',
		btn: ['确定','关闭'] //按钮
	}, function(){//确定
		deleteSend(id);
	}, function(){//取消
		layer.close('confirm');
	});
}

// 选择所在主页

function toChooseHome(id,homeId){
	$objectDetailDialog = BootstrapDialog.show({
		type : BootstrapDialog.TYPE_PRIMARY,
		size : BootstrapDialog.SIZE_WIDE,
		title: "学生所在主页",
        message: $('<div></div>').load( $toChooseHomeUrl + '?id='+id),
        buttons : [{
	    	   icon: 'fa fa-save',
	    	   label : '保存',
	    	   cssClass : 'btn-primary',
	    	   action : function(dialog){
	    		   saveHomeId();
	    	   }
	       },{
	    	   icon: 'fa fa-close',
	    	   label : '取消',
	    	   action : function(dialogRef){
	    		   dialogRef.close();
	    	   }
	       }]
    });
	
}

function saveHomeId(){
	var saveurl= $saveHomeIdUrl;
	var $objectDetailForm = $("#objectStudentForm"); //数据表单
	var data = $objectDetailForm.serialize();
	loading();
	$.ajax({
		type : 'POST',
		url : saveurl,
		data : data,
		success : function(data){
			closeLoading();
			if (data.rescode == 100) {
				$currentPageDataTables.ajax.reload();
				$objectDetailDialog.close();
				toast_success(data.msg);
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





function deleteSend(id) {
	loading();
	$.ajax({
		type : 'POST',
		url : $deleteObjectUrl,
		data : {
			id : id
		},
		success : function(data) {
			closeLoading();
			if (data.rescode == 100) {
				$currentPageDataTables.ajax.reload();
				toast_success(data.msg);
			}else{
				toast_fail(data.msg);
			}
		},
		error : function(resp,bbb,ccc) {
			closeLoading();
			toast_fail('发生错误，请联系管理员！');
		}
	});
}


function showHome(id, atHome){
	var url =  SERVER_PATH + '/admin/student/updateShow';
	loading();
	$.ajax({
		type : 'POST',
		url : url,
		data : {
			sid : id,
			atHome : atHome
		},
		success : function(data){
			closeLoading();
			if (data.rescode == 100) {
				$currentPageDataTables.ajax.reload();
				toast_success(data.msg);
			}else{
				toast_fail(data.msg);
			}
		},error:function(resp,bbb,ccc) {
			closeLoading();
			toast_fail('发生错误，请联系管理员！');
		}
	});
}
