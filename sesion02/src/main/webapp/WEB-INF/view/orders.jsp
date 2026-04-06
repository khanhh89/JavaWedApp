<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Danh sách đơn hàng</title>
</head>
<body>

<h2>
    Xin chào, ${sessionScope.loggedUser}!
    Vai trò: ${sessionScope.role}
</h2>

<a href="logout">Đăng xuất</a>

<h3>Danh sách đơn hàng</h3>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>Mã đơn</th>
        <th>Tên sản phẩm</th>
        <th>Tổng tiền</th>
        <th>Ngày đặt</th>
    </tr>

    <c:forEach var="order" items="${requestScope.orderList}">
        <tr>
            <td>${order.orderId}</td>
            <td>${order.productName}</td>
            <td>
                <fmt:formatNumber value="${order.totalAmount}" type="currency" currencySymbol="₫"/>
            </td>
            <td>
                <fmt:formatDate value="${order.orderDate}" pattern="dd/MM/yyyy"/>
            </td>
        </tr>
    </c:forEach>
</table>

<br>

<h3>
    Tổng lượt xem đơn hàng toàn hệ thống:
    ${applicationScope.totalViewCount}
</h3>

</body>
</html>