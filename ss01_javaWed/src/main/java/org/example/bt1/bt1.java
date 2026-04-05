package org.example.bt1;

public class bt1 {
    // code sai
    // this.gateway = new InternalPaymentGateway();
    // cách viết này khó thay đổi cổng thanh toán khác như momo, vn pay. Nếu muốn thay đổi phải sửa code và biên dịch lại lớp RechargeService
    //Khó kiểm thử: không thể thay đổi cổng thanh toán thật bằng một đối tượng giả khi chạy thử
    // Vi phạm IoC : đối tuongj không khoit tạo phụ thuộc của nó (RechargeSevice đang kiểm soát khởi tạo gaeteway)

}
