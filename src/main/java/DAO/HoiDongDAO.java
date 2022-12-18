package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnect;
import model.*;
public class HoiDongDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<HoiDongModel> getAllHoiDong(){
		List<HoiDongModel>listHD=new ArrayList<HoiDongModel>();
		String sql= "select * from HoiDong";
		try {
//			Mở kết nối database
			conn= new DBConnect().getConnection();
//			Ném câu query vào SQL server
			ps = conn.prepareStatement(sql);
//			Chạy câu query và nhân lại kết quả
			rs=ps.executeQuery();
//			Lấy từ ResultSet đổ vào list
			while(rs.next()){
				listHD.add( new HoiDongModel(rs.getString(1),rs.getString(2)));
			}
			return listHD;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public boolean taoHoiDong(HoiDongModel hd) {
		String sql = "insert into HoiDong values(?,?)";
		try {	
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, hd.getMaHoiDong());
			ps.setString(2,hd.getTenHoiDong());
			ps.execute();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<ThongTinHDModel> getThongTinHD(HoiDongModel hd){
		List<ThongTinHDModel> listGVHD = new ArrayList<ThongTinHDModel>();
		String sql = "select HoiDong.MaHoiDong,MaGV,TenGV,TenHoiDong from GiangVien,HoiDong where HoiDong.MaHoiDong=? and HoiDong.MaHoiDong=GiangVien.HoiDong";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,hd.getMaHoiDong());
			rs = ps.executeQuery();
			while (rs.next()) {
				listGVHD.add(new ThongTinHDModel(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4)));
			}
			return listGVHD;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean XoaHD(String maHD) {
		String sql = "delete from HoiDong where MaHoiDong=?";
		try {	
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,maHD);
			ps.execute();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
