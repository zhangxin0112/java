package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HIVELoader {
	private static String url = "jdbc:hive2://192.168.0.61:10000";
	private static String username = "root";
	private static String pwd = "root";
	private static String drivername = "org.apache.hive.jdbc.HiveDriver";
	private static String sql = "select * from testforzx limit 10";

	public static void main(String[] args) {
		HIVELoader hiveloader = new HIVELoader();
		try {
			hiveloader.exehive(url, username, pwd, drivername, sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void exehive(String url, String username, String pwd,
			String drivername, String sql) throws ClassNotFoundException {
		Class.forName(drivername);
		Connection conn = null;
		Statement stat = null;
		ResultSet rst = null;
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url, username, pwd);
				stat = conn.createStatement();
				rst = stat.executeQuery(sql);
				while (rst.next()) {
					System.out.println(rst.getString(2));
					// System.out.println(rst.getString("test_zx.a_iden_string"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// try {
				// stat.close();
				// } catch (SQLException e1) {
				// // TODO Auto-generated catch block
				// e1.printStackTrace();
				// }
				// try {
				// conn.close();
				// } catch (SQLException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }
			}
		}
	}
}
