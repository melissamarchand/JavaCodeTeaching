import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//INSERT a record into "users" table.

public class InsertACarRecord {
	private static final String INSERT_USERS_SQL = "INSERT INTO car" + " (year, make, model, description, cost) VALUES "
					+ "  (?, ?, ?, ?, ?);";

		//	public static void main(String[] args) throws SQLException {
		//		insertIntoTable createTableExample = new insertIntoTable();
		//		createTableExample.insertRecord();
		//	}

		public void insertCarRecord(Int year, String make, String model, String description, Double cost) throws SQLException {

				System.out.println(INSERT_USERS_SQL);

				// establishing a connection

				try (Connection connection = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false", "root", "");

						// create a statement using connection object

					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
					preparedStatement.setInt(1, year);
					preparedStatement.setString(2, make);
					preparedStatement.setString(3, model);
					preparedStatement.setString(4, description);
					preparedStatement.setDouble(5, cost);

					System.out.println(preparedStatement);

					// execute the query or update query

					preparedStatement.executeUpdate();
				} catch (SQLException e) {

					// print SQL exception info

					printSQLException(e);
				}

				// try with resource statement will auto close the connection.
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
