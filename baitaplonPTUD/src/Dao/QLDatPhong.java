package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.KhachHang;
import Entity.Phong;
import Entity.ThuePhong;



public class QLDatPhong {
	
	public ArrayList<ThuePhong> layDanhSachTP() {
		ArrayList<ThuePhong> list = new ArrayList<ThuePhong>();
		ThuePhong tp = null;
		try {
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = String.format("select *from ThuePhong");
			ResultSet resultSet = statement.executeQuery(sql);
			String maTP;
			String maP;
			String maKH;
			String tenKH;
			String loaiP;
			Double gia;
			Date ngayVao;
			while (resultSet.next()) {
				maTP = resultSet.getString(1);
				maP = resultSet.getString(2);
				maKH= resultSet.getString(3);
				tenKH = resultSet.getString(4);
				loaiP = resultSet.getString(5);
				gia = resultSet.getDouble(6);
				ngayVao=resultSet.getDate(7);
				tp = new ThuePhong(maTP, maP,maKH,tenKH,loaiP, gia,ngayVao);
				list.add(tp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public  boolean themThueP(String matp,String map,String makh,String tenkh,String lp,double gia,Date ngay) {
		try {

			String add = "INSERT into ThuePhong values('" + matp + "','" + map + "','" + makh + "',N'" + tenkh+ "','" + lp + "','" + gia+ "','" + ngay + "')";
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = String.format(add);
			statement.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			// return false;
			e.printStackTrace();
		}
		return true;

	}
	public boolean updateTrangThai(String map) {
		try {
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = String.format("UPDATE Phong set Trangthai=N'Đã thuê' where MaP='"+map+ "' ");
			statement.executeUpdate(sql);
			
		}catch(ClassNotFoundException| SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	}
	
