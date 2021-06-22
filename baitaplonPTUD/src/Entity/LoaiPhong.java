package Entity;

public class LoaiPhong {
	private String MaLoai;
	private String TenLoai;
	private Double gia;
	public LoaiPhong(String maLoai, String tenLoai, Double gia) {
		super();
		MaLoai = maLoai;
		TenLoai = tenLoai;
		this.gia = gia;
	}
	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	public String getTenLoai() {
		return TenLoai;
	}
	public void setTenLoai(String tenLoai) {
		TenLoai = tenLoai;
	}
	public Double getGia() {
		return gia;
	}
	public void setGia(Double gia) {
		this.gia = gia;
	}
	@Override
	public String toString() {
		return MaLoai + ";" + TenLoai + ";" + gia ;
	}
	
	
}
