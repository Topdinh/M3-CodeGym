package dao;

import model.MatBang;
import util.DBConnection;

import java.sql.*;
import java.util.*;

public class MatBangDAO {

    public List<MatBang> getList(String loai, String tang, String gia) {
        List<MatBang> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM mat_bang WHERE 1=1";
            if (loai != null && !loai.isEmpty()) sql += " AND loai = '" + loai + "'";
            if (tang != null && !tang.isEmpty()) sql += " AND tang = " + tang;
            if (gia != null && !gia.isEmpty()) sql += " AND gia_tien <= " + gia;
            sql += " ORDER BY dien_tich ASC";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                MatBang m = new MatBang();
                m.setMaMatBang(rs.getString("ma_mat_bang"));
                m.setTrangThai(rs.getString("trang_thai"));
                m.setDienTich(rs.getFloat("dien_tich"));
                m.setTang(rs.getInt("tang"));
                m.setLoai(rs.getString("loai"));
                m.setGiaTien(rs.getLong("gia_tien"));
                m.setNgayBatDau(rs.getString("ngay_bat_dau"));
                m.setNgayKetThuc(rs.getString("ngay_ket_thuc"));
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(MatBang m) {
        String sql = "INSERT INTO mat_bang VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, m.getMaMatBang());
            ps.setString(2, m.getTrangThai());
            ps.setFloat(3, m.getDienTich());
            ps.setInt(4, m.getTang());
            ps.setString(5, m.getLoai());
            ps.setLong(6, m.getGiaTien());
            ps.setString(7, m.getNgayBatDau());
            ps.setString(8, m.getNgayKetThuc());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String maMatBang) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM mat_bang WHERE ma_mat_bang = ?")) {
            ps.setString(1, maMatBang);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
