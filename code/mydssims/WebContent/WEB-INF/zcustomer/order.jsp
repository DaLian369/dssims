<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="col-xs-12 col-sm-6" style="border:1px solid;" >
<form role="form">
	<div class="form-group">
		<label for="datetime_example" class="col-sm-4 control-label">药品</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="mid"  value=${mid } disabled="disabled">
		</div>
	</div>
	<div class="form-group">
		<label for="datetime_example" class="col-sm-4 control-label">供应商</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="sid"  value=${sid } disabled="disabled">
		</div>
	</div>
	<div class="form-group">
		<label for="datetime_example" class="col-sm-4 control-label">管理员</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="aid"  value=${aid } disabled="disabled">
		</div>
	</div>
	<div class="form-group">
		<label for="datetime_example" class="col-sm-4 control-label">单价</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="price"  value=${price } disabled="disabled">
		</div>
	</div>
	<div class="form-group">
		<label for="datetime_example" class="col-sm-4 control-label">数量</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="count">
		</div>
	</div>
	<div class="form-group">
		<label for="datetime_example" class="col-sm-4 control-label">总价</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="dollars" disabled="disabled">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-4 col-sm-8">
			<button type="button" class="btn btn-primary" id="sureOrder">
			<span><i class="fa fa-clock-o"></i></span>下单
			</button>
		</div>
	</div>
</form>
</div>
<script>
/**
 * 计算总价
 */
$("#count").focusout(function(){
	var count = $("#count").val();
	var price = $("#price").val();
	$("#dollars").val(count*price);
});

/**
 * 下订单
 */
$("#sureOrder").click(function(){
	var mid = $("#mid").val();
	var sid = $("#sid").val();
	var aid = $("#aid").val();
	var qty = $("#count").val();
	var dollars = $("#dollars").val();
	$.ajax({
		type:"post",
		data:{mid:mid,sid:sid,aid:aid,qty:qty,dollars:dollars},
		url:"zcustomer/addOrder.form",
		success:function(msg){
			if(msg=="y"){
				alert("下单成功，请在待付款订单中付款!");
			}else{
				alert("下单失败!");
			}
			window.location.reload();
		}
	});
});
</script>

				