package model;

public class DeTaiModel {
	private int MaDeTai;
	private String TenDeTai;
	private String GiangVien;
	public DeTaiModel() {
		super();
	}
	public DeTaiModel(int maDeTai, String tenDeTai, String giangVien) {
		super();
		MaDeTai = maDeTai;
		TenDeTai = tenDeTai;
		GiangVien = giangVien;
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
	public String getGiangVien() {
		return GiangVien;
	}
	public void setGiangVien(String giangVien) {
		GiangVien = giangVien;
	}
	
	
}
