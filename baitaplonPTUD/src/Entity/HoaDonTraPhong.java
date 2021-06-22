package Entity;

public class HoaDonTraPhong {
	private String MaHD;
	private ThuePhong ThueP;
	private String NgayRa;
	private float giamGia;
	private Double tongTien;
	public HoaDonTraPhong(String maHD, ThuePhong thueP, String ngayRa, float giamGia, Double tongTien) {
		super();
		MaHD = maHD;
		ThueP = thueP;
		NgayRa = ngayRa;
		this.giamGia = giamGia;
		this.tongTien = tongTien;
	}
	public String getMaHD() {
		return MaHD;
	}
	public void setMaHD(String maHD) {
		MaHD = maHD;
	}
	public ThuePhong getThueP() {
		return ThueP;
	}
	public void setThueP(ThuePhong thueP) {
		ThueP = thueP;
	}
	public String getNgayRa() {
		return NgayRa;
	}
	public void setNgayRa(String ngayRa) {
		NgayRa = ngayRa;
	}
	public float getGiamGia() {
		return giamGia;
	}
	public void setGiamGia(float giamGia) {
		this.giamGia = giamGia;
	}
	public Double getTongTien() {
		return tongTien;
	}
	public void setTongTien(Double tongTien) {
		this.tongTien = tongTien;
	}
	@Override
	public String toString() {
		return "HoaDonTraPhong [MaHD=" + MaHD + ", ThueP=" + ThueP + ", NgayRa=" + NgayRa + ", giamGia=" + giamGia
				+ ", tongTien=" + tongTien + "]";
	}
	
	
}
