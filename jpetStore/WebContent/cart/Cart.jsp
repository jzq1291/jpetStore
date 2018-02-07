
<%@ page language="java" import="java.util.*,com.domain.*,java.lang.Integer" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../common/IncludeTop.jsp" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">


	$(function(){
		var rowCount;
		
		//计算总价
		$(".sumprice").each(function(){
				var price = $(this).parent().parent().children().eq(7).html();
				var sumprice = $(this).parent().parent().children().eq(8).html();
				var count = $(this).parent().parent().children().eq(5).children().val();
// 				var count = $(this).parent().parent().children().eq(5).html();
				$(this).html(price * count);
			
		})
		
		//结算 ,如果没登录则跳转到登录页面
		$("#buy").click(function(){
			 if("${userid }" == ""){
			 	location.href="account/SignonForm.jsp";
			 }else{
				location.href="cart/Checkout.jsp";
			}
		})
		
		
		//是否展示底部广告
		if("${profile.mylistopt}" == 0){
			$("#MyList").css("display","none");
		}

		
		//查看物品详情
		$(".itemId").click(function(){
			location.href = "queryQtyAction?item.itemid=" + $(this).html();
		});
		
		
		//增加数量
		$(".add").click(function(){
			var itemId = $(this).parent().children().eq(0).children().html();
			var count = $(this).parent().children().eq(5).children().val();
			
			//更新购物车
		    var td = $(this);
			var price = $(this).parent().children().eq(7).html();
		    var maxprice = $("#maxprice");
		    var sumprice = $(this).parent().children().eq(8).children();

			$.ajax({
				url:"shoppingCartAdd",
				data:{
					"itemId":itemId,
					"count":count
				},
				dataType:"json",
				type:"post",
				success:function(data){
					
					if(data.res == 1){
						td.parent().children().eq(5).children().val(parseInt(count)+1);
						maxprice.html((maxprice.html()*1)+(price*1));
						sumprice.html((sumprice.html()*1)+(price*1));
					}
					alert(data.result);
				},
				error:function(d){
					alert(d.responseText);
				}
			});
		});
		
		
		//减少数量
		$(".sub").click(function(){
			var itemId = $(this).parent().children().eq(0).children().html();
			var count = $(this).parent().children().eq(5).children().val();
			
			//更新购物车
		    var td = $(this);
			var price = $(this).parent().children().eq(7).html();
		    var maxprice = $("#maxprice");
		    var sumprice = $(this).parent().children().eq(8).children();
			
			$.ajax({
				url:"shoppingCartSub",
				data:{
					"itemId":itemId
				},
				dataType:"json",
				type:"post",
				success:function(data){
					if(data.res == 1){
						//如果数量大于一减一,否则移除
						if((count*1)>1){
							td.parent().children().eq(5).children().val((count*1)-1);
						}else {
							td.parent().remove()
						}
						maxprice.html((maxprice.html()*1)-(price*1));
						sumprice.html((sumprice.html()*1)-(price*1));
					}
					alert(data.result);
				},
				error:function(d){
					alert(d.responseText);
				}
			});
			
		});
		
		
		//获取焦点时,保存获取前的数量
		$(".textview").focus(function(){
			rowCount = $(this).val();
		});

		
		//修改数量
		$(".textview").blur(function() {
			var itemId = $(this).parent().parent().children().eq(0).children().html();
			var count = $(this).val();
			var input=$(this);
				
			if(count == 0){
				alert("数量最少为1");
				input.val(rowCount);
				return;
			}else if(count == rowCount){
				return;
			}
				
			//更新购物车
			var td = $(this);
			var price = $(this).parent().parent().children().eq(7).html();
			var maxprice = $("#maxprice");
			var sumprice = $(this).parent().parent().children().eq(8).children();
				
			$.ajax({
				url:"shoppingCartModify",
				data:{
					"itemId":itemId,
					"count" :count,
					"rowCount":rowCount
				},
				dataType:"json",
				type:"post",
				success:function(data){
					if(data.res == 1){
						maxprice.html((maxprice.html()*1)-(price*((rowCount*1)-(count*1))));
						sumprice.html((sumprice.html()*1)-(price*((rowCount*1)-(count*1))));
						alert(data.result);
					}else{
						input.val(rowCount);
						alert(data.result);
					}
				},
				error:function(d){
					alert(d.responseText);
				}
			});
				
		});
		
		
		//删除购物车项
		$(".btn").click(function(){
			var itemId = $(this).parent().parent().children().children().first().html();
			var count = $(this).parent().parent().children().eq(5).children().val();
			var maxprice = $("#maxprice");
			var sumprice = $(this).parent().parent().children().eq(8).children().html();
			
			alert(maxprice.html()*1);
			alert(sumprice*1);
			
			var tr = $(this).parents('tr:first');
			$.ajax({
				url:"shoppingCartRemove",
				data:{
					"itemId":itemId,
					"count":count
				},
				dataType:"json",
				type:"post",
				success:function(data){
					if(data.res == 1){
						maxprice.html((maxprice.html()*1)-(sumprice*1));
						tr.remove()
					}
					alert(data.result);
				},
				error:function(d){
					alert(d.responseText);
				}
			});
		});
		
		
		/*  付款  */
		$("#buy").click(function(){
			 if("${userid }" == ""){
			 	location.href="account/SignonForm.jsp";
			 }else{
				location.href="cart/Checkout.jsp";
			}
		})
			
	})
	
</script>


<div id="Catalog">

<div id="BackLink" >
  <a href="<%=basePath%>catalog/Main.jsp">返回主菜单</a>
</div>
  <div id="Cart">

    <h2>购物车</h2>
    <form  method="post">
      <table id="shopping">
        <tr>
          <th><b>商品编号</b></th>  <th><b>产品编号</b></th>  <th><b>产品描述</b></th> <th><b>有库存?</b></th>
          <th colspan="3"><b>产品数量</b></th>  <th><b>定价</b></th> <th><b>总价</b></th>  <th>&nbsp;</th>
        </tr>
		
		<c:if test="${myCart==null }">
				<tr><td colspan="8"><b>你的购物车是空的.</b></td></tr>
			</c:if>
			
			<c:if test="${sessionScope.myCart!=null }"> 
				<c:forEach items="${sessionScope.myCart.items }" var="it">
			    	<tr>
			            <td><a class="itemId" href="javascript:void(0)">${it.item.itemid }</a></td>
			            <td>${it.item.productid }</td>
				        <td>${it.item.attr1 }</td>
				        <td>有</td>
				        <td class="sub">-</td>
		              	<td style="background: white; text-align: center;">
		              		<input type="text" class="textview" size="1" style="text-align: center; " value="${it.quantity }"/> 
		              	</td>
				        <td class="add">+</td>
			            <td>${it.item.listprice }</td>
			            <td>$<span class="sumprice"></span></td>
			            <td><a  class="btn" href="javascript:void(0)">
			         	     取消</a></td>
			    	</tr>
			    </c:forEach>	
		</c:if>
        <tr>
          <td colspan="9">
           	 总金额:$ <span id="maxprice">${myCart.total }</span>
          </td>
          <td>&nbsp;</td>
        </tr>
      </table>
      
    </form>

    <a class="Button" id="buy" href="javascript:void(0)" >付款</a>


  </div>
    <div id="MyList" style="margin-top:10px;">
   		 <%@ include file="IncludeMyList.jsp" %>
    </div>
  <div id="Separator">&nbsp;</div>

</div>


<%@ include file="../common/IncludeBottom.jsp" %>



