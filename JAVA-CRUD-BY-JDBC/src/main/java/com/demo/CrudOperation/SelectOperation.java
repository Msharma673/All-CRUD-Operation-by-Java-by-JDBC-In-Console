//package com.demo.CrudOperation;
//
//
//
//
//	import java.sql.Connection;
//	import java.sql.PreparedStatement;
//	import java.sql.ResultSet;
//	import java.sql.SQLException;
//	import java.util.Scanner;
//
//	public class SelectOperation {
//	    public void performSelect(Scanner scanner, Connection conn) throws SQLException {
//	        String selectAllQuery = "SELECT * FROM faculty";
//	        String selectByNameQuery = "SELECT * FROM faculty WHERE fac_name = ?";
//	        String selectByIdQuery = "SELECT * FROM faculty WHERE id = ?";
//
//	        System.out.println("Select an option:");
//	        System.out.println("1. Select all records");
//	        System.out.println("2. Select by name");
//	        System.out.println("3. Select by ID");
//	        int choice = scanner.nextInt();
//	        scanner.nextLine();  // Consume the newline
//
//	        PreparedStatement preparedStatement = null;
//
//	        switch (choice) {
//	            case 1: // Select all records
//	                preparedStatement = conn.prepareStatement(selectAllQuery);
//	                break;
//
//	            case 2: // Select by name
//	                System.out.println("Enter the faculty name:");
//	                String name = scanner.nextLine();
//	                preparedStatement = conn.prepareStatement(selectByNameQuery);
//	                preparedStatement.setString(1, name);
//	                break;
//
//	            case 3: // Select by ID
//	                System.out.println("Enter the faculty ID:");
//	                int id = scanner.nextInt();
//	                preparedStatement = conn.prepareStatement(selectByIdQuery);
//	                preparedStatement.setInt(1, id);
//	                break;
//
//	            default:
//	                System.out.println("Invalid choice.");
//	                return;
//	        }
//
//	        // Execute the query and display the results
//	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
//	            if (!resultSet.isBeforeFirst()) {
//	                System.out.println("No records found.");
//	            } else {
//	                while (resultSet.next()) {
//	                    System.out.println("ID: " + resultSet.getInt("id") +
//	                            ", Name: " + resultSet.getString("fac_name") +
//	                            ", Email: " + resultSet.getString("fac_email") +
//	                            ", Address: " + resultSet.getString("fac_address"));
//	                }
//	            }
//	        }
//	    }
//	}
//	
	





//package com.demo.CrudOperation;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//public class SelectOperation {
//    public void performSelect(Scanner scanner, Connection conn) throws SQLException {
//        // Initial confirmation prompt to perform selection
//        System.out.println("Do you want to perform a selection operation? (yes/no)");
//        String confirmSelection = scanner.nextLine();
//
//        if (!confirmSelection.equalsIgnoreCase("yes")) {
//            System.out.println("Selection operation canceled.");
//            return; // Exit the method if the user does not want to select
//        }
//
//        String selectAllQuery = "SELECT * FROM faculty";
//        String selectByNameQuery = "SELECT * FROM faculty WHERE fac_name = ?";
//        String selectByIdQuery = "SELECT * FROM faculty WHERE id = ?";
//
//        // Prompt user for selection option
//        System.out.println("Select an option:");
//        System.out.println("1. Select all records");
//        System.out.println("2. Select by name");
//        System.out.println("3. Select by ID");
//        int choice = scanner.nextInt();
//        scanner.nextLine();  // Consume the newline
//
//        PreparedStatement preparedStatement = null;
//
//        switch (choice) {
//            case 1: // Select all records
//                preparedStatement = conn.prepareStatement(selectAllQuery);
//                break;
//
//            case 2: // Select by name
//                System.out.println("Enter the faculty name:");
//                String name = scanner.nextLine();
//                preparedStatement = conn.prepareStatement(selectByNameQuery);
//                preparedStatement.setString(1, name);
//                break;
//
//            case 3: // Select by ID
//                System.out.println("Enter the faculty ID:");
//                int id = scanner.nextInt();
//                preparedStatement = conn.prepareStatement(selectByIdQuery);
//                preparedStatement.setInt(1, id);
//                break;
//
//            default:
//                System.out.println("Invalid choice.");
//                return;
//        }
//
//        // Confirmation prompt to proceed with the selected operation
//        System.out.println("Do you want to perform this selection? (yes/no)");
//        String confirmPerform = scanner.nextLine();
//
//        if (!confirmPerform.equalsIgnoreCase("yes")) {
//            System.out.println("Selection operation canceled.");
//            return; // Exit the method if the user does not want to perform the selection
//        }
//
//        // Execute the query and display the results
//        try (ResultSet resultSet = preparedStatement.executeQuery()) {
//            if (!resultSet.isBeforeFirst()) {
//                System.out.println("No records found.");
//            } else {
//                while (resultSet.next()) {
//                    System.out.println("ID: " + resultSet.getInt("id") +
//                            ", Name: " + resultSet.getString("fac_name") +
//                            ", Email: " + resultSet.getString("fac_email") +
//                            ", Address: " + resultSet.getString("fac_address"));
//                }
//            }
//        }
//    }
//}
//
//

package com.demo.CrudOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectOperation {
    public void performSelect(Scanner scanner, Connection conn) throws SQLException {
//
//        String selectAllQuery = "SELECT * FROM faculty";
//        String selectByNameQuery = "SELECT * FROM faculty WHERE fac_name = ?";
//        String selectByIdQuery = "SELECT * FROM faculty WHERE id = ?";

        System.out.println("Select an option:");
        System.out.println("1. Select all records");
        System.out.println("2. Select by name");
        System.out.println("3. Select by ID");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        // Ask the user if they want to proceed with the selected operation
        System.out.println("Do you want to perform this operation? (yes/no)");
        String response = scanner.nextLine().trim().toLowerCase();

        if (!response.equals("yes")) {
            System.out.println("Operation cancelled.");
            return;
        }

        PreparedStatement preparedStatement = null;

        switch (choice) {
            case 1: // Select all records
                preparedStatement = conn.prepareStatement(QueryClassConstant.selectAllQuery);
                break;

            case 2: // Select by name
                System.out.println("Enter the faculty name:");
                String name = scanner.nextLine();
                preparedStatement = conn.prepareStatement(QueryClassConstant.selectByNameQuery);
                preparedStatement.setString(1, name);
                break;

            case 3: // Select by ID
                System.out.println("Enter the faculty ID:");
                int id = scanner.nextInt();
                preparedStatement = conn.prepareStatement(QueryClassConstant.selectByIdQuery);
                preparedStatement.setInt(1, id);
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        // Execute the query and display the results
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
//            if (!resultSet.isBeforeFirst()) {
//                System.out.println("No records found.");
//            } else {
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id") +
                            ", Name: " + resultSet.getString("fac_name") +
                            ", Email: " + resultSet.getString("fac_email") +
                            ", Address: " + resultSet.getString("fac_address"));
                }
//            }
        }
    }
}
