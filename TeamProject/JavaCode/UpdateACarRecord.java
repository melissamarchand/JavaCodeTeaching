import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// update a car record
public class UpdateACarRecord {

	public static final String UPDATE_CAR_SQL = "update cars SET cost = cost * (100 - ? ) / 100;";

	// public static void main(String[] args) throws SQLException {
	// UpdateARecord updateARecord = new UpdateARecord();
	// updateARecord.updateRecord();
	// }

	public static void updateCarSale(int carId) throws SQLException {
		System.out.println(UPDATE_CAR_SQL);

		// establish a connection

		try (
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealership?useSSL=false",
						"root", "Dolphins");

				// create a car statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CAR_SQL)) {
			preparedStatement.setInt(1, carId);

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
