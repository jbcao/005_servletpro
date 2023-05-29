<%--
  功能：
  User: apple
  Date: 1.6.22
  Time: 1:16 AM
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>
    <%--一个页面，css可以引入多个--%>
    <link rel="stylesheet" href="css/common.css" type="text/css">
    <link rel="stylesheet" href="css/index.css" type="text/css">
</head>
<body>
<div class="top"><img src="img/top.jpg"></div>
<%--中间左边部分  --%>
<div class="us-mid-left">
    <%--广告信息头--%>
    <div class="ad_info_title">
        <span><img src="img/xd.jpg"><font class="font-style1">推荐企业广告信息</font></span>
    </div>
    <%--快速信息检索头--%>
    <div class="ad-info-list">
        <ul>
            <li><a href="#">- 上海明天会更好。。。</a></li>
            <li><a href="#">- 上海明天会更好。。。</a></li>
            <li><a href="#">- 上海明天会更好。。。</a></li>
            <li><a href="#">- 上海明天会更好。。。</a></li>
        </ul>
    </div>
    <%--快速信息检索头--%>
    <div class="ad_info_search">
        <span><img src="img/xd.jpg"><font class="font-style1">快速信息检索头</font></span>
    </div>
    <%--信息检索表单--%>
    <div class="info-search">
        <table>
            <tr>
                <td>关键字</td>
                <td><input type="text" name="keyword"/></td>
            </tr>
            <tr>
                <td>条件</td>
                <td><select>
                    <option value="qz">求职信息</option>
                    <option value="zp">招聘信息</option>
                    <option value="jj">家教信息</option>
                </select></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="image" src="img/button.jpg"></td>
            </tr>
        </table>
    </div>
    <%--联系我们--%>
    <div class="contact-us">
        <span><img src="img/xd.jpg"><font class="font-style1">联系我们</font></span>
    </div>
    <div class="contact-info">
        <span>
            <font class="font-style2">及时雨网</font><br/>
            <hr class="underLine-style"/>
            地址：XXX<br/>
            电话：XXX<br/>
            邮编：XXX<br/>
        </span>
    </div>
</div>
<%--中右--%>
<div class="us-mid-right">
    <div class="pay-title">

    </div>
    <div class="pay-info-con">
        <table>
            <tr>
                <td><font class="font-style2">「求职信息」</font> <font class="font-style3">我是一个求职人</font> <font
                        class="font-style4">2010-11-14 12：09：30</font></td>
            </tr>
            <tr>
                <td style="text-indent: 2em"><font class="font-style5">你好hellokkkkkkkkkkkkkkkllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll</font>
                </td>
            </tr>
            <tr>
                <td><font class="font-style3">联系人：111 联系电话：999</font></td>
            </tr>
            <tr>
                <td>
                    <hr/>
                </td>
            </tr>
        </table>
    </div>
    <%--广告位--%>
    <div class="ad-con">
        <img src="img/ad.jpg">

    </div>
    <%--免费专区 --%>
    <div class="free-title">

    </div>
    <%--免费信息--%>
    <div class="free-info-con">
        <table>
            <tr>
                <td><font class="font-style2">「求职信息」</font> <font class="font-style3">我是一个求职人</font> <font
                        class="font-style4">2010-11-14 12：09：30</font></td>
            </tr>
            <tr>
                <td style="text-indent: 2em"><font class="font-style5">你好hellokkkkkkkkkkkkkkkllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll</font>
                </td>
            </tr>
            <tr>
                <td><font class="font-style3">联系人：111 联系电话：999</font></td>
            </tr>
            <tr>
                <td>
                    <hr/>
                </td>
            </tr>
        </table>

        <table>
            <tr>
                <td><font class="font-style2">「求职信息」</font> <font class="font-style3">我是一个求职人</font> <font
                        class="font-style4">2010-11-14 12：09：30</font></td>
            </tr>
            <tr>
                <td style="text-indent: 2em"><font class="font-style5">你好hellokkkkkkkkkkkkkkkllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll</font>
                </td>
            </tr>
            <tr>
                <td><font class="font-style3">联系人：111 联系电话：999</font></td>
            </tr>
            <tr>
                <td>
                    <hr/>
                </td>
            </tr>
        </table>


        <table>
            <tr>
                <td><font class="font-style2">「求职信息」</font> <font class="font-style3">我是一个求职人</font> <font
                        class="font-style4">2010-11-14 12：09：30</font></td>
            </tr>
            <tr>
                <td style="text-indent: 2em"><font class="font-style5">你好hellokkkkkkkkkkkkkkkllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll</font>
                </td>
            </tr>
            <tr>
                <td><font class="font-style3">联系人：111 联系电话：999</font></td>
            </tr>
            <tr>
                <td>
                    <hr/>
                </td>
            </tr>
        </table>
        <span class="pagenavi">共3条 每页显示4条 第1页/共1页</span>
    </div>
</div>
<%--首页底部--%>
<div class="us-bottom">
    <span ><font class="font-style6">网络 版权信息  编号00000</font></span>
</div>
</html>
