<%@ page import="Util.User" %>
<%@ page import="DAOImpl.ShopDemoDAOImpl" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/4/25
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
    nav{
        width: 150px;
        height: 100%;
    }
    #h51{
        position: relative;
        color: deepskyblue;
        font-size: 15px;
    }
</style>
<body>
<% User user = new ShopDemoDAOImpl().SearchByName((String) request.getSession().getAttribute("username"));%>
<nav class="navbar navbar-inverse">
    <ul class="nav nav-pills nav-stacked">
        <li style="text-align: center"><h5 id="h51">hi！<%= user.getPetname() %></h5></li>
    <hr color="white"/>
        <li><a href="/ShopDemo_war_exploded/JspPage/PassWordManage.jsp">密码管理</a></li>
        <li><a href="/ShopDemo_war_exploded/JspPage/AddressManage.jsp">收货地址管理</a></li>
        <li><a href="/ShopDemo_war_exploded/JspPage/HistoryShop.jsp">我的订单</a></li>
    </ul>
</nav>
</body>
</html>
