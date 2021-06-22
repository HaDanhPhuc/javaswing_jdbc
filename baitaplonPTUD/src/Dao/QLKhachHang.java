package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.KhachHang;



public class QLKhachHang {
	public ArrayList<KhachHang> layDanhSachKH() {
	ArrayList<KhachHang> list = new ArrayList<KhachHang>();
	KhachHang khachHang = null;
	try {
		Connection connection = KetNoiSQL.ketNoiVoiSQL();
		Statement statement = connection.createStatement();
		String sql = String.format("select *from KhachHang");
		ResultSet resultSet = statement.executeQuery(sql);
		String ma;
		String ten;
		String cmnd;
		String quequan;
		String gioitinh;
		String sdt;
		while (resultSet.next()) {
			ma = resultSet.getString(1);
			ten = resultSet.getString(2);
			cmnd = resultSet.getString(3);
			quequan = resultSet.getString(4);
			gioitinh = resultSet.getString(5);
			sdt = resultSet.getString(6);
			khachHang = new KhachHang(ma, ten,cmnd,quequan,gioitinh, sdt);
			list.add(khachHang);
		}
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	return list;
	}
	public ArrayList<KhachHang> DsKHTrongNgay(String ngay) {
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		KhachHang khachHang = null;
		try {
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = String.format("select *from ThuePhong where Ngaythue like '%" + ngay + "%' " );
			ResultSet resultSet = statement.executeQuery(sql);
			String ma;
			String ten;
			String cmnd;
			String quequan;
			String gioitinh;
			String sdt;
			while (resultSet.next()) {
				ma = resultSet.getString(1);
				ten = resultSet.getString(2);
				cmnd = resultSet.getString(3);
				quequan = resultSet.getString(4);
				gioitinh = resultSet.getString(5);
				sdt = resultSet.getString(6);
				khachHang = new KhachHang(ma, ten,cmnd,quequan,gioitinh, sdt);
				list.add(khachHang);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
		}
	public boolean themkhachhanh(String makh,String tenkh,String cmnd,String quequan,String gioitinh,String sdt) {
	try {
		Connection con = KetNoiSQL.ketNoiVoiSQL();
		Statement smt = con.createStatement();
		String sql = String.format("INSERT into KhachHang(MaKH,TenKH,CMND,Quequan,Gioitinh,Sodienthoai)  values('%s',N'%s','%s',N'%s',N'%s','%s')", makh,tenkh, cmnd, quequan, gioitinh,sdt);
																								
		smt.executeUpdate(sql);
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}

	return true;

}
	public boolean xoaKHang(String makh) {

		try {

			String add = "DELETE from KhachHang where MaKH='" + makh + "'";
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = String.format(add);
			statement.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			return false;
		}
		return true;

	}
public void capNhatkhachhanh(String makh,String tenkh,String cmnd,String quequan,String gioitinh,String sdt) {
		
		try {
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = String.format("UPDATE KhachHang set TenKH=N'%s', CMND='%s',Quequan=N'%s',Gioitinh=N'%s',Sodienthoai='%s' where MaKH='%s'",tenkh,cmnd,quequan,gioitinh,sdt,makh);
			statement.executeUpdate(sql);		
		}catch(ClassNotFoundException| SQLException e) {
			e.printStackTrace();
		}
		
		} 


}
