var $objectDetailDialog;
(function () {
  getBanners(2);
}());

function getBanners(code){
	$.ajax({
        type : 'GET',
        url : SERVER_PATH + '/home/getBanners',
        data : {
        	code : code
        },
        async:true,
        success : function(res){
        	if(res.rescode == 100) {
        		var banners = res.data;
        		var src = new Array();
        		for(v in banners){
        			var video = new Object();
        			video.src= banners[v].imgUrl;
        			video.type= 'video/mp4'
        			src.push(video);
        		}
        		var size = res.totalSize;
        		var bv = new Bideo();
        		bv.init({
        		    videoEl: document.querySelector('#background_video'),
        		    container: document.querySelector('body'),
        		    resize: true,
        		    autoplay: true,
        		    src: src,
        		    onLoad: function () {
        		      document.querySelector('#video_cover').style.display = 'none';
        		    }
        		});
        	}
        }
	});
}

