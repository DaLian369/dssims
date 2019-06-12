<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <div class="col-xs-12 col-sm-6" style="border:1px solid;" >
<form role="form">
	<div class="form-group">
		<label for="datetime_example" class="col-sm-4 control-label">旧密码</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="oldPass">
		</div>
	</div>
	<div class="form-group">
		<label for="datetime_example" class="col-sm-4 control-label">新密码</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="newPass1">
		</div>
	</div>
	<div class="form-group">
		<label for="datetime_example" class="col-sm-4 control-label">确认密码</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="newPass2">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-4 col-sm-8">
			<button type="button" class="btn btn-primary" id="sure">
			<span><i class="fa fa-clock-o"></i></span>确定
			</button>
		</div>
	</div>
</form>
</div>
<script type="text/javascript">
$("#sure").click(function(){
	var oldPass = $("#oldPass").val();
	var newPass = $("#newPass1").val();
	var newPass2 = $("#newPass2").val();
	if(newPass==newPass2){
		$("#ajax-content").load("zcustomer/updateInfo.form",{oldPass:oldPass,newPass:newPass});
	}else{
		alert("新密码不一致!");
	}
});
</script>