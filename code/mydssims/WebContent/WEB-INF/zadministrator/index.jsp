<%@ page language="java" import="cn.dlian.entities.*,java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta http-equiv="Context-Type" content="text/html; charset=utf-8">
		<title>药品存销信息管理系统</title>
		<meta name="description" content="description">
		<meta name="author" content="薛磊">
		<meta name="keyword" content="keywords">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="plugins/bootstrap/bootstrap.css" rel="stylesheet">
		<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
		<link href='http://fonts.googleapis.com/css?family=Righteous' rel='stylesheet' type='text/css'>
		<link href="css/style.css" rel="stylesheet">
		<link href="plugins/jquery-ui/jquery-ui.min.css" rel="stylesheet">
		<link href="plugins/fancybox/jquery.fancybox.css" rel="stylesheet">
		<link href="plugins/fullcalendar/fullcalendar.css" rel="stylesheet">
		<link href="plugins/xcharts/xcharts.min.css" rel="stylesheet">
		<link href="plugins/select2/select2.css" rel="stylesheet">
	</head>
<body>
	<header class="navbar">
	<div class="container-fluid expanded-panel">
		<div class="row">
			<div id="logo" class="col-xs-12 col-sm-2">
				<a href="index.jsp">管理员界面</a>
			</div>
			<div id="top-panel" class="col-xs-12 col-sm-10">
				<div class="row">
					<div class="col-xs-8 col-sm-4">
						<a href="#" class="show-sidebar">
						  <i class="fa fa-bars"></i>
						</a>
						<div id="search">
							<input type="text" placeholder="search"/>
							<i class="fa fa-search"></i>
						</div>
					</div>
					<div class="col-xs-4 col-sm-8 top-panel-right">
						<ul class="nav navbar-nav pull-right panel-menu">
							<li class="dropdown">
								<a href="#" class="dropdown-toggle account" data-toggle="dropdown">
									<div class="avatar">
									</div>
									<i class="fa fa-angle-down pull-right"></i>
									<div class="user-mini pull-right">
										<span class="welcome">欢迎您,</span>
										<span id="username"></span>
									</div>
								</a>
								<ul class="dropdown-menu">
									<li>
										<a href="javascript:void(0)" id="userInfo">
											<i class="fa fa-cog"></i>
											<span class="hidden-sm text">个人信息</span>
										</a>
									</li>
									<li>
										<a href="javascript:void(0)" id="updatePass">
											<i class="fa fa-cog"></i>
											<span class="hidden-sm text">修改密码</span>
										</a>
									</li>
									<li>
										<a href="index.form">
											<i class="fa fa-power-off" id="logout"></i>
											<span class="hidden-sm text">退出登录</span>
										</a>
									</li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>
<!--End Header-->
<!--Start Container-->
<div id="main" class="container-fluid">
	<div class="row">
		<div id="sidebar-left" class="col-xs-2 col-sm-2">
			<ul class="nav main-menu">
				<li></li>
				<li>
					<a href="javascript:void(0)" id="headPage">
						<i class="fa fa-calendar"></i>
						<span class="hidden-xs">首页</span>
					</a>
				</li>
				
				<li>
					<a href="javascript:void(0)" id="buyMedicine  ">
						<i class="fa fa-calendar"></i>
						<span class="hidden-xs">采购药品</span>
					</a>
				</li>
				
				<li class="dropdown">
					<a href="javascript:void(0)" class="dropdown-toggle">
						<i class="fa fa-pencil-square-o"></i>
						 <span class="hidden-xs">库存</span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="javascript:void(0)" id="querySellOutInventory">将要售罄</a></li>
						<li><a href="javascript:void(0)" id="queryAllInventory">所有库存</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="javascript:void(0)" class="dropdown-toggle">
						<i class="fa fa-pencil-square-o"></i>
						 <span class="hidden-xs">药品管理</span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="javascript:void(0)" id="addInventory">发布药品</a></li>
						<li><a href="javascript:void(0)" id="updateInventory">更新药品</a></li>
					</ul>
				</li>
				
				<li>
					<a href="javascript:void(0)" id="buyMedicinePage">
						<i class="fa fa-calendar"></i>
						<span class="hidden-xs">采购药品</span>
					</a>
				</li>
				<li class="dropdown">
					<a href="javascript:void(0)" class="dropdown-toggle">
						<i class="fa fa-pencil-square-o"></i>
						 <span class="hidden-xs">订单查询</span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="javascript:void(0)" id="queryWaitOrder">待付款</a></li>
						<li><a href="javascript:void(0)" id="queryPaidOrder">已付款</a></li>
						<li><a href="javascript:void(0)" id="queryAccuratePaidOrder">精确查询</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="javascript:void(0)" class="dropdown-toggle">
						<i class="fa fa-pencil-square-o"></i>
						 <span class="hidden-xs">采购单查询</span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="javascript:void(0)" id="queryWaitPurchases">待付款</a></li>
						<li><a href="javascript:void(0)" id="queryPaidPurchases">已付款</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<!--Start Content-->
		<div id="content" class="col-xs-12 col-sm-10">
			<div class="preloader">
			</div>
			<div id="ajax-content"></div>
		</div>
		<!--End Content-->
	</div>
</div>
<script src="plugins/jquery/jquery-2.1.0.min.js"></script>
<script src="plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="plugins/bootstrap/bootstrap.min.js"></script>
<script src="plugins/justified-gallery/jquery.justifiedgallery.min.js"></script>
<script src="plugins/tinymce/tinymce.min.js"></script>
<script src="plugins/tinymce/jquery.tinymce.min.js"></script>
<!-- All functions for this theme + document.ready processing -->
<script src="js/devoops.js"></script>
<script src="js/administrator.js"></script>
</body>
</html>

