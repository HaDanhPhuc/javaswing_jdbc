package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Dao.KetNoiSQL;

public class XuLyChung {
	public static boolean kiemTraMaNhanVien(String maNV) {
		String regex = "^NV[0-9]{1,8}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(maNV);
		return matcher.find();
	}

	public static boolean kiemTraMaPhong(String map) {
		String regex = "^P[0-9]{1,8}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(map);
		return matcher.find();
	}

	public static boolean kiemTraMaKhachHang(String maKH) {
		String regex = "^KH[0-9]{1,8}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(maKH);
		return matcher.find();
	}
	public static boolean kiemTraCMND(String cmnd) {
		String regex = "[0-9]$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(cmnd);
		return matcher.find();
	}

	public static boolean kiemTraMaLoai(String maLP) {
		String regex = "^LP[0-9]{1,8}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(maLP);
		return matcher.find();
	}
	public static boolean kiemTraTiengViet(String hoten) {
		String regex = "[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ0-9 ]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(hoten);
		return matcher.find();
	}
	public static boolean kiemTraSoDT(String sdt) {
		String regex = "(09|01|08|03|07|05)[0-9]{8}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(sdt);
		return matcher.find();
	}

	public static boolean kiemTraEmail(String email) {
		String regex = "^[a-zA-Z]+[a-zA-Z0-9._]*@gmail.com$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.find();
	}

	
	public static String layMaKH() {
		String makh = null;
		try {
			Connection connection =KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = "select max(dem) from KhachHang";
			ResultSet resultSet = statement.executeQuery(sql);
			int dem = 0;
			while (resultSet.next())
				dem = resultSet.getInt(1);
			makh = String.format("KH%d", dem + 1);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return makh;
	}

	public static String layMaNV() {
		String manv = null;
		try {
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = "select max(dem) from NhanVien";
			ResultSet resultSet = statement.executeQuery(sql);
			int dem = 0;
			while (resultSet.next())
				dem = resultSet.getInt(1);
			manv = String.format("NV%d", dem + 1);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return manv;
	}
	public static String layMaTP() {
		String matp = null;
		try {
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = "select max(dem) from ThuePhong";
			ResultSet resultSet = statement.executeQuery(sql);
			int dem = 0;
			while (resultSet.next())
				dem = resultSet.getInt(1);
			matp = String.format("TP%d", dem + 1);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return matp;
	}

	public static String layMaHoaDon() {
		String mahd = null;
		try {
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = "select max(dem) from HoaDon";
			ResultSet resultSet = statement.executeQuery(sql);
			int dem = 0;
			while (resultSet.next())
				dem = resultSet.getInt(1);
			mahd = String.format("HD%d", dem + 1);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return mahd;
	}

	public static String layMaPhong() {
		String map = null;
		try {
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = "select max(dem) from Phong";
			ResultSet resultSet = statement.executeQuery(sql);
			int dem = 0;
			while (resultSet.next())
				dem = resultSet.getInt(1);
			map = String.format("P%d", dem + 1);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	public static String layMaLP() {
		String mancc = null;
		try {
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = "select max(dem) from LoaiPhong";
			ResultSet resultSet = statement.executeQuery(sql);
			int dem = 0;
			while (resultSet.next())
				dem = resultSet.getInt(1);
			mancc = String.format("LP%d", dem + 1);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return mancc;
	}

}
