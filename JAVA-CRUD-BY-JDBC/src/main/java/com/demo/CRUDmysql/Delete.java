package com.demo.CRUDmysql;



import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.demo.MysqlConnection.MysqlConnection;


public class Delete {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String deleteQuery = "DELETE FROM faculty WHERE fac_name = ?";
        String name;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter name of the faculty to delete:");
        name = scanner.nextLine();

        PreparedStatement preparedStatement = MysqlConnection.getConnectionDetails().prepareStatement(deleteQuery);
        preparedStatement.setString(1, name);

        int i = preparedStatement.executeUpdate();
        if (i != 0)
            System.out.println("Record deleted successfully");
        else
            System.out.println("No record found with the given name");
    }
}


//package com.demo.CRUDmysql;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//import com.demo.MysqlConnection.MysqlConnection;
//
//public class Delete {
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        // SQL queries
//        String selectQuery = "SELECT id, fac_name, fac_email, fac_address FROM faculty WHERE fac_name = ? OR id = ?";
//        String deleteQuery = "DELETE FROM faculty WHERE fac_name = ? OR id = ?";
//
//        try (Scanner scanner = new Scanner(System.in)) {
//            // Gather input from the user
//            System.out.println("Enter name of the faculty (press Enter to skip if using ID):");
//            String name = scanner.nextLine().trim();
//
//            System.out.println("Enter faculty ID (enter 0 to skip if using name):");
//            int id = scanner.nextInt();
//            scanner.nextLine();  // Consume newline
//
//            // Check if user provided either name or ID
//            if (name.isEmpty() && id == 0) {
//                System.out.println("You must provide either a name or ID to delete the record.");
//                return;
//            }
//
//            // Show current record before deletion
//            try (Connection conn = MysqlConnection.getConnectionDetails();
//                 PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
//
//                selectStmt.setString(1, name);  // Check by name
//                selectStmt.setInt(2, id);  // OR check by ID
//
//                try (ResultSet rs = selectStmt.executeQuery()) {
//                    if (rs.next()) {
//                        // Display the current record, including id, name, email, and address
//                        int currentId = rs.getInt("id");
//                        String currentFacName = rs.getString("fac_name");
//                        String currentEmail = rs.getString("fac_email");
//                        String currentAddress = rs.getString("fac_address");
//
//                        System.out.println("Record to be deleted:");
//                        System.out.println("ID: " + currentId);
//                        System.out.println("Name: " + currentFacName);
//                        System.out.println("Email: " + currentEmail);
//                        System.out.println("Address: " + currentAddress);
//
//                        // Ask for confirmation before deletion
//                        System.out.println("Are you sure you want to delete this record? (yes/no):");
//                        String confirmation = scanner.nextLine().trim().toLowerCase();
//
//                        if (!confirmation.equals("yes")) {
//                            System.out.println("Deletion canceled.");
//                            return;
//                        }
//
//                        // Proceed with the deletion
//                        try (PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery)) {
//                            deleteStmt.setString(1, name.isEmpty() ? null : name);  // Where name (if provided)
//                            deleteStmt.setInt(2, id == 0 ? -1 : id);  // OR Where ID (if provided)
//
//                            int rowsDeleted = deleteStmt.executeUpdate();
//                            if (rowsDeleted > 0) {
//                                System.out.println("Record deleted successfully.");
//                            } else {
//                                System.out.println("No record found with the given name or ID.");
//                            }
//                        }
//                    } else {
//                        System.out.println("No record found with the given name or ID.");
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("An error occurred: " + e.getMessage());
//        }
//    }
//}



//package com.demo.CRUDmysql;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//import com.demo.MysqlConnection.MysqlConnection;
//
//public class Delete {
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        // SQL queries for selecting and deleting
//        String selectQueryByName = "SELECT id, fac_name, fac_email, fac_address FROM faculty WHERE fac_name = ?";
//        String selectQueryById = "SELECT id, fac_name, fac_email, fac_address FROM faculty WHERE id = ?";
//        String deleteQueryByName = "DELETE FROM faculty WHERE fac_name = ?";
//        String deleteQueryById = "DELETE FROM faculty WHERE id = ?";
//
//        try (Scanner scanner = new Scanner(System.in)) {
//            // Menu for selecting delete option
//            System.out.println("Select an option:");
//            System.out.println("1. Delete by name");
//            System.out.println("2. Delete by ID");
//            int option = scanner.nextInt();
//            scanner.nextLine();  // Consume the newline character after the integer input
//
//            String name = null;
//            int id = 0;
//            String selectQuery = "";
//            String deleteQuery = "";
//
//            // Get the necessary input based on user's choice
//            if (option == 1) { // Delete by name
//                System.out.println("Enter name of the faculty:");
//                name = scanner.nextLine().trim();
//
//                if (name.isEmpty()) {
//                    System.out.println("You must provide a name.");
//                    return;
//                }
//
//                selectQuery = selectQueryByName;
//                deleteQuery = deleteQueryByName;
//            } else if (option == 2) { // Delete by ID
//                System.out.println("Enter faculty ID:");
//                id = scanner.nextInt();
//                scanner.nextLine();  // Consume the newline character
//
//                if (id == 0) {
//                    System.out.println("You must provide a valid ID.");
//                    return;
//                }
//
//                selectQuery = selectQueryById;
//                deleteQuery = deleteQueryById;
//            } else {
//                System.out.println("Invalid option. Please select either '1' or '2'.");
//                return;
//            }
//
//            // Show the current record before deletion
//            try (Connection conn = MysqlConnection.getConnectionDetails();
//                 PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
//
//                if (option == 1) {
//                    selectStmt.setString(1, name);
//                } else {
//                    selectStmt.setInt(1, id);
//                }
//
//                try (ResultSet rs = selectStmt.executeQuery()) {
//                    if (rs.next()) {
//                        // Display the current record
//                        int currentId = rs.getInt("id");
//                        String currentFacName = rs.getString("fac_name");
//                        String currentEmail = rs.getString("fac_email");
//                        String currentAddress = rs.getString("fac_address");
//
//                        System.out.println("Record to be deleted:");
//                        System.out.println("ID: " + currentId);
//                        System.out.println("Name: " + currentFacName);
//                        System.out.println("Email: " + currentEmail);
//                        System.out.println("Address: " + currentAddress);
//
//                        // Ask for confirmation before deletion
//                        System.out.println("Are you sure you want to delete this record? (yes/no):");
//                        String confirmation = scanner.nextLine().trim().toLowerCase();
//
//                        if (!confirmation.equals("yes")) {
//                            System.out.println("Deletion canceled.");
//                            return;
//                        }
//
//                        // Proceed with the deletion
//                        try (PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery)) {
//                            if (option == 1) {
//                                deleteStmt.setString(1, name);
//                            } else {
//                                deleteStmt.setInt(1, id);
//                            }
//
//                            int rowsDeleted = deleteStmt.executeUpdate();
//                            if (rowsDeleted > 0) {
//                                System.out.println("Record deleted successfully.");
//                            } else {
//                                System.out.println("No record found with the given name or ID.");
//                            }
//                        }
//                    } else {
//                        System.out.println("No record found with the given name or ID.");
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("An error occurred: " + e.getMessage());
//        }
//    }
//}
//
//
