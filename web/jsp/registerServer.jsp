<%--
  Created by IntelliJ IDEA.
  User: alon
  Date: 4/8/19
  Time: 9:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
    <form method="post" action="regServer1">
        <input type="hidden" name="q" value="regServer2">
        Server Name : <input type="text" name="serverName" required="required"><br>
        Server Address : <input type="text" name="serverAddr" required="required"><br>
        <input type="submit" value="Register">
    </form>
</div>

</body>
</html>
