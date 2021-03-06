<%--
  Created by IntelliJ IDEA.
  User: senyint
  Date: 2018/2/28
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>用户中心</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="../layui/css/public.css" media="all" />
</head>
<body class="childrenBody">
<form class="layui-form">
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" class="layui-input searchVal" placeholder="真实姓名" />
                </div>
                <a class="layui-btn search_btn" data-type="reload">搜索</a>
            </div>
            <div class="layui-inline">
                <a class="layui-btn layui-btn-normal add_btn"><i class="layui-icon"></i>添加用户</a>
            </div>
        </form>
    </blockquote>
    <table id="userList" lay-filter="userList"></table>

    <!--操作-->
    <script type="text/html" id="userListBar">
        <a class="layui-btn layui-btn-xs" lay-event="edit"><i class="layui-icon"></i>编辑</a>
        <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del"><i class="layui-icon"></i>删除</a>
    </script>
</form>
<script type="text/javascript" src="../layui/layui.js"></script>
<script type="text/javascript" src="../layui/employee_list.js"></script>
</body>
</html>