package Entity;

public class Phong {
	private String MaP;
	private String TenP;
	private String maLoaiPhong;
	private String TrangThai;
	private String tinhTrang;
	private String GhiChu;
	
	
	public Phong(String maP, String tenP, String maLoaiPhong, String trangThai, String tinhTrang, String ghiChu) {
		super();
		MaP = maP;
		TenP = tenP;
		this.maLoaiPhong = maLoaiPhong;
		TrangThai = trangThai;
		this.tinhTrang = tinhTrang;
		GhiChu = ghiChu;
	}


	public String getMaP() {
		return MaP;
	}


	public void setMaP(String maP) {
		MaP = maP;
	}


	public String getTenP() {
		return TenP;
	}


	public void setTenP(String tenP) {
		TenP = tenP;
	}


	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}


	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}


	public String getTrangThai() {
		return TrangThai;
	}


	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}


	public String getTinhTrang() {
		return tinhTrang;
	}


	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}


	public String getGhiChu() {
		return GhiChu;
	}


	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}


	@Override
	public String toString() {
		return MaP+";"+TenP +";"+maLoaiPhong+" ;"+ TrangThai+";"+tinhTrang+";"+GhiChu;
				
	}
	
	

}
