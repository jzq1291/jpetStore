<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	
	<script type="text/javascript">
		
			$(function(){
				$("#").click(function(){
					
					location.href = "historyOrdersAction?signon.username=" + "${userid }";
				})
			})
	</script>
<div id="Catalog">

<form method="post" action="insertAction">

 

    <h3>账户信息</h3>
     <table>
      <tr>
        <td>账户:</td><td><input type="text"  value="${signon.username }" name="signon.username" readonly="readonly"></td>
      </tr><tr>
       <td>新密码:</td><td><input type="password" value="${signon.password }" name="signon.password"></td>
      </tr><tr>
      <td>重复密码:</td><td><input  type="password" value="${signon.password }"></td>
    </tr>
    </table>
    <%@ include file="IncludeAccountFields.jsp" %>

    <input type="submit" name="submit" id="saveInfo" value="保存账户资料"/>



</form>
  <a id="orderList" href="javascript:void(0)">我的订单</a>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>


