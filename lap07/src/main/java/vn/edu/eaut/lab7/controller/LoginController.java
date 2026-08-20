package vn.edu.eaut.lab7.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u = req.getParameter("username");
        String p = req.getParameter("password");

        // Tài khoản mẫu: admin / admin123
        if ("admin".equals(u) && "admin123".equals(p)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", u);
            // Đăng nhập thành công, chuyển hướng về trang chủ
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        } else {
            // Sai mật khẩu, quay lại trang đăng nhập báo lỗi
            req.setAttribute("error", "Tài khoản hoặc mật khẩu không đúng!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}