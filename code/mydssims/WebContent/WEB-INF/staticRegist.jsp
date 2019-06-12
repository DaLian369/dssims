<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

