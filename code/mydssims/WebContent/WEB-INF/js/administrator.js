
	$(function(){
		$("#ajax-content").load("zcustomer/headPage.form");
		$.ajax({
			type:"post",
			url:"zcustomer/getUserName.form",
			success:function(jsonObj){
				var username = jsonObj.username;
				$("#username").text(username);
			}
		})
	});
	$("#userInfo").click(function(){
		$("#ajax-content").load("zcustomer/userInfo.form");
	});
	$("#headPage").click(function(){
		$("#ajax-content").load("zcustomer/headPage.form");
	});
	$("#updatePass").click(function(){
		$("#ajax-content").load("zcustomer/updatePass.form");
	});
	$("#buyMedicinePage").click(function(){
		$("#ajax-content").load("zcustomer/buyMedicinePage.form");
	});
	
	//查询待付款订单
	$("#queryWaitOrder").click(function(){
		$("#ajax-content").load("zcustomer/orderInfo.form",queryWaitOrder);
		
	});
	
	function queryWaitOrder(){
		$.ajax({
			type:"post",
			data:{},
			url:"zcustomer/queryWaitOrder.form",
			success:function(jsonObj){
				var orders = jsonObj.orders;
				for(var i = 0;i<orders.length;i++){
					var orderRow = $("<tr><td>"+(i+1)+"</td><td>"+
							orders[i].id+"</td><td>"+
							orders[i].mid+"</td><td>"+
							orders[i].sid+"</td><td>"+
							orders[i].aid+"</td><td>"+
							orders[i].dollars+"</td><td>"+
							orders[i].transactionDate+"</td><td>"+
							"<button type='button' name='payment' value="+orders[i].id+">待付款</button>&emsp;" +
							"<button type='button' name='cancleOrder' value="+orders[i].id+">取消</button></td></tr>");
					
					$("#orderInfo").append(orderRow);
				}
				$("button[name='cancleOrder']").click(function(){
					var oid = $(this).val();
					var par = $(this).parent().parent();
					$.ajax({
						type:"post",
						data:{oid:oid},
						url:"zcustomer/cancleOrder.form",
						success:function(jsonObj){
							if(jsonObj.msg=="y"){
								alert("取消成功！");
							}else{
								alert("取消失败!");
							}
							par.remove();
						}
					});
				});
				
				$("button[name='payment']").click(function(){
					var oid = $(this).val();
					var par = $(this).parent().parent();
					$.ajax({
						type:"post",
						data:{oid:oid},
						url:"zcustomer/cancleOrder.form",
						success:function(jsonObj){
							if(jsonObj.msg=="y"){
								alert("付款成功！");
							}else{
								alert("付款失败!");
							}
							par.remove();
						}
					});
				});
			}
		});
	}
	//查询已付款订单
	$("#queryPaidOrder").click(function(){
		$("#ajax-content").load("zcustomer/orderInfo.form",function(){
			$.ajax({
				type:"post",
				data:{},
				url:"zcustomer/queryPaidOrder.form",
				success:function(jsonObj){
					var orders = jsonObj.orders;
					for(var i = 0;i<orders.length;i++){
						var orderRow = $("<tr><td>"+(i+1)+"</td><td>"+
								orders[i].id+"</td><td>"+
								orders[i].mid+"</td><td>"+
								orders[i].sid+"</td><td>"+
								orders[i].aid+"</td><td>"+
								orders[i].dollars+"</td><td>"+
								orders[i].transactionDate+"</td><td>"+
								"已付款</td></tr>");
						$("#orderInfo").append(orderRow);
					}
				}
			});
		});
		
	});
