<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$("#submitBtn").click(function(){
				
				//将表单中的值序列化成param 作为参数传递
				var param = $("#loginForm").serialize();
				console.log(param);

				$.ajax({
					url:"loginAction",
					data:param,
					dataType:"json",
					type:"GET",
					success:function(data){
						if(data.result > 0 ){
							location.href="catalog/Main.jsp";
						}else{
							$("#errorSpan").show();
						}
						
					},
					error:function(){
						alert("服务调用出错");
					}
			});
			})
		})
	
	</script>


<div id="Catalog">
  <form id="loginForm">

    <p>请输入您的用户名和密码.</p>
    <p>
            用户名:<input type="text" value="" name="username"/>
    <br/> 
            密&nbsp; 码:<input type="password" value="" name="password"/>
    </p>
    <input type="button" id="submitBtn"  name="submit" value="登录"/>
	<span id="errorSpan" style="color:red;display:none" >用户名或密码错误！！</span>
    </form>

            需要用户名和密码？
    <a href="<%=basePath %>account/NewAccountForm.jsp">立即注册!</a>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>

