<%@ page import="java.util.ArrayList" %>
<%@ page import="Util.ShopInfo" %>
<%@ page import="DAOImpl.ShopDemoDAOImpl" %>
<%@ page import="Util.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找结果</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        table{
            width:44%;
            line-height: 40px;
            border:1px solid black;
            position: absolute;
            border-collapse: collapse;
            top:70px;
            left:400px;
        }
        th,td{
            border:1px solid black;
            text-align: center;
        }
        #img2{
            width: 35px;
            height:35px;
        }
        #h61{
            position: absolute;
            width: 100px;
            top: 20px;
            left: 1420px;
            color: white;
        }
    </style>
</head>
<body>
<%
    User user = new ShopDemoDAOImpl().SearchByName((String) request.getSession().getAttribute("username"));
    HttpSession httpSession = request.getSession();
    String message = (String)httpSession.getAttribute("message");
    ArrayList<ShopInfo> list = new ShopDemoDAOImpl().SearchShopinfo(message);
%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top" style="z-index:106;">
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
        <li style="text-align: center">
            <h6 id="h61"><%= user.getPetname() %></h6>
        </li>
    </ul>
</nav>
<div class="col-sm-4" style="width:330px;position: relative;top:10px;left: 1090px;z-index: 140;">
    <div class="input-group">
        <input type="text" id="searchmessage" class="form-control" style="border-radius: 4px;height: 35px;" onkeydown="onKeyDown(event)"/>
        <img id="img2" src="/ShopDemo_war_exploded/Image/搜索.png" onclick="search()">
    </div>
</div>
<table>
    <tr><th>商品名称</th><th>商品价格</th><th>商品数量</th><th>商品产地</th><th>操作</th></tr>
    <%
        for(int i=0;i<list.size();i++){
    %>
    <tr>
        <td><%=list.get(i).getShopname() %></td>
        <td>￥<%=list.get(i).getShopprice()%></td>
        <td><%=list.get(i).getShopnumber() %></td>
        <td><%=list.get(i).getShoparea()%></td>
        <td>
            <button type="button" class="btn btn-success " onclick="javascript:location.href='/ShopDemo_war_exploded/JspPage/AccountsPage.jsp?shopname=<%= list.get(i).getShopname() %>'">购买</button>
            &nbsp;&nbsp;&nbsp;
            <button type="button" class="btn btn-primary" onclick="javascript:alert('添加成功！'); location.href='/ShopDemo_war_exploded/Servlet/AddShopCarServlet?shopname=<%= list.get(i).getShopname() %>'">添加购物车</button>
        </td>
    </tr>
    <%
        }
    %>
</table>
<script>
    function onKeyDown(event){
        var m = document.getElementById("searchmessage");
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if(e && e.keyCode==13){
            if(m.value=='') {
                alert('搜索条件为空！');
            }else{
                window.location.href='/ShopDemo_war_exploded/Servlet/SearchShopServlet?message='+m.value+'';
            }
        }
    }
    function search() {
        var m = document.getElementById("searchmessage");
        if(m.value==''){
            alert('搜索条件为空！');
        }else{
            window.location.href='/ShopDemo_war_exploded/Servlet/SearchShopServlet?message='+m.value+'';
        }
    }
</script>
</body>
</html>
