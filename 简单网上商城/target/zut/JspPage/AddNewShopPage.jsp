<%@ page import="Util.ShopInfo" %>
<%@ page import="DAOImpl.ShopDemoDAOImpl" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/6/4
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增商品</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css">
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
<h4 style="position: relative;left: 670px;top: 10px;">新增商品信息</h4>
<img src="/ShopDemo_war_exploded/Image/返回.png" onclick="back();">
<hr style="border: 1.5px solid black;"/>
<div id="div1">
    <div class="col-lg-3">
        <input type="text" name="shopname" id="name" class="form-control" aria-describedby="sizing-addon2" placeholder="请输入商品名称"/>
    </div>
    <br/>
    <br/>
    <div class="col-lg-3">
        <input type="text" name="price" id="price" class="form-control" aria-describedby="sizing-addon2" placeholder="请输入商品价格" onkeyup="clearNoNum(this)"/>
    </div>
    <br/>
    <br/>
    <div class="col-lg-3">
    <input type="text" name="number" id="number" class="form-control" aria-describedby="sizing-addon2" placeholder="请输入商品库存"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
    </div>
    <br/>
    <br/>
    <div class="col-lg-3">
    <input type="text" name="area" id="area" class="form-control" aria-describedby="sizing-addon2" placeholder="请输入商品产地"/>
    </div>
    <br/>
    <br/>
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
        if(n!=''&&p!=''&&nr!=''&&a!=''){
            window.location.href="/ShopDemo_war_exploded/Servlet/AddShopServlet?shopname="+n+"&price="+p+"&number="+nr+"&area="+a+"";
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
