
var $currentPageDataTables;
var $currentPageDataSelector = "#currentPageDataTable";
var tableTitle = "新闻信息";
var dataTablesDataUrl = SERVER_PATH + '/admin/news/getLists'; //数据url
var $toObjectDetailUrl = SERVER_PATH+'/admin/news/toObjectDetail';//
var $saveObjectDetailUrl = SERVER_PATH + '/admin/news/objectSave';
var $deleteObjectUrl = SERVER_PATH + '/admin/news/objectDelete';
var $objectDetailDialog;


$(function() {
	getCateList();
	var colsBindData = [
        {"data" : "nid"},
        {"data" : "title"},
        {"data" : "createTime",render:function (data,type,row,meta) {
			var aa = formatDate(data);
			return aa;
		}},
		{"data" : "img", render:function(data,type,row,meta){
        	var img = '<img src="'+data+'" alt="'+ row.title + '" style="width:100px;"/>';
        	return img;
        }},
        {"data" : "brief"},
        {"data" : "category", render:function(data,type,row,meta){
        	var cate = data != null ? data.name : '未分类';
        	return cate;
        }},
        {"data" : "sort"},
        {"data" : "isTop", render:function(data,type,row,meta){
        	var top = data==2 ? '置顶' : '未置顶';
        	return top;
        }},
        {"data" : "state",render:function(data,type,row,meta){
			var operate = '';

			operate+='<button type="button" class="btn btn-primary btn-sm" onclick="objectEdit(\''+row.nid+'\')">' +
					'<i class="ace-icon fa fa-align-justify fa-lg white"></i> 编辑' +
				'</button>';
			operate+='&nbsp;<button type="button" class="btn btn-primary btn-sm" onclick="objectDelete(\''+row.nid+'\')">' +
				'<i class="ace-icon fa fa-align-justify fa-lg white"></i> 删除' +
				'</button>';
			if(row.isTop==2){
				operate+='&nbsp;<button type="button" class="btn btn-primary btn-sm" onclick="topNews(\''+row.nid+'\',1)">' +
				'<i class="ace-icon fa fa-align-justify fa-lg white"></i>取消置顶' +
				'</button>';
			} else {
				operate+='&nbsp;<button type="button" class="btn btn-primary btn-sm" onclick="topNews(\''+row.nid+'\',2)">' +
				'<i class="ace-icon fa fa-align-justify fa-lg white"></i> 置顶' +
				'</button>';
			}
			
        	return operate;
        }}
    ];
	var colsDefs = [
       {targets:0,visible:false},//第1列隐藏
    ];
	var appendReqParms = {};
	$currentPageDataTables = createCurrentPageDefaultDataTables($currentPageDataSelector,tableTitle,dataTablesDataUrl,appendReqParms,colsBindData,colsDefs);
	
	$("button[name='dataReload']").click(function(){
		var url = $currentPageDataTables.ajax.url(dataTablesDataUrl+"?reloadRequest=123").load();
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
	var img = $('#imgUrl').attr('key');
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


function getCateList(){
	loading();
	$.ajax({
		type : 'POST',
		url : SERVER_PATH + '/admin/news/getCateLists',
		success : function(data) {
			closeLoading();
			if (data.rescode == 100) {
				var cates = data.data;
				if(cates!= null) {
					var li = '<option></option>';
					$.each(cates, function(i, item){
						li += '<option value="'+item.cid+'">' + item.name + '</option>'
					});
					$('#catelist').empty();
					$('#catelist').html(li);
				}
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

function topNews(id, isTop){
	var saveurl =  SERVER_PATH + '/admin/news/updateTop';
	loading();
	$.ajax({
		type : 'POST',
		url : saveurl,
		data : {
			nid : id,
			isTop : isTop
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
