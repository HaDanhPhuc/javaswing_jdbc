package Entity;

public class NhanVien {
	private String MaNv;
	private String TenNv;
	private String ChucVu;
	private String SDT;
	private String DiaChi;
	public NhanVien(String maNv, String tenNv, String chucVu, String sDT, String diaChi) {
		super();
		MaNv = maNv;
		TenNv = tenNv;
		ChucVu = chucVu;
		SDT = sDT;
		DiaChi = diaChi;
	}
	
	

	public String getMaNv() {
		return MaNv;
	}
	public void setMaNv(String maNv) {
		MaNv = maNv;
	}
	public String getTenNv() {
		return TenNv;
	}
	public void setTenNv(String tenNv) {
		TenNv = tenNv;
	}
	
	public String getChucVu() {
		return ChucVu;
	}
	public void setChucVu(String chucVu) {
		ChucVu = chucVu;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	@Override
	public String toString() {
		return MaNv=" ;"  + TenNv+";" +ChucVu+";"+ SDT+";" +DiaChi ;
	}
	
	

}
