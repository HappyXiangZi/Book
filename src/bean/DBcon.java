package bean;
import java.sql.*;

public class DBcon {
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/books?"
			+ "useUnicode=true&characterEncoding=UTF-8";
	private static final String user = "root";
	private static final String psw = "123456";
	public static Connection getConnection() {
		Connection dbConnection = null;
		try {Class.forName(DRIVER_CLASS);
			dbConnection = DriverManager.getConnection(url, user, psw);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dbConnection;
	}
	//�ر�����
	public static void closeConnection(Connection dbConnection) {
		try {
			if (dbConnection!=null&&(!dbConnection.isClosed())) {
				dbConnection.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void closeResultSet(ResultSet res) {
		try {
			if (res!=null) {
				res.close();
				res = null;
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void closeStatement(PreparedStatement pStatement) {
		try {
			if (pStatement!=null) {
				pStatement.close();
				pStatement=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
