
var $currentPageDataTables;
var $currentPageDataSelector = "#currentPageDataTable";
var tableTitle = "内容信息";
var dataTablesDataUrl = SERVER_PATH + '/admin/pageContent/getPageContentLists'; //数据url
var $toObjectDetailUrl = SERVER_PATH+'/admin/pageContent/toPageContentDetail';//
var $saveObjectDetailUrl = SERVER_PATH + '/admin/pageContent/pageContentSave';
var $deleteObjectUrl = SERVER_PATH + '/admin/pageContent/pageContentDelete';
var $objectDetailDialog;


$(function() {
	var targetId = $('#targetId').val();
	var colsBindData = [
        {"data" : "pid"},
        {"data" : "title"},
        {"data" : "subTitle"},
        {"data" : "content"},
        {"data" : "pic", render:function(data,type,row,meta){
        	var pic = (data!=null && data!= '')?'<img src="'+data+'" alt="'+ row.name + '" style="width:100px;"/>':'';
        	return pic;
        }},
        {"data" : "background", render:function(data,type,row,meta){
        	var background = (data!=null && data!= '')? '<img src="'+data+'" alt="背影" style="width:100px;"/>':'';
        	return background;
        }},
        {"data" : "sort"},
        {"data" : "type", render:function(data,type,row,meta){
        	var type = (data!=null && data!= '')? type==1 ? '副标题':'':'';
        	return type;
        }},
        {"data" : "state",render:function(data,type,row,meta){
			var operate = '';

			operate+='<button type="button" class="btn btn-primary btn-sm" onclick="objectEdit(\''+row.pid+'\')">' +
					'<i class="ace-icon fa fa-align-justify fa-lg white"></i> 编辑' +
				'</button>';
			/*operate+='&nbsp;<button type="button" class="btn btn-primary btn-sm" onclick="objectDelete(\''+row.pid+'\')">' +
				'<i class="ace-icon fa fa-align-justify fa-lg white"></i> 删除' +
				'</button>';*/
        	return operate;
        }}
    ];
	var colsDefs = [
       {targets:0,visible:false},//第1列隐藏
    ];
	var appendReqParms = {targetId:targetId};
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
        message: $('<div></div>').load( $toObjectDetailUrl + '?id='+id),
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
	var pic = $('#pic').attr('key');
	var background = $('#background').attr('key');
	var saveurl= $saveObjectDetailUrl;
	var $objectDetailForm = $("#objectDetailForm"); //数据表单
	var data = $objectDetailForm.serialize() + '&pic='+ pic + '&background='+background;
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
