package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entity.LoaiPhong;
import Entity.Phong;





public class QLPhong {
	public ArrayList<Phong> layDanhPhong() {
		ArrayList<Phong> dsP = new ArrayList<Phong>();
		Phong phong;
		try {
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql="select *from Phong ";
			//String sql = "select p.MaPhong,p.TenPhong,p.MaLP,p.Trangthai,p.tinhTrang,p.Ghichu from Phong p left join LoaiPhong lp on p.MaLP=lp.MaLP";
			ResultSet resultSet = statement.executeQuery(sql);
			String maP, tenP,maLoai, tenloaiP,trangthai,tinhtrang,ghichu;
			
	
			while (resultSet.next()) {
				maP = resultSet.getString(1);
				tenP = resultSet.getString(2);
				maLoai=resultSet.getString(3);
				trangthai = resultSet.getString(4);
				tinhtrang=resultSet.getString(5);
				ghichu= resultSet.getString(6);
				
				
				phong = new Phong(maP, tenP,maLoai,trangthai,tinhtrang, ghichu );

				dsP.add(phong);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return dsP;
	}
	public ArrayList<Phong> layDanhPhongTrong() {
		ArrayList<Phong> dsPt = new ArrayList<Phong>();
		Phong phong;
		try {
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql ="select *from  Phong where Trangthai=N'Trống' ";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maPhong = rs.getString(1);
				String tenphong = rs.getString(2);				
				String maLP = rs.getString(3);
				String trangthai = rs.getString(4);	
				String tinhtrang = rs.getString(5);	
				String  ghichu = rs.getString(6);	
				Phong p = new Phong(maPhong,tenphong,maLP,trangthai,tinhtrang,ghichu);			
				dsPt.add(p);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return dsPt;
	}
	public  boolean themPhong(String map,String tenp,String maLoai,String trangthai,String tinhtrang,String ghichu) {
		try {
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = String.format(
					"INSERT into Phong(MaPhong,TenPhong,MaLP,Trangthai,Tinhtrang,Ghichu )values('%s',N'%s','%s',N'%s',N'%s','%s')",map,tenp,maLoai,trangthai,tinhtrang,ghichu);
					
			statement.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	public void suaPhong(String map,String tenp,String maLoai,String trangthai,String tinhtrang,String ghichu) {
			
			try {
				Connection connection = KetNoiSQL.ketNoiVoiSQL();
				Statement statement = connection.createStatement();
				String sql = String.format("UPDATE Phong set TenPhong=N'%s', MaLP='%s',Trangthai=N'%s',Tinhtrang=N'%s',Ghichu='%s' where MaPhong='%s'",tenp,maLoai,trangthai,tinhtrang,ghichu,map);
				statement.executeUpdate(sql);		
			}catch(ClassNotFoundException| SQLException e) {
				e.printStackTrace();
			}
			
			} 

	public boolean xoaPhong(String map) {

		try {

			String add = "DELETE from Phong where MaPhong='" + map + "'";
			Connection connection = KetNoiSQL.ketNoiVoiSQL();
			Statement statement = connection.createStatement();
			String sql = String.format(add);
			statement.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			return false;
		}
		return true;

	}
}
