<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="form-group">
	<label for="datetime_example" class="col-sm-4 control-label">药品id</label>
	<div class="col-sm-8">
		<input type="text" class="form-control" id="mid">
	</div>
</div>
<div class="form-group">
	<label for="datetime_example" class="col-sm-4 control-label">管理员id</label>
	<div class="col-sm-8">
		<input type="text" class="form-control" id="aid">
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
						<tr><td>序号</td><td>订单号</td><td>药品</td><td>管理员</td><td>数量</td><td>总价</td><td>日期</td><td>状态</td></tr>
					</thead>
					<tbody id=purInfo align="center">
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
		var mid = $("#mid").val();
		var aid = $("#aid").val();
		url = "zsupplier/queryPurchasesByThreeId.form";
		data = {mid:mid,aid:aid};
		$.ajax({
			type:"post",
			url:url,
			data:data,
			success:function(jsonObj){
				$("#purInfo").text("");
				var purs = jsonObj.purs;
				var str;
				for(var i = 0;i<purs.length;i++){
					if(purs[i].state==1){
						str = "已付款";
					}else{
						str = "待付款";
					}
					var purRow = $("<tr><td>"+(i+1)+"</td><td>"+
							purs[i].id+"</td><td>"+
							purs[i].mid+"</td><td>"+
							purs[i].aid+"</td><td>"+
							purs[i].qty+"</td><td>"+
							purs[i].dollars+"</td><td>"+
							purs[i].transactionDate+"</td><td>"+
							str+"</td></tr>");
					$("#purInfo").append(purRow);
				}
			}
		});
	});

	/**
	 * 清空药品查询输入框里的内容
	 */
	$("#clear").click(function(){
		$("#mid").val("");
		$("#aid").val("");
		$("#purInfo").text("");
	});
		
		
});

</script>