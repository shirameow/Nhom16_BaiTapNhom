package model;

public class PhanBienModel {
	private DeTaiModel DeTai;
	private GiangVienModel GiangVien;
	public PhanBienModel(DeTaiModel deTai, GiangVienModel giangVien) {
		super();
		DeTai = deTai;
		GiangVien = giangVien;
	}
	public PhanBienModel() {
		super();
	}
	
	public PhanBienModel(DeTaiModel deTai) {
		super();
		DeTai = deTai;
	}
	public DeTaiModel getDeTai() {
		return DeTai;
	}
	public void setDeTai(DeTaiModel deTai) {
		DeTai = deTai;
	}
	public GiangVienModel getGiangVien() {
		return GiangVien;
	}
	public void setGiangVien(GiangVienModel giangVien) {
		GiangVien = giangVien;
	}
	
	
}
