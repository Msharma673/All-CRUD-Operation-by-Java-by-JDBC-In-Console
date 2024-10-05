//package com.demo.CRUDmysql;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import com.demo.MysqlConnection.MysqlConnection;
//
//public class Select {
//	
//	 public static void main(String[] args) {
//	        String selectQuery = "SELECT * FROM faculty";
//	        Statement statement;
//	        try {
//	            statement = MysqlConnection.getConnectionDetails().createStatement();
//	            ResultSet resultSet = statement.executeQuery(selectQuery);
//	            while (resultSet.next()) {
//	                System.out.println(resultSet.getInt(1)  + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
//	            }
//	            MysqlConnection.getConnectionDetails().close();
//	            
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	    }
//
//}


package com.demo.CRUDmysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.demo.MysqlConnection.MysqlConnection;

public class Select {

    public static void main(String[] args) {
        // SQL queries for different selections
        String selectAllQuery = "SELECT * FROM faculty";
        String selectByNameQuery = "SELECT * FROM faculty WHERE fac_name = ?";
        String selectByIdQuery = "SELECT * FROM faculty WHERE id = ?";

        try
        (Scanner scanner = new Scanner(System.in)) {
            // Menu for user to select query type
            System.out.println("Select an option:");
            System.out.println("1. Select all records");
            System.out.println("2. Select by name");
            System.out.println("3. Select by ID");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            try (Connection conn = MysqlConnection.getConnectionDetails()) {
                PreparedStatement preparedStatement = null;

                switch (choice) {
                    case 1: // Select all records
                        preparedStatement = conn.prepareStatement(selectAllQuery);
                        break;

                    case 2: // Select by name
                        System.out.println("Enter the faculty name:");
                        String name = scanner.nextLine();
                        preparedStatement = conn.prepareStatement(selectByNameQuery);
                        preparedStatement.setString(1, name);
                        break;

                    case 3: // Select by ID
                        System.out.println("Enter the faculty ID:");
                        int id = scanner.nextInt();
                        preparedStatement = conn.prepareStatement(selectByIdQuery);
                        preparedStatement.setInt(1, id);
                        break;

                    default:
                        System.out.println("Invalid choice.");
                        return;
                }

                // Execute the query and display results
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (!resultSet.isBeforeFirst()) { // Check if result set is empty
                        System.out.println("No records found.");
                    } else {
                        while (resultSet.next()) {
                            // Display each record, assuming the table has columns id, fac_name, fac_email, fac_address
                            System.out.println("ID: " + resultSet.getInt("id") +
                                    ", Name: " + resultSet.getString("fac_name") +
                                    ", Email: " + resultSet.getString("fac_email") +
                                    ", Address: " + resultSet.getString("fac_address"));
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

