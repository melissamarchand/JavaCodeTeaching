package InsertIntoTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//select from table example

public class SelectFromTable {
	private static final String QUERY = "select * from users where id =?";

	//public static void main(String[] args) {

		// establish connection

		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false", "root", "");

				// create a statement using connection object

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
			int i = 1;
			preparedStatement.setInt(1, i);
			System.out.println(preparedStatement);

			// execute the query

			ResultSet rs = preparedStatement.executeQuery();

			// process the result set

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				String password = rs.getString("password");
				System.out.println(id + "'" + name + "," + email + "," + country + "," + password);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		// try to close the connection
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
