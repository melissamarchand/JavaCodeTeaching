package com.promineotech.dealerships.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.promineotech.dealerships.entity.Transaction;

public class LocationDao {
	
	//getLocation method- get a location by id
    public List<Location> getLocation(Integer locationID){
        final String getLocation = "SELECT * FROM locations where locationID = ?";

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealership?useSSL=false",
                        "root", "Dolphins");

                // create a statement using connection object
                    PreparedStatement preparedStatement = connection.prepareStatement(getLocation);
                    
            ) {
                preparedStatement.setInt(1, LocationID);
            // execute the location query
            ResultSet rs = preparedStatement.executeQuery();
            List<Location> list = new ArrayList<>();
            while (rs.next()) {
                int locationID = rs.getInt("locationID");
                String location_name = rs.getString("locationName");
              
                Location location = new Location(locationID, location_name);
                list.add(location);
            }
            return list;
        } catch (SQLException e) {
            printSQLException(e);
            return null;
        } 
    }

    
    public void addNewLocation(int locationID, String location_name) {
         
        final String updateTransaction = "INSERT into locations (locationID, location_name)" +
            "Values (?, ?);";

        // establish a connection

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealership?useSSL=false",
                        "root", "Dolphins");

                // create a car statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(updateTransaction)) {
                    preparedStatement.setInt(1, locationID);
                    preparedStatement.setString(2, location_name);


            // execute query or update query

            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQLException info
            printSQLException(e);
        }
    }


    public void updateLocation(int locationID, String location_name) {
         
        final String updateLocation = "update locations set locationID = ?, location_name = ? , where locationID = ?;";

        // establish a connection

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealership?useSSL=false",
                        "root", "Dolphins");

                // create a car statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(updateLocation)) {
                    preparedStatement.setInt(1, locationID);
                    preparedStatement.setString(2, location_name);
                

            // execute query or update query

            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQLException info
            printSQLException(e);
        }
    }


    public void deleteLocation(Integer locationID){
        final String getTransaction = "DELETE * FROM locations where locationID = ?";

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dealership?useSSL=false",
                        "root", "Dolphins");

                // create a statement using connection object
                    PreparedStatement preparedStatement = connection.prepareStatement(getTransaction);
                    
            ) {
                preparedStatement.setInt(1, locationID);
            // execute the location query
            int result = preparedStatement.executeUpdate();
            System.out.println("Number of location records affected :: " + result);
        } catch (SQLException e) {
            printSQLException(e);
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
