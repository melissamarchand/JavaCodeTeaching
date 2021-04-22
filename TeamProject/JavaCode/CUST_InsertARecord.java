package InsertCustIntoTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//INSERT a record into "users" table.

public class insertIntoTable {
	private static final String INSERT_CUST_USERS_SQL = "INSERT INTO users" + " (id, name, email, country, password) VALUES "
					+ "  (?, ?, ?, ?, ?);";

			//public static void main(String[] args) throws SQLException {
			//	insertIntoTable createTableExample = new insertIntoTable();
			//	createTableExample.insertRecord();
			//}

			public void insertCustRecord() throws SQLException {
				System.out.println(INSERT_CUST_USERS_SQL);

				// establishing a connection

				try (Connection connection = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false", "root", "");

						// create a statement using connection object

						PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
					preparedStatement.setInt(1, 1);
					preparedStatement.setString(2, "Melissa");
					preparedStatement.setString(3, "melissa@email.com");
					preparedStatement.setString(4, "US");
					preparedStatement.setString(5, "secret");

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
