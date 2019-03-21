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

<style type="text/css">
    <%@include file="/bootstrap-4.3.1/css/bootstrap.min.css" %>
    <%@include file="/bootstrap-4.3.1/css/bootstrap-grid.min.css" %>
</style>
<script type="text/javascript">
    <%@include file="/bootstrap-4.3.1/js/bootstrap.min.js" %>
    <%@include file="/bootstrap-4.3.1/js/jquery.min.js" %>
</script>

<body>
<div align="center">
<form method="post" action="regHost1">
        <input type="hidden" name="q" value="regHost2">
    Application : <input type="text" name="appname" required="required"><br>
    IP Address : <input type="text" name="ipAddr" required="required"><br>
    Url : <input type="text" name="url"  required="required"><br>
    <input type="submit" value="Register">
</form>
</div>
</body>
</html>
