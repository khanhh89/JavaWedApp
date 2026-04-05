package org.example.bt3;

public class bt3 {
    //input:
        // userId
        // foodId
        // quantity
    //output
        // Đặt món thành công, số dư tài khoản đã trừ và cập nhật kho
        // Thất bại: Hêt hàng || Số dư không đủ

    //Thiết kế
        // Interface InventoryRepository: ĐỊnh ngĩa các hàm kiểm tra và cập nhật kho
        // Interfacce UserAccountRepository: Định nghĩa các hàm kiểm tra số dư và trừ tiền
        // class OrderFoodService: logic xử lý, nhận các Repository thông qua constructor

    // quy trình
        // tiếp nhận yêu cầu: Nhận thông tin món ăn và khách hàng từ controler
        //Kiểm tra kho: Gọi Intertory để kiểm tra số lượng
            // bẫy 1: nếu số lượng = 0 hoặc nhỏ hơn số lượng khách đặt, dừng xử lý và ném Exception
        // Kiểm tra tài khoản:
            // tính tổng tiền
            // GỌi userAccount để lấy số dư của userId
            // Bẫy 2: Nếu số dư<tổng tiền, dừng xư lý và ném Exception
        // thực hiện gioa dịch:
            // nếu hợp lệ tiến hành trừ tiền khách hàng qua userAccount
            // trừ số luongj tồn kho qua Inventory
        //kq


}
