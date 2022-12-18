package model;

public class GiangVienModel {
	private String id;
	private String Hoten;
	private String TaiKhoan;
	private String BoMon;
	private String HoiDong;
	private int TruongBoMon;
	public GiangVienModel(String id, String hoten, String taiKhoan, String boMon, String hoiDong, int truongBoMon) {
		super();
		this.id = id;
		Hoten = hoten;
		TaiKhoan = taiKhoan;
		BoMon = boMon;
		HoiDong = hoiDong;
		TruongBoMon = truongBoMon;
	}
	public GiangVienModel() {
		super();
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
	public String getBoMon() {
		return BoMon;
	}
	public void setBoMon(String boMon) {
		BoMon = boMon;
	}
	public String getHoiDong() {
		return HoiDong;
	}
	public void setHoiDong(String hoiDong) {
		HoiDong = hoiDong;
	}
	public int getTruongBoMon() {
		return TruongBoMon;
	}
	public void setTruongBoMon(int truongBoMon) {
		TruongBoMon = truongBoMon;
	}
	
	

	

}
