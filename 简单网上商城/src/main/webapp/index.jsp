<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style type="text/css">
form{
    position: absolute;
    top: 250px;
    right:680px;
}
#btn{
    position: absolute;
    top: px;
    right: px;
}
.jumbotron{
    width: 400px;
    height: 280px;
    background-color:lightblue;
    opacity: 0.5;
}
.container{
    position: absolute;
    top:220px;
    left:550px;
}
body{
    overflow: hidden;
    background-image: url("Image/timg.jpg");
    background-repeat: no-repeat;
    background-size: 100% 100%;
}
    </style>
</head>
<body>
<div class="container">
<div class="jumbotron"></div></div>
<form action="Servlet/LoginCheckServlet" method="post">
    <h5>用户名：</h5>
    <input type="text" name="username" class="form-control" placeholder="请输入用户名" required/><br/>
    <h5>密码：</h5><input type="password" name="password" class="form-control" placeholder="请输入密码" required/><br/>
    <button id="btn" type="submit" class="btn btn-info" value="登录">登录</button>
</form>
</body>
</html>
