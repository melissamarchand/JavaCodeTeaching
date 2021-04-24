

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// update a customer record
public class UpdateACustRecord {

	public static final String UPDATE_USERS_SQL = "update customer users set name = ? where customer_id = ?;";

//	public static void main(String[] args) throws SQLException {
//		UpdateARecord updateARecord = new UpdateARecord();
//		updateARecord.updateARecord();
//	}

	public void updateACustRecord(Int customer_id, String name, String address, String phone, String email) throws SQLException {
		System.out.println(UPDATE_USERS_SQL);


		// establish a connection

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false",
				"root", "");

// create a statement using connection object
			PreparedCustStatement preparedCustStatement = connection.prepareCustStatement(UPDATE_CUSTOMER_USERS_SQL)) {
			preparedCustStatement.setInt(1, customer_id);
			preparedCustStatement.setString(2, name);
			preparedCustStatement.setString(3, address);
			preparedCustStatement.setString(4, phone);
			preparedCustStatement.setString(5, email);

			// execute query or update query

			preparedCustStatement.executeUpdate();
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
