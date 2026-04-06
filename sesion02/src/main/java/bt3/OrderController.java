package bt3;
import com.demo.model.Order;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServlet;

@WebServlet("/orders")
public class OrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        // Chưa login → về login
        if (session == null || session.getAttribute("loggedUser") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Tạo danh sách đơn hàng giả
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("OD01", "Laptop", 15000000, new Date()));
        orderList.add(new Order("OD02", "Chuột", 300000, new Date()));
        orderList.add(new Order("OD03", "Bàn phím", 700000, new Date()));

        // Request Scope
        request.setAttribute("orderList", orderList);

        // Application Scope – totalViewCount (có synchronized tránh race condition)
        ServletContext application = request.getServletContext();
        synchronized (application) {
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if (count == null) count = 0;
            count++;
            application.setAttribute("totalViewCount", count);
        }

        request.getRequestDispatcher("orders.jsp").forward(request, response);
    }
}