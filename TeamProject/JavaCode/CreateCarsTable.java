package createCarTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// create "cars" table in java JDBC program in a database.

public class CreateCarTable {
        
	// use statement below if old table exists
	//private static final String dropTableSQL = "drop table cars;";
	
	private static final String createTableSQL = "create table cars (\r\n" + " Car_id int(3) primary key, \r\n"
			+ " year int(4), \r\n" + " make varchar(20),\r\n" + " model varchar(20),\r\n"
			+ " color varchar(20),\r\n" + " cost int(6) \r\n" + " );";

	public static void main(String[] args) throws SQLException {
	CreateCarTable createTableExample = new CreateCarTable();
		createTableExample.createTable();
	}

	public void createTable() throws SQLException {
		System.out.println(createTableSQL);
		// establishing a connection
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false",
				"root",
				"");

				// create statement using connection object
				Statement statement = connection.createStatement();) {

			// execute the query or update query
			
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

