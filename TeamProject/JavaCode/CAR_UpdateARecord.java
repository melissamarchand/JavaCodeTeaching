import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedCarStatement;
import java.sql.SQLException;

// update a car record
public class UpdateACarRecord {

	public static final String UPDATE_CAR_USERS_SQL = "update car set price = price * (100 - ? ) / 100;";

	//public static void main(String[] args) throws SQLException {
	//	UpdateARecord updateARecord = new UpdateARecord();
	//	updateARecord.updateRecord();
	//}

	public void updateCarSale(int sale) throws SQLException {
		System.out.println(UPDATE_CAR_USERS_SQL);

		// establish a connection

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false",
				"root", "");

// create a car statement using connection object
			PreparedCarStatement preparedCarStatement = connection.prepareStatement(UPDATE_CAR_USERS_SQL)) {
			preparedCarStatement.setInt(1, sale);

			// execute query or update query

			preparedCarStatement.executeUpdate();
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
