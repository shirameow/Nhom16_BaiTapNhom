package model;

public class BoMonModel {
	private String MaBoMon;
	private String TenBoMon;
	public BoMonModel() {
		super();
	}
	public BoMonModel(String maBoMon, String tenBoMon) {
		super();
		MaBoMon = maBoMon;
		TenBoMon = tenBoMon;
	}
	public String getMaBoMon() {
		return MaBoMon;
	}
	public void setMaBoMon(String maBoMon) {
		MaBoMon = maBoMon;
	}
	public String getTenBoMon() {
		return TenBoMon;
	}
	public void setTenBoMon(String tenBoMon) {
		TenBoMon = tenBoMon;
	}
}
