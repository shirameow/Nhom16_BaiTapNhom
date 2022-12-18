package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.*;
import connection.DBConnect;

public class AccountDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public boolean DoiMK(String taiKhoan, String newpw) {
		String sql = "update TaiKhoan set MatKhau=? where Username=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, newpw);
			ps.setString(2, taiKhoan);
			ps.execute();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<accountModel> getAllAccount() {
		List<accountModel> listACC = new ArrayList<accountModel>();
		String sql = "select * from TaiKhoan";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				listACC.add(new accountModel(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
			return listACC;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public boolean XoaTK(String userName) {
		String sql = "delete TaiKhoan where Username=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.execute();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean ThemTK(accountModel acc) {
		String sql = "insert into TaiKhoan values(?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, acc.getUsername());
			ps.setString(2, acc.getPassword());
			ps.setString(3, acc.getRole());
			ps.execute();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public int checkRole(String taiKhoan) {
		int a = 0;
		String sql = "select * from TaiKhoan where Username=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, taiKhoan);
			accountModel acc = new accountModel();
			rs = ps.executeQuery();
			while (rs.next()) {
				acc = new accountModel(rs.getString(1), rs.getString(2), rs.getString(3));
			}
			String role = acc.getRole();
			if (role.equals("Sinh Viên"))
				a = 1;
			else if (role.equals("Giảng Viên"))
				a = 2;
			else if (role.equals("Admin"))
				a = 3;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;

	}
	public List<accountModel> getAllAccountNoneUser(){
		List<accountModel> listACCN = new ArrayList<accountModel>();
		String sql = " select * from TaiKhoan where Quyen=N'Sinh Viên'\r\n"
				+ "  except select Username,MatKhau,Quyen from TaiKhoan, SinhVien where TaiKhoan.Username=SinhVien.TaiKhoan and TaiKhoan.Quyen=N'Sinh Viên'";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				listACCN.add(new accountModel(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
			return listACCN;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
