<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%-- 静态包含base标签，css样式、jQuery --%>
    <%@include file="/pages/common/head.jsp" %>
</head>
<script type="text/javascript">
	$(function (){
		$(".cart_delete").click(function (){
			return confirm("你确定要删除【"+$(this).parent().parent().find("td:first").text()+"】吗？")
		});
		$("a.cart_clear").click(function (){
			return confirm("你确定要清空购物车吗？")
		});
		$("input.updateCount").change(function (){
			var name = $(this).parent().parent().find("td:first").text();
			var id = $(this).attr("bookId");
			var count = this.value;
			if (confirm("你确定要将【"+name+"】商品数量修改为："+count+"吗？")){
				location.href="${pageScope.basePath}CarServlet?action=updateCount&id="+id+"&count="+count;
			}else {
				this.value=this.defaultValue;
			}
		});
	});
</script>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <div>
        <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
        <a href="pages/order/order.jsp">我的订单</a>
        <a href="index.jsp">注销</a>&nbsp;&nbsp;
        <a href="index.jsp">返回</a>
    </div>
</div>

<div id="main">
    <c:if test="${empty sessionScope.cart.items}">
        <h1 align="center"><a href="index.jsp" style="color: red;"> 购物车空空如也~~~，快去挑选东西吧</a>
        </h1>
    </c:if>
    <c:if test="${not empty sessionScope.cart.items}">
        <table>
            <tr>
                <td>商品名称</td>
                <td>数量</td>
                <td>单价</td>
                <td>金额</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td><input type="text" class="updateCount" bookId="${entry.value.id}"
							   value="${entry.value.count}"
							   style="width: 50px;text-align: center"></td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a class="cart_delete" href="${pageScope.basePath}CarServlet?action=delete&id=${entry.value.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>

        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a class="cart_clear" href="${pageScope.basePath}CarServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
        </div>
    </c:if>
</div>

<%-- 静态包含页脚内容 --%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>