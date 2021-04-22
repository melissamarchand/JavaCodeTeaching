package InsertCustIntoTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//INSERT a customer record into cust "users" table.

public class insertCustIntoTable {
	private static final String INSERT_CUST_USERS_SQL = "INSERT INTO customer users" + " (customer_id, name, address, phone, email) VALUES "
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
					preparedStatement.setInt(1, customer_id);
					preparedStatement.setString(2, name);
					preparedStatement.setString(3, address);
					preparedStatement.setString(4, phone);
					preparedStatement.setString(5, email);

					System.out.println(preparedCustStatement);

					// execute the query or update query

					preparedCustStatement.executeCustUpdate();
				} catch (SQLException e) {

					// print cust SQL exception info

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
