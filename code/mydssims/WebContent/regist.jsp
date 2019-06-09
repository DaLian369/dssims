<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>DevOOPS</title>
		<meta name="description" content="description">
		<meta name="author" content="Evgeniya">
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
		<script type="text/javascript">
			
			$(function(){
				$("#cus").click(function(){
					var pageHeader = $("#pageHeader");
					pageHeader.html("客户注册");
					var city = $("#city");
					city.parent(".form-group").html("");
				});
			
				$("#adm").click(function(){
					var pageHeader = $("#pageHeader");
					pageHeader.html("管理员注册");
					var city = $("#city");
					city.parent(".form-group").html("");
				});
				
				$("#sup").click(function(){
					var pageHeader = $("#pageHeader");
					pageHeader.html("供应商注册");
					var supCity = $("#supCity");
					var text = '<label id="city" class="control-label">城市</label><input type="text" class="form-control" name="city" />'
					supCity.html(text);
				});
			});
			
		</script>
	</head>
<body>
<div class="container-fluid">
	<div id="page-login" class="row">
		<div class="col-xs-12 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
			<div class="text-right">
				
			</div>
			<div class="box">
				<div class="box-content">
					<div class="text-center">
						<h3 id="pageHeader" class="page-header">客户注册</h3>
					</div>
					<form action="regist.form" method="post" class="box-content">
						<div class="form-group">
							<label id="name" class="control-label">姓名</label>
							<input type="text" class="form-control" name="name" />
						</div>
						<div class="form-group">
							<label id="password" class="control-label">密码</label>
							<input type="password" class="form-control" name="password" />
						</div>
						<div class="form-group">
							<label id="phone" class="control-label">电话</label>
							<input type="password" class="form-control" name="phone" />
						</div>
						<div class="form-group" id="supCity">
							
						</div>
						<div class="form-group">
					        <input type="radio" id="cus" name="identity" checked value="cus"  />客户&emsp;
					        <input type="radio" id="adm" name="identity" value="adm"> 管理员&emsp;
					        <input type="radio" id="sup" name="identity" value="sup"> 供应商&emsp;
				    	</div>
						<div class="text-center">
							<input type="submit" value="注册" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
