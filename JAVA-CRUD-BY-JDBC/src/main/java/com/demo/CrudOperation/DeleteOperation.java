package com.demo.CrudOperation;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.Scanner;

	public class DeleteOperation {
	    
	    public void performDelete(Scanner scanner, Connection conn) throws SQLException {
//	        String deleteByIdQuery = "DELETE FROM faculty WHERE id = ?";
//	        String deleteByNameQuery = "DELETE FROM faculty WHERE fac_name = ?";
//	        String fetchDetailsByIdQuery = "SELECT * FROM faculty WHERE id = ?";
//	        String fetchDetailsByNameQuery = "SELECT * FROM faculty WHERE fac_name = ?";

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
	                
	                // Fetch and display details before deletion
	                if (fetchFacultyDetails(conn, QueryClassConstant.fetchDetailsByIdQuery, id)) {
	                    // Confirm deletion
	                    System.out.println("Do you want to delete this record? (yes/no)");
	                    String confirm = scanner.nextLine();
	                    if (confirm.equalsIgnoreCase("yes")) {
	                        preparedStatement = conn.prepareStatement(QueryClassConstant.deleteByIdQuery);
	                        preparedStatement.setInt(1, id);
	                    } else {
	                        System.out.println("Deletion canceled.");
	                        return;
	                    }
	                } else {
	                    System.out.println("No record found with the given ID.");
	                    return;
	                }
	                break;

	            case 2: // Delete by name
	                System.out.println("Enter the faculty name:");
	                String name = scanner.nextLine();
	                
	                // Fetch and display details before deletion
	                if (fetchFacultyDetails(conn, QueryClassConstant.fetchDetailsByNameQuery, name)) {
	                    // Confirm deletion
	                    System.out.println("Do you want to delete this record? (yes/no)");
	                    String confirm = scanner.nextLine();
	                    if (confirm.equalsIgnoreCase("yes")) {
	                        preparedStatement = conn.prepareStatement(QueryClassConstant.deleteByNameQuery);
	                        preparedStatement.setString(1, name);
	                    } else {
	                        System.out.println("Deletion canceled.");
	                        return;
	                    }
	                } else {
	                    System.out.println("No record found with the given name.");
	                    return;
	                }
	                break;

	            default:
	                System.out.println("Invalid choice.");
	                return;
	        }

	        // Execute the delete operation if preparedStatement is set
	        if (preparedStatement != null) {
	            int result = preparedStatement.executeUpdate();
	            if (result > 0) {
	                System.out.println("Record deleted successfully.");
	            } else {
	                System.out.println("No record found with the given criteria.");
	            }
	        }
	    }

	    private boolean fetchFacultyDetails(Connection conn, String query, Object param) throws SQLException {
	        PreparedStatement preparedStatement = conn.prepareStatement(query);
	        
	        if (param instanceof Integer) {
	            preparedStatement.setInt(1, (Integer) param);
	        } else if (param instanceof String) {
	            preparedStatement.setString(1, (String) param);
	        }
	        
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        if (resultSet.next()) {
	            // Assuming the faculty table has the following columns:
	            int facultyId = resultSet.getInt("id");
	            String facultyName = resultSet.getString("fac_name");
	            String facultyEmail = resultSet.getString("fac_email");
	            String facultyAddress = resultSet.getString("fac_address");

	            // Print full details in the specified format
	            System.out.println("Faculty Details:");
	            System.out.println("ID: " + facultyId +
	                               ", Name: " + facultyName +
	                               ", Email: " + facultyEmail +
	                               ", Address: " + facultyAddress);
	            return true; // Record found
	        } else {
	            return false; // No record found
	        }
	    }
	}

