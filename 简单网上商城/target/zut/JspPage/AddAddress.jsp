<%@ page import="Util.Address" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/5/5
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增收货地址</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        #div1{
            position: relative;
            top: 10px;
            left: 500px;
        }
        #div2{
            position: absolute;
            top: 116px;
            left: 15px;
            height: 20px;
        }
        #one{
            border-radius: 5px;
            height: 40px;
            width: 158px;
        }
        #two{
            border-radius: 5px;
            height: 40px;
            width: 158px;
        }
        #three{
            border-radius: 5px;
            height: 40px;
            width: 158px;
        }
        #btn1{
            width: 100%;
        }
        #ads{
            font-size: 15px;
        }
    </style>
</head>
<body>
<div id="div1">
<div class="col-lg-4">
    <input type="text" name="receivername" id="name" class="form-control" placeholder="收货人姓名" aria-describedby="sizing-addon2" >
</div>
<br/>
<div class="col-lg-4">
    <input type="text" name="telephone" id="tel" class="form-control" placeholder="手机号码" aria-describedby="sizing-addon2" >
</div>
<br/><br/>
    <br/>
    <div id="div2">
        <select class="sheng" id="one" name="province">
            <option>省</option>
        </select>
        <select class="shi" id="two" name="city">
            <option>市</option>
        </select>
        <select class="qu" id="three" name="area">
            <option>区</option>
        </select>
    </div>
<div class="col-lg-4">
    <input type="text" name="street" id="stt" class="form-control" placeholder="街道" aria-describedby="sizing-addon2"  onchange="getsmtg()">
</div>
<br/>
<div class="col-lg-4">
    <input type="text" name="zopcode" id="zopcode" class="form-control" placeholder="邮政编码" aria-describedby="sizing-addon2" >
</div>
<br/>
<div class="col-lg-4">
    <input type="text" name="address" id="ads" class="form-control" placeholder="详细地址" aria-describedby="sizing-addon2">
</div>
</div>
<br/>
<nav class="navbar navbar-default navbar-fixed-bottom">
    <button id="btn1" type="button" class="btn btn-danger" onclick="judge()">保存</button>
</nav>
<script type="text/javascript">

        var shengSelect =document.querySelector(".sheng");
        var shiSelect =document.querySelector(".shi");
        var quSelect =document.querySelector(".qu");

        var shenglist=['河南省','广西省','广东省','湖北省'];
        var shilist=[['郑州市','开封市','洛阳市','焦作市'],['南宁市','桂林市','柳州市'],['广州市','深圳市','东莞市'],['武汉市','荆门市','襄阳市']];
        var qulist=[
            [['中原区','二七区','金水区',',惠济区','管城区','上街区','巩义市','新郑市','登封市','荥阳市','新密市','中牟县'],['龙亭区','鼓楼区','禹王台区','顺河区','祥符区','兰考县','通许县','杞县','尉氏县'],['涧西区','西工区','老城区','瀍河区','洛龙区','吉利区','偃师市','宜阳县','孟津县','新安县','洛宁县','栾川县','伊川县','汝阳县','嵩县'],['山阳区','中站区','解放区','马村区','沁阳市','孟州市','修武县','博爱县','武陟县','温县']],
            [['南1区','南2区','南3区'],['桂1区','桂2区','桂3区'],['柳1区','柳2区','柳3区']],
            [['广1区','广2区','广3区'],['深1区','深2区','深3区'],['东1区','东2区']],
            [['武1区','武2区','武3区'],['荆1区','荆2区','荆3区'],['襄1区','襄2区','襄3区']]
        ];
        //选择省的下标
        var shengIndex =0;
        //加载省
        for(var i=0;i<shenglist.length;i++){
            var shengOption = new Option(shenglist[i]);
            shengSelect.options.add(shengOption);
        }
        //选择省后加载市
        shengSelect.onchange =function(){
            shengIndex =this.selectedIndex-1;
            if(shengIndex == -1){
                shiSelect.options.length = 0;
                quSelect.options.length = 0;
                shiSelect.options.add(new Option('市'));
                quSelect.options.add(new Option('区'));
            }else{
                shiSelect.options.length = 0;
                quSelect.options.length = 0;
                for(var j=0;j<shilist.length;j++){
                    var shiOption =new Option(shilist[shengIndex][j]);
                    shiSelect.options.add(shiOption);
                }
                //加载市的同时，加载第一个市的全部区
                for(var k=0;k<qulist[shengIndex][0].length;k++){
                    var quOption =new Option(qulist[shengIndex][0][k]);
                    quSelect.options.add(quOption);
                }
            }
        }
        //选择市后加载区
        shiSelect.onchange=function(){
            var shiIndex =this.selectedIndex;
            quSelect.options.length =0;
            for(var n =0;n<qulist[shengIndex][shiIndex].length;n++){
                var quOption =new Option(qulist[shengIndex][shiIndex][n]);
                quSelect.options.add(quOption);
            }
        }
        function getsmtg() {
            var myselect1 = document.getElementById("one");
            var myselect2 = document.getElementById("two");
            var myselect3 = document.getElementById("three");
            var n = document.getElementById("ads");
            var st = document.getElementById("stt");
            var index1 = myselect1.selectedIndex;
            var index2 = myselect2.selectedIndex;
            var index3 = myselect3.selectedIndex;
            var v1 = myselect1.options[index1].value;
            var v2 = myselect2.options[index2].value;
            var v3 = myselect3.options[index3].value;
            n.value=v1+v2+v3+st.value;
        }
        function judge() {
            var myselect1 = document.getElementById("one");
            var myselect2 = document.getElementById("two");
            var myselect3 = document.getElementById("three");
            var n = document.getElementById("ads");
            var st = document.getElementById("stt");
            var index1 = myselect1.selectedIndex;
            var index2 = myselect2.selectedIndex;
            var index3 = myselect3.selectedIndex;
            var v1 = myselect1.options[index1].value;
            var v2 = myselect2.options[index2].value;
            var v3 = myselect3.options[index3].value;
            var v4 = document.getElementById("name");
            var v5 = document.getElementById("tel");
            var v6 = document.getElementById("stt");
            var v7 = document.getElementById("zopcode");
            if(v4.value==""){
                alert("请填写收货人姓名！");
            }
            if(v5.value==""){
                alert("请填写手机号码！");
            }
            if(v1=="省"||v2=="市"||v3=="区"){
                alert("请选择省市区！");
            }
            if(v6.value==""){
                alert("请填写街道！");
            }
            if(v7.value==""){
                alert("请填写邮政编码！");
            }
            if(v1!="省"&&v2!="市"&&v3!="区"&&v4.value!=""&&v5.value!=""&&v6.value!=""&&v7.value!=""){
                window.location.href="/ShopDemo_war_exploded/Servlet/AddaddressServlet?name="+v4.value+"&tel="+v5.value+"&address="+n.value+"&zopcode="+v7.value+"";
            }
        }
</script>
</body>
</html>
