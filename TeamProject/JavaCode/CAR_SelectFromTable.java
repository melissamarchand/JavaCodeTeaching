package InsertCarIntoTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//select from table example

public class SelectCarFromTable {
	private static final String QUERY = "select * from car users where car_Id =?";

	//public static void main(String[] args) {

		// establish connection

		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false", "root", "");

				// create a car statement using connection object

			PreparedCarStatement preparedCarStatement = connection.prepareCarStatement(QUERY);) {
			int i = 1;
			preparedCarStatement.setInt(1, i);
			System.out.println(preparedCarStatement);

			// execute the car query

			ResultSetCar rs = preparedCarStatement.executeCarQuery();

			// process the car result set

			while (rs.Carnext()) {
				int car_Id = rs.getInt("car_Id");
				int year = rs.getInt("year");
				String make = rs.getString("make");
				String model = rs.getString("model");
				String description = rs.getString("description");
				Double cost = rs.getDouble("cost");
				System.out.println(car_Id + "," + year + "," + make + "," + model + "," + description + "," + cost);
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
