<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
	
		$("a").click(function(){
		
				alert("123");
		})
		
	})


</script>
<div id="Catalog">

<div id="BackLink">
  <a href="<%=basePath%>catalog/Main.jsp">返回主菜单</a>
</div>

请确认以下信息，然后按"继续"...

  <table>
    <tr><th align="center" colspan="2">
      <font size="4"><b>订单</b></font>
      <br/><font size="3"><b>2013/02/21 11:13:31</b></font>
    </th></tr>

    <tr><th colspan="2">
    账单地址
    </th></tr>
    <tr><td>
    姓:</td><td> ${account.firstname }
    </td></tr>
    <tr><td>
      名:</td><td>	${account.lastname } 
    </td></tr>
    <tr><td>
      地址 1:</td><td>${account.addr1 }
    </td></tr>
    <tr><td>
      地址 2:</td><td>${account.addr2 }    </td></tr>
    <tr><td>
      城市: </td><td>	${account.city }
    </td></tr>
    <tr><td>
      州 、邦:</td><td>${account.state } 
    </td></tr>
    <tr><td>
     邮政编号:</td><td>${account.zip }
    </td></tr>
    <tr><td>
      国家: </td><td>${account.country } 
    </td></tr>
    <tr><th colspan="2">
  寄运地址
    </th></tr><tr><td>
    姓:</td><td>${account.firstname }
  </td></tr>
    <tr><td>
      名:</td><td>${account.lastname }
    </td></tr>
    <tr><td>
     地址1:</td><td>${account.addr1 }
    </td></tr>
    <tr><td>
      地址 2:</td><td>${account.addr2 }
    </td></tr>
    <tr><td>
   城市: </td><td>${account.city }
    </td></tr>
    <tr><td>
      州、邦:</td><td>${account.state }
    </td></tr>
    <tr><td>
     邮政编码:</td><td>${account.zip }
    </td></tr>
    <tr><td>
     国家: </td><td>${account.country }
    </td></tr>

  </table>
 
    <form action="saveOrderAction" method = "post">
  			<input type="hidden" name="account.firstname"  value = "${account.firstname }" />
  			<input type="hidden" name="account.firstname"  value = "${account.firstname }" />
  			<input type="hidden" name="orders.shipaddr1" value = "${account.addr1 }" />
  			<input type="hidden" name="orders.shipcity" value = "${account.city }" />
  			<input type="hidden" name="orders.shipzip" value = "${account.zip }" />
  			<input type="hidden" name="orders.shipcountry" value = "${account.country }" />
  			
  			<input type="hidden" name="orders.billaddr1" value = "${account.addr1 }" />
  			<input type="hidden" name="orders.billcity" value = "${account.city }"/>
  			<input type="hidden" name="orders.courier" value = "顺丰速运" />
  			<input type="hidden" name="orders.billcountry" value = "${account.country }" />
  			<input type="hidden" name="orders.billstate" value="${account.state }" />
  			<input type="hidden" name="orders.billzip" value="${account.zip }" />
  			<input type="hidden" name="orders.billtofirstname"  value="${account.firstname }"/>
  			<input type="hidden" name="orders.billtolastname"  value="${account.lastname }"/>
  			<input type="hidden" name="orders.totalprice"  value="111111" />
  			<input type="hidden" name="orders.shiptofirstname"  value="${account.firstname }"/>
  			<input type="hidden" name="orders.shiptolastname"  value="${account.lastname }"/>
  			<input type="hidden" name="orders.creditcard"  value="9999 9999 999999" />
  			<input type="hidden" name="orders.exprdate"  value="12/03" />
  			<input type="hidden" name="orders.cardtype"  value="美国运通信用卡" />
  			<input type="hidden" name="orders.shipstate"  value="22" />
  			
  			<input type="submit" value="确认" >
  </form>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>





