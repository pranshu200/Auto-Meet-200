package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author The Web Spyder Get Connection to database
 */
public class DatabaseConnection {

	/**
	 * 
	 * @return Connection object to get connection instance to database
	 */

	public static Connection getConnection() {
		Connection conn = null;
		try {

			Class.forName("org.apache.derby.jdbc.ClientDriver");
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/AutoMeet200/Database/mydb");

		}

		catch (ClassNotFoundException e) {

			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return conn;
	}

}
