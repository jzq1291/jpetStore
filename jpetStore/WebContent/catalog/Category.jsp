<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".productid").click(function(){
			location.href="queryItemAction?pager.page=1&product.productid=" + $(this).html();
		})
		
		$("#select").change(function(){
			location.href="queryProductByCategory?pager.page="+this.value+"&category.catid="+"${pager.list[0].category }";
		})
	
	});
	
</script>
<div id="Catalog">

<div id="BackLink">

  <a href="<%=basePath%>catalog/Main.jsp">返回主菜单</a>

</div>
	
     <center>
     	 <h2>${pager.list[0].category }</h2>
	  <table>
	     <tr><td>产品编号</td> <td>产品名称</td></tr>
	     <c:forEach  items="${requestScope.pager.list }" var="pro">
	     	<tr>
	     		<td><a class="productid">${pro.productid }</a></td>
	     		<td>${pro.name }</td>
	     	</tr>
	     </c:forEach>
	     <tr>
	  	 <td colspan="2">
	       	<c:if test="${pager.page!=1 }">
	       		 <a class="Button" href="queryProductByCategory?pager.page=1&category.catid=${pager.list[0].category }"/>首页</a>&nbsp;&nbsp;
	       		 <a class="Button" href="queryProductByCategory?pager.page=${pager.page-1 }&category.catid=${pager.list[0].category }"/>上一页</a>&nbsp;&nbsp;
	       	</c:if>
		    <c:if test="${pager.page==1 }">
		    	<a class="Button1"> 首页</a>&nbsp;&nbsp;
		    	<a class="Button1"> 上一页</a>&nbsp;&nbsp;
		    </c:if>
	     	<c:if test="${pager.page!=pager.totalpage }">
	     		<a class="Button" href="queryProductByCategory?pager.page=${pager.page+1 }&category.catid=${pager.list[0].category }"/>下一页</a>&nbsp;&nbsp;
	       		<a class="Button" href="queryProductByCategory?pager.page=${pager.totalpage }&category.catid=${pager.list[0].category }"/>末页</a>&nbsp;&nbsp;
	     	</c:if>
	     	<c:if test="${pager.page==pager.totalpage }">
		    	<a class="Button1"> 下一页</a>&nbsp;&nbsp;
		    	<a class="Button1"> 末页</a>&nbsp;&nbsp;
	     	</c:if>
	     	
	     		当前第:${requestScope.pager.page }页 总页数:${pager.totalpage }
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
  </center>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>


