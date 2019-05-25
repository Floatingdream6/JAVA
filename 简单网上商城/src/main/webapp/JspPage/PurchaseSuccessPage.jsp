<%@ page import="DAOImpl.ShopDemoDAOImpl" %>
<%@ page import="Util.User" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/5/16
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购买成功</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        div{
            position: absolute;
            top:380px;
            left: 700px;
        }
        #img1{
            position: absolute;
            width: 45px;
            height: 45px;
            top: 8px;
            right: 105px;
        }#h51{
             width: 200px;
             text-align: center;
             position: absolute;
             top: 15px;
             left: 1340px;
         }
    </style>
</head>
<body>
<% User user = new ShopDemoDAOImpl().SearchByName((String)request.getSession().getAttribute("username"));%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
    <a class="navbar-brand" href="#">简易网上商城</a>
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="/ShopDemo_war_exploded/JspPage/SuccessPage.jsp">首页</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/ShopDemo_war_exploded/JspPage/ShopCar.jsp">购物车</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/ShopDemo_war_exploded/JspPage/UserPersonCenter.jsp">个人中心</a>
        </li>
        <li class="nav-item">
            <h5 id="h51" style="color:white;">hi！<%= user.getPetname() %></h5>
        </li>
    </ul>
</nav>
<div>
    <img id="img1" src="/ShopDemo_war_exploded/Image/提交,成功,对号.png"/>
<h5>购买成功！</h5>
<button id="button3" class="btn btn-success btn-sm" onclick="javascript:location.href='/ShopDemo_war_exploded/JspPage/SuccessPage.jsp'">返回首页</button>
</div>
</body>
</html>
