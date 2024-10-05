package com.demo.CrudOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateOperation {
    public void performUpdate(Scanner scanner, Connection conn) throws SQLException {
        // Queries
//        String selectByIdQuery = "SELECT * FROM faculty WHERE id = ?";
//        String selectByNameQuery = "SELECT * FROM faculty WHERE fac_name = ?";
//        String updateQuery = "UPDATE faculty SET fac_name = ?, fac_email = ?, fac_address = ? WHERE id = ? OR fac_name = ?";
//        
    	
        // Query to fetch the updated record
        String fetchUpdatedRecordQuery = "SELECT * FROM faculty WHERE id = ?";

        System.out.println("Select an option:");
        System.out.println("1. Update by ID");
        System.out.println("2. Update by name");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        PreparedStatement selectStatement = null;
        PreparedStatement updateStatement = null;
        PreparedStatement fetchUpdatedStatement = null; // Statement to fetch updated record
        int id = 0; // Declare id here for use in updateStatement
        String currentName = ""; // Declare currentName here for use in both cases

        switch (choice) {
            case 1: // Update by ID
                System.out.println("Enter the faculty ID:");
                id = scanner.nextInt();
                scanner.nextLine();  // Consume the newline

                // Prepare and execute select query to show the matching record
                selectStatement = conn.prepareStatement(QueryClassConstant.selectByIdQuery);
                selectStatement.setInt(1, id);
                break;

            case 2: // Update by name
                System.out.println("Enter the faculty name:");
                currentName = scanner.nextLine(); // Store the name entered by the user

                // Prepare and execute select query to show the matching record
                selectStatement = conn.prepareStatement(QueryClassConstant.selectByNameQuery);
                selectStatement.setString(1, currentName);
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        // Execute the select query
        ResultSet resultSet = selectStatement.executeQuery();

        // Check if record exists
        if (!resultSet.isBeforeFirst()) {  // No data found
            System.out.println("No matching record found.");
            return;
        }

        // Show the current record to the user
        while (resultSet.next()) {
            System.out.println("Current Record - ID: " + resultSet.getInt("id") +
                    ", Name: " + resultSet.getString("fac_name") +
                    ", Email: " + resultSet.getString("fac_email") +
                    ", Address: " + resultSet.getString("fac_address"));
        }

        // Ask for confirmation to proceed with the update
        System.out.println("Do you want to update this record? (yes/no)");
        String confirmUpdate = scanner.nextLine();

        if (!confirmUpdate.equalsIgnoreCase("yes")) {
            System.out.println("Update operation canceled.");
            return; // Exit the method if the user does not want to update
        }

        // Collect new data for update
        System.out.println("Enter new name:");
        String newName = scanner.nextLine();
        System.out.println("Enter new email:");
        String newEmail = scanner.nextLine();
        System.out.println("Enter new address:");
        String newAddress = scanner.nextLine();

        // Prepare the update statement
        updateStatement = conn.prepareStatement(QueryClassConstant.updateQuery);
        updateStatement.setString(1, newName);
        updateStatement.setString(2, newEmail);
        updateStatement.setString(3, newAddress);
        
        // Set parameters for WHERE clause
        if (choice == 1) {
            updateStatement.setInt(4, id); // Set ID for the first parameter
            updateStatement.setString(5, newName); // Set newName as the second parameter
        } else {
            // Here we assume we will always set id for updating by name.
            // Thus, we need to fetch the id from the record we selected earlier.
            resultSet.first(); // Move to the first result to get the ID
            id = resultSet.getInt("id");
            updateStatement.setInt(4, id); // Set ID for the first parameter
            updateStatement.setString(5, currentName); // Set currentName as the second parameter
        }

        // Execute the update
        int result = updateStatement.executeUpdate();
        if (result > 0) {
            System.out.println("Record updated successfully.");

            // Fetch and display the updated record
            fetchUpdatedStatement = conn.prepareStatement(fetchUpdatedRecordQuery);
            fetchUpdatedStatement.setInt(1, id); // Set ID to fetch the updated record
            ResultSet updatedResultSet = fetchUpdatedStatement.executeQuery();

            if (updatedResultSet.next()) {
                // Display the updated record
                System.out.println("Updated Record - ID: " + updatedResultSet.getInt("id") +
                        ", Name: " + updatedResultSet.getString("fac_name") +
                        ", Email: " + updatedResultSet.getString("fac_email") +
                        ", Address: " + updatedResultSet.getString("fac_address"));
            }
        } else {
            System.out.println("No record found with the given criteria.");
        }
    }
}

