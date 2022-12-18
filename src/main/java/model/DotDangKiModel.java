package model;

public class DotDangKiModel {
	private String NhomNguoi;
	private int TrangThai;
	public DotDangKiModel() {
		super();
	}
	public DotDangKiModel(String nhomNguoi, int trangThai) {
		super();
		NhomNguoi = nhomNguoi;
		TrangThai = trangThai;
	}
	public String getNhomNguoi() {
		return NhomNguoi;
	}
	public void setNhomNguoi(String nhomNguoi) {
		NhomNguoi = nhomNguoi;
	}
	public int getTrangThai() {
		return TrangThai;
	}
	
	public void setTrangThai(int trangThai) {
		TrangThai = trangThai;
	}
	
}
