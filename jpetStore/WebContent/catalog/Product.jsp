<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("table tr td a").click(function(){
			if($(this).html() == "添加到购物车"){
				location.href="saveShoppingAction?item.itemid=" + $(this).parent().parent().children().children().first().html();
			}else{
				location.href="queryQtyAction?item.itemid=" + $(this).html();
			}
		})
		
		$("#select").change(function(){
			location.href="queryItemAction?pager.page="+this.value+"&product.productid="+"${pager.list[0].productid }";
		})
	});
	
		
			
		
	
</script>

<div id="Catalog">
<div id="BackLink">

  <a href="<%=basePath %>queryProductByCategory?category.catid=${product.category}">
       返回 ${product.category}</a>

</div>
  <h2>${product.name}</h2>
	
  <table>
    <tr><th>商品编号</th> <th>产品编号</th>  <th>产品描述</th>  <th>定价</th>  <th>&nbsp;</th></tr>

    	 <c:forEach  items="${pager.list }" var="item">
	     		<tr>
		    		<td><a>${item.itemid }</a></td>
		    		<td>${item.productid }</td>
		    		<td>${item.attr1 }</td>
		    		<td>$${item.listprice }</td>
		    		<td><a class="Button">添加到购物车</a></td>
		    		
		    	</tr>
	     </c:forEach>
	     <tr>
	  	 <td colspan="2">
	       	<c:if test="${pager.page!=1 }">
	       		 <a class="Button" href="queryItemAction?pager.page=1&product.productid=${pager.list[0].productid}"/>首页</a>&nbsp;&nbsp;
	       		 <a class="Button" href="queryItemAction?pager.page=${pager.page-1 }&product.productid=${pager.list[0].productid }"/>上一页</a>&nbsp;&nbsp;
	       	</c:if>
		    <c:if test="${pager.page==1 }">
		    	<a class="Button1"> 首页</a>&nbsp;&nbsp;
		    	<a class="Button1"> 上一页</a>&nbsp;&nbsp;
		    </c:if>
	     	<c:if test="${pager.page!=pager.totalpage }">
	     		<a class="Button" href="queryItemAction?pager.page=${pager.page+1 }&product.productid=${pager.list[0].productid }"/>下一页</a>&nbsp;&nbsp;
	       		<a class="Button" href="queryItemAction?pager.page=${pager.totalpage }&product.productid=${pager.list[0].productid }"/>末页</a>&nbsp;&nbsp;
	     	</c:if>
	     	<c:if test="${pager.page==pager.totalpage }">
		    	<a class="Button1"> 下一页</a>&nbsp;&nbsp;
		    	<a class="Button1"> 末页</a>&nbsp;&nbsp;
	     	</c:if>
	     		当前第:${requestScope.pager.page }页 总页数:${requestScope.pager.totalpage }
	     		<select id="select">
						<c:forEach begin="1" end="${pager.totalpage }" step="1" var="n">
							<c:if test="${pager.page==n }">
								<option value="${n }" selected="selected">${n }</option>
							</c:if>
							<c:if test="${pager.page!=n }">
								<option value="${n }">${n }</option>
							</c:if>
						</c:forEach>
				</select>
	   		 </td>
	     </tr>
  </table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>





