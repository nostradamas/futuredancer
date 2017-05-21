var isMobile = {
	Android : function() {
		return navigator.userAgent.match(/Android/i);
	},
	BlackBerry : function() {
		return navigator.userAgent.match(/BlackBerry/i);
	},
	iOS : function() {
		return navigator.userAgent.match(/iPhone|iPad|iPod/i);
	},
	Opera : function() {
		return navigator.userAgent.match(/Opera Mini/i);
	},
	Windows : function() {
		return navigator.userAgent.match(/IEMobile/i);
	},
	any : function() {
		return (isMobile.Android() || isMobile.BlackBerry() || isMobile.iOS()
				|| isMobile.Opera() || isMobile.Windows());
	}
};
var fullHeight = function(sub) {

	if (!isMobile.any()) {
		var height = $(window).height() - $('.index-header').height();
		height = sub ? height - 100 : height;
		$('.js-fullheight').css('height', height);
		$(window).resize(function() {
			$('.js-fullheight').css('height', height);
		});
	}

};
var sliderMain = function(sub) {
	var height = $(window).height();
	height = sub ? height - 100 : height;
	$('#banner .flexslider').flexslider({
		animation : "fade",
		slideshowSpeed : 5000,
		directionNav : true,
		pauseOnHover : true,
		start : function() {
			setTimeout(function() {
				$('.slider-text').removeClass('animated fadeInUp');
				$('.flex-active-slide').find('.slider-text').addClass(
						'animated fadeInUp');
			}, 500);
		},
		before : function() {
			setTimeout(function() {
				$('.slider-text').removeClass('animated fadeInUp');
				$('.flex-active-slide').find('.slider-text').addClass(
						'animated fadeInUp');
			}, 500);
		}

	});
	$('.flex-control-nav li').find('a').hover(function(){
		$(this).click();
	});
	$('#banner .flexslider .slides > li').css('height', height);
	$(window).resize(function() {
		$('#banner .flexslider .slides > li').css('height', height);
	});

};