package model;

public class HoiDongModel {
	private String MaHoiDong;
	private String TenHoiDong;
	public HoiDongModel() {
		super();
	}
	public HoiDongModel(String maHoiDong, String tenHoiDong) {
		super();
		MaHoiDong = maHoiDong;
		TenHoiDong = tenHoiDong;
	}
	public String getMaHoiDong() {
		return MaHoiDong;
	}
	public void setMaHoiDong(String maHoiDong) {
		MaHoiDong = maHoiDong;
	}
	public String getTenHoiDong() {
		return TenHoiDong;
	}
	public void setTenHoiDong(String tenHoiDong) {
		TenHoiDong = tenHoiDong;
	}
}
