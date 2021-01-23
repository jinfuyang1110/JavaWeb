<%--
  Created by IntelliJ IDEA.
  User: 57206
  Date: 2021/1/17
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- base标签永远固定相对路径跳转的结果-->
<%--动态获取base标签--%>
<%
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
    pageContext.setAttribute("basePath",basePath);
%>
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<style type="text/css">
    .login_form {
        height: 420px;
        margin-top: 25px;
    }
</style>
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>