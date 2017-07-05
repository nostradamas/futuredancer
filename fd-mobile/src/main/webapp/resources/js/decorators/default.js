function onClickMenu(link) {
	var $cur = $(link);
	var menuHref = $cur.attr('href');
	if (menuHref.length > 1 && menuHref.substring(menuHref.length - 1) == '/') {
		menuHref = menuHref.substring(0, menuHref.length - 1);
	}
	
	$.cookie('currentMenuUrl', menuHref, {
		expires : 7,
		path : SERVER_PATH
	});
}
$(function() {

	var menuHref = $.cookie('currentMenuUrl');
	if (!menuHref || menuHref == '')
		menuHref = location.pathname + location.search;
	if (menuHref.length > 1 && menuHref.substring(menuHref.length - 1) == '/')
		menuHref = menuHref.substring(0, menuHref.length - 1);

	var curpath = window.location.pathname;
	if (curpath.length > 1 && curpath.substring(curpath.length - 1) == '/')
		curpath = curpath.substring(0, curpath.length - 1);
	
	$('.sidebar-menu a').each(function() {
		var thisHref = $(this).attr('href');
		if (thisHref.length > 1 && thisHref.substring(thisHref.length - 1) == '/')
			thisHref = thisHref.substring(0, thisHref.length - 1);

		if (thisHref == curpath) { //menuHref
			var $parent = $(this).parent();
			$parent.addClass('active');

			$('#navMenuName').html($parent.text());
			var subNav = '<li><a href="'+menuHref+'">'+$parent.text()+'</a></li>';
			if ($parent.parent().hasClass('treeview-menu')) {
				var $topmenu = $parent.parent().parent();
				$topmenu.addClass('active');
				$('#navMenuName').html($topmenu.find('.menu-text').text());
				var subNav1 = '<li><a href="'+menuHref+'">'+$topmenu.find('.menu-text').text()+'</a></li>' + subNav;
				subNav = subNav1;
			}
			$('.breadcrumb').html(subNav);

			return false;
		}

	});
	
	
});

/**
 * 搜索方法
 * @param div
 * @returns {Boolean}
 */
function showMoreSearch(div){
	$div = $('#'+div);
	if($('#btnMoreSearch').hasClass('fa-angle-double-down')){
		$("#btnMoreSearch").removeClass('fa-angle-double-down').addClass('fa-angle-double-up');
		$div.show();
	}else{
		$("#btnMoreSearch").removeClass('fa-angle-double-up').addClass('fa-angle-double-down');
		$div.hide();
	}
	return false;
}



/**
 * datatables 初始化
 * @param dataTables_selector 表格的选择器
 * @param tableTitle 表格标题
 * @param dataTablesDataUrl 请求数据url
 * @param appendReqParms 追加请求参数
 * @param colsBindData 列绑定数据源
 * @param colsDefs 列定义
 * @returns
 */
function createCurrentPageDefaultDataTables(dataTables_selector,tableTitle,dataTablesDataUrl,appendReqParms,colsBindData,colsDefs){
	var currentTable = $(dataTables_selector).DataTable({
		language : {
			"sProcessing" : "处理中...",
			"sLengthMenu" : "显示 _MENU_ 项结果",
			"sZeroRecords" : "没有匹配结果",
			"sInfo" : "第 _START_ 至 _END_ 项，共 _TOTAL_ 项",
			"sInfoEmpty" : "显示第 0 至 0 项结果，共 0 项",
			"sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
			"sInfoPostFix" : "",
			"sSearch" : "搜索:",
			"sUrl" : "",
			"sEmptyTable" : "表中数据为空",
			"sLoadingRecords" : "载入中...",
			"sInfoThousands" : ",",
			"oPaginate" : {
				"sFirst" : "首页",
				"sPrevious" : "上页",
				"sNext" : "下页",
				"sLast" : "末页"
			},
			"oAria" : {
				"sSortAscending" : ": 以升序排列此列",
				"sSortDescending" : ": 以降序排列此列"
			}
		},
        processing : true, //加载提示
        serverSide : true, //设置 serverSide 服务器模式 启用服务器端分页
        bFilter : false, //去掉搜索框
        stripeClasses : ["odd", "even"],//为奇偶行加上样式，兼容不支持CSS伪类的场合
        sScrollCollapse : true,
        sScrollX : true, //开启水平滚动条
        ordering : false,//禁用排序
        stateSaveCallback : true,//保存状态
        stateLoadCallback : true
        ,ajax : {
        	type: "POST",
        	url : dataTablesDataUrl,
        	cache : false,  //禁用缓存
        	data : appendReqParms,
        	dataSrc : function(data){
        		return data.data;
        	}
        }
        //绑定数据源
        ,columns : colsBindData
        /* ,"createdRow": function ( row, data, index ) {//创建行回调
        	//row 在table中的行
        	// data 是返回数组中的object
        	// index 当前行的索引 开始的地方是 0
            $('td', row).eq(2).css('font-weight',"bold").css("color","red");
        } */
        //指定每一列作处理、渲染
        ,columnDefs : colsDefs
        //自定义table布局
        ,"dom": "<'row'<'col-md-6'><'col-md-6'>>" 
        	+"t" +
        "<'row'<'col-md-3'i><'#dataTablesSetPageSize.col-md-3' and l><'col-md-6 text-right'p>>"
        
	});
	
	//选择行
	$(dataTables_selector+' tbody').on('click','tr',function(){
        	$(this).toggleClass('selected');
    });
    $("button[name='dataselected']").click(function () {
        alert( currentTable.rows('.selected').data().length +' row(s) selected' );
    });

	return currentTable;
}
//'activityDetail' 元素id
function initUEditer(selectEdEm) {
	UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
	UE.Editor.prototype.getActionUrl=function (action) {
		//这里很重要，很重要，很重要，要和配置中的imageActionName值一样
		if (action=='uploadimage'){
			//这里调用后端我们写的图片上传接口
			console.log("action:"+action);
			return SERVER_PATH+'/file/uploadUEImg?imgPerfix=';
		}else if(action == 'uploadvideo'){
			return '';
		}else{
			return this._bkGetActionUrl.call(this,action);
		}
	};

	var uediter =  UE.getEditor(selectEdEm,{
		toolbars:[[
			'fullscreen', 'source', '|', 'undo', 'redo', '|',
			'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|',
			'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
			'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
			'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|','simpleupload','imagenone', 'imageleft', 'imageright', 'imagecenter','insertimage', 'scrawl', '|',
			'directionalityltr', 'directionalityrtl', 'indent', '|',
			'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
			'link', 'unlink', 'anchor', '|',
			'emotion','attachment', 'insertframe','pagebreak', '|',
			'horizontal', 'date', 'time', 'spechars', 'snapscreen', '|',
			'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', 'charts', '|',
			'print', 'preview', 'searchreplace', 'drafts'
		]],
		autoHeight:false,
		initialFrameWidth:500, //初始化编辑器宽度，默认1000
		zIndex:1400,//编辑器在页面上的z-index层级的基数，默认是900
		maximumWords:20000//允许的最大字符数 [默认值：10000]
	});

	return uediter;
}

/**
*
* @param imageName 自定义的图片名称
* @param uploadBrowseBtnParent 上传按钮的 父元素id
* @param uploadBrowseBtn 上传按钮的id
* @param $collbackViewImage 单张图片 回显id
* @param uploadToken 上传uploadToken
* @param qiniuDomain 七牛外链域名
* @param singleMult 添加的是单文件还是多文件，1单图片，2是多图片
* @param $activityPictUl 多图片承载的父id
*/
function qiniuuploadimage(imageName,uploadBrowseBtnParent,uploadBrowseBtn,$collbackViewImage,uploadToken,qiniuDomain,wh) {
	var loadingIndex;

	var uploader = Qiniu.uploader({
		runtimes: 'html5,flash,html4',      // 上传模式，依次退化
		browse_button: uploadBrowseBtn,         // 上传选择的点选按钮，必需
		// 在初始化时，uptoken，uptoken_url，uptoken_func三个参数中必须有一个被设置
		// 切如果提供了多个，其优先级为uptoken > uptoken_url > uptoken_func
		// 其中uptoken是直接提供上传凭证，uptoken_url是提供了获取上传凭证的地址，如果需要定制获取uptoken的过程则可以设置uptoken_func
		uptoken: uploadToken, // uptoken是上传凭证，由其他程序生成
		//uptoken_url: '/token',         // Ajax请求uptoken的Url，强烈建议设置（服务端提供）
		// uptoken_func: function(file){    // 在需要获取uptoken时，该方法会被调用
		//    // do something
		//    return uptoken;
		// },
		get_new_uptoken: false,             // 设置上传文件的时候是否每次都重新获取新的uptoken
		// downtoken_url: '/downtoken',
		// Ajax请求downToken的Url，私有空间时使用，JS-SDK将向该地址POST文件的key和domain，服务端返回的JSON必须包含url字段，url值为该文件的下载地址
		unique_names: false,              // 默认false，key为文件名。若开启该选项，JS-SDK会为每个文件自动生成key（文件名）
		save_key: false,                  // 默认false。若在服务端生成uptoken的上传策略中指定了sava_key，则开启，SDK在前端将不对key进行任何处理
		domain: qiniuDomain,     // bucket域名，下载资源时用到，必需
		container: uploadBrowseBtnParent,             // 上传区域DOM ID，默认是browser_button的父元素
		max_file_size: '20mb',             // 最大文件体积限制
		flash_swf_url: '/plupload/Moxie.swf',  //引入flash，相对路径 不知道有用没用
		max_retries: 3,                     // 上传失败最大重试次数
		dragdrop: false,                     // 开启可拖曳上传
		drop_element: uploadBrowseBtnParent,          // 拖曳上传区域元素的ID，拖曳文件或文件夹后可触发上传
		chunk_size: '4mb',                  // 分块上传时，每块的体积
		auto_start: true,                   // 选择文件后自动上传，若关闭需要自己绑定事件触发上传
		//x_vars : {
		//    查看自定义变量
		//    'time' : function(up,file) {
		//        var time = (new Date()).getTime();
		// do something with 'time'
		//        return time;
		//    },
		//    'size' : function(up,file) {
		//        var size = file.size;
		// do something with 'size'
		//        return size;
		//    }
		//},
		init: {
			'FilesAdded': function (up, files) {
				plupload.each(files, function (file) {
					// 文件添加进队列后，处理相关的事情
				});
			},
			'BeforeUpload': function (up, file) {
				// 每个文件上传前，处理相关的事情
				loadingIndex= loading();
			},
			'UploadProgress': function (up, file) {
				// 每个文件上传时，处理相关的事情
			},
			'FileUploaded': function (up, file, info) {
				// 每个文件上传成功后，处理相关的事情
				// 其中info是文件上传成功后，服务端返回的json，形式如：
				// {
				//    "hash": "Fh8xVqod2MQ1mocfI4S4KpRL6D98",
				//    "key": "gogopher.jpg"
				//  }
				var domain = up.getOption('domain');
				var res = eval('(' + info + ')');
				var sourceLink = "http://" + qiniuDomain + res.key+wh; //获取上传成功后的文件的Url
				$collbackViewImage.removeClass('hide');
				$collbackViewImage.find('img').attr({height: 150, "width": 300, src: sourceLink, key: sourceLink});

				closeLoading(loadingIndex);
			},
			'Error': function (up, err, errTip) { //上传出错时，处理相关的事情
				closeLoading(loadingIndex);
			},
			'UploadComplete': function () {//队列文件处理完毕后，处理相关的事情
				closeLoading(loadingIndex);
			},
			'Key': function (up, file) {
				// 若想在前端对每个文件的key进行个性化处理，可以配置该函数
				// 该配置必须要在unique_names: false，save_key: false时才生效
				var key = new Date().getTime() + Math.floor(Math.random() * 1000);
				return key;
			}
		}
	});
}



