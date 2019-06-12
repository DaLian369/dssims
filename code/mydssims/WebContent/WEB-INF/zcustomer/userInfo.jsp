<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="col-xs-12 col-sm-6" style="border:1px solid;" >
<form role="form">
	<div class="form-group">
		<label for="datetime_example" class="col-sm-4 control-label">姓名</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="name"  value=${cus.name }>
		</div>
	</div>
	<div class="form-group">
		<label for="datetime_example" class="col-sm-4 control-label">电话</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="phone"  value=${cus.phone }>
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
	$(function(){
		var nameValue = $("#name").val();
		var phoneValue = $("#phone").val();
		$("#sure").click(function(){
			var name = $("#name").val();
			var phone = $("#phone").val();
			if(nameValue==name && phoneValue==phone){
				alert("请至少修改一项!");
			}else{
				$("#ajax-content").load("zcustomer/updateInfo.form",{name:name,phone:phone});
			}
		});
	});
	
</script>

				