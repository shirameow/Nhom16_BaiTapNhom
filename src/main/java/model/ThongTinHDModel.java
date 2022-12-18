package model;

public class ThongTinHDModel {
	private String MaHD;
	private String MaGV;
	private String TenGV;
	private String TenHoiDong;
	public ThongTinHDModel() {
		super();
	}
	public ThongTinHDModel(String maHD, String maGV, String tenGV, String tenHoiDong) {
		super();
		MaHD = maHD;
		MaGV = maGV;
		TenGV = tenGV;
		TenHoiDong = tenHoiDong;
	}
	public String getMaHD() {
		return MaHD;
	}
	public void setMaHD(String maHD) {
		MaHD = maHD;
	}
	public String getMaGV() {
		return MaGV;
	}
	public void setMaGV(String maGV) {
		MaGV = maGV;
	}
	public String getTenGV() {
		return TenGV;
	}
	public void setTenGV(String tenGV) {
		TenGV = tenGV;
	}
	public String getTenHoiDong() {
		return TenHoiDong;
	}
	public void setTenHoiDong(String tenHoiDong) {
		TenHoiDong = tenHoiDong;
	}
}
