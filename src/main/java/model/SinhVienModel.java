package model;

public class SinhVienModel {
	private String Id;
	private String Hoten;
	private String BoMon;
	private String TaiKhoan;
	private int Nhom;
	private int NhomTruong;
	
	public SinhVienModel(String id, String hoten, String boMon, String taiKhoan, int nhom, int nhomTruong) {
		super();
		Id = id;
		Hoten = hoten;
		BoMon = boMon;
		TaiKhoan = taiKhoan;
		Nhom = nhom;
		NhomTruong = nhomTruong;
	}

	public SinhVienModel() {
		super();
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getHoten() {
		return Hoten;
	}

	public void setHoten(String hoten) {
		Hoten = hoten;
	}

	public String getBoMon() {
		return BoMon;
	}

	public void setBoMon(String boMon) {
		BoMon = boMon;
	}

	public String getTaiKhoan() {
		return TaiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		TaiKhoan = taiKhoan;
	}

	public int getNhom() {
		return Nhom;
	}

	public void setNhom(int nhom) {
		Nhom = nhom;
	}

	public int getNhomTruong() {
		return NhomTruong;
	}

	public void setNhomTruong(int nhomTruong) {
		NhomTruong = nhomTruong;
	}

	

}
