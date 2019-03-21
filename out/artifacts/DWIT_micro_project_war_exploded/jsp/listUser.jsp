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
    <title>List</title>
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
<h2>User Details</h2>
<ul>
    <li><a href="register?q=register" style="align-items: center"><button type="submit" style="align-items: center">Add User</button></a></li>
    <li><a href="home?q=home"><button type="submit">Home</button> </a></li>
    <li><a href="logout?q=logout"><button type="submit">Logout</button> </a></li>

</ul>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

    <c:forEach var="user" items="${u}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td><a href="editUser?q=editUser&id=${user.id}">Edit</a></td>
            <td><a href="deleteUser?q=deleteUser&id=${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

</body>
</html>
