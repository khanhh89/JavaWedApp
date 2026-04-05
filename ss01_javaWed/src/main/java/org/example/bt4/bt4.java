package org.example.bt4;

public class bt4 {
    //Constructor Injection vs Field Injection
    //Constructor Injection (Tiêm qua hàm khởi tạo)
    //Ưu điểm:
    //An toàn tuyệt đối: Cho phép dùng từ khóa final, đảm bảo các phụ thuộc không bị thay đổi sau khi khởi tạo (Immutability).
    //Tránh lỗi Null: Ứng dụng sẽ báo lỗi ngay khi khởi động nếu thiếu phụ thuộc, giúp phát hiện lỗi sớm.
    //Dễ kiểm thử: Có thể truyền các đối tượng giả (Mock) vào trực tiếp mà không cần dùng đến thư viện Spring.
    //Nhược điểm: Code trông dài dòng hơn vì phải viết hàm khởi tạo.
    //Field Injection (Tiêm trực tiếp vào biến bằng @Autowired)
    //Ưu điểm:
    //Cực kỳ gọn nhẹ: Chỉ cần một dòng annotation @Autowired trên biến.
    //Tiện lợi: Nhanh chóng khi cần thêm nhiều phụ thuộc vào một class.
    //Nhược điểm:
    //Rủi ro cao: Không dùng được final, dễ bị lỗi NullPointerException lúc chương trình đang chạy (Runtime).
    //Khó kiểm thử: Bắt buộc phải khởi chạy Spring Context hoặc dùng Reflection để nạp dữ liệu giả vào biến private.

    //Lựa chọn tối ưu: Constructor Injection.
    //Lý do: Hệ thống thông báo trừ tiền yêu cầu độ tin cậy cực cao. Constructor Injection giúp đảm bảo NotificationService luôn có đủ công cụ (Email/SMS) trước khi hoạt động.
    //
    //Xử lý bẫy dữ liệu: Khi mạng SMS bị đứt, nhờ việc đối tượng smsSender đã được khởi tạo chắc chắn, ta chỉ cần xử lý lỗi kết nối mạng (try-catch) để chuyển sang gửi Email dự phòng mà không lo lỗi "biến bị trống".
}
