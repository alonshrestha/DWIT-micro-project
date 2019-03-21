<%--
  Created by IntelliJ IDEA.
  User: alon
  Date: 3/6/19
  Time: 8:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Hosts</title>
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
    <form action="editHostPost" method="post">
        <h1>ID=${id}</h1>
        <input type="hidden" name="q" value="editHost">
        <input type="hidden" name="id" value="${id}">
        Application <input type="text" name="appName" value="${appName}" required="required"><br><br>
        IP Address <input type="text" name="ipAddr"  value="${ipAddr}" required = "required"><br><bra>
        Url <input type="text" name="url"  value="${url}"required = "required"><br><br>
        <input type="submit" value="Save">
    </form>
</div>

</body>
</html>
