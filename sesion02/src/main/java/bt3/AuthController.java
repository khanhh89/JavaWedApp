package bt3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class AuthController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (("admin".equals(username) && "admin123".equals(password)) ||
                ("staff".equals(username) && "staff123".equals(password))) {

            HttpSession session = request.getSession();
            session.setAttribute("loggedUser", username);

            if (username.equals("admin")) {
                session.setAttribute("role", "Admin");
            } else {
                session.setAttribute("role", "Staff");
            }

            response.sendRedirect("orders");
        } else {
            // Lỗi → Request Scope (chỉ hiển thị 1 lần)
            request.setAttribute("error", "Sai username hoặc password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
