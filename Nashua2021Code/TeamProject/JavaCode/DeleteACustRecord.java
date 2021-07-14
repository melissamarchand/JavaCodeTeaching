import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// delete a cust record

public class DeleteACustRecord {
	private static final String DELETE_CUST_SQL = "DELETE FROM customers where customer_id = ?;";

	// public static void main(String[] args) throws SQLException {
	// DeleteARecord deleteARecord = new DeleteARecord();
	// deleteARecord.deleteRecord();
	// }

	public static void deleteCustRecord(int cust_id) throws SQLException {
		System.out.println(DELETE_CUST_SQL);

		// establish connection

		try (
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealership?useSSL=false",
						"root", "Dolphins");

				// create a statement using connection object

				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUST_SQL);) {
			preparedStatement.setInt(1, cust_id);
			// execute the query or update query

			int result = preparedStatement.executeUpdate();
			System.out.println("Number of customer records affected :: " + result);
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
