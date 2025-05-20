package controller;

import dao.MatBangDAO;
import model.MatBang;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;


public class DanhSachServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String loai = req.getParameter("loai");
        String tang = req.getParameter("tang");
        String gia = req.getParameter("gia");

        MatBangDAO dao = new MatBangDAO();
        List<MatBang> list = dao.getList(loai, tang, gia);

        req.setAttribute("ds", list);
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req, res);
    }
}
