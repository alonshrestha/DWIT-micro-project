<%--
  Created by IntelliJ IDEA.
  User: alon
  Date: 3/2/19
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
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
