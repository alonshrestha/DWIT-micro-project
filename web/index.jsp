<%--
  Created by IntelliJ IDEA.
  User: alon
  Date: 2/12/19
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body style="background-color: gainsboro">
<div  style="position:relative; float: right ;  ">
<form method="post" action="login">
    Email<br>
    <input style="align-items: center" type="email" name="email" required="required"><br>
    Password<br>
    <input type="password" name="password"  required="required"><br><br>
    <input  type="submit" value="Login"><br>
    <a href="register?q=register">Register ?</a>

</form>
</div>

<div  align="center">
    <form method="post" action="sendDetail">
        <input type="text" name="name" placeholder="Your Name"><br>
        <input type="text" name="batch" placeholder="Your Batch"><br>
        <input type="text" name="cc" placeholder="Your Email @deerwalk.edu.np"><br>
        <input type="text" name="subject" placeholder="Your Subject"><br>
        <input type="text" name="message" placeholder="Enter Your Problem Here"><br>
        <input type="submit" value="Send">
    </form>

</div>
</body>
</html>