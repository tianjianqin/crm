<%--
  Created by IntelliJ IDEA.
  User: senyint
  Date: 2018/2/9
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>CRM后台系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="icon" href="favicon.ico">
    <link rel="stylesheet" href="layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="statics/css/index1.css" media="all" />
</head>
<body class="main_body childrenBody">
<div class="layui-layout layui-layout-admin">
    <!-- 顶部 -->
    <div class="layui-header header">
        <div class="layui-main mag0">
            <a href="#" class="logo">CRM 1.0</a>
            <!-- 显示/隐藏菜单 -->
            <a href="javascript:;" class="seraph hideMenu icon-caidan"></a>
            <!-- 顶部右侧菜单 -->
            <ul class="layui-nav top_menu">
                <li class="layui-nav-item" pc>
                    <a href="javascript:;" class="clearCache"><i class="layui-icon" data-icon="&#xe640;">&#xe640;</i><cite>清除缓存</cite><span class="layui-badge-dot"></span></a>
                </li>
                <li class="layui-nav-item" id="userInfo">
                    <a href="javascript:;"><img src="statics/images/face.jpg" class="layui-nav-img userAvatar" width="35" height="35"><cite class="adminName">${sessionScope.employee.realname}</cite></a>
                    <dl class="layui-nav-child">
                        <%--<dd><a href="javascript:;" class="updatePassword"><i class="seraph icon-xiugai" data-icon="icon-xiugai"></i><cite>修改密码</cite></a></dd>--%>
                        <dd><a href="javascript:;" data-url="page/changePwd.jsp"><i class="seraph icon-xiugai" data-icon="icon-xiugai"></i><cite>修改密码</cite></a></dd>
                        <dd pc><a href="javascript:;" class="functionSetting"><i class="layui-icon">&#xe620;</i><cite>功能设定</cite><span class="layui-badge-dot"></span></a></dd>
                        <dd pc><a href="javascript:;" class="changeSkin"><i class="layui-icon">&#xe61b;</i><cite>更换皮肤</cite></a></dd>
                        <dd><a href="javascript:;" class="signOut"><i class="seraph icon-tuichu"></i><cite>退出</cite></a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <!-- 左侧导航 -->
    <div class="layui-side layui-bg-black">
        <div class="user-photo">
            <a class="img" title="我的头像" ><img src="statics/images/face.jpg" class="userAvatar"></a>
            <p>你好！<span class="userName">${sessionScope.employee.realname}</span>, 欢迎登录</p>
        </div>
        <div class="navBar layui-side-scroll" id="navBar">
            <ul class="layui-nav layui-nav-tree">
                <li class="layui-nav-item  layui-this">
                    <a href="javascript:;" data-url="page/main.jsp"><i class="layui-icon" data-icon=""></i><cite>后台首页</cite></a>
                </li>

                <c:forEach items="${sessionScope.rightsList}" var="rights">
                    <li class="layui-nav-item">
                        <c:if test="${rights.rid==rights.pid}">
                            <a href="javascript:;">
                                <i class="layui-icon" data-icon="&#xe630">&#xe630;</i>
                                <cite>${rights.name}</cite><span class="layui-nav-more"></span>
                            </a>
                            <c:forEach items="${sessionScope.rightsList}" var="rights1">
                                <c:if test="${rights.pid==rights1.pid && rights.rid!=rights1.rid}">
                                    <dl class="layui-nav-child">
                                        <dd>
                                            <a href="javascript:;" data-url="page/${rights1.url}"><i class="seraph icon-ziliao" data-icon="icon-ziliao"></i><cite>${rights1.name}</cite></a>
                                        </dd>
                                    </dl>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <!-- 右侧内容 -->
    <div class="layui-body layui-form">
        <div class="layui-tab mag0" lay-filter="bodyTab" id="top_tabs_box">
            <ul class="layui-tab-title top_tab" id="top_tabs">
                <li class="layui-this" lay-id=""><i class="layui-icon">&#xe68e;</i> <cite>后台首页</cite></li>
            </ul>
            <ul class="layui-nav closeBox">
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon caozuo">&#xe643;</i> 页面操作</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" class="refresh refreshThis"><i class="layui-icon">&#x1002;</i> 刷新当前</a></dd>
                        <dd><a href="javascript:;" class="closePageOther"><i class="seraph icon-prohibit"></i> 关闭其他</a></dd>
                        <dd><a href="javascript:;" class="closePageAll"><i class="seraph icon-guanbi"></i> 关闭全部</a></dd>
                    </dl>
                </li>
            </ul>
            <div class="layui-tab-content clildFrame">
                <div class="layui-tab-item layui-show">
                    <iframe src="page/main.jsp"></iframe>
                </div>
            </div>
        </div>
    </div>
    <!-- 底部 -->
    <div class="layui-footer footer">
        <p><span>copyright @2018 crm</span></p>
    </div>

    <!-- 修改密码 -->
    <div id="passwordLayer" style="display: none;">
        <form class="layui-form layui-row changePwd">
            <div class="layui-col-xs12 layui-col-sm10 layui-col-md10">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-block">
                        <span class="layui-btn">${employee.username}</span>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">旧密码</label>
                    <div class="layui-input-block">
                        <input type="password" value="" placeholder="请输入旧密码" lay-verify="required|oldPwd" id="oldPwd" class="layui-input pwd">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">新密码</label>
                    <div class="layui-input-block">
                        <input type="password" value="" placeholder="请输入新密码" lay-verify="required|newPwd" id="newPwd" class="layui-input pwd">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">确认密码</label>
                    <div class="layui-input-block">
                        <input type="password" value="" placeholder="请确认密码" lay-verify="required|confirmPwd" id="confirmPwd" class="layui-input pwd">
                    </div>
                </div>
            </div>
        </form>
    </div>

</div>

<!-- 移动导航 -->
<div class="site-tree-mobile"><i class="layui-icon">&#xe602;</i></div>
<div class="site-mobile-shade"></div>

<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/cache.js"></script>
</body>
</html>
