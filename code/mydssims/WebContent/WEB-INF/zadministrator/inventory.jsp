<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-content no-padding">
				<table class="table table-bordered table-striped table-hover table-heading table-datatable" id="datatable-1">
					<thead align="center">
						<tr><td>序号</td><td>药品</td><td>供应商</td><td>数量</td><td>下单</td></tr>
					</thead>
					<tbody id="invInfo" align="center">
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<script>
$(function(){
	$.ajax({
		type:"post",
		url:"zadministrator/queryWillSellOut.form",
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
			//重要，下订单
			$("button[name='addPur']").click(function(){
				var num = $(this).val();
				alert(num);
				var sid = invs[num].sup.id;
				var mid = invs[num].med.id;
				var price = invs[num].med.price;
				$("#ajax-content").load("zadministrator/purchase.form",{sid:sid,mid:mid,price:price});
			});
		}
	})
})
</script>