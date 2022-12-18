package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.*;
import connection.DBConnect;

public class GiangVienDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public boolean themGVVaoHD(String maHD, String magv) {
		String sql = "update GiangVien set HoiDong=? where MaGV=? and HoiDong is null";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, maHD);
			ps.setString(2, magv);
			ps.execute();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<GiangVienModel> getGVNoneHD() {
		List<GiangVienModel> listGVNHD = new ArrayList<GiangVienModel>();
		String sql = "select * from GiangVien where HoiDong is null";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				listGVNHD.add(new GiangVienModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6)));
			}
			return listGVNHD;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<GiangVienModel> DanhSachGiangVienTheoBoMon(String mabomon) {
		List<GiangVienModel> list = new ArrayList<GiangVienModel>();
		String sql = "select * from GiangVien where BoMon=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mabomon);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new GiangVienModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6)));
			}
			return list;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean XoaGVKhoiHD(String maGV) {
		String sql = "update GiangVien set HoiDong=null where MaGV=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, maGV);
			ps.execute();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean themGiangVien(GiangVienModel gv) {
		String sql = "insert into GiangVien values(?,?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, gv.getId());
			ps.setString(2, gv.getHoten());
			ps.setString(3, gv.getTaiKhoan());
			ps.setString(4, gv.getBoMon());
			ps.setString(5, gv.getHoiDong());
			ps.setInt(6, gv.getTruongBoMon());
			ps.execute();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public GiangVienModel TimGiangVienTheoMaGV(String magv) {
		String sql = "Select * from GiangVien where MaGV=?";
		
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, magv);
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
}
