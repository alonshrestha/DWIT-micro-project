<%--
  Created by IntelliJ IDEA.
  User: alon
  Date: 4/9/19
  Time: 1:38 PM
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
    <form action="editServerPost" method="post">
        <h1>ID=${serverId}</h1>
        <input type="hidden" name="q" value="editServer">
        <input type="hidden" name="serverId" value="${serverId}">
        Application <input type="text" name="serverName" value="${serverName}" required="required"><br><br>
        IP Address <input type="text" name="serverAddr"  value="${serverAddr}" required = "required"><br><br>
        <input type="submit" value="Save">
    </form>
</div>

</body>
</html>
