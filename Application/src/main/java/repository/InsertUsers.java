package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.UserNotExistsException;
import model.Users;
import util.DatabaseConnection;
import util.UserIdGenerator;

/**
 * @author The Web Spyder
 *
 */
public class InsertUsers {

	static String LOGGINGSTATEMENT = "no previous login";

	public static void main(String[] args) {

		List<Users> userFromService = new ArrayList<>();
		userFromService.add(new Users("Abhi", "abhi@gmail.com", "1238567890", "Manager", 2000));

		List<Users> a = insertUsers(userFromService);
		System.out.println(a);
	}

	public static List<Users> insertUsers(List<Users> userList) {
		Connection conn = null;
		try {
			conn = DatabaseConnection.getConnection();

			List<Users> duplicateUser = new ArrayList<>();
			int userId = UserIdGenerator.generateId();
			int i = 0;

			for (Users u : userList) {

				try {
					if (findUserByNameEmail(conn, u.getEmail(), u.getUserName()) == true) {
						duplicateUser.add(u);
					}

				} catch (UserNotExistsException ex) {
					PreparedStatement pst = conn.prepareStatement("insert into users values (?,?,?,?,?,?,?)");
					pst.setInt(1, userId);

					pst.setString(2, u.getUserName());
					pst.setString(3, u.getEmail());
					pst.setString(4, u.getPhone());
					pst.setString(5, u.getRole());
					pst.setInt(6, u.getCredit());
					pst.setString(7, LOGGINGSTATEMENT);

					int row = pst.executeUpdate();

					userId += 1;
					i += 1;

				}

			}
			UserIdGenerator.updateCount(i);
			return duplicateUser;

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("Database Error");
		} catch (RuntimeException re) {
			re.printStackTrace();
			throw new RuntimeException(re);
		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}

	}

	public static boolean findUserByNameEmail(Connection conn, String email, String name)
			throws UserNotExistsException {

		try {

			PreparedStatement pst = conn.prepareStatement("select * from users where email=? and userName=? ");
			pst.setString(1, email);
			pst.setString(2, name);
			pst.execute();
			ResultSet rs = pst.getResultSet();

			if (rs.next()) {
				return true;
			} else {
				System.out.println("not found");
				throw new UserNotExistsException();
			}

		} catch (SQLException e) {
			System.out.println("error in checking user");
			throw new RuntimeException("Error in checking data");

		}
	}

}
