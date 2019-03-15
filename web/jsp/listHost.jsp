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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
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
<h2>Host Details</h2>
<ul>
    <li><a href="regHost?q=regHost" style="align-items: center"><button type="submit" style="align-items: center">Add Host</button></a></li>
    <li><a href="home?q=home"><button type="submit">Home</button> </a></li>
    <li><a href="logout?q=logout"><button type="submit">Logout</button> </a></li>

</ul>
<table>
    <tr>
        <th>ID</th>
        <th>Application</th>
        <th>IP Address</th>
        <th>URL</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

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


</body>
</html>

</body>
</html>
