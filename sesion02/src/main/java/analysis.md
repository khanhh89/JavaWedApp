1. Vì sao lỗi đăng nhập phải dùng Request Scope?

Thông báo lỗi đăng nhập chỉ cần hiển thị một lần sau khi submit form, nên phải lưu trong Request Scope (chỉ tồn tại trong 1 request).

Nếu lưu vào Session Scope:

Lỗi sẽ tồn tại suốt phiên làm việc.
Sau khi đăng nhập đúng, lỗi vẫn còn.
Khi quay lại trang login, lỗi cũ vẫn hiển thị → sai logic.

Kết luận:

Error → Request Scope
User info → Session Scope
2. Vì sao totalViewCount phải dùng Application Scope?

totalViewCount là số lượt xem toàn hệ thống, tất cả người dùng phải thấy cùng một giá trị.

Nếu dùng Session Scope:

Mỗi user có 1 session riêng
Mỗi người thấy số khác nhau

Ví dụ:

User A xem 2 lần → thấy 2
User B xem 1 lần → thấy 1

→ Không còn là tổng toàn hệ thống.

Kết luận:

totalViewCount → Application Scope
3. Race Condition là gì?

Race Condition xảy ra khi nhiều thread cùng truy cập và thay đổi một biến chung, làm dữ liệu bị sai.

Trong web:

Mỗi request = 1 thread
Nhiều user truy cập cùng lúc → nhiều thread cùng tăng biến