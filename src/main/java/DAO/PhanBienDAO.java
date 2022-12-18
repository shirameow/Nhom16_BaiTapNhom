package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.*;
import connection.DBConnect;

public class PhanBienDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public boolean ThemGiangVienPhanVien(int madt, String magv) {
		String sql = "insert into PhanBien values (?,?)";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, madt);
			ps.setString(2, magv);
			ps.execute();

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean ThayGiangVienPhanVien(int madt, String magv) {
		String sql = "Update PhanBien set MaGV =? where DeTai=?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(2, madt);
			ps.setString(1, magv);
			ps.execute();

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public GiangVienModel GiangVienDangPhanBien(int madt) {
		String sql = "select GiangVien.* from PhanBien,GiangVien where GiangVien.MaGV=PhanBien.MaGV and PhanBien.DeTai=?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, madt);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new GiangVienModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
