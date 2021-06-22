package Entity;

import java.sql.Date;

public class ThuePhong {
	private String maTP;
	private String maphong;
	private String maKH;
	private String tenKH;
	private String loaiP;
	private Double gia;
	private Date ngayVao;
	
	
	

	public ThuePhong(String maTP, String maphong, String maKH, String tenKH, String loaiP, Double gia, Date ngayVao) {
		super();
		this.maTP = maTP;
		this.maphong = maphong;
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.loaiP = loaiP;
		this.gia = gia;
		this.ngayVao = ngayVao;
	}

	public String getMaTP() {
		return maTP;
	}

	public void setMaTP(String maTP) {
		this.maTP = maTP;
	}

	public String getMaphong() {
		return maphong;
	}

	public void setMaphong(String maphong) {
		this.maphong = maphong;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getLoaiP() {
		return loaiP;
	}

	public void setLoaiP(String loaiP) {
		this.loaiP = loaiP;
	}

	public Double getGia() {
		return gia;
	}

	public void setGia(Double gia) {
		this.gia = gia;
	}

	

	

	public Date getNgayVao() {
		return ngayVao;
	}

	public void setNgayVao(Date ngayVao) {
		this.ngayVao = ngayVao;
	}

	@Override
	public String toString() {
		return maTP+";"+maphong+";"+maKH+";"+ tenKH+";"+loaiP+";"+gia+";" +ngayVao;
	}
	
	
	
}
