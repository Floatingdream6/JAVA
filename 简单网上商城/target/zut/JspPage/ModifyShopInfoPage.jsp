<%@ page import="DAOImpl.ShopDemoDAOImpl" %>
<%@ page import="Util.ShopInfo" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/6/4
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <style>
        body{
            overflow:scroll;
            overflow-x:hidden;
            overflow-y: hidden;
        }
        #div1{
            position: relative;
            top: 20px;
            left: 555px;
        }
        #btn1{
            position: relative;
            width: 100%;
            top: 10px;
        }
        img{
            position: absolute;
            width: 30px;
            height: 30px;
            top: 3px;
        }
    </style>
</head>
<body>
<%
    String shopname = request.getParameter("shopname");
    ShopInfo shop = new ShopDemoDAOImpl().SerachShop(shopname);
%>
<h4 style="position: relative;left: 670px;top: 10px;">修改商品信息</h4>
<img src="/ShopDemo_war_exploded/Image/返回.png" onclick="back();">
<hr style="border: 1.5px solid black;"/>
<div id="div1">
    <div class='input-group'>
        <span class="input-group-addon" id="basic-addon1" style="height: 40px;">商品名称</span>
        <input type='text' id="name" readonly class="form-control" value="<%=shop.getShopname()%>" style="height: 40px;width: 350px;"/>
    </div>
    <br/>
    <br/>
    <div class='input-group'>
        <span class="input-group-addon" id="basic-addon2" style="height: 40px;">商品价格</span>
        <input type='text' id="price" class="form-control" value="<%=shop.getShopprice()%>" style="height: 40px;width: 350px;" onkeyup="clearNoNum(this)"/>
    </div>
    <br/>
    <br/>
    <div class='input-group'>
        <span class="input-group-addon" id="basic-addon3" style="height: 40px;">商品库存</span>
        <input type='text' id="number" class="form-control" value="<%=shop.getShopnumber()%>" style="height: 40px;width: 350px;"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
    </div>
    <br/>
    <br/>
    <div class='input-group'>
        <span class="input-group-addon" id="basic-addon4" style="height: 40px;">商品产地</span>
        <input type='text' id="area" class="form-control" value="<%=shop.getShoparea()%>" style="height:40px;width: 350px;"/>
    </div>
</div>
<nav class="navbar navbar-default navbar-fixed-bottom">
    <button id="btn1" type="button" class="btn btn-danger" onclick="add();">保存</button>
</nav>
<script>
    function back() {
        window.history.back(-1);
    }
    function add() {
        var n =document.getElementById("name").value;
        var p =document.getElementById("price").value;
        var nr =document.getElementById("number").value;
        var a =document.getElementById("area").value;
        if(p!=''&&nr!=''&&a!=''){
            window.location.href="/ShopDemo_war_exploded/Servlet/ModifyShopInfoServlet?shopname="+n+"&price="+p+"&number="+nr+"&area="+a+"";
        }else{
            alert("有项未填写！");
        }
    }
    function clearNoNum(obj) {
        obj.value = obj.value.replace(/[^\d.]/g, "");  //清除“数字”和“.”以外的字符
        obj.value = obj.value.replace(/\.{2,}/g, "."); //只保留第一个. 清除多余的
        obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
        obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/, '$1$2.$3');//只能输入两个小数
        if (obj.value.indexOf(".") < 0 && obj.value != "") {//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额
            obj.value = parseFloat(obj.value);
        }
    }
</script>
</body>
</html>
