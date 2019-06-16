
$(function(){
	$("#ajax-content").load("zsupplier/headPage.form");
	$.ajax({
		type:"post",
		url:"zsupplier/getUserName.form",
		success:function(jsonObj){
			var username = jsonObj.username;
			$("#username").text(username);
		}
	})
	
	$("#userInfo").click(function(){
		$("#ajax-content").load("zsupplier/userInfo.form");
	});
	$("#headPage").click(function(){
		$("#ajax-content").load("zsupplier/headPage.form");
	});
	$("#updatePass").click(function(){
		$("#ajax-content").load("zsupplier/updatePass.form");
	});

	
	//查询待付款订单
	$("#queryWaitPurchases").click(function(){
		$("#ajax-content").load("zsupplier/purchaseInfo.form",queryWaitPurchases());
		
	});
	
	function queryWaitPurchases(){
		$.ajax({
			type:"post",
			url:"zsupplier/queryWaitPurchases.form",
			success:function(jsonObj){
				var purs = jsonObj.purs;
				for(var i = 0;i<purs.length;i++){
					var purRow = $("<tr><td>"+(i+1)+"</td><td>"+
							purs[i].id+"</td><td>"+
							purs[i].mid+"</td><td>"+
							purs[i].aid+"</td><td>"+
							purs[i].qty+"</td><td>"+
							purs[i].dollars+"</td><td>"+
							purs[i].transactionDate+"</td><td>"+
							"待付款</td></tr>");
					$("#purInfo").append(purRow);
				}
			}
		});
	}

	
	
	/**
	 * 精确查询
	 */
	$("#exactQuery").click(function(){
		$("#ajax-content").load("zsupplier/exactQuery.form");
	});
});

