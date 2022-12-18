package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnect;
import model.*;
public class DotDangKiDAO {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		public List<DotDangKiModel> getDotDK() {
			List<DotDangKiModel>listDDK=new ArrayList<DotDangKiModel>();
			String sql= "select * from DotDangKi";
			try {
//				Mở kết nối database
				conn= new DBConnect().getConnection();
//				Ném câu query vào SQL server
				ps = conn.prepareStatement(sql);
//				Chạy câu query và nhân lại kết quả
				rs=ps.executeQuery();
//				Lấy từ ResultSet đổ vào list
				while(rs.next()){
					listDDK.add( new DotDangKiModel(rs.getString(1),rs.getInt(2)));
				}
				return listDDK;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		public boolean ThayDoiTrangThaiDDK(DotDangKiModel ddk) {
			String sql = "update DotDangKi set TrangThai=? where NhomNguoi=?";
			try {
				int trangThai=0;
				if(ddk.getTrangThai()==1)
					trangThai=0;
				else if(ddk.getTrangThai()==0){
					trangThai=1;
				}
				conn = new DBConnect().getConnection();
				ps = conn.prepareStatement(sql);
				ps.setInt(1, trangThai);
				
				ps.setString(2,ddk.getNhomNguoi());
				ps.execute();
				return true;

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
}
