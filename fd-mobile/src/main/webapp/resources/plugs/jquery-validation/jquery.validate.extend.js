$(document).ready(function () {
	
	$.validator.setDefaults({
	    errorClass:"fa fa-times-circle inline error",
		focusInvalid: false,
		onkeyup:  function(element) { 
			if(!$(element).valid()){
				
			};
		},
		wrapper : 'span',
		errorPlacement: function(error, element) {
		    error.appendTo(element.parent());
		}
	});
	/*************插件新功能-设置插件validator的默认参数********/
	/*$.validator.setDefaults({
	    关闭键盘输入时的实时校验
	    onkeyup: null,
	    添加校验成功后的执行函数--修改提示内容，并为正确提示信息添加新的样式(默认是valid)
	    success: function(label){
	        label的默认正确样式为valid，需要通过validClass来重置，否则这里添加的其他样式不能被清除
	        label.text('').addClass('valid');
	    },
	    重写校验元素获得焦点后的执行函数--增加[1.光标移入元素时的帮助提示,2.校验元素的高亮显示]两个功能点
	    onfocusin: function( element ) {
	        this.lastActive = element;
	        
	        1.帮助提示功能
	        this.addWrapper(this.errorsFor(element)).hide();
	        var tip = $(element).attr('tip');
	        if(tip && $(element).parent().children(".tip").length === 0){
	            $(element).parent().append("<label class='tip'>" + tip + "</label>");
	        }
	        
	        2.校验元素的高亮显示
	        $(element).addClass('highlight');

	        // Hide error label and remove error class on focus if enabled
	        if ( this.settings.focusCleanup ) {
	            if ( this.settings.unhighlight ) {
	                this.settings.unhighlight.call( this, element, this.settings.errorClass, this.settings.validClass );
	            }
	            this.hideThese( this.errorsFor( element ) );
	        }
	    },
	    重写校验元素焦点离开时的执行函数--移除[1.添加的帮助提示,2.校验元素的高亮显示]
	    onfocusout: function( element ) {
	        1.帮助提示信息移除
	        $(element).parent().children(".tip").remove();

	        2.校验元素高亮样式移除
	        $(element).removeClass('highlight');
	        
	        3.替换下面注释的原始代码，任何时候光标离开元素都触发校验功能
	        this.element( element );
	        
	        if ( !this.checkable( element ) && ( element.name in this.submitted || !this.optional( element ) ) ) {
	            this.element( element );
	        }
	    }
	});*/
});

// 中文字两个字节   
jQuery.validator.addMethod("byteRangeLength", function (value, element, param) {
    var length = value.length;
    for (var i = 0; i < value.length; i++) {
        if (value.charCodeAt(i) > 127) {
            length++;
        }
    }
    return this.optional(element) || (length >= param[0] && length <= param[1]);
}, "请确保输入的值在3-15个字节之间(一个中文字算2个字节)");

/* 追加自定义验证方法 */
// 身份证号码验证   
jQuery.validator.addMethod("isIdCardNo", function (value, element) {
    return this.optional(element) || isIdCardNo(value);
}, "请正确输入您的身份证号码");

// 字符验证   
jQuery.validator.addMethod("userName", function (value, element) {
    return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);
}, "用户名只能包括中文字、英文字母、数字和下划线");

// 手机号码验证   
jQuery.validator.addMethod("isMobile", function (value, element) {
    var length = value.length;
    return this.optional(element) || (length == 11 && /^(((1[3,5,7,8][0-9]{1}))+\d{8})$/.test(value));
}, "请正确填写您的手机号码");

// 电话号码验证   
jQuery.validator.addMethod("isPhone", function (value, element) {
    var tel = /^(\d{3,4}-?)?\d{7,9}$/g;
    return this.optional(element) || (tel.test(value));
}, "请正确填写您的电话号码");

// 邮政编码验证   
jQuery.validator.addMethod("isZipCode", function (value, element) {
    var tel = /^[0-9]{6}$/;
    return this.optional(element) || (tel.test(value));
}, "请正确填写您的邮政编码");


// 域名验证   
jQuery.validator.addMethod("isDomain", function (value, element) {
    var isDomail = /^([a-zA-Z0-9]([a-zA-Z0-9\-]{0,61}[a-zA-Z0-9])?\.)+[a-zA-Z]{2,6}$/;
    return this.optional(element) || (isDomail.test(value));
}, "请正确填写域名");

// 资源管理中值的验证
jQuery.validator.addMethod("isResourceValue", function (value, element) {
    var isDomail = /^~\/[a-zA-Z0-9.\/]+$/;
    return this.optional(element) || (isDomail.test(value));
}, "请正确资源值：~/path/file");


// 中英文字符验证   
jQuery.validator.addMethod("custName", function (value, element) {
    return this.optional(element) || /^([\u4E00-\uFA29]*[a-z]*[A-Z]*)+$/.test(value);
},"姓名只能包含中英文");

// 密码验证不能包含中文   
jQuery.validator.addMethod("fpwd", function (value, element) {
    return this.optional(element) || !/^([\u4E00-\uFA29]*)+$/.test(value);
},"请输入正确的密码字符");

// 二次密码验证   
jQuery.validator.addMethod("secPwd", function (value, element,param) {
    return this.optional(element) || $(param).val()==value;
},"两次输入密码不同");

jQuery.validator.addMethod("isDate", function(value, element){
	if(value==null || value=='')return true;
	var ereg = /^(\d{1,4})(-|\/)(\d{1,2})(-|\/)(\d{1,2})$/;
	var r = value.match(ereg);
	if (r == null) {
		return false;
	}
	var d = new Date(r[1], r[3] - 1, r[5]);
	var result = (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[3] && d.getDate() == r[5]);
	return this.optional(element) || (result);
}, "请输入正确的日期");

//wanggang 2014-12-18 16:36:48 数字和英文
jQuery.validator.addMethod("isEngOrDigit", function(value, element){
	return !/[\W]/g.test(value);
}, "请输入正确的内容");
  

//增加身份证验证
function isIdCardNo(num) {
    var factorArr = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1);
    var parityBit = new Array("1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2");
    var varArray = new Array();
    var intValue;
    var lngProduct = 0;
    var intCheckDigit;
    var intStrLen = num.length;
    var idNumber = num;
    // initialize
    if ((intStrLen != 15) && (intStrLen != 18)) {
        return false;
    }
    // check and set value
    for (i = 0; i < intStrLen; i++) {
        varArray[i] = idNumber.charAt(i);
        if ((varArray[i] < '0' || varArray[i] > '9') && (i != 17)) {
            return false;
        } else if (i < 17) {
            varArray[i] = varArray[i] * factorArr[i];
        }
    }

    if (intStrLen == 18) {
        //check date
        var date8 = idNumber.substring(6, 14);
        if (isDate8(date8) == false) {
            return false;
        }
        // calculate the sum of the products
        for (i = 0; i < 17; i++) {
            lngProduct = lngProduct + varArray[i];
        }
        // calculate the check digit
        intCheckDigit = parityBit[lngProduct % 11];
        // check last digit
        if (varArray[17] != intCheckDigit) {
            return false;
        }
    }
    else {        //length is 15
        //check date
        var date6 = idNumber.substring(6, 12);
        if (isDate6(date6) == false) {
            return false;
        }
    }
    return true;
}
function isDate6(sDate) {
    if (!/^[0-9]{6}$/.test(sDate)) {
        return false;
    }
    var year, month, day;
    year = sDate.substring(0, 4);
    month = sDate.substring(4, 6);
    if (year < 1700 || year > 2500) return false
    if (month < 1 || month > 12) return false
    return true
}


function isDate8(sDate) {
    if (!/^[0-9]{8}$/.test(sDate)) {
        return false;
    }
    var year, month, day;
    year = sDate.substring(0, 4);
    month = sDate.substring(4, 6);
    day = sDate.substring(6, 8);
    var iaMonthDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    if (year < 1700 || year > 2500) return false
    if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) iaMonthDays[1] = 29;
    if (month < 1 || month > 12) return false
    if (day < 1 || day > iaMonthDays[month - 1]) return false
    return true
}

//判断日期格式为yyyy-MM-dd
function isDate10(sDate){
	if(sDate.value==null || sDate.value=='')return;
	var ereg = /^(\d{1,4})(-|\/)(\d{1,2})(-|\/)(\d{1,2})$/;
	var r = sDate.value.match(ereg);
	if (r == null) {
		alert("日期格式不对，格式为yyyy-MM-dd");
		sDate.value="";
		return;
	}
	var d = new Date(r[1], r[3] - 1, r[5]);
	var result = (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[3] && d.getDate() == r[5]);
	if(!result){
		alert("日期格式不对，格式为yyyy-MM-dd");
		sDate.value="";
	}
	return result;
}


