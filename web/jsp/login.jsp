<%--
  Created by IntelliJ IDEA.
  User: alon
  Date: 3/6/19
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div align="center">
<form method="post" action="login">
    Email<br>
    <input style="align-items: center" type="email" name="email" required="required"><br>
    Password<br>
    <input type="password" name="password"  required="required"><br><br>
    <input  type="submit" value="Login"><br>
    <a href="register?q=register">Register ?</a>
</form>
</div>
</body>
</html>
