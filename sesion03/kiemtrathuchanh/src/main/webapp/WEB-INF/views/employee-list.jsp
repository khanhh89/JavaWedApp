<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Danh sách nhân viên</title>
</head>
<body>

<h2>Danh sách nhân viên phòng Đào tạo</h2>

<table border="100" cellpadding="1000">
    <tr>
        <th>ID</th>
        <th>Họ tên</th>
        <th>Phòng ban</th>
        <th>Lương</th>
        <th>Đánh giá</th>
    </tr>

    <c:forEach var="emp" items="${employees}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.fullName}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>

            <td>
                <c:choose>
                    <c:when test="${emp.salary >= 10000}">
                        Mức lương cao
                    </c:when>
                    <c:otherwise>
                        Mức lương cơ bản
                    </c:otherwise>
                </c:choose>
            </td>

        </tr>
    </c:forEach>

</table>

</body>
</html>