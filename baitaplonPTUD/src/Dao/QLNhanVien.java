package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entity.NhanVien;
import GUI.DangNhap;
import GUI.giaodienChinh;


public class QLNhanVien {
	private ArrayList<NhanVien> Dsnv;

	public QLNhanVien() {
		Dsnv = new ArrayList<NhanVien>();
	}

	public ArrayList<NhanVien> layDanhSachNhanVien() {
		NhanVien nhanVien = null;
		try {
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = String.format("select MaNV,TenNV,Chucvu,Sdt,Diachi from NhanVien");
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				String manv = resultSet.getString(1);
				String ten = resultSet.getString(2);
				String chucVu = resultSet.getString(3);
				String sdt  = resultSet.getString(4);
				String diaChi = resultSet.getString(5);
				nhanVien = new NhanVien(manv, ten, chucVu, sdt, diaChi);
				Dsnv.add(nhanVien);
			}

		} catch (ClassNotFoundException | SQLException e) {

		}

		return Dsnv;
	}
	public void DangNhapNV(String manv, String matkhau) {
		int dem=0;
		try {

			String sql="select TenNV,MatKhau from NhanVien where MaNV='"+manv+"' and Matkhau='"+matkhau+"'";
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				dem++;
			}
			if(dem==1) {
				giaodienChinh gdc=new giaodienChinh();
				gdc.setVisible(true);
				DangNhap dn=new DangNhap("PHẦN MỀM QUẢN LÝ KHÁCH SẠN");
				dn.setVisible(false);
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Bạn Nhập Chưa Đúng Tài Khoản Hoặc Mật Khẩu");
			}
		} catch (ClassNotFoundException | SQLException e) {
			
		}
	
		
	}

	

	/*public boolean themNhanVien(String manv, String hoten, String MatKhau, String chucvu, String sdt,
			String diaChi) {

		try {

			String add = "INSERT into NhanVien values('" + manv + "',N'" + hoten + "','" + MatKhau + "','" + chucvu + "',N'"
					+ sdt + "','" + diaChi + "')";
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = String.format(add);
			statement.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			return false;
		}
		return true;

	}

	public boolean xoaNhanVien(String manv) {

		try {

			String add = "DELETE from NhanVien where MaNV='" + manv + "'";
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = String.format(add);
			statement.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			return false;
		}
		return true;

	}

	public void suaNhanVien(String manv,String hoten, String chucvu, String sdt, String chucvu, double luong) {

		try {

			String add = "UPDATE NhanVien set HoTen=N'" + hoten + "',SoDT='" + sodt + "',Email='" + email
					+ "',ChucVu=N'" + chucvu + "',Luong=" + luong + "where MaNV='" + manv + "'";
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = String.format(add);
			statement.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {

		}

	}

	public NhanVien timNhanVienTheoMa(String key) {
		NhanVien a = null;
		try {

			String add = "SELECT MaNV,HoTen,SoDT,Email,ChucVu,Luong from NhanVien where MaNV='" + key + "'";
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = String.format(add);
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String manv = resultSet.getString(1);
				String ten = resultSet.getString(2);
				String soDT = resultSet.getString(3);
				String email = resultSet.getString(4);
				String chucVu = resultSet.getString(5);
				double luong = resultSet.getDouble(6);
				a = new NhanVien(manv, ten, soDT, luong);
			}

		} catch (ClassNotFoundException | SQLException e) {

		}
		return a;
	}

	public ArrayList<NhanVien> timNhanVienTheoTen(String key) {
		ArrayList<NhanVien> a = null;
		NhanVien nhanVien = null;
		try {
			a = new ArrayList<NhanVien>();
			String add = "SELECT MaNV,HoTen,SoDT,Email,ChucVu,Luong from NhanVien where HoTen like '%%" + key + "%%'";
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = String.format(add);
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String manv = resultSet.getString(1);
				String ten = resultSet.getString(2);
				String soDT = resultSet.getString(3);
				String email = resultSet.getString(4);
				String chucVu = resultSet.getString(5);
				double luong = resultSet.getDouble(6);
				nhanVien = new NhanVien(manv, ten, soDT, luong);

				a.add(nhanVien);
			}

		} catch (ClassNotFoundException | SQLException e) {

		}

		return a;
	}

	public int soLuongNhanVien() {
		int a = 0;
		try {
			String add = "SELECT Max(dem) from NhanVien";
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = String.format(add);
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				a = Integer.parseInt(resultSet.getString(1));
			}

		} catch (ClassNotFoundException | SQLException e) {

		}
		return a;
	}

	public static boolean kiemTraTaiKhoanMatKhau(String tk, String mk) {
		boolean flag = false;
		try {
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = String.format("select MatKhau from NhanVien where  MaNV='%s'", tk);
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				String temp = resultSet.getString(1);
				if (mk.equals(temp))
					flag = true;
			}

		} catch (ClassNotFoundException | SQLException e) {
			return false;
		}
		return flag;
	}

	public static NhanVien timTheoMa(String maNV) {
		NhanVien nhanVien = null;
		try {
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = String.format("select HoTen,SoDT,Email,ChucVu,luong from NhanVien where MaNV='%s'", maNV);
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				String ten = resultSet.getString(1);
				String soDT = resultSet.getString(2);
				String email = resultSet.getString(3);
				String chucVu = resultSet.getString(4);
				double luong = resultSet.getDouble(5);
				nhanVien = new NhanVien(maNV, ten, soDT, luong);
			}

		} catch (ClassNotFoundException | SQLException e) {

		}

		return nhanVien;
	}
*/
}
