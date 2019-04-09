<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: alon
  Date: 3/3/19
  Time: 12:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Host</title>
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
<!DOCTYPE html>
<html>
<head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>

<body>
<h2>Application Details</h2>
<ul>
    <a href="regHost?q=regHost"><button type="submit" class="btn btn-primary">Add Host</button></a>
    <a href="home?q=home"><button type="submit" class="btn btn-primary">Home</button> </a>
</ul>
    <table  class="table table-striped">
    <thead class="thead-dark">
    <tr>
        <th>ID</th>
        <th>Application</th>
        <th>IP Address</th>
        <th>URL</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <c:forEach var="host" items="${h}">
        <tr>
            <td>${host.id}</td>
            <td>${host.appName}</td>
            <td>${host.ipAddr}</td>
            <td><a target="_blank" href="">${host.url}</a></td>
            <td><a href="editHost?q=editHost&id=${host.id}&appName=${host.appName}&ipAddr=${host.ipAddr}&url=${host.url}">Edit</a></td>
            <td><a href="deleteHost?q=deleteHost&id=${host.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<h2>Server Details</h2>
<ul>
    <a href="regServer?q=regServer"><button type="submit" class="btn btn-primary">Add Server</button></a>
</ul>
<div class="table-responsive">
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Server Name</th>
            <th>Server Address</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <c:forEach var="server" items="${s}">
        <tr>

            <td>${server.serverId}</td>
            <td>${server.serverName}</td>
            <td>${server.serverAddr}</td>
            <td><a href="editServer?q=editServer&serverId=${server.serverId}&serverName=${server.serverName}&serverAddr=${server.serverAddr}">Edit</a></td>
            <td><a href="deleteServer?q=deleteServer&serverId=${server.serverId}">Delete</a></td>
        </tr>
        </c:forEach>

    </table>
</div>



</body>
</html>

</body>
</html>
