package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.*;
import connection.DBConnect;

public class NhomDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	PreparedStatement ps1 = null;
	ResultSet rs = null;

	public List<SinhVienModel> DanhSachThanhVienNhom(int nhom){
		String sql = "Select * from SinhVien where Nhom=?";
		List<SinhVienModel> listSV = new ArrayList<SinhVienModel>();
		
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, nhom);
			rs = ps.executeQuery();
			while(rs.next()) {
				listSV.add(new SinhVienModel(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getInt(5), rs.getInt(6)));
			}
			return listSV;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	
	public NhomModel ThongTinNhom(int nhom) {
		String sql = "Select * from NhomSV where MaNhom=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, nhom);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new NhomModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void ThemThanhVienNhom(int nhom, String mssv) {
		String sql = "Update SinhVien set Nhom=?, NhomTruong=0 where MSSV=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, nhom);
			ps.setString(2, mssv);
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int KiemTraNhom(String mssv) {
		String sql = "Select Nhom from SinhVien where MSSV=?";
		int manhom = 0;
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mssv);
			rs = ps.executeQuery();
			while(rs.next()) {
				manhom = rs.getInt(1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manhom;
	}
	
	public List<NhomModel> DanhSachNhomTheoBoMon(String bm){
		String sql = "Select * from NhomSV where BoMon=?";
		List<NhomModel> listNhom = new ArrayList<NhomModel>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, bm);
			rs = ps.executeQuery();
			while(rs.next()) {
				listNhom.add(new NhomModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			return listNhom;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int DemSoLuongNhom() {
		String sql = "Select count(*) from NhomSV";
		try {
			conn= new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public int LayMaNhomTheoTenNhom(String tenNhom) {
		String sql = "Select MaNhom from NhomSV where TenNhom=?";
		try {
			conn= new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tenNhom);
			rs=ps.executeQuery();
			while(rs.next()){
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public void DangKyNhom(String tenNhom, String boMon, String lienHe, String mssv) {
		String sql1 = "Insert into NhomSV values(?,?,?)";
		String sql2 = "Update SinhVien set Nhom=?, NhomTruong=1 where MSSV=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql1);
			ps.setString(1, tenNhom);
			ps.setString(2, boMon);
			ps.setString(3, lienHe);
			ps.execute();
			
			int maNhom = LayMaNhomTheoTenNhom(tenNhom);
			ps1 = conn.prepareStatement(sql2);
			ps1.setInt(1, maNhom);
			ps1.setString(2, mssv);
			ps1.execute();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void XoaThanhVienNhom(String mssv) {
		String sql = "Update SinhVien set Nhom=null, NhomTruong=null where MSSV =?";
		try {
			conn= new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mssv);
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<NhomModel> DanhSachNhomChungDeTai(int madt){
		String sql = "Select NhomSV.* from DKDeTai, NhomSV where DKDeTai.DeTai=? and NhomSV.MaNhom = DKDeTai.MaNhom";
		List<NhomModel> listNhom = new ArrayList<NhomModel>();
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, madt);
			rs = ps.executeQuery();
			while(rs.next()) {
				listNhom.add(new NhomModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			return listNhom;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
