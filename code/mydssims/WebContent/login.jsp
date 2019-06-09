<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta charset="utf-8" content="text/html; charset=utf-8">
		<title>药品存销信息管理系统</title>
		<meta name="description" content="description">
		<meta name="author" content="Evgeniya">
		<meta name="keyword" content="keywords">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="plugins/bootstrap/bootstrap.css" rel="stylesheet">
		<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
		<link href='http://fonts.googleapis.com/css?family=Righteous' rel='stylesheet' type='text/css'>
		<link href="css/style.css" rel="stylesheet">
		<script type="text/javascript" src="plugins/jquery/jquery-2.1.0.min.js"></script>
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
				<script src="http://getbootstrap.com/docs-assets/js/html5shiv.js"></script>
				<script src="http://getbootstrap.com/docs-assets/js/respond.min.js"></script>
		<![endif]-->
	</head>
	<script type="text/javascript">
		
	</script>
<body>
<div class="container-fluid">
	<div id="page-login" class="row">
		<div class="col-xs-12 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
			<div class="text-right" style="margin-top: 150px;">
				<a href="#" class="txt-default">忘记密码</a>&emsp;
				<a href="regist.jsp" class="txt-default">注册账号</a>
			</div>
			<form action="login.form" method="post" class="box-content">
			    <div class="text-center">
			        <h3 class="page-header">用户登录</h3>
			    </div>
			    <div class="form-group">
			        <label class="control-label">用户ID</label>
			        <input type="text" class="form-control" name="id" />
			    </div>
			    <div class="form-group">
			        <label class="control-label">密&emsp;码</label>
			        <input type="password" class="form-control" name="password"/>
			    </div>
			    <div class="form-group">
			        <input type="radio" name="identity" checked value="cus" />客户&emsp;
			        <input type="radio" name="identity" value="adm"> 管理员&emsp;
			        <input type="radio" name="identity" value="sup"> 供应商&emsp;
			    </div>
			    
			    <div class="text-center">
			        <input type="submit" class="btn btn-primary" value="登录" />
			    </div>
			</form>
		</div>
	</div>
</div>
</body>
</html>