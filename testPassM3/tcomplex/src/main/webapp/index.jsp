<%@ page import="java.util.List" %>
<%@ page import="model.MatBang" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách mặt bằng</title>
</head>
<body>
<h2>Danh sách mặt bằng</h2>
<a href="add.jsp">➕ Thêm mặt bằng mới</a>
<form action="DanhSachServlet" method="get">
    Loại:
    <select name="loai">
        <option value="">--Chọn--</option>
        <option>Văn phòng chia sẻ</option>
        <option>Văn phòng trọn gói</option>
    </select>
    Tầng:
    <select name="tang">
        <option value="">--Chọn--</option>
        <% for(int i=1; i<=15; i++) { %>
            <option><%=i%></option>
        <% } %>
    </select>
    Giá <= <input type="number" name="gia" />
    <input type="submit" value="Tìm kiếm" />
</form>
<hr/>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>Mã MB</th><th>Trạng thái</th><th>Diện tích</th><th>Tầng</th>
        <th>Loại</th><th>Giá</th><th>Bắt đầu</th><th>Kết thúc</th>
    </tr>
    <%
        List<MatBang> list = (List<MatBang>) request.getAttribute("ds");
        if (list != null && !list.isEmpty()) {
            for (MatBang m : list) {
    %>
    <tr>
        <td><%= m.getMaMatBang() %></td>
        <td><%= m.getTrangThai() %></td>
        <td><%= m.getDienTich() %></td>
        <td><%= m.getTang() %></td>
        <td><%= m.getLoai() %></td>
        <td><%= m.getGiaTien() %></td>
        <td><%= m.getNgayBatDau() %></td>
        <td><%= m.getNgayKetThuc() %></td>
    </tr>
    <%  } 
        } else { %>
    <tr><td colspan="8">Không có dữ liệu để hiển thị</td></tr>
    <% } %>
</table>
</body>
</html>