
	$(function(){
		$("#ajax-content").load("zadministrator/headPage.form");
		$.ajax({
			type:"post",
			url:"zadministrator/getUserName.form",
			success:function(jsonObj){
				var username = jsonObj.username;
				$("#username").text(username);
			}
		})
	});
	$("#userInfo").click(function(){
		$("#ajax-content").load("zadministrator/userInfo.form");
	});
	$("#headPage").click(function(){
		$("#ajax-content").load("zadministrator/headPage.form");
	});
	$("#updatePass").click(function(){
		$("#ajax-content").load("zadministrator/updatePass.form");
	});
	$("#buyMedicinePage").click(function(){
		$("#ajax-content").load("zadministrator/buyMedicinePage.form");
	});
	
	//查询待付款订单
	$("#queryWaitOrder").click(function(){
		var url = "zadministrator/queryWaitOrder.form";
		var state = "待付款";
		$("#ajax-content").load("zadministrator/orderInfo.form",queryOrder(url,state));
	});
	
	function queryOrder(url,state){
		$.ajax({
			type:"post",
			url:url,
			success:function(jsonObj){
				var orders = jsonObj.orders;
				for(var i = 0;i<orders.length;i++){
					var orderRow = $("<tr><td>"+(i+1)+"</td><td>"+
							orders[i].id+"</td><td>"+
							orders[i].mid+"</td><td>"+
							orders[i].sid+"</td><td>"+
							orders[i].qty+"</td><td>"+
							orders[i].dollars+"</td><td>"+
							orders[i].transactionDate+"</td><td>"+
							state+"</td></tr>");
					$("#orderInfo").append(orderRow);
				}
			}
		});
	}
	//查询已付款订单
	$("#queryPaidOrder").click(function(){
		var url = "zadministrator/queryPaidOrder.form";
		var state = "已付款";
		$("#ajax-content").load("zadministrator/orderInfo.form",queryOrder(url,state));
	});
	
	/**
	 * 精确查找订单
	 **/
	$("#exactQueryOrderPage").click(function(){
		$("#ajax-content").load("zadministrator/exactQueryOrderPage.form");
	});
	
	/**
	 * 待付款采购单
	 */
	$("#queryWaitPurchase").click(function(){
		$("#ajax-content").load("zadministrator/purchaseInfo.form");
		$.ajax({
			type:"post",
			url:"zadministrator/queryWaitPurchases.form",
			success:function(jsonObj){
				var purs = jsonObj.purs;
				for(var i = 0;i<purs.length;i++){
					var purRow = $("<tr><td>"+(i+1)+"</td><td>"+
							purs[i].id+"</td><td>"+
							purs[i].mid+"</td><td>"+
							purs[i].sid+"</td><td>"+
							purs[i].qty+"</td><td>"+
							purs[i].dollars+"</td><td>"+
							purs[i].transactionDate+"</td><td>"+
							"<button type='button' name='payment' value="+purs[i].id+">付款</button>&emsp;" +
							"<button type='button' name='canclePur' value="+purs[i].id+">取消</button></td></tr>");
					$("#purInfo").append(purRow);
				}
				//取消采购单
				$("button[name='canclePur']").click(function(){
					var pid = $(this).val();
					var par = $(this).parent().parent();
					$.ajax({
						type:"post",
						data:{pid:pid},
						url:"zadministrator/canclePurchase.form",
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
				//付款
				$("button[name='payment']").click(function(){
					var pid = $(this).val();
					var par = $(this).parent().parent();
					$.ajax({
						type:"post",
						data:{pid:pid},
						url:"zadministrator/payment.form",
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
		})
	});
	
	/**
	 * 已付款采购单
	 */
	$("#queryPaidPurchase").click(function(){
		$("#ajax-content").load("zadministrator/purchaseInfo.form");
		$.ajax({
			type:"post",
			url:"zadministrator/queryPaidPurchases.form",
			success:function(jsonObj){
				var purs = jsonObj.purs;
				for(var i = 0;i<purs.length;i++){
					var purRow = $("<tr><td>"+(i+1)+"</td><td>"+
							purs[i].id+"</td><td>"+
							purs[i].mid+"</td><td>"+
							purs[i].sid+"</td><td>"+
							purs[i].qty+"</td><td>"+
							purs[i].dollars+"</td><td>"+
							purs[i].transactionDate+"</td><td>"+
							"已付款</td></tr>");
					$("#purInfo").append(purRow);
				}
			}
		})
	});
	
	/**
	 * 库存查询
	 */
	$("#queryInventoryPage").click(function(){
		$("#ajax-content").load("zadministrator/inventoryPage.form");
	});
	
	/**
	 * 将要售罄
	 * */
	$("#willSellOut").click(function(){
		$("#ajax-content").load("zadministrator/inventory.form");
	});
