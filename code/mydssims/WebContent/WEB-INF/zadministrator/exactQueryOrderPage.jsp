<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="form-group">
	<label for="datetime_example" class="col-sm-4 control-label">订单id</label>
	<div class="col-sm-8">
		<input type="text" class="form-control" id="oid">
	</div>
</div>
<div class="form-group">
	<label for="datetime_example" class="col-sm-4 control-label">客户id</label>
	<div class="col-sm-8">
		<input type="text" class="form-control" id="cid">
	</div>
</div>
<div class="form-group">
	<div class="col-sm-offset-4 col-sm-8">
		<button type="button" class="btn btn-primary" id="sureQuery">
		<span><i class="fa fa-clock-o"></i></span>确定
		</button>
		<button type="button" class="btn btn-primary" id="clear">
		<span><i class="fa fa-clock-o"></i></span>清空
		</button>
	</div>
</div>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-content no-padding">
				<table class="table table-bordered table-striped table-hover table-heading table-datatable" id="datatable-1">
					<thead align="center">
						<tr><td>序号</td><td>订单号</td><td>客户</td><td>药品</td><td>供应商</td><td>数量</td><td>总价</td><td>日期</td><td>状态</td></tr>
					</thead>
					<tbody id=orderInfo align="center">
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<script>
$(function(){
	/**
	 * 查询药品按钮事件
	 */
	$("#sureQuery").click(function(){
		var url;
		var data;
		var oid = $("#oid").val();
		var cid = $("#cid").val();
		url = "zadministrator/exactQueryOrder.form";
		data = {oid:oid,cid:cid};
		$.ajax({
			type:"post",
			url:url,
			data:data,
			success:function(jsonObj){
				$("#orderInfo").text("");
				var orders = jsonObj.orders;
				var str;
				for(var i = 0;i<orders.length;i++){
					if(orders[i].state==1){
						str = "已付款";
					}else{
						str = "待付款";
					}
					var orderRow = $("<tr><td>"+(i+1)+"</td><td>"+
							orders[i].id+"</td><td>"+
							orders[i].cid+"</td><td>"+
							orders[i].mid+"</td><td>"+
							orders[i].sid+"</td><td>"+
							orders[i].qty+"</td><td>"+
							orders[i].dollars+"</td><td>"+
							orders[i].transactionDate+"</td><td>"+
							str+"</td></tr>");
					$("#orderInfo").append(orderRow);
				}
			}
		});
	});

	/**
	 * 清空药品查询输入框里的内容
	 */
	$("#clear").click(function(){
		$("#oid").val("");
		$("#cid").val("");
		$("#orderInfo").text("");
	});
		
		
});

</script>