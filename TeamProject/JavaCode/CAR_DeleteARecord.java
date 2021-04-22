package CreateUsersTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// delete a record

public class DeleteARecord {
	private static final String DELETE_USERS_SQL = "delete from users where id = ";

	// public static void main(String[] args) throws SQLException {
	// 	DeleteARecord deleteARecord = new DeleteARecord();
	// 	deleteARecord.deleteRecord();
	// }

	public void deleteRecord(String record) throws SQLException {
		String command = DELETE_USERS_SQL + record + ";";
		System.out.println(command);

		// establish connection

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false",
				"root", "");

				// create a statement using connection object

				Statement statement = connection.createStatement();) {

			// execute the query or update query

			int result = statement.executeUpdate(command);
			System.out.println("Number of records affected :: " + result);
		} catch (SQLException e) {

			// print SQL exception info:
			printSQLException(e);
		}
		// try-with-resource statement will auto close the connection.

	}

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
