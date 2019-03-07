<%--
  Created by IntelliJ IDEA.
  User: alon
  Date: 3/4/19
  Time: 6:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<div align="center">
<form action="editUserGet" method="post">
    <h1>ID=${i}</h1>
    <input type="hidden" name="id" value="${i}">
    Name <input type="text" name="name"  required="required"><br><br>
    Email <input type="email" name="email"  required="required"><br><bra>
    Password <input type="password" name="password"  required="required"><br><br>
    <input type="submit" value="Save">
</form>
</div>
</body>
</html>
