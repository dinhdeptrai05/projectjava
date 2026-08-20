package vn.edu.eaut.lab7.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.edu.eaut.lab7.model.SinhVien;
import vn.edu.eaut.lab7.repository.SinhVienRepository;
import java.io.IOException;

@WebServlet("/sinh-vien")
public class SinhVienController extends HttpServlet {
    private final SinhVienRepository repo = new SinhVienRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        // Hiển thị form thêm mới
        if ("new".equals(action)) {
            req.getRequestDispatcher("/views/sinhvien/form.jsp").forward(req, resp);
            return;
        }

        // Hiển thị form cập nhật (có dữ liệu cũ)
        if ("edit".equals(action)) {
            req.setAttribute("sv", repo.findById(Integer.parseInt(req.getParameter("id"))));
            req.getRequestDispatcher("/views/sinhvien/form.jsp").forward(req, resp);
            return;
        }

        // Xem chi tiết sinh viên
        if ("detail".equals(action)) {
            req.setAttribute("sv", repo.findById(Integer.parseInt(req.getParameter("id"))));
            req.getRequestDispatcher("/views/sinhvien/detail.jsp").forward(req, resp);
            return;
        }

        // Xóa sinh viên
        if ("delete".equals(action)) {
            repo.deleteById(Integer.parseInt(req.getParameter("id")));
            resp.sendRedirect(req.getContextPath() + "/sinh-vien");
            return;
        }

        // Mặc định: Hiển thị danh sách (có hỗ trợ tìm kiếm theo keyword)
        req.setAttribute("dsSinhVien", repo.search(req.getParameter("keyword")));
        req.getRequestDispatcher("/views/sinhvien/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Xử lý lưu dữ liệu khi submit form (POST)
        req.setCharacterEncoding("UTF-8");

        String idParam = req.getParameter("id");
        int id = (idParam != null && !idParam.isEmpty()) ? Integer.parseInt(idParam) : 0;

        String maSinhVien = req.getParameter("maSinhVien");
        String hoTen = req.getParameter("hoTen");
        String email = req.getParameter("email");
        String lop = req.getParameter("lop");

        // Tạo đối tượng và lưu vào repository (nếu id = 0 là thêm mới, ngược lại là cập nhật)
        SinhVien sv = new SinhVien(id, maSinhVien, hoTen, email, lop);
        repo.save(sv);

        // Sau khi lưu xong, chuyển hướng về trang danh sách
        resp.sendRedirect(req.getContextPath() + "/sinh-vien");
    }
}