<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">


	$(function(){	
		var sum = 0;
		$(".sumprice").each(function(){
				var price = $(this).parent().parent().children().eq(3).html();
				var count = $(this).parent().parent().children().eq(2).html();
				$(this).html(price * count);
				var countPirce = parseInt($(this).html());
				sum = sum + countPirce;
		})
		
		$("#maxprice").html(sum);
		
		
		
	});
	
	
</script>


<div id="Catalog">
<div id="BackLink">
  <a href="<%=basePath%>catalog/Main.jsp">返回主菜单</a>
</div>
<table>
<tr><th align="center" colspan="2">
  订单 号1000 2013/02/21 11:13:31 
</th></tr>
<tr><th colspan="2">
付款详情
</th></tr>
<tr><td>
  信用卡类型:</td><td>
 维萨信用卡
</td></tr>
<tr><td>
信用卡号码:</td><td>999 9999 9999 9999 
</td></tr>
<tr><td>
 有效日期 (MM/YYYY):</td><td>12/03
</td></tr>
<tr><th colspan="2">
账单地址
</th></tr>
<tr><td>
  姓名:</td><td>${account.firstname }</td></tr>

<tr><td>
 地址 1:</td><td>${orders.shipaddr1 }
</td></tr>
<tr><td>
地址 2:</td><td>${orders.shipaddr1 }
</td></tr>
<tr><td>
城市: </td><td>${orders.shipcity }
</td></tr>
<tr><td>
区、县:</td><td>${orders.shipstate }
</td></tr>
<tr><td>
邮政编码:</td><td>${orders.shipzip } 
</td></tr>
<tr><td>
 国籍: </td><td>${orders.shipcountry }
</td></tr>
<tr><th colspan="2">
收货地址
</th></tr><tr><td>
姓:</td><td>${account.firstname }
</td></tr>
<tr> 
	<td>名:</td>
	<td>${account.lastname }</td>
</tr>
<tr><td>
  地址1:</td><td>${orders.shipaddr1 }
</td></tr>
<tr><td>
地址2:</td><td>${orders.shipaddr1 }
</td></tr>
<tr><td>
城市: </td><td>${orders.shipcity }
</td></tr>
<tr><td>
区、县:</td><td>${orders.shipstate }
</td></tr>
<tr><td>
邮政编码:</td><td>${orders.shipzip }
</td></tr>
<tr><td>
国籍: </td><td>${orders.shipcountry }
</td></tr>
<tr><td>
邮政公司: </td><td>${orders.courier }
</td></tr>
<tr><td colspan="2">
  状态:已付款
</td></tr>
<tr><td colspan="2">
  <table >
    <tr>
      <th>商品编号</th>
      <th>产品描述</th>
      <th>数量</th>
      <th>价格</th>
      <th>总金额</th>
    </tr>
	      <c:forEach items="${sessionScope.myCart.items }" var="cart">
	     	  <tr>
			      <td>${cart.item.itemid }</td>
			      <td>${cart.item.attr1 }</td>
			      <td>${cart.quantity }</td>
			      <td>${cart.item.listprice }</td>
			      <td>$<span class="sumprice"></span></td>
			 </tr>
	      </c:forEach>
    	<tr>
      <th colspan="5">总金额: $ <span id="maxprice">0000</span>
      </th>
    </tr>
  </table>
</td></tr>

</table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>



