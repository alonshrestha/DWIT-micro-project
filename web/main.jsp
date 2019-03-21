<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style type="text/css">
        <%@include file="css/main.css" %>
        <%@include file="bootstrap-4.3.1/css/bootstrap.min.css" %>
        <%@include file="bootstrap-4.3.1/css/bootstrap-grid.min.css" %>
    </style>
    <script type="text/javascript">
        <%@include file="bootstrap-4.3.1/js/bootstrap.min.js" %>
        <%@include file="bootstrap-4.3.1/js/jquery.min.js" %>
    </script>
</head>
<body>
<div class="container-fluid">

    <div class="row">
        <div class="col-sm-9 " align="center">
            <div class="jumbotron">
                <h1>Contact Us</h1>
                <form method="post" action="sendDetail">
                    <input type="text" name="name" placeholder="Your Name"><br>
                    <input type="text" name="batch" placeholder="Your Batch"><br>
                    <input type="text" name="cc" placeholder="Your Email @deerwalk.edu.np"><br>
                    <input type="text" name="subject" placeholder="Your Subject"><br>
                    <textarea type="text" name="message" placeholder="Enter Your Problem Here"></textarea><br><br>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
        <div class="col-sm-3" align="center">
            <div class="jumbotron">
                <form method="post" action="login">
                    <h1>Login</h1>
                    <input type="hidden" name="q" value="listHost">
                    <input style="align-items: center" type="email" name="email" placeholder="Your Email" required="required"><br>
                    <input type="password" name="password" required="required" placeholder="Password"><br><br>
                    <button type="submit" class="btn btn-primary">Login</button>
                </form>
            </div>
        </div>
    </div>
</div>
<% String message = (String)request.getAttribute("alertMsg");
if (message == null){
    request.getRequestDispatcher("main.jsp").forward(request,response);
}
%>
<script type="text/javascript">
    var msg = "<%=message%>";
    alert(msg);
</script>
<script src="bootstrap-4.3.1/js/jquery.min.js"></script>
<script src="bootstrap-4.3.1/js/bootstrap.min.js"></script>
</body>
</html>