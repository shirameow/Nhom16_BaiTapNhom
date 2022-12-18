package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.*;
import connection.DBConnect;
public class ThongtintaikhoanDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	
	public SinhVienModel ThongTinSV(String taiKhoan) {
		String sql = "Select * from SinhVien where TaiKhoan=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, taiKhoan);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new SinhVienModel(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getInt(5), rs.getInt(6));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public GiangVienModel ThongTinGV(String taiKhoan) {
		String sql = "Select * from GiangVien where TaiKhoan=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, taiKhoan);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new GiangVienModel(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getInt(6));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public AdminModel ThongTinAd(String taiKhoan) {
		String sql = "Select * from Admin where TaiKhoan=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, taiKhoan);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new AdminModel(rs.getString(1), rs.getString(2), rs.getString(3));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
