package Entity;

public class KhachHang {
	private String MaKH;
	private String TenKH;
	private String Cmnd;
	private String QueQuan;
	private String GioiTinh;
	private String sdt;
	public KhachHang(String maKH, String tenKH, String cmnd, String queQuan, String gioiTinh, String sdt) {
		super();
		MaKH = maKH;
		TenKH = tenKH;
		Cmnd = cmnd;
		QueQuan = queQuan;
		GioiTinh = gioiTinh;
		this.sdt = sdt;
	}
	public String getMaKH() {
		return MaKH;
	}
	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	public String getCmnd() {
		return Cmnd;
	}
	public void setCmnd(String cmnd) {
		Cmnd = cmnd;
	}
	public String getQueQuan() {
		return QueQuan;
	}
	public void setQueQuan(String queQuan) {
		QueQuan = queQuan;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	@Override
	public String toString() {
		return MaKH +";"  + TenKH +";"+Cmnd+";" + QueQuan+" ;"+ GioiTinh+";" + sdt;
	}

	
	
}
