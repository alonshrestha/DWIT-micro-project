<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
&lt;%&ndash;
  Created by IntelliJ IDEA.
  User: alon
  Date: 3/2/19
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
&ndash;%&gt;
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
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
<h1>Welcome!!</h1>
<a href="logout?q=logout">
    <button type="submit">Logout</button>
</a>
<a href="register?q=register">
    <button type="submit">Register</button>
</a>
<a href="listUser?q=listUser">
    <button type="submit">User Details</button>
</a>
<a href="regHost?q=regHost">
    <button type="submit">Register Host</button>
</a>
<a href="listHost?q=listHost">
    <button type="submit">Host Details</button>
</a><br>
<form method="post" action="checkStatus">
    <input type="hidden" name="q" value="serverStatus">
    Server Status <input type="text" name="ip" placeholder="IP Address" required="required">
    <input type="submit" value="Check">
</form><br>
<form method="post" action="httpStatus">
    <input type="hidden" name="q" value="httpStatus">
    Http Status  <input type="text" name="url" placeholder="http://example.com" value="http://" required="required">
    <input type="submit" value="Check">
</form>
</body>
</html>
--%>


<html>
<head>
    <title>home</title>

    <style type="text/css">
        <%@include file="/bootstrap-4.3.1/css/bootstrap.min.css" %>
        <%@include file="/bootstrap-4.3.1/css/bootstrap-grid.min.css" %>
    </style>
    <script type="text/javascript">
        <%@include file="/bootstrap-4.3.1/js/bootstrap.min.js" %>
        <%@include file="/bootstrap-4.3.1/js/jquery.min.js" %>
    </script>
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
<header>
    <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
        <a class="navbar-brand">Welcome!!</a>
            <a href="logout?q=logout">
                <button class="btn btn-primary" type="submit">Logout</button>
            </a>
    </nav>
</header>
<div class="container-fluid">
    <div class="row">
        <nav class="col-sm-3 col-md-2 d-none d-sm-block bg-light sidebar">
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Overview
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Reports</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="listHost?q=listHost">Host</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="listUser?q=listUser">Admin</a>
                </li>
            </ul>
        </nav>

        <main role="main" class="col-sm-9 ml-sm-auto col-md-10 pt-3">
            <h1>Dashboard</h1>


            <section class="row text-center placeholders">
                <div class="col-6 col-sm-3 placeholder">
                    <img src="data:image/gif;base64,R0lGODlhAQABAIABAAJ12AAAACwAAAAAAQABAAACAkQBADs=" width="200"
                         height="200" class="img-fluid rounded-circle"
                         alt="Generic placeholder thumbnail">
                    <h4>Running Server</h4>
                    <div class="text-muted">Number of Servers</div>
                </div>

                <form class="form-inline" method="post" action="checkStatus">
                    <input type="hidden" name="q" value="serverStatus">
                    <input class="form-control mr-sm-2" type="text" name="ip" placeholder="IP Address">
                    <button class="btn btn-outline-primary" type="submit">Check</button>
                </form>
                <div class="col-6 col-sm-3 placeholder">
                    <img src="data:image/gif;base64,R0lGODlhAQABAIABAADcgwAAACwAAAAAAQABAAACAkQBADs=" width="200"
                         height="200" class="img-fluid rounded-circle"
                         alt="Generic placeholder thumbnail">
                    <h4>Running Application</h4>
                    <span class="text-muted">Number of Applications</span>
                </div>
                <form class="form-inline" method="post" action="httpStatus">
                    <input type="hidden" name="q" value="httpStatus">
                    <input class="form-control mr-sm-2" type="text" name="url" placeholder="http://example.com"
                           value="http://">
                    <button class="btn btn-outline-primary" type="submit">Check</button>
                </form>
            </section>

            <br>
            <h2>Application On Monitor</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Application</th>
                        <th>IP Address</th>
                        <th>URL</th>
                    </tr>

                    <c:forEach var="host" items="${h}">
                    <tr>
                        <td>${host.appName}</td>
                        <td>${host.ipAddr}</td>
                        <td><a target="_blank" href="">${host.url}</a></td>

                    </tr>
                    </c:forEach>
                </table>
            </div>


            <h2>Server On Monitor</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Server Name</th>
                        <th>Server Address</th>
                    </tr>

                    <c:forEach var="server" items="${s}">
                    <tr>
                        <td>${server.serverName}</td>
                        <td>${server.serverAddr}</td>

                    </tr>
                    </c:forEach>
                </table>
            </div>
        </main>

    </div>
</div>
<c:forEach var="count" items="${hc}">
    <h1>${count.hostCount}</h1>
</c:forEach>
<script src="bootstrap-4.3.1/js/jquery.min.js"></script>
<script src="bootstrap-4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
