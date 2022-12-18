package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DBConnect;
import model.*;

public class SinhVienDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public boolean themSinhVien(SinhVienModel sv) {
		String sql = "insert into SinhVien values(?,?,?,?,?,?)";
		try {	
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, sv.getId());
			ps.setString(2, sv.getHoten());
			ps.setString(3, sv.getBoMon());
			ps.setString(4,sv.getTaiKhoan() );
			ps.setNull(5, sv.getNhom());
			ps.setInt(6, sv.getNhomTruong());
			ps.execute();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
}
}
