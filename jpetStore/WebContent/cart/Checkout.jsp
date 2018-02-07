
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		var sum = 0;
		$(".sumprice").each(function(){
				var price = $(this).parent().parent().children().eq(5).html()
			
				var count = $(this).parent().parent().children().eq(4).html();
				$(this).html(price * count);
				var countPirce =($(this).html())*1.0;
			
				sum = sum + countPirce;
			
		})
		$("#maxprice").html(sum);

		$("#continue").click(function(){
			
			location.href="queryAccountAction";
			
		});
	})
</script>
<div id="Catalog">
<div id="BackLink">
<a href="<%=basePath %>/cart/Cart.jsp">返回到购物车</a>
</div>

  <table>
    <tr>
      <td>
        <h2>核对信息</h2>

        <table>

          <tr>
            <td><b>商品编号</b></td>  <td><b>产品编号</b></td>  <td><b>产品描述</b></td> <td><b>In Stock?</b></td>
            <td><b>产品数量</b></td>  <td><b>定价</b></td> <td><b>总成本</b></td>
          </tr>

       		<c:forEach items="${sessionScope.myCart.items }" var="it">
			    <tr>
			         <td>${it.item.itemid }</td>
			         <td>${it.item.productid }</td>
				     <td>${it.item.attr1 }</td>
				     <td>有</td>
		             <td style="background: white; text-align: center;">${it.quantity }</td>
			         <td>${it.item.listprice }</td>
			         <td>$<span class="sumprice"></span></td>
			    </tr>
			 </c:forEach>
        
          <tr>
            <td colspan="7">
    		          总金额:$<span id="maxprice"></span>
            </td>
          </tr>
        </table>
        <center><a class="Button" id="continue" href="javascript:void(0)">继续</a></center>
      </td>
  

    </tr>
  </table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>





