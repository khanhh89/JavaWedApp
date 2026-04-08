<%--
  Created by IntelliJ IDEA.
  User: khanhdao
  Date: 08/04/2026
  Time: 10:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Kết quả tìm kiếm thực đơn</h1>
    <p style="color: green;">Thông báo: ${msg}</p>

    <ul>
        <li>Loại món ăn: <strong>${cate}</strong></li>
        <li>Số lượng giới hạn hiển thị: <strong>${lim}</strong> món</li>
    </ul>

    <hr>
    <p>Hệ thống đang liệt kê các món ăn thuộc nhóm ${cate}...</p>
</body>
</html>
