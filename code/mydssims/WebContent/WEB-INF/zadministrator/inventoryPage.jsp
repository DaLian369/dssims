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
	<div class="col-sm-offset-4 col-sm-8">
		<button type="button" class="btn btn-primary" id="sureQuery">
		<span><i class="fa fa-clock-o"></i></span>确定
		</button>
		<button type="button" class="btn btn-primary" id="clear">
		<span><i class="fa fa-clock-o"></i></span>清空
		</button>
	</div>
</div>
<div id="invContent">
</div>
<script>
$(function(){
	$("#invContent").load("zadministrator/inventory.form");
	/**
	 * 查询药品按钮事件
	 */
	$("#sureQuery").click(function(){
		var url;
		var data;
		var mid = $("#mid").val();
		var sid = $("#sid").val();
		url = "zadministrator/queryMedicineByTwoId.form";
		data = {mid:mid,sid:sid};
		$.ajax({
			type:"post",
			url:url,
			data:data,
			success:function(jsonObj){
				$("#invInfo").text("");
				var invs = jsonObj.invs;
				for(var i = 0;i<invs.length;i++){
					var invRow = $("<tr><td>"+(i+1)+"</td><td>"+
							invs[i].med.name+"</td><td>"+
							invs[i].sup.name+"</td><td>"+
							invs[i].count+"</td><td>"+
							"<button class='btn btn-success' type='button' name='addPur'value="+i+">购买</button></td></tr>");
					$("#invInfo").append(invRow);
				}
			}
		});
	});

	/**
	 * 清空药品查询输入框里的内容
	 */
	$("#clear").click(function(){
		$("#mid").val("");
		$("#sid").val("");
		$("#invInfo").text("");
	});
		
		
});

</script>