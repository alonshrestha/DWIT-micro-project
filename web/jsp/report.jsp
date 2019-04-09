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
<h2>User Issue Reports</h2>
<ul>
    <a href="home?q=home"><button type="submit" class="btn btn-primary">Home</button> </a>
</ul>
<table  class="table table-striped">
    <thead class="thead-dark">
    <tr>
        <th>Date</th>
        <th>Name</th>
        <th>Email</th>
        <th>Batch</th>
        <th>Subject</th>
        <th>Message</th>
    </tr>
    </thead>
    <c:forEach var="repo" items="${a}">
        <tr>
            <td>${repo.date}</td>
            <td>${repo.reportName}</td>
            <td>${repo.reportEmail}</td>
            <td>${repo.reportBatch}</td>
            <td>${repo.reportSubject}</td>
            <td>${repo.reportMessage}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

</body>
</html>
