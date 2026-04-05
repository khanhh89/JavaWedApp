package org.example.bt2;

public class bt2 {
    // khi đánh dấu 1 lớp là conponent m không định nghĩa gì Spring mặc định coi là Singleton Bean
    // Lỗi tình nhầm tiền:
        //+ Dùng chung 1 thực thể: chỉ tạo 1 đối tượng PlaySession cho toàn bộ ứng dụng, chia sẻ trạng thái: biến playTime trở thành chung. Khi máy 1 gọi addTime(), nó đang cộng dồn vào biến playTime duy nhất
        // Máy 2 cũng đang trỏ vào PlaySessioon với máy 1, nên máy 2 thấy playTime tăng lên và bị trừ tiền
}
