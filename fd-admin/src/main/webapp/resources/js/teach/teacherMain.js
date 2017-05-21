
var $currentPageDataTables;
var $currentPageDataSelector = "#currentPageDataTable";
var tableTitle = "教师信息";
var dataTablesDataUrl = SERVER_PATH + '/admin/teacher/getTeacherLists'; //数据url
var $toObjectDetailUrl = SERVER_PATH+'/admin/teacher/toTeacherDetail';//
var $saveObjectDetailUrl = SERVER_PATH + '/admin/teacher/teacherSave';
var $deleteObjectUrl = SERVER_PATH + '/admin/teacher/teacherDelete';
var $objectDetailDialog;


$(function() {
	var colsBindData = [
        {"data" : "tid"},
        {"data" : "name"},
        {"data" : "brief"},
        {"data" : "detail"},
		{"data" : "img", render:function(data,type,row,meta){
        	var img = '<img src="'+data+'" alt="'+ row.name + '" style="width:100px;"/>';
        	return img;
        }},
		{"data" : "icon", render:function(data,type,row,meta){
        	var img = '<img src="'+data+'" alt="'+ row.name + '" style="width:100px;"/>';
        	return img;
        }},
        {"data" : "type", render:function(data,type,row,meta){
        	var type = data == 1 ?  '教育专家' : data == 2 ? '金牌教师' : '';
        	return type
        }},
        {"data" : "sort"},
        {"data" : "atHome", render:function(data,type,row,meta){
        	var top = data==1 ? '显示' : '未显示';
        	return top;
        }},
        {"data" : "state",render:function(data,type,row,meta){
			var operate = '';

			operate+='<button type="button" class="btn btn-primary btn-sm" onclick="objectEdit(\''+row.tid+'\',\''+$('#homeId').val()+'\')">' +
					'<i class="ace-icon fa fa-align-justify fa-lg white"></i> 编辑' +
				'</button>';
			operate+='&nbsp;<button type="button" class="btn btn-primary btn-sm" onclick="objectDelete(\''+row.tid+'\')">' +
				'<i class="ace-icon fa fa-align-justify fa-lg white"></i> 删除' +
				'</button><br/>';
			if(row.atHome==1){
				operate+='&nbsp;<button type="button" class="btn btn-primary btn-sm mt5" onclick="showHome(\''+row.tid+'\',2)">' +
				'<i class="ace-icon fa fa-align-justify fa-lg white"></i>取消显示' +
				'</button>';
			} else {
				operate+='&nbsp;<button type="button" class="btn btn-primary btn-sm mt5" onclick="showHome(\''+row.tid+'\',1)">' +
				'<i class="ace-icon fa fa-align-justify fa-lg white"></i>显示在首页' +
				'</button>';
			}
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

function objectEdit(id,homeId){
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
	var logo = $('#icon').attr('key');
	var saveurl= $saveObjectDetailUrl;
	var $objectDetailForm = $("#objectDetailForm"); //数据表单
	var data = $objectDetailForm.serialize() + '&img='+ img + '&icon='+logo;
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
	var url =  SERVER_PATH + '/admin/teacher/updateShow';
	loading();
	$.ajax({
		type : 'POST',
		url : url,
		data : {
			tid : id,
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