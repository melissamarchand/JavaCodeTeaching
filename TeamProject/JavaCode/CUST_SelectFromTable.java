package InsertCustIntoTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//select customer from table

public class SelectCustFromTable {
	private static final String QUERY = "select * from customer users where customer_id =?";

//	public static void main(String[] args) {

		// establish connection

		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false", "root", "");

				// create a statement using connection object

			PreparedCustStatement preparedCustStatement = connection.prepareCustStatement(QUERY);) {
			int i = 1;
			preparedCustStatement.setInt(1, i);
			System.out.println(preparedCustStatement);

			// execute the query

			ResultSetCust rs = preparedCustStatement.executeQuery();

			// process the result set

			while (rs.next()) {
				int customer_id = rs.getInt("customer_id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				System.out.println(customer_id + "," + name + "," + address + "," + phone + "," + email);
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
