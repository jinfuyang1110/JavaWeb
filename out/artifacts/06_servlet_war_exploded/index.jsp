<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 57206
  Date: 2021/1/17
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set scope="request" var="ab" value="123"/>
${requestScope.ab}
<c:forEach begin="0" end="32" var="i">
    ${i}<br/>
</c:forEach>
</body>
</html>
