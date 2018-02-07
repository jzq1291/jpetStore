<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<bean:define id="product" name="catalogBean" property="product"/>
<bean:define id="item" name="catalogBean" property="item"/>

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	
	<script type="text/javascript">
		$(function(){
			
			$("#Shopping").click(function(){
				location.href="saveShoppingAction?item.itemid=${item.itemid}";
			})
		
			$("#aaa").html('${product.descn}');
		})
		
	</script>

<div id="Catalog">
<div id="BackLink">
<a href="queryItemAction?product.productid=${product.productid }">
    ${product.name }</a>
</div>
  <table id="itemTable">
    
    <tr>
      <td>
      	<span id="aaa"></span>
      </td>
    </tr>
    <tr>
      <td>
        <b>${item.itemid }</b>
      </td>
    </tr><tr>
    <td>
      <b><font size="4">
      	${item.attr1 }
      </font></b>
    </td></tr>
    <tr><td>
       ${product.name }
    </td></tr>
    <tr><td>
       ${qty }库存。
    </td></tr>
    <tr><td>
    $${item.listprice }

    <tr><td>
      <a id="Shopping" class="Button" href="javascript:void(0)">
       	添加到购物车</a>
    </td></tr>
    
    
  		
    
  </table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>



