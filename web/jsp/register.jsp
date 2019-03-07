<%--
  Created by IntelliJ IDEA.
  User: alon
  Date: 3/2/19
  Time: 10:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<div align="center">
<form method="post" action="register">
    Username : <input type="text" name="name" required="required"><br>
    Email : <input type="text" name="email" required="required"><br>
    Password : <input type="password" name="password1"  required="required"><br>
    Re-Password : <input type="password" name="password2"  required="required"><br>
    <input type="submit" value="Register">
</form>
</div>
</body>
</html>
