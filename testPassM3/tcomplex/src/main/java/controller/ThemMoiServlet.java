package controller;

import dao.MatBangDAO;
import model.MatBang;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.regex.*;

public class ThemMoiServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String ma = req.getParameter("ma_mat_bang");
        String trangThai = req.getParameter("trang_thai");
        String dienTich = req.getParameter("dien_tich");
        String tang = req.getParameter("tang");
        String loai = req.getParameter("loai");
        String gia = req.getParameter("gia_tien");
        String nbd = req.getParameter("ngay_bat_dau");
        String nkt = req.getParameter("ngay_ket_thuc");

        Pattern pattern = Pattern.compile("^[A-Z]{3}-\\d{2}-\\d{2}$");
        Matcher matcher = pattern.matcher(ma);

        if (!matcher.matches()) {
            req.setAttribute("error", "Mã mặt bằng phải theo định dạng XXX-XX-XX");
            req.setAttribute("data", req.getParameterMap());
            req.getRequestDispatcher("add.jsp").forward(req, res);
            return;
        }

        MatBang m = new MatBang();
        m.setMaMatBang(ma);
        m.setTrangThai(trangThai);
        m.setDienTich(Float.parseFloat(dienTich));
        m.setTang(Integer.parseInt(tang));
        m.setLoai(loai);
        m.setGiaTien(Long.parseLong(gia));
        m.setNgayBatDau(nbd);
        m.setNgayKetThuc(nkt);

        if (new MatBangDAO().insert(m)) {
            res.sendRedirect("DanhSachServlet");
        } else {
            req.setAttribute("error", "Thêm thất bại. Kiểm tra lại dữ liệu.");
            req.getRequestDispatcher("add.jsp").forward(req, res);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }
}