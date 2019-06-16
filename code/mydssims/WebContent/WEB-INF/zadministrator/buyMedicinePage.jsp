<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="form-group">
	<label for="datetime_example" class="col-sm-4 control-label">药品id</label>
	<div class="col-sm-8">
		<input type="text" class="form-control" id="mid">
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
			<button type="button" class="btn btn-primary" id="sure">
			<span><i class="fa fa-clock-o"></i></span>确定
			</button>
			<button type="button" class="btn btn-primary" id="clear">
			<span><i class="fa fa-clock-o"></i></span>清空
			</button>
		</div>
	</div>
<table>
	
</table>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-content no-padding">
				<table class="table table-bordered table-striped table-hover table-heading table-datatable" id="datatable-1">
					<thead align="center">
						<tr><td>序号</td><td>药品名称</td><td>供应商</td><td>药品描述</td><td>下单</td></tr>
					</thead>
					<tbody id="medInfo" align="center">
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<script>
	$("#sure").click(function(){
		var url;
		var data;
		if($("#msg").val()==""){
			var mid = $("#mid").val();
			var sid = $("#sid").val();
			url = "zadministrator/queryMedicineByTwoId.form";
			data = {mid:mid,sid:sid};
		}else{
			var msg = $("#msg").val();
			url = "zadministrator/fuzzyQuery.form";
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
							invs[i].med.name+"</td><td>"+
							invs[i].sup.name+"</td><td>"+
							invs[i].med.type+"</td><td>"+
							"<a href='javascript:void(0)'>购买</a></tr>");
					$("#medInfo").append(invRow);
				}
			}
		});
	});
	
	$("#clear").click(function(){
		$("#mid").val("");
		$("#sid").val("");
		$("#msg").val("");
		$("#medInfo").text("");
	});
</script>