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
	<label for="datetime_example" class="col-sm-4 control-label">供应商id</label>
	<div class="col-sm-8">
		<input type="text" class="form-control" id="sid">
	</div>
</div>
<div class="form-group">
	<label for="datetime_example" class="col-sm-4 control-label">模糊查询</label>
	<div class="col-sm-8">
		<input type="text" class="form-control" id="msg">
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
						<tr><td>序号</td><td>管理员</td><td>药品名称</td><td>供应商</td><td>单价</td><td>药品描述</td><td>下单</td></tr>
					</thead>
					<tbody id="medInfo" align="center">
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<script>
/**
 * 查询药品按钮事件
 */
$("#sureQuery").click(function(){
	var url;
	var data;
	if($("#msg").val()==""){
		var mid = $("#mid").val();
		var aid = $("#aid").val();
		var sid = $("#sid").val();
		url = "zcustomer/queryMedicineByThreeId.form";
		data = {mid:mid,aid:aid,sid:sid};
	}else{
		var msg = $("#msg").val();
		url = "zcustomer/fuzzyQuery.form";
		data = {msg:msg};
	}
	$.ajax({
		type:"post",
		url:url,
		data:data,
		success:function(jsonObj){
			$("#medInfo").text("");
			var invs = jsonObj.invs;
			for(var i = 0;i<invs.length;i++){
				var invRow = $("<tr><td>"+(i+1)+"</td><td>"+
						invs[i].adm.name+"</td><td>"+
						invs[i].med.name+"</td><td>"+
						invs[i].sup.name+"</td><td>"+
						invs[i].med.price+"</td><td>"+
						invs[i].med.type+"</td><td>"+
						"<button type='button' name='addOrder'value="+i+">购买</button></td></tr>");
				$("#medInfo").append(invRow);
			}
			//重要，下订单
			$("button[name='addOrder']").click(function(){
				var num = $(this).val();
				var aid = invs[num].adm.id;
				var sid = invs[num].sup.id;
				var mid = invs[num].med.id;
				var price = invs[num].med.price;
				$("#ajax-content").load("zcustomer/order.form",{aid:aid,sid:sid,mid:mid,price:price});
			});
		}
	});
});

/**
 * 清空药品查询输入框里的内容
 */
$("#clear").click(function(){
	$("#mid").val("");
	$("#aid").val("");
	$("#sid").val("");
	$("#msg").val("");
	$("#medInfo").text("");
});
	
	
</script>