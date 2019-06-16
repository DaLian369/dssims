<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="login.form" method="post" class="box-content">

    <div class="text-center">
        <h3 class="page-header">用户登录</h3>
    </div>
    <div class="form-group">
        <label class="control-label">用户ID</label>
        <input type="text" class="form-control" name="id" />
    </div>
    <div class="form-group">
        <label class="control-label">密&emsp;码</label>
        <input type="password" class="form-control" name="password"/>
    </div>
    <div class="form-group">
        <input type="radio" name="identity" checked value="cus" />客户&emsp;
        <input type="radio" name="identity" value="adm"> 管理员&emsp;
        <input type="radio" name="identity" value="sup"> 供应商&emsp;
    </div>
    <div class="text-center">
        <input type="submit" class="btn btn-primary" value="登录" />
    </div>
 </form> 
 <!--
<script type="text/javascript">
	$(function(){
		$("#login").click(function(){
			var id = $("input[name='id']").val();
			var password = $("input[name='password']").val();
			var identity = $("input[name='identity']").val();
			$("#bo").load("login.form",{id:id,password:password,identity:identity},function(msg){
				if(msg=="n"){
					alert("用户名或密码错误!");
				}
			});
		});
	});
</script>-->