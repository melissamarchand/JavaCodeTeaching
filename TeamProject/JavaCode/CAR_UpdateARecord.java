package InsertIntoTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// update a record
public class UpdateARecord {

	public static final String UPDATE_USERS_SQL = "update users set name = ? where id = ?;";

	//public static void main(String[] args) throws SQLException {
	//	UpdateARecord updateARecord = new UpdateARecord();
	//	updateARecord.updateRecord();
	//}

	public void updateRecord() throws SQLException {
		System.out.println(UPDATE_USERS_SQL);

		// establish a connection

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false",
				"root", "");

// create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
			preparedStatement.setString(1, "Ram");
			preparedStatement.setInt(2, 1);

			// execute query or update query

			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			// print SQLException info
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
