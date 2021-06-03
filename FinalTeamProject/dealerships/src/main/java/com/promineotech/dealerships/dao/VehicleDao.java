package com.promineotech.dealerships.dao;

import org.springframework.stereotype.Service;

@Service
public class VehicleDao {
    private static final String HOSTNAME = "jdbc:mysql://localhost:3306/dealership?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Dolphins";

     public List<Vehicle> getVehicle(Integer vehicleID) {
    	   final String getVehicle = "SELECT * FROM vehicles where transactionID = ?";
    	   
    	   try(
    			   Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
    			   
    			      PreparedStatement preparedStatement = connection.prepareStatement(getVehicle);
    			     
    			   
    			   ){
    		   preparedStatement.setInt(1, vehicleID);
    		   
    		   ResultSet rs = preparedStatement .executeQuery();
    		   List<Vehicle> list = new ArrayList<>();
    		   while (rs.next()) {
    			   int vehicleid = rs.getInt("vehicleID");
    			   int dealershipID = rs.getInt("dealershipID");
    			   boolean is_sold = rs.getBoolean("is_sold");
    			   String make = rs.getString("make");
    			   String model = rs.getString("model");
    			   double price = rs.getDouble("price");
    			   Vehicle vehicle = new Vehicle(vehicleID, dealershipID, is_sold, make, model, price);
    			   list.add(vehicle);
    		   }
    		   return list;
    	   } catch (SQLException e) {
    		  printSQLException(e);
    		   return Collections.emptyList();
    	   }
       }
       
      
       public void newVehicle(int vehicleID, int dealershipID, boolean is_sold, String make, String model, double price) {
    	   final String updateVehicle = "INSERT into vehicle (int vehicleID, int dealershipID, boolean is_sold, String make, String model, double price)" +
       "Values (?,?,?,?,?,?);";
    	   
    	   try(
    		  Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
    			   
    			   PreparedStatement preparedStatement = connection.prepareStatement(updateVehicle)){
    		   preparedStatement.setInt(1, vehicleID);
    		   preparedStatement.setInt(2,dealershipID);
    		   preparedStatement.setBoolean(3, is_sold);
    		   preparedStatement.setString(4, make);
    		   preparedStatement.setString(5, model);
    		   preparedStatement.setDouble(6, price);
    		   
    		   preparedStatement.executeUpdate();   	
  	   }catch (SQLException e) {
  		   printSQLException(e);
  	   }
       }
       
       public void deleteVehicle(Integer vehicleID) {
    	   final String getVehicles = "DELETE * FROM vehicles where vehicles_ID = ?";
    	   
    	   try(
    			   Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
    			   
    			   PreparedStatement preparedStatement = connection.prepareStatement(getVehicles);
    			 
    			   ){
    		   preparedStatement.setInt(1, vehicleID);
    		   
    		   int result = preparedStatement.executeUpdate();
    		   System.out.println("Number of vehicle records affected ::" + result);
    	   }catch (SQLException e) {
    		   printSQLException(e);
    	   }
    	   
    	   
    	   }
       public static void printSQLException(SQLException ex) {
    	   for(Throwable e :ex) {
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
} {
    }
    
}
