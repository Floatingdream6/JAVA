<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/4/28
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        #div1{
            position: relative;
            top: 320px;
            left: 500px;
        }
        #btn1{
            width: 32%;
        }
        #input1{
            position: relative;
            top: 25px;
            left: 20px;
            width: 18px;
            height: 18px;
        }
        #h61{
            position: relative;
            left: 50px;
        }
        #a1{
            position: absolute;
            top:243px;
            left:177px;
            font-size: 13px;
        }
        #img1{
            position: absolute;
            left: 580px;
            width: 300px;
            height: 300px;
        }
        #img2{
            position: absolute;
            width: 25px;
            height: 25px;
            top: 7px;
            left: 500px;
            display: none;
        }
        #img3{
            position: absolute;
            width: 25px;
            height: 25px;
            top: 7px;
            left: 500px;
            display: none;
        }
        #img4{
             position: absolute;
             width: 25px;
             height: 25px;
             top: 7px;
             left: 500px;
             display: none;
         }
        #img5{
            position: absolute;
            width: 25px;
            height: 25px;
            top: 7px;
            left: 500px;
            display: none;
        }
    </style>
</head>
<body>
<img id="img1" src="/ShopDemo_war_exploded/Image/logo.jpg">
<div id="div1">
    <div class="col-lg-4">
        <input type="text" id="name" class="form-control" placeholder="用户名" aria-describedby="sizing-addon2" >
    </div>
    <br/>
    <div class="col-lg-4">
        <input type="text" id="id" class="form-control" placeholder="账号" aria-describedby="sizing-addon2" onkeyup="value=value.replace(/[^\d]/g,'')">
    </div>
    <br/>
    <div class="col-lg-4">
        <img id="img2" src="/ShopDemo_war_exploded/Image/对号.png">
        <img id="img4" src="/ShopDemo_war_exploded/Image/错号.png">
        <input type="password" id="p1" class="form-control" placeholder="密码" aria-describedby="sizing-addon2" onkeyup="check1();value=value.replace(/[^\w\.\/]/ig,'')" onchange="check1()">
    </div>
    <br/>
    <div class="col-lg-4">
        <img id="img3" src="/ShopDemo_war_exploded/Image/对号.png">
        <img id="img5" src="/ShopDemo_war_exploded/Image/错号.png">
        <input type="password" id="p2" class="form-control" placeholder="确认密码" aria-describedby="sizing-addon2" onkeyup="check2();value=value.replace(/[^\w\.\/]/ig,'')" onchange="check2();">
    </div>
        <input id="input1" type="checkbox">
    <h5 id="h61">我已阅读协议</h5>
    <a id="a1" href="https://www.taobao.com/go/chn/member/agreement.php">《用户服务协议》</a>
    <nav class="navbar navbar-default navbar-fixed-bottom">
        <button id="btn1" type="button" class="btn btn-danger" onclick="check3()">注册</button>
    </nav>
</div>
<script type="text/javascript">
    function check1()
    {
        var p1 = document.getElementById("p1");
        var i1 = document.getElementById("img4");
        var i2 = document.getElementById("img2");
        var n1 = p1.value;
        if(n1.length<6){
            i1.style.display='block';
            i2.style.display='none';
        }else{
            i1.style.display='none';
            i2.style.display='block';
        }
    }
    function check2() {
        var p1 = document.getElementById("p1");
        var p2 = document.getElementById("p2");
        var n1 = p1.value;
        var n2 = p2.value;
        var i3 = document.getElementById("img3");
        var i4 = document.getElementById("img5");
        if (n2.length < 6 || n1 != n2) {
            i3.style.display = 'none'
            i4.style.display = 'block';
        } else {
            i3.style.display = 'block';
            i4.style.display = 'none';
        }
    }
    function check3() {
        var val1 = document.getElementById("name").value;
        var val2 = document.getElementById("id").value;
        var val3 = document.getElementById("p1").value;
        var val4 = document.getElementById("p2").value;
        var check = document.getElementsByTagName("input")[4];
        if(!check.checked){
            alert("请阅读协议！");
        }else{
            if(val1==""&&val2==""&&val2==""){
                alert("有项填写不完整！");
            }else{
                if(val3!=val4){
                    alert("两次密码填写不一致！");
                }else{
                    window.location.href="/ShopDemo_war_exploded/Servlet/AddUserServlet?name="+val1+"&id="+val2+"&password="+val3+"";
                }
            }

        }
    }
</script>
</body>
</html>
