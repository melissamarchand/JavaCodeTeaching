package createCustomerTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// create "Customers" table in java JDBC program in a database.

public class CreateCustomersTable {

	// if previous customer table exists, drop old table

	private static final String dropTableSQL = "drop table customers;";

	private static final String createTableSQL = "create table customers (\r\n" + " Car_id int(7) primary key, \r\n"
			+ " name varchar(20), \r\n" + " address varchar(60),\r\n" + " email varchar(20),\r\n"
			+ " phone_number int(10)\r\n" + "  );";

	public static void main(String[] args) throws SQLException {
		CreateCustomersTable createTable = new CreateCustomersTable();
		createTable.createTable();
	}

	public void createTable() throws SQLException {
		System.out.println(createTableSQL);
		// establishing a connection
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false",
				"root", "");

				// create statement using connection object
				Statement statement = connection.createStatement();) {

			// execute the query or update query
			// statement.execute(dropTableSQL);

			statement.execute(createTableSQL);
		} catch (SQLException e) {

			// print SQL exception information
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
