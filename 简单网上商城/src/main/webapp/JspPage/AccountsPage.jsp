<%@ page import="DAOImpl.ShopDemoDAOImpl" %>
<%@ page import="Util.ShopInfo" %>
<%@ page import="Util.Address" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/4/25
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>确认订单</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.9.1.min.js"></script>
</head>
<style type="text/css">
    table{
        position: absolute;
        top:300px;
        height: 30px;
    }
    th,td{
        text-align: center;
    }
    #input1{
        border:1px solid black;
        width: 35px;
        height: 35px;
        text-align:center;
    }
    #input2{
        position: relative;
        width: 55px;
        height: 45px;
        top: 0px;
        right: 115px;
        border: 1px solid white;
        text-align: center;
    }
    #input3{
        position: absolute;
        top: 14px;
        border: 1px solid white;
        text-align:right;
        width: 50px;
        font-size:85%;
        color: darkgray;
        right: 218px;
    }
    #caldiv{
        position: absolute;
        top:550px;
        right: 80px;
    }
    #h6{
        position: absolute;
        top: 10px;
        right: 120px;
        width: 100px;
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
        position:absolute;
        border-radius:20px;
        width:100px;
        height:38px;
        top:3px;
        right:10px;
        font-color:black;
    }
    #img1{
        position: absolute;
        height: 40px;
        width: 40px;
        top: 80px;
        left: 550px;
    }
    #img2{
        position: absolute;
        height: 20px;
        width: 20px;
        top: 90px;
        right: 500px;
    }
    #img3{
        position: absolute;
        height: 45px;
        width: 45px;
        top: 82px;
        left: 540px;
    }
    #img4{
        position: absolute;
        height: 20px;
        width: 20px;
        top: 90px;
        right: 475px;
    }
    #img5{
        position: relative;
        top: 0px;
        right: 1px;
        width: 15px;
        height: 15px;
    }
    #img6{
        position: relative;
        top: 0px;
        right: 1px;
        width: 15px;
        height: 15px;
    }
    #img10{
        position: absolute;
        width: 35px;
        height: 35px;
        top: 5px;
        left: 5px;
    }
    #div1{
        position: absolute;
        width: 100%;
        height: 15px;
        background-color: lightgray;
        top: 250px;
    }
    #rec1{
        position: absolute;
        border:0px solid white;
        width: 65px;
        font-size: 120%;
        top: 73px;
        left:595px ;
    }
    #rec2{
        position: absolute;
        border:0px solid white;
        font-size: 100%;
        width:100px;
        top: 81px;
        left:675px;
    }
    #rec3{
        position: absolute;
        border:0px solid white;
        width: 500px;
        font-size: 80%;
        top: 106px;
        left: 595px;
    }
    #rec4{
        position: absolute;
        color: red;
        font-size: 13px;
        top: 104px;
        left:593px;
        display: block;
    }
    #rec5{
        position: absolute;
        border:0px solid white;
        width: 65px;
        font-size: 120%;
        top: 73px;
        left:595px ;
    }
    #rec6{
        position: absolute;
        border:0px solid white;
        font-size: 100%;
        width:100px;
        top: 81px;
        left:675px;
    }
    #rec7{
        position: absolute;
        border:0px solid white;
        width: 500px;
        font-size: 80%;
        top: 106px;
        left: 656px;
    }
</style>
<body onload="cal();acount()">
<img id="img10" src="/ShopDemo_war_exploded/Image/返回.png" onclick="back()">
<%
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    ArrayList<Address> list = new ShopDemoDAOImpl().SerchAddress();
    String name = request.getParameter("name");
    String shopname = request.getParameter("shopname");
    ShopInfo shopinfo = new ShopDemoDAOImpl().SerachShop(shopname);
    Address ads = null;
    if(name==null) {
        ads = new Address();
        for (Address address : list) {
            if (address.getAcquiesce().equals("是")) {
                ads.setName(address.getName());
                ads.setTelephone(address.getTelephone());
                ads.setAddress(address.getAddress());
            }
        }
%>
<div>
    <img id="img3" src="/ShopDemo_war_exploded/Image/地址.png">
    <a href="AddressPage.jsp?shopname=<%= shopname %>"><img id="img4" src="/ShopDemo_war_exploded/Image/右箭头.png"></a>
    <h6 id="rec4">[默认地址]</h6>
    <h5 id="rec5"><%= ads.getName() %></h5>
    <h6 id="rec6"><%= ads.getTelephone() %></h6>
    <h6 id="rec7"><%= ads.getAddress() %></h6>
</div>
<%
}else{
    ads = new ShopDemoDAOImpl().SearchAddress(name);
%>
<div>
    <img id="img1" src="/ShopDemo_war_exploded/Image/地址.png">
    <a href="AddressPage.jsp?shopname=<%= shopname %>"><img id="img2" src="/ShopDemo_war_exploded/Image/右箭头.png"></a>
    <h5 id="rec1"><%= ads.getName() %></h5>
    <h6 id="rec2"><%= ads.getTelephone() %></h6>
    <h6 id="rec3"><%= ads.getAddress() %></h6>
</div>
<%
    }
%>
<div id="div1">
</div>
<table class="table table-bordered table-hover">
    <tr><th>商品名称</th><th>商品价格</th><th>商品数量</th></tr>
    <tr>
        <td><%=shopname%></td>
        <td><%=shopinfo.getShopprice()%></td>
        <td>
            <button id="button1" class="btn btn-primary btn-sm" onclick="add();acount()" onmouseup="cal1()"><img id="img5" src="/ShopDemo_war_exploded/Image/加号.png"></button>
            <input type="text" id="input1" name="shopnumber" value="1" onblur="limit();cal();acount()" onkeyup="this.value=this.value.replace(/[^\d]/g,'') " onafterpaste="this.value=this.value.replace(/[^\d]/g,'')"/>
            <button id="button2" class="btn btn-primary btn-sm" onclick="cut();acount()" onmouseup="cal2()"><img id="img6" src="/ShopDemo_war_exploded/Image/减号.png"></button>
        </td>
    </tr>
</table>
<div id="caldiv">
    <input id="input3" readonly="readonly"/>
    <strong><h5 id="h6" style="display: none">合计:</h5></strong>
    <input id="input2" style="display: none" readonly="readonly"/>
    <button id="button3" class="btn btn-danger btn-sm" onclick="shopnumbercut()">提交订单</button>
</div>
<script type="text/javascript">
    function add()
    {
        var txt=document.getElementById('input1');
        var a=txt.value;
        if(a>=<%= shopinfo.getShopnumber() %>)
        {
            alert('亲，该商品不能购买更多哟！');
        }
        else
        {
            a++;
            txt.value=a;
        }

    }
    function cut()
    {
        var txt=document.getElementById('input1');
        var b=txt.value;
        if(b<=1)
        {
            alert('对不起，购买数量不能为0！');
        }
        else
        {
            b--;
            txt.value=b;
        }
    }
    function limit() {
        var n = document.getElementById("input1");
        var num = n.value;
        if(num><%= shopinfo.getShopnumber() %>){
            alert("亲，该商品不能购买更多哟！");
            n.value=1;
        }
    }
    function cal() {
        var num1 = document.getElementById("input1").value;
        var num2 = <%= shopinfo.getShopprice() %>;
        var price = document.getElementById("input2");
        var h = document.getElementById("h6");
        if(num1<=<%= shopinfo.getShopnumber() %>){
            price.value='￥'+num1*num2;
            price.style.display='block';
            h.style.display='block';
        }
    }
    function cal1() {
        var num1 = document.getElementById("input1").value;
        var num2 = <%= shopinfo.getShopprice() %>;
        var n1 = parseFloat(num1);
        var n2 = parseFloat(num2);
        var price = document.getElementById("input2");
        var h = document.getElementById("h6");
        if(num1<<%= shopinfo.getShopnumber() %>){
            price.value='￥'+(n1+1)*n2;
            price.style.display='block';
            h.style.display='block';
        }else if(num1==''){
            price.value='￥'+1*n2;
            price.style.display='block';
            h.style.display='block';
        }
    }
    function cal2() {
        var num1 = document.getElementById("input1").value;
        var num2 = <%= shopinfo.getShopprice() %>;
        var n1 = parseFloat(num1);
        var n2 = parseFloat(num2);
        var price = document.getElementById("input2");
        var h = document.getElementById("h6");
        if(num1>1){
            price.value='￥'+(n1-1)*n2;
            price.style.display='block';
            h.style.display='block';
        }else if(num1==''){
            price.value='￥'+1*n2;
            price.style.display='block';
            h.style.display='block';
        }
    }
    function acount() {
        var num1 = document.getElementById("input1").value;
        var num2 = document.getElementById("input3");
        if(num1 > <%= shopinfo.getShopnumber() %>){
            num1 = 1;
            num2.value = '共'+num1+'件，';
        }else if(num1==''){
            num2.value = '共'+0+'件，';
        }else{
            num2.value = '共'+num1+'件，';
        }
    }
    function back() {
        window.history.back(1);
    }
    function shopnumbercut(){
        var n = document.getElementById("input1").value;
        window.location.href="/ShopDemo_war_exploded/Servlet/ShopNumberCutServlet?shopname=<%= shopname %>&number="+n+"";
    }
</script>
</body>
</html>
