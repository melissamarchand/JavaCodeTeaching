import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// update a customer record
public class UpdateACustRecord {

	public static final String UPDATE_CUST_SQL = "update customers set name = ?, address = ? , phone = ?, email = ? where customer_id = ?;";

	// public static void main(String[] args) throws SQLException {
	// UpdateARecord updateARecord = new UpdateARecord();
	// updateARecord.updateARecord();
	// }

	public static void updateCustRecord(int customer_id, String name, String address, String phone, String email)
			throws SQLException {
		System.out.println(UPDATE_CUST_SQL);

		// establish a connection

		try (
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealership?useSSL=false",
						"root", "Dolphins");

				// create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUST_SQL)) {

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, address);
			preparedStatement.setString(3, phone);
			preparedStatement.setString(4, email);
			preparedStatement.setInt(5, customer_id);

			// execute query or update query

			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			// print customer SQLException info
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
