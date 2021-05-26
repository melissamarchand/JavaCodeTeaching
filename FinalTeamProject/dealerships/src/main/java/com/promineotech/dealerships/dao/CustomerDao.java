package com.promineotech.dealerships.dao;

import java.util.List;

import com.promineotech.dealerships.entity.Customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerDao {

    public List<Customer> listAllCustomers() {
        String sql = "SELECT * FROM customers";
        //DoSQL

        try (
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealership?useSSL=false",
						"root", "Dolphins");

				// create a car statement using connection object

				PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ) {

			// execute the car query

			ResultSet rs = preparedStatement.executeQuery();

            List<Customer> list = new List()<>;

            while (rs.next()) {
				int customer_id = rs.getInt("customer_id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				Customer customer = new Customer(customer_id, name, address, phone);
                list.add(customer)
			}

            return list;

        } catch (SQLException e) {
			printSQLException(e);
            return null;
		} 
            
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
