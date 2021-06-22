package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoiSQL {
	private static final String user="sa";
	private static final String password="sapassword";
	public static Connection ketNoiVoiSQL() throws SQLException, ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://localhost;databaseName=QL_KSan;";
		Connection connection = DriverManager.getConnection(url,user,password);
		return connection;
	}

}
