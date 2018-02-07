<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RegiestSuccess</title>
</head>
<body>
	<font style="color: red" size="4px">保存成功!！账户信息如下</font>
	<br>用户名:${signon.username }
	<br>密码：   ${signon.password }
	<br>姓名：   ${account.firstname } &nbsp ${account.lastname }
	<br>电话：   ${account.phone }
	<br>邮箱：   ${account.email }
	<br>国籍：   ${account.country }
	
	
	<p><a href="account/SignonForm.jsp">返回登录</a></p>
	<p><a href="index.html">回到首页</a></p>
</body>
</html>