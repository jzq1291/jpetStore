<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h3>客户基本信息</h3>

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
		$(function(){
			
			if("${profile.mylistopt }"){
				$("#checkboxOne").attr("checked","checked");
			}
			if("${profile.banneropt}"){
				$("#checkboxTwo").attr("checked","checked");
			}
			
			$("#selectlike option[value='${profile.favcategory }']").attr("selected",true);
			
			$("#languagelike option[value='${profile.langpref }']").attr("selected",true);
						
		
		});

</script>

<table id="accountTwoTable">
  <tr>
    <td>姓:</td><td><input type=text value="${account.firstname }" name="account.firstname"/></td>
  </tr><tr>
  <tr>
    <td>名:</td><td><input type=text value="${account.lastname }" name="account.lastname"/></td>
  </tr><tr>
  <td>邮箱:</td><td><input type=text  size="40" value="${account.email }" name="account.email"></td>
</tr><tr>
  <td>联系电话:</td><td><input type=text  size="40" value="${account.phone }" name="account.phone"/></td>
</tr><tr>
  <td>地址1:</td><td><input type=text size="40"  value="${account.addr1 }" name="account.addr1"/></td>
</tr><tr>
  <td>地址2:</td><td><input type=text  size="40" value=""></td>
</tr><tr>
  <td>城市:</td><td><input type=text  value="${account.city }" name="account.city"/></td>
</tr><tr>
  <td>区、县</td><td><input type=text size="4"  value="${account.state }" name="account.state"/></td>
</tr><tr>
  <td>邮政编码:</td><td><input type=text size="10" value="${account.zip }" name="account.zip"/></td>
</tr><tr>
  <td>国籍:</td><td><input type=text  size="15" value="${account.country }" name="account.country"/></td>
</tr>
</table>

<h3>个人喜好</h3>

<table>
  <tr>
    <td>喜爱的语言:</td><td>
          <select name="profile.langpref" id="languagelike">
       <option value="ENGLISH">ENGLISH</option>
        <option value="CHINESE">CHINESE</option>
 
      </select></td>
  </tr><tr>
  <td>喜欢的动物类别:</td><td>
     <select name="profile.favcategory" id="selectlike">
         <option value="CATS" >CATS</option>
         <option value="DOGS">DOGS</option>
         <option value="FISH">FISH</option>
         <option value="REPTILES">REPTILES</option>
         <option value="BIRD">BIRD</option>
     </select></td>
</tr><tr>
  <td>根据喜爱动物类别为您推荐</td><td><input type="checkbox" id="checkboxOne" name="profile.mylistopt" value="1"/></td>
</tr><tr>
  <td>是否植入广告</td><td><input type="checkbox" id="checkboxTwo" name="profile.banneropt" value="1"/></td>
</tr>

</table>
