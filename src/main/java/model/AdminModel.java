package model;

public class AdminModel {
	private String id;
	private String Hoten;
	private String TaiKhoan;
	
	public AdminModel() {
		super();
	}
	
	public AdminModel(String id, String hoten, String taiKhoan) {
		super();
		this.id = id;
		Hoten = hoten;
		TaiKhoan = taiKhoan;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHoten() {
		return Hoten;
	}
	public void setHoten(String hoten) {
		Hoten = hoten;
	}
	public String getTaiKhoan() {
		return TaiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		TaiKhoan = taiKhoan;
	}
}
