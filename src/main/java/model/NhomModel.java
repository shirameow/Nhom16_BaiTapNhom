package model;

public class NhomModel {
	private int MaNhom;
	private String TenNhom;
	private String BoMon;
	private String LienHe;
	public NhomModel(int maNhom, String tenNhom, String boMon, String lienHe) {
		super();
		MaNhom = maNhom;
		TenNhom = tenNhom;
		BoMon = boMon;
		LienHe = lienHe;
	}
	public NhomModel() {
		super();
	}
	public int getMaNhom() {
		return MaNhom;
	}
	public void setMaNhom(int maNhom) {
		MaNhom = maNhom;
	}
	public String getTenNhom() {
		return TenNhom;
	}
	public void setTenNhom(String tenNhom) {
		TenNhom = tenNhom;
	}
	public String getBoMon() {
		return BoMon;
	}
	public void setBoMon(String boMon) {
		BoMon = boMon;
	}
	public String getLienHe() {
		return LienHe;
	}
	public void setLienHe(String lienHe) {
		LienHe = lienHe;
	}
	
	
}
