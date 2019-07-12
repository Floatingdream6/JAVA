<%@ page import="java.util.ArrayList" %>
<%@ page import="Util.ShopInfo" %>
<%@ page import="DAOImpl.ShopDemoDAOImpl" %>
<%@ page import="Util.User" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/4/25
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">>
    <style>
        table{
            position: absolute;
            height: 30px;
            top:80px;
        }
        th,td{
            text-align: center;
        }
        input {
            border: 1px solid black;
            width: 35px;
            height: 35px;
            text-align: center;
        }
        #cbx,#check{
            height: 16px;
            width: 16px;
        }
        #button1{
            position: relative;
            top: -2.5px;
            width: 35px;
            height: 35px;
        }
        #button2{
            position: relative;
            top: -2.5px;
            width: 35px;
            height: 35px;
        }
        #button3{
            height: 30px;
            width: 80px;
        }
        #img1{
            position: relative;
            top: 0px;
            right: 1px;
            width: 15px;
            height: 15px;
        }
        #img2{
            position: relative;
            top: 0px;
            right: 1px;
            width: 15px;
            height: 15px;
        }
        #h51{
            width: 200px;
            text-align: center;
            position: absolute;
            top: 15px;
            left: 1340px;
        }
        #in6{
            position: relative;
            top: 560px;
            left:1365px;
            width: 80px;
            border:0px;
            text-align: left;
        }
        #btn1{
            position: relative;
            top:604px;
            left: 1430px;
        }
    </style>
</head>
<body>
<%
    ShopDemoDAOImpl sdl = new ShopDemoDAOImpl();
    User user = sdl.SearchByName((String)request.getSession().getAttribute("username"));
%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
    <a class="navbar-brand" href="#">简易网上商城</a>
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="/ShopDemo_war_exploded/JspPage/SuccessPage.jsp">首页</a>
        </li>
        <li class="nav-item">
            <a class="nav-link">购物车</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/ShopDemo_war_exploded/JspPage/UserPersonCenter.jsp">个人中心</a>
        </li>
        <li class="nav-item">
            <h5 id="h51" style="color:white;">hi！<%= user.getPetname() %></h5>
        </li>
    </ul>
</nav>
<table id="mytable" class="table table-bordered table-hover">
    <tr>
    <th><input type="checkbox" id="check" onclick="javascript:var cbx=document.getElementsByName('cbx');if(document.getElementById('check').checked==true){ for(var i=0;i<cbx.length;i++){ cbx[i].checked=true; }}else{for(var i=0;i<cbx.length;i++){ cbx[i].checked=false; }};cal2()"/></th><th>商品名称</th><th>商品价格</th><th>商品数量</th><th></th>
    </tr>
<%
    String owner =(String) request.getSession().getAttribute("username");
    ArrayList<ShopInfo> list = new ShopDemoDAOImpl().SerachShopCar(owner);
    for(int i=0;i<list.size();i++){
%>
    <tr>
        <td><input id="cbx" name="cbx" type="checkbox" onclick="cal()"/></td>
        <td><%=list.get(i).getShopname()%></td>
        <td><%=list.get(i).getShopprice()%></td>
        <td>
            <button id="button1" class="btn btn-primary btn-sm" onclick="change(this,1);cal1();"><img id="img1" src="/ShopDemo_war_exploded/Image/加号.png"></button>
            <input type="text" id="input1" name="shopnumber" value="<%= list.get(i).getShopnumber() %>" onchange="cal1()" onkeyup="this.value=this.value.replace(/[^\d]/g,'') " onafterpaste="this.value=this.value.replace(/[^\d]/g,'')" oninput="if(value<1)value=1"/>
            <button id="button2" class="btn btn-primary btn-sm" onclick="change(this,-1);cal1();"><img id="img2" src="/ShopDemo_war_exploded/Image/减号.png"></button>
        </td>
        <td>
            <button id="button3" class="btn btn-danger btn-sm" onclick="del(<%=i+1%>)" >删除</button>
        </td>
    </tr>
    <%
        }
    %>
</table>
<nav class="navbar navbar-default navbar-fixed-bottom">
    <button id="btn1" type="button" class="btn btn-danger" onclick="syn();" <%--onclick="javascript:location.href='/ShopDemo_war_exploded/Servlet/AccountsShopCarServlet'"--%>>结算</button>
</nav>
<input id="in6" type="text"  readonly>
<script type="text/javascript">
    function change(btn,n){
        var inputs = btn.parentNode.getElementsByTagName("input");
        var amount = parseInt(inputs[0].value);
        if(amount<=1 && n<0){
            return;
        }
        inputs[0].value = amount + n;
        amount = inputs[0].value;
    }
    function del(num) {
        window.location.href="/ShopDemo_war_exploded/Servlet/ShopCarServlet?n="+num+"";
    }
    function cal() {
        var num=document.getElementsByName("shopnumber");
        var cbx=document.getElementsByName("cbx");
        var in6 = document.getElementById("in6");
        var totalprice=0;
        for(var i = 0;i<cbx.length;i++) {
            if (cbx[i].checked) {
                var price = document.getElementById('mytable').rows[i + 1].cells[2].innerHTML;
                totalprice = totalprice + (price * num[i].value);
            }
        }
        if(totalprice==0){
            in6.value='';
        }else{
            in6.value ='￥'+totalprice;
        }
    }
    function cal1() {
        var in6 = document.getElementById("in6");
        var num=document.getElementsByName("shopnumber");
        var cbx=document.getElementsByName("cbx");
        var totalprice=0;
        for(var i=0;i<num.length;i++) {
            if(!cbx[i].checked){
                continue
            }else{
                var price = document.getElementById('mytable').rows[i+1].cells[2].innerHTML;
                totalprice=totalprice+(num[i].value*price);
            }
        }
        if(totalprice==0){
            in6.value='';
        }else{
            in6.value ='￥'+totalprice;
        }
    }
    function cal2() {
        var in6 = document.getElementById("in6");
        var c = document.getElementById("check");
        var num=document.getElementsByName("shopnumber");
        var totalprice=0;
        if(c.checked){
            for(var i=0;i<num.length;i++) {
                var price = document.getElementById('mytable').rows[i+1].cells[2].innerHTML;
                totalprice=totalprice+(num[i].value*price);
            }
        }else{
            totalprice=0;
        }
        if(totalprice==0){
            in6.value='';
        }else{
            in6.value ='￥'+totalprice;
        }
    }
    function syn() {
        var in6 = document.getElementById("in6");
        var num = document.getElementsByName("shopnumber");
        var b = document.getElementById("btn1");
        if (in6.value == '') {
            alert("未选择商品，无法购买！");
            return;
        } else {
            var list1 = [];
            var list2 = [];
            for (var i = 0; i < num.length; i++) {
                var name = document.getElementById('mytable').rows[i + 1].cells[1].innerHTML;
                list1.push(name);
                list2.push(num[i].value);
            }
            location.href = '/ShopDemo_war_exploded/Servlet/AccountsShopCarServlet?list=' + list1 + '&number=' + list2 + '';
        }
    }
</script>
</body>
</html>
