<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	
	<script type="text/javascript">
		
	</script>

  <p>
   宠物的最爱
    <br/>
     为你最喜欢的宠物店在这里
  </p>
  <ul>

	<c:forEach items="${sessionScope.productlist }" var="product">
	   	<li><a href="queryItemAction?product.productid=${product.productid }">${product.name }</a></li>
	</c:forEach>
  </ul>

  <p>
      <a href="javascript:void(0)" class="Button">&lt;&lt;上一页</a>
      <a href="javascript:void(0)" class="Button">下一页 &gt;&gt;</a>
  
  </p>




