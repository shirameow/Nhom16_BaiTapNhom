package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import connection.DBConnect;
import model.accountModel;
public class loginDAO {
	Connection conn=null;
//	Sử dụng các kêu Query
	PreparedStatement ps=null;
//	Xuất kết quả 
	ResultSet rs=null;
	public accountModel getAccount(String username,String password) {
		String sql= "select * from TaiKhoan where Username=? and MatKhau=?";
		try {
//			Mở kết nối database
			conn= new DBConnect().getConnection();
//			Ném câu query vào SQL server
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
//			Chạy câu query và nhân lại kết quả
			rs=ps.executeQuery();
//			Lấy từ ResultSet đổ vào list
//			rs.next() chạy từng dòng
			while(rs.next()){
				return new accountModel(rs.getString(1),rs.getString(2),rs.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
