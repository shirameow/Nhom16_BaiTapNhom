package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DBConnect;
import model.*;

public class AdminDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public boolean themAdmin(AdminModel ad) {
		String sql = "insert into Admin values(?,?,?)";
		try {	
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, ad.getId());
			ps.setString(2, ad.getHoten());
			ps.setString(3,ad.getTaiKhoan() );
			ps.execute();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
}
}
