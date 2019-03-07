<%--
  Created by IntelliJ IDEA.
  User: alon
  Date: 3/5/19
  Time: 9:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Hostname </title>
</head>
<title>Register</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<body>
<div align="center">
<form method="post" action="addHost">
        <input type="hidden" name="q" value="regHost">
    Application : <input type="text" name="appname" required="required"><br>
    IP Address : <input type="text" name="ipAddr" required="required"><br>
    Url : <input type="text" name="url"  required="required"><br>
    <input type="submit" value="Register">
</form>
</div>
</body>
</html>
