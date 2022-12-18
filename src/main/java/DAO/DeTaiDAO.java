package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnect;
import model.*;
public class DeTaiDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public boolean TaoDeTai(String tenDeTai,String giangVien) {
		String sql = "insert into DeTai values (?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,tenDeTai);
			ps.setString(2,giangVien);
			ps.execute();
			return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		}
	public List<DeTaiModel>getDeTaiTheoBoMon(String boMon){
		List<DeTaiModel> listDT=new ArrayList<DeTaiModel>();
		String sql = "select DeTai.MaDeTai,DeTai.TenDeTai, GiangVien.MaGV from\r\n"
				+ "DeTai inner join GiangVien on DeTai.GiangVien=GiangVien.MaGV\r\n"
				+ "inner join BoMon on BoMon.MaBoMon=GiangVien.BoMon where BoMon.MaBoMon=? ";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,boMon);
			rs=ps.executeQuery();
			while(rs.next()) {
				listDT.add(new DeTaiModel(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
			return listDT;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
