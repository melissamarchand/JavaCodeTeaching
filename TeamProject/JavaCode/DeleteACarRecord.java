import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// delete a car record

public class DeleteACarRecord {
	private static final String DELETE_CAR_SQL = "DELETE FROM cars where car_id = ?;";

	// public static void main(String[] args) throws SQLException {
	// DeleteARecord deleteARecord = new DeleteARecord();
	// deleteARecord.deleteRecord();
	// }

	public static void deleteCarRecord(int car_id) throws SQLException {
		System.out.println(DELETE_CAR_SQL);

		// establish connection

		try (
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealership?useSSL=false",
						"root", "Dolphins");

				// create a statement using connection object

				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CAR_SQL);) {
			preparedStatement.setInt(1, car_id);

			// execute the query or update query

			preparedStatement.executeUpdate();
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
