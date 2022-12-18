package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnect;
import model.*;
public class BoMonDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<BoMonModel> getAllBoMon(){
		List<BoMonModel> listBM = new ArrayList<BoMonModel>();
		String sql = "select * from BoMon";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				listBM.add(new BoMonModel(rs.getString(1), rs.getString(2)));
			}
			return listBM;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String TimBoMonTheoMa(String mabm) {
		String sql = "Select TenBoMon from BoMon where MaBoMon=?";
		
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mabm);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
