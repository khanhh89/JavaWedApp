package bt1;

public class bt1 {
    // phần 1:
    // 1. Trong MyWebAppInitializer.java, khi cấu hình: "/api/*" DispatcherServlet chỉ xử lý các request có tiền tố /api/ (chỉ xử lý các URL dạng:/api/*
    //Ví dụ: /api/welcome → được xử lý)
    // 2. Spring MVC đang tìm @Controller trong com.demo.service nhưng Controller lại nằm trong com.demo.controller, nên không tìm thấy Controller và URL không được ánh xạ.
    // 3. ứng dụng vẫn không chạy được.
    //Vì khi sửa Servlet Mapping thành "/" thì DispatcherServlet đã nhận được request /welcome, nhưng do cấu hình
    //@ComponentScan(basePackages = "com.demo.service") không quét package chứa WelcomeController, nên Spring không tìm thấy Controller.




}
