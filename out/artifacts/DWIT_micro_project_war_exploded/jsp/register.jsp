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
    <style type="text/css">
        <%@include file="/bootstrap-4.3.1/css/bootstrap.min.css" %>
        <%@include file="/bootstrap-4.3.1/css/bootstrap-grid.min.css" %>
    </style>
    <script type="text/javascript">
        <%@include file="/bootstrap-4.3.1/js/bootstrap.min.js" %>
        <%@include file="/bootstrap-4.3.1/js/jquery.min.js" %>
    </script>
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
