<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: khanhdao
  Date: 06/04/2026
  Time: 7:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Titile</h1>
    <table border="1">
        <tr>
            <th>STT</th>
            <th>Họ tên</th>
            <th>Điểm</th>
            <th>Xếp loại</th>
        </tr>
        <c:forEach var="sv" items="${svList}"> varStatus="loop">
            <tr>
                <td>${loop.index+1}</td>
                <td><c:out value="${sv.getFullName()}"/></td>
                <td>${sv.getScore()}</td>
                <td>
                    <c:choose>
                        <c:when test="${sv.score >=90}">
                            Xuất sắc
                        </c:when>
                        <c:when test="${sv.score >=80}">
                            Giỏi
                        </c:when>
                        <c:when test="${sv.score >=70}">
                            Khá
                        </c:when>
                        <c:when test="${sv.score >=60}">
                            Trung bình khá
                        </c:when>
                        <c:when test="${sv.score >=50}">
                            Trung bình
                        </c:when>
                        <c:otherwise>
                            Yếu
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
