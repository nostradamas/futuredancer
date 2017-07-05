<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>AdminLTE 2 | Registration Page</title>
  <%@ include file="/WEB-INF/pages/common/globa.jsp"%>
  
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="${SERVER_PATH_resources}/assets/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet"
	href="${SERVER_PATH_resources}/assets/font/css/font-awesome.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${SERVER_PATH_resources}/assets/dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${SERVER_PATH_resources}/assets/plugins/iCheck/square/blue.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href=""><b>信息服务中心</b>用户注册</a>
  </div>

  <div class="register-box-body">
    <p class="login-box-msg">注册一个新的用户</p>

    <form method="post">
      <div class="form-group has-feedback">
        <input type="text" name="userName" class="form-control" placeholder="姓名">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="email" name="userEmail" class="form-control" placeholder="邮箱">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="text" name="phoneNum" class="form-control" placeholder="手机号">
        <span class="glyphicon glyphicon-phone form-control-feedback"></span>
      </div>
      
      <!-- <div class="form-group has-feedback">
        <input type="text" name="vcode" class="form-control" placeholder="手机验证码">
        <span class="glyphicon glyphicon-tag form-control-feedback"></span>
      </div> -->
      
      <div class="form-group has-feedback">
        <input type="password" name="password" class="form-control" placeholder="密码">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" name="confirmPassword" class="form-control" placeholder="密码确认">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8"></div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="button" name="registerBtn" class="btn btn-primary btn-block btn-flat">注册</button>
        </div>
        <!-- /.col -->
      </div>
    </form>
    <a href="${SERVER_PATH}/admin/user/toLogin" class="text-center">我已经有账户，去登录</a>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 2.2.3 -->
<script src="${SERVER_PATH_resources}/assets/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="${SERVER_PATH_resources}/assets/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="${SERVER_PATH_resources}/assets/plugins/iCheck/icheck.min.js"></script>

<script src="${SERVER_PATH_resources}/assets/plugins/layer-v2.4/layer.js"></script>
<link rel="stylesheet" href="${SERVER_PATH_resources }/assets/plugins/layer-v2.4/skin/layer.css" />
<script src="${SERVER_PATH_resources}/js/utils.js"></script>
<script src="${SERVER_PATH_resources}/js/api_url.js"></script>

<script type="text/javascript">
	$(function() {
		$("button[type='button'][name='registerBtn']").click(
				
			function() {
				loading();
				var userName = $("input[name='userName']").val();
				var userEmail = $("input[name='userEmail']").val();
				var phoneNum = $("input[name='phoneNum']").val();
				var vcode = $("input[name='vcode']").val();
				var password = $("input[name='password']").val();
				var confirmPassword = $("input[name='confirmPassword']").val();
				
				$.ajax({
					type : 'POST',
					url : $url_user_register,
					data : {
						userName : userName,
						userEmail : userEmail,
						password : password,
						confirmPassword : confirmPassword,
						phoneNum : phoneNum,
						vcode : vcode,
					},
					success : function(data) {
						closeLoading();
						console.log(data);
						if (data.rescode == 100) {
							toast_success(data.msg);
							window.location.href = SERVER_PATH + "/home/index";
						} else {
							toast_fail(data.msg);
						}
					},
					error : function(data) {
						closeLoadingWithNetError();
					}

				});
			});
		});
	</script>
	
</body>
</html>
