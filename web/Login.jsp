
  Created by IntelliJ IDEA.
  User: 17204
  Date: 2016/5/19
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<form action="login" method="post">
用户名：<input type="text" name="name"/><br>
密码:<input type="password" name="pwd"/><br>
    <input type="submit" value="登录"/>
    <input type="button" value="注册" onclick="window.location.href = 'zhuce.jsp' "/>
    </form>
</body>
</html>
