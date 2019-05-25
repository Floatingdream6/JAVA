<%@ page import="DAOImpl.ShopDemoDAOImpl" %>
<%@ page import="Util.Address" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/5/5
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选择收货地址</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        #rec1{
            position: relative;
            right: 205px;
            top:28px;
        }
        #rec3{
            position: relative;
            left:65px;
        }
        #rec4{
            position: absolute;
            color: red;
            font-size: 13px;
            top: 73px;
            left:535px;
        }
        table{
            position: relative;
            text-align: center;
            width: 60%;
        }
        #h1{
            position: relative;
            right: 205px;
            top:28px;
        }
        #rdo1{
            position: absolute;
            top: 55px;
            left:1050px;
            width: 18px;
            height: 18px;
        }
        #rdo2{
             position: absolute;
             top: 55px;
             left:1050px;
             width: 18px;
             height: 18px;
         }
        #btn1{
            width: 100%;
        }

    </style>
</head>
<body>
<%
    ArrayList<Address> list = new ShopDemoDAOImpl().SerchAddress();
    String shopname = request.getParameter("shopname");
    Address ads = new Address();
    for(Address address:list){
        if(address.getAcquiesce().equals("是")){
            ads.setName(address.getName());
            ads.setTelephone(address.getTelephone());
            ads.setAddress(address.getAddress());
        }
    }
%>
<table id="table1" class="table table-bordered table-hover">
    <tr>
    <td>
<h6 id="rec4">[默认地址]</h6>
    <h5 id="rec1"><%= ads.getName() %></h5>
    <h6 id="rec2"><%= ads.getTelephone() %></h6>
    <h6 id="rec3"><%= ads.getAddress() %></h6>
        <input id="rdo1" type="radio" onclick="javascript:location.href='/ShopDemo_war_exploded/JspPage/AccountsPage.jsp?shopname=<%= shopname %>&name=<%= ads.getName() %>'">
    </td>
    </tr>
</table>
  <%
      for(Address add:list){
          if(!add.getAcquiesce().equals("是")){
  %>
<table class="table table-bordered table-hover">
    <tr>
    <td>
        <h5 id="h1"><%= add.getName() %></h5>
    <h6 id="h2"><%= add.getTelephone() %></h6>
    <h6 id="h3"><%= add.getAddress() %></h6>
        <input id="rdo2" type="radio" onclick="javascript:location.href='/ShopDemo_war_exploded/JspPage/AccountsPage.jsp?shopname=<%= shopname %>&name=<%= add.getName() %>'">
    </td>
    </tr>
</table>
<% }
      }
%>
<nav class="navbar navbar-default navbar-fixed-bottom">
    <button id="btn1" type="button" class="btn btn-danger" onclick="javascript:location.href='/ShopDemo_war_exploded/JspPage/AddAddress.jsp?shopname=<%= shopname %>'">新增收货地址</button>
</nav>
</body>
</html>