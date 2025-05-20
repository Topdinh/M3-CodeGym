<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mặt bằng</title>
</head>
<body>
<h2>Thêm mới mặt bằng</h2>
<form method="post" action="ThemMoiServlet">
    Mã mặt bằng: <input name="ma_mat_bang" required value="<%= request.getParameter("ma_mat_bang") != null ? request.getParameter("ma_mat_bang") : "" %>"/><br/>
    <% if (request.getAttribute("error") != null) { %>
        <span style="color:red"><%= request.getAttribute("error") %></span><br/>
    <% } %>
    Trạng thái: <input name="trang_thai" required value="<%= request.getParameter("trang_thai") != null ? request.getParameter("trang_thai") : "" %>"/><br/>
    Diện tích: <input name="dien_tich" required type="number" value="<%= request.getParameter("dien_tich") != null ? request.getParameter("dien_tich") : "" %>"/><br/>
    Tầng: <input name="tang" required type="number" value="<%= request.getParameter("tang") != null ? request.getParameter("tang") : "" %>"/><br/>
    Loại:
    <select name="loai">
        <option>Văn phòng chia sẻ</option>
        <option>Văn phòng trọn gói</option>
    </select><br/>
    Giá tiền: <input name="gia_tien" required type="number" value="<%= request.getParameter("gia_tien") != null ? request.getParameter("gia_tien") : "" %>"/><br/>
    Ngày bắt đầu: <input name="ngay_bat_dau" required type="date" value="<%= request.getParameter("ngay_bat_dau") != null ? request.getParameter("ngay_bat_dau") : "" %>"/><br/>
    Ngày kết thúc: <input name="ngay_ket_thuc" required type="date" value="<%= request.getParameter("ngay_ket_thuc") != null ? request.getParameter("ngay_ket_thuc") : "" %>"/><br/>
    <input type="submit" value="Thêm mới"/>
</form>
<a href="DanhSachServlet">Quay lại danh sách</a>
</body>
</html>

<a href="add.jsp">➕ Thêm mặt bằng mới</a><br/><br/>