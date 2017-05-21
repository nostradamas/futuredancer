<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>登录 | 未来舞者网站管理</title>
    <%@ include file="/WEB-INF/pages/common/globa.jsp" %>
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet"
          href="${SERVER_PATH_resources}/assets/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet"
          href="${SERVER_PATH_resources}/assets/font/css/font-awesome.min.css">
    <!-- Theme style -->
    <link rel="stylesheet"
          href="${SERVER_PATH_resources}/assets/dist/css/AdminLTE.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet"
          href="${SERVER_PATH_resources}/assets/dist/css/skins/_all-skins.min.css">
     
	<link rel="stylesheet"  href="${SERVER_PATH_resources }/assets/plugins/layer-v2.4/skin/layer.css"/>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body style="height: auto" class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="#"><b>未来舞者网站管理</b>登录</a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <form method="post">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="账号">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div>
                <button type="button" class="btn btn-primary btn-block btn-flat">登录</button>
            </div>
        </form>
        <div class="social-auth-links">
            <a href="${SERVER_PATH}/admin/user/toRegister" style="float: right">注册新用户</a>
        </div>
        <div style="clear: both"></div>
    </div>
</div>
<!-- /.login-box -->

<!-- jQuery 2.2.0 -->
<script
        src="${SERVER_PATH_resources}/assets/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script
        src="${SERVER_PATH_resources}/assets/bootstrap/js/bootstrap.min.js"></script>

<script
        src="${SERVER_PATH_resources}/assets/plugins/layer-v2.4/layer.js"></script>
<script src="${SERVER_PATH_resources}/js/utils.js"></script>

<script type="text/javascript">
    $(function () {
        $("button[type='button']").click(function () {
            loading();
            var email = $("input[type='text']").val();
            var password = $("input[type='password']").val();
            var loginUrl = SERVER_PATH + '/admin/user/login';
            $.ajax({
                type: 'POST',
                url: loginUrl,
                data: {
                    admin : admin,
                    password: password
                },
                success: function (data) {
                    closeLoading();
                    if (data.rescode == 100) {
                        toast_success(data.msg);
                        window.location.href = SERVER_PATH + "/admin/home/toWelcomeMain";
                    } else {
                        toast_fail(data.msg);
                    }
                },
                error: function (data) {
                    closeLoadingWithNetError();
                }

            });
        });
    });
</script>

</body>
</html>
