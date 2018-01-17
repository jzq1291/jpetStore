<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("table tr td a").click(function(){
			location.href="queryItemAction?product.productid=" + $(this).html();
		})
	
	});
	
		
			
		
	
</script>
<div id="Catalog">

<div id="BackLink">

  <a href="<%=basePath%>catalog/Main.jsp">返回主菜单</a>

</div>
<%--   <h2><s:property value="category.catid"/></h2> --%>

  <table>
     <tr><td>产品编号</td> <td>产品名称</td></tr>
     <c:forEach  items="${requestScope.pager.list }" var="pro">
     	<tr>
     		<td>${pro.productid }</td>
     		<td>${pro.name }</td>
     	</tr>
     </c:forEach>
     <tr>
<!--   	 <td> -->
<%--         <a class="Button" href="categoryAction?begin=${begin-1 }&category.catid=<s:property value="category.catid"/>"/>上一页</a>&nbsp;&nbsp; --%>
<%--      	<a class="Button" href="categoryAction?begin=${begin+1 }&category.catid=<s:property value="category.catid"/>">下一页</a>&nbsp;&nbsp; --%>
<!--    	 </td> -->
     </tr>
  </table>
  

</div>

<%@ include file="../common/IncludeBottom.jsp" %>


