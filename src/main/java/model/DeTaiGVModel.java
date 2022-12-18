package model;

public class DeTaiGVModel {
	private int MaDeTai;
	private String TenDeTai;
	private GiangVienModel GiangVien;
	public DeTaiGVModel(int maDeTai, String tenDeTai, GiangVienModel giangVien) {
		super();
		MaDeTai = maDeTai;
		TenDeTai = tenDeTai;
		GiangVien = giangVien;
	}
	public DeTaiGVModel() {
		super();
	}
	public int getMaDeTai() {
		return MaDeTai;
	}
	public void setMaDeTai(int maDeTai) {
		MaDeTai = maDeTai;
	}
	public String getTenDeTai() {
		return TenDeTai;
	}
	public void setTenDeTai(String tenDeTai) {
		TenDeTai = tenDeTai;
	}
	public GiangVienModel getGiangVien() {
		return GiangVien;
	}
	public void setGiangVien(GiangVienModel giangVien) {
		GiangVien = giangVien;
	}
	
	
}
