package bt2;

public class bt2 {
    // phần 1:
    //Dòng <%! private int requestCounter = 0; %> là Declaration dùng biến toàn cục trong JSP. Biến này được chia sẻ giữa nhiều request nên có thể gây lỗi race condition khi nhiều người truy cập cùng lúc, làm sai lệch dữ liệu.
    //Việc sử dụng Scriptlet <% %> để lấy dữ liệu từ request và xử lý trong JSP vi phạm nguyên tắc “View ngốc nghếch” (Thin View). JSP chỉ nên hiển thị dữ liệu, không nên chứa logic Java.
    //Vòng lặp for và các câu lệnh if-else để xếp loại sinh viên được viết trực tiếp trong JSP là đưa business logic vào View, khiến code khó bảo trì và không đúng mô hình MVC.
    //Dòng <%= sv.getFullName() %> in trực tiếp dữ liệu ra HTML mà không escape, có thể gây lỗ hổng bảo mật XSS nếu dữ liệu chứa mã độc.
    //Dòng <%= sv.getScore()%>; có dấu chấm phẩy dư trong Expression, làm hiển thị ký tự ; ra giao diện, gây lỗi hiển thị.
}
