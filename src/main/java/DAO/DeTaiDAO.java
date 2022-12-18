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
	PreparedStatement ps1 = null;
	ResultSet rs = null;

	public List<DeTaiModel> DanhSachDeTaiTheoBoMon(String boMon) {
		String sql = "Select DeTai.* from DeTai, GiangVien where DeTai.GiangVien = GiangVien.MaGV and GiangVien.BoMon =?";
		List<DeTaiModel> listDeTai = new ArrayList<DeTaiModel>();

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, boMon);
			rs = ps.executeQuery();
			while (rs.next()) {
				listDeTai.add(new DeTaiModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			return listDeTai;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<DeTaiModel> ToanBoDanhSachDeTai() {
		String sql = "Select * from DeTai";
		List<DeTaiModel> listDeTai = new ArrayList<DeTaiModel>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				listDeTai.add(new DeTaiModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			return listDeTai;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<DeTaiModel> DanhSachDeTaiSVDaDK(int maNhom) {
		String sql = "Select DeTai.* from DeTai, DKDeTai where DeTai.MaDeTai=DKDeTai.DeTai and DKDeTai.MaNhom=?";
		List<DeTaiModel> listDeTai = new ArrayList<DeTaiModel>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maNhom);
			rs = ps.executeQuery();
			while (rs.next()) {
				listDeTai.add(new DeTaiModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			return listDeTai;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public DeTaiModel DeTaiCuaNhomDaDuyet(int maNhom) {
		String sql = "Select DeTai.* from DeTai, DKDeTai where DeTai.MaDeTai=DKDeTai.DeTai"
				+ " and DKDeTai.MaNhom=? and DKDeTai.TrangThai='1'";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maNhom);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new DeTaiModel(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void XoaDeTaiDangChoDuyet(int madt, int manhom) {
		String sql = "Delete from DKDeTai where DeTai=? and MaNhom=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, madt);
			ps.setInt(2, manhom);
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ThemDangKyDeTai(int madt, int manhom) {
		String sql = "Insert into DKDeTai values(?,?,0)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, manhom);
			ps.setInt(2, madt);
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int KiemTraDeTaiNhomDaDangKy(int madt, int manhom) {
		String sql = "Select count(*) from DKDeTai where MaNhom=? and DeTai=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, manhom);
			ps.setInt(2, madt);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int KiemTraDeTaiDaDuocGiaoChoNhomKhac(int madt) {
		String sql = "Select count(*) from DKDeTai where DeTai=? and TrangThai=1";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, madt);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int KiemTraTrangThaiDangKySV() {
		String sql = "Select TrangThai from DotDangKi where NhomNguoi = N'Sinh Viên'";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
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
	
	public List<DeTaiModel> getDeTaiCaNhanGV(String magv){
		String sql = "Select * from DeTai where GiangVien=?";
		List<DeTaiModel> listDT=new ArrayList<DeTaiModel>();
		
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,magv);
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
	
	public void DuyetDeTai(int manhom, int madt) {
		String sql = "Update DKDeTai set TrangThai = 1 where MaNhom=? and DeTai=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, manhom);
			ps.setInt(2, madt);
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean KiemTraTinhTrangGiaoDeTai(int madt) {
		String sql = "Select TrangThai from DKDeTai where DeTai=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, madt);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)==1)
					return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
