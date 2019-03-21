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
