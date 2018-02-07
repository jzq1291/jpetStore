<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
	
	
	<script type="text/javascript">
		$(function(){
				
				$.ajax({
					url:"queryBannerdataAction",
					dataType:"json",
					type:"POST",
					success:function(data){
						if(data){
							if(data.profile.banneropt == 1){
								$("#Banner").append(data.bannerdata.bannername);
							}
						}
					},
					error:function(){
						
					}
			})
		
		})
	
	</script>


<html>

<body>

<div id="Footer">

  <div id="PoweredBy">
    <a href="http://ibatis.apache.org"><img src="./images/poweredby.gif"/></a>
  </div>

  <div id="Banner">
  
  </div>

</div>

</body>
</html>