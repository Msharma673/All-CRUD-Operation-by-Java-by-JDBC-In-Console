package com.demo.OtherMethod;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.demo.MysqlConnection.MysqlConnection;

public class CRUDOperations {

    public static void main(String[] args) throws SQLException {
        try (Scanner scanner = new Scanner(System.in);
        		Connection conn = MysqlConnection.getConnectionDetails()) {
           boolean continueOperations = true;

            while (continueOperations) {
                // Display menu for user to select an operation
                System.out.println("Select an operation:");
                System.out.println("1. Select Records");
                System.out.println("2. Insert Record");
                System.out.println("3. Update Record");
                System.out.println("4. Delete Record");
                System.out.println("5. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline

                switch (choice) {
                    case 1:
                        performSelect(scanner, conn);
                        break;
                    case 2:
                        performInsert(scanner, conn);
                        break;
                    case 3:
                        performUpdate(scanner, conn);
                        break;
                    case 4:
                        performDelete(scanner, conn);
                        break;
                    case 5:
                        System.out.println("Exiting program...");
                        return;  // Exit the program
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                        break;
                }

                // Ask the user if they want to perform another operation
                System.out.println("Do you want to perform another operation? (yes/no)");
                String continueResponse = scanner.nextLine().trim().toLowerCase();
                if (!continueResponse.equals("yes")) {
                    continueOperations = false;
                    System.out.println("Program terminated.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to perform SELECT operation
    private static void performSelect(Scanner scanner, Connection conn) throws SQLException {
        String selectAllQuery = "SELECT * FROM faculty";
        String selectByNameQuery = "SELECT * FROM faculty WHERE fac_name = ?";
        String selectByIdQuery = "SELECT * FROM faculty WHERE id = ?";

        System.out.println("Select an option:");
        System.out.println("1. Select all records");
        System.out.println("2. Select by name");
        System.out.println("3. Select by ID");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

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

        // Execute the query and display the results
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
//            if (!resultSet.isBeforeFirst()) {
//                System.out.println("No records found.");
//            } else {
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id") +
                            ",      Name: " + resultSet.getString("fac_name") +
                            ",      Email: " + resultSet.getString("fac_email") +
                            ",      Address: " + resultSet.getString("fac_address"));
                }
//            }
        }
    }

    // Method to perform INSERT operation
    private static void performInsert(Scanner scanner, Connection conn) throws SQLException {
        String insertQuery = "INSERT INTO faculty (fac_name, fac_email, fac_address) VALUES (?, ?, ?)";

        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter address:");
        String address = scanner.nextLine();

        if (name.isEmpty() || email.isEmpty() || address.isEmpty()) {
            System.out.println("All fields (name, email, address) are required.");
            return;
        }

        PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, address);

        int result = preparedStatement.executeUpdate();
        if (result > 0) {
            System.out.println("Record inserted successfully.");
            System.out.println("Inserted Record -> Name: " + name + ", Email: " + email + ", Address: " + address);
        } else {
            System.out.println("Failed to insert the record.");
        }
    }

   
    
 // Method to perform UPDATE operation
    private static void performUpdate(Scanner scanner, Connection conn) throws SQLException {
        // Queries
        String selectByIdQuery = "SELECT * FROM faculty WHERE id = ?";
        String selectByNameQuery = "SELECT * FROM faculty WHERE fac_name = ?";
        String updateQuery = "UPDATE faculty SET fac_name = ?, fac_email = ?, fac_address = ? WHERE id = ? OR fac_name = ?";
        
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
                selectStatement = conn.prepareStatement(selectByIdQuery);
                selectStatement.setInt(1, id);
                break;

            case 2: // Update by name
                System.out.println("Enter the faculty name:");
                currentName = scanner.nextLine(); // Store the name entered by the user

                // Prepare and execute select query to show the matching record
                selectStatement = conn.prepareStatement(selectByNameQuery);
                selectStatement.setString(1, currentName);
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        // Execute the select query
        ResultSet resultSet = selectStatement.executeQuery();

        // Check if record exists
//        if (!resultSet.isBeforeFirst()) {  // No data found
//            System.out.println("No matching record found.");
//            return;
//        }

        // Show the current record to the user
        while (resultSet.next()) {
            System.out.println("Current Record - ID: " + resultSet.getInt("id") +
                    ", Name: " + resultSet.getString("fac_name") +
                    ", Email: " + resultSet.getString("fac_email") +
                    ", Address: " + resultSet.getString("fac_address"));
        }

        // Proceed to update after showing the current record
        System.out.println("Proceeding with the update...");

        // Collect new data for update
        System.out.println("Enter new name:");
        String newName = scanner.nextLine();
        System.out.println("Enter new email:");
        String newEmail = scanner.nextLine();
        System.out.println("Enter new address:");
        String newAddress = scanner.nextLine();

        // Prepare the update statement
        updateStatement = conn.prepareStatement(updateQuery);
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



 // Method to perform DELETE operation
    private static void performDelete(Scanner scanner, Connection conn) throws SQLException {
        String deleteByIdQuery = "DELETE FROM faculty WHERE id = ?";
        String deleteByNameQuery = "DELETE FROM faculty WHERE fac_name = ?";

        System.out.println("Select an option:");
        System.out.println("1. Delete by ID");
        System.out.println("2. Delete by name");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        PreparedStatement preparedStatement = null;

        switch (choice) {
            case 1: // Delete by ID
                System.out.println("Enter the faculty ID:");
                int id = scanner.nextInt();
                scanner.nextLine();  // Consume the newline

                preparedStatement = conn.prepareStatement(deleteByIdQuery);
                preparedStatement.setInt(1, id);
                break;

            case 2: // Delete by name
                System.out.println("Enter the faculty name:");
                String name = scanner.nextLine();

                preparedStatement = conn.prepareStatement(deleteByNameQuery);
                preparedStatement.setString(1, name);
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        // Execute the delete operation
        int result = preparedStatement.executeUpdate();
        if (result > 0) {
            System.out.println("Record deleted successfully.");
        } else {
            System.out.println("No record found with the given criteria.");
        }
    }

    
}

