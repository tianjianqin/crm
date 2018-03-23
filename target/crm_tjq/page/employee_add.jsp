<%--
  Created by IntelliJ IDEA.
  User: senyint
  Date: 2018/3/2
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>添加用户</title>
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
<form class="layui-form" style="width:80%;">
    <input type="hidden" class="layui-input id" name="id">
    <div class="layui-form-item layui-row layui-col-md8 layui-col-xs12">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input username" lay-verify="required" placeholder="请输入用户名">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-md8 layui-col-xs12">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input password" lay-verify="required" placeholder="请输入登录密码">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-md8 layui-col-xs12">
        <label class="layui-form-label">昵称</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input nickname" lay-verify="required" placeholder="请输入用户昵称">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-md8 layui-col-xs12">
        <label class="layui-form-label">真实姓名</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input realname" lay-verify="required" placeholder="请输入真实姓名">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-md8 layui-col-xs12">
        <label class="layui-form-label">状态</label>
        <div class="layui-input-block workstatu">
            <input type="radio" name="workstatu" value="1" title="在职" checked>
            <input type="radio" name="workstatu" value="0" title="离职">
        </div>
    </div>
    <div class="layui-row">
        <div class="magb15 layui-col-md4 layui-col-xs12">
            <label class="layui-form-label">部门</label>
            <div class="layui-input-block">
                <select name="departmentid" lay-verify="required" class="departmentid" lay-filter="departmentid">

                </select>
            </div>
        </div>
        <div class="magb15 layui-col-md4 layui-col-xs12">
            <label class="layui-form-label">职位</label>
            <div class="layui-input-block">
                <select name="jobinfoid" lay-verify="required" class="jobinfoid" lay-filter="jobinfoid">

                </select>
            </div>
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-md8 layui-col-xs12">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input phoneno" lay-verify="phone" placeholder="请输入手机号">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-md8 layui-col-xs12">
        <label class="layui-form-label">办公电话</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input officetel" lay-verify="required" placeholder="请输入办公电话">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-sm" lay-submit="" lay-filter="addEmployee">确定</button>
            <button type="reset" class="layui-btn layui-btn-sm layui-btn-primary">取消</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="../layui/layui.js"></script>
<script type="text/javascript" src="../layui/employee_add.js"></script>
</body>
</html>
