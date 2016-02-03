package Reflect;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection getCon() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		// ¼ÓÉÏ×Ö·û´®±àÂëÖ¸¶¨£¬·ÀÖ¹ÂÒÂë
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test?characterEncoding=utf8",
				"root", "root");
		return connection;
	}

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test", "root", "root");
		System.out.println(connection);
		connection.close();

	}
}
