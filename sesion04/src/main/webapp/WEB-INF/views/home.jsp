<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: khanhdao
  Date: 08/04/2026
  Time: 8:07 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>
    <h1>Đây là trong chủ</h1>
    <c:forEach items="${students}" var="student">
        <p>${student.fullName}</p>
    </c:forEach>
</body>
</html>
