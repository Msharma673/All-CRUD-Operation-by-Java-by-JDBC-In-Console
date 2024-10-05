////package com.demo.OtherMethod;
////
////import java.sql.PreparedStatement;
////import java.sql.ResultSet;
////import java.sql.SQLException;
////import java.util.Scanner;
////
////import com.demo.MysqlConnection.MysqlConnection;
////
////public class UpdateNew {
////	
////	
////	    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//////	    	 String name, email, address;
////	    	
////	    	String selectQueryByName = "SELECT id, fac_name, fac_email, fac_address FROM faculty WHERE fac_name = ?";
////	        String selectQueryById = "SELECT id, fac_name, fac_email, fac_address FROM faculty WHERE id = ?";
////	        String updateQueryByName = "UPDATE faculty SET fac_name = ?, fac_email = ?, fac_address = ? WHERE fac_name = ?";
////	        String updateQueryById = "UPDATE faculty SET fac_name = ?, fac_email = ?, fac_address = ? WHERE id = ?";
////	       
////	        
////	        // Menu for selecting update option
////            System.out.println("Select an option:");
////            System.out.println("1. Update by name");
////            System.out.println("2. Update by ID");
////            
////            
////            Scanner scanner = new Scanner(System.in);
////            
////            int option = scanner.nextInt();
////            scanner.nextLine();  // Consume the newline character after the integer input
////	        
////            String currentName = null;
////            int id = 0;
////            String selectQuery = "";
////            String updateQuery = "";
////
////            
////            
////            if (option == 1) { // Update by name
////                System.out.println("Enter current name of the faculty:");
////                currentName = scanner.nextLine().trim();
////
////                if (currentName.isEmpty()) {
////                    System.out.println("You must provide a name.");
////                    return;
////                }
////
////                selectQuery = selectQueryByName;
////                updateQuery = updateQueryByName;
////            } else if (option == 2) { // Update by ID
////                System.out.println("Enter faculty ID:");
////                id = scanner.nextInt();
////                scanner.nextLine();  // Consume the newline character
////
////                if (id == 0) {
////                    System.out.println("You must provide a valid ID.");
////                    return;
////                }
////
////                selectQuery = selectQueryById;
////                updateQuery = updateQueryById;
////            } else {
////                System.out.println("Invalid option. Please select either '1' or '2'.");
////                return;
////            }
////            
////            PreparedStatement preparedStatement = MysqlConnection.getConnectionDetails().prepareStatement(selectQuery);
////	        
////            if (option == 1) {
////            	preparedStatement.setString(1, currentName);
////            } else {
////            	preparedStatement.setInt(1, id);
////            }
////            
////            ResultSet resultSet = preparedStatement.executeQuery(selectQuery);
////            while (resultSet.next()) {
////            	 if (resultSet.next()) {
////                     // Display the current record
////                     int currentId = resultSet.getInt("id");
////                     String currentFacName = resultSet.getString("fac_name");
////                     String currentEmail = resultSet.getString("fac_email");
////                     String currentAddress = resultSet.getString("fac_address");
////
////                     System.out.println("Current Record:");
////                     System.out.println("ID: " + currentId);
////                     System.out.println("Name: " + currentFacName);
////                     System.out.println("Email: " + currentEmail);
////                     System.out.println("Address: " + currentAddress);
////                 } else {
////                     System.out.println("No record found with the given name or ID.");
////                     return;
////                 }
////            	
////            	
//////            	System.out.println(resultSet.getInt(1)  + " " + resultSet.getString(2) 
//////            	+ " " + resultSet.getString(3) +
//////            			" " + resultSet.getString(4));
////            	 
////            	  // Collect new details for updating
////                 System.out.println("Enter new name (or press Enter to keep current):");
////                 String newName = scanner.nextLine().trim();
////                 System.out.println("Enter new email (or press Enter to keep current):");
////                 String email = scanner.nextLine().trim();
////                 System.out.println("Enter new address (or press Enter to keep current):");
////                 String address = scanner.nextLine().trim();
////                 
////                 
////                 PreparedStatement updateStmt = MysqlConnection.getConnectionDetails().prepareStatement(selectQuery);
////
////                 if (newName.isEmpty()) newName = currentName;
////                 if (email.isEmpty()) email = null;
////                 if (address.isEmpty()) address = null;
////
////                 // Prepare the update statement
////                 updateStmt.setString(1, newName);
////                 updateStmt.setString(2, email);
////                 updateStmt.setString(3, address);
////
////                 if (option == 1) {
////                     updateStmt.setString(4, currentName);
////                 } else {
////                     updateStmt.setInt(4, id);
////                 }
////
////                 int rowsUpdated = updateStmt.executeUpdate();
////                 if (rowsUpdated > 0) {
////                     System.out.println("Record updated successfully");
////                     
////                     
////                     PreparedStatement selectStmt = MysqlConnection.getConnectionDetails().prepareStatement(selectQuery);
////            	 
////                     if (option == 1) {
////                         selectStmt.setString(1, newName);
////                     } else {
////                         selectStmt.setInt(1, id);
////                         
////                         
////                     }
////                     
////                     while (resultSet.next())  {
////                         if (resultSet.next()) {
////                             // Display the updated record
////                             int updatedId = resultSet.getInt("id");
////                             String updatedFacName = resultSet.getString("fac_name");
////                             String updatedEmail = resultSet.getString("fac_email");
////                             String updatedAddress = resultSet.getString("fac_address");
////
////                             System.out.println("Updated Record:");
////                             System.out.println("ID: " + updatedId);
////                             System.out.println("Name: " + updatedFacName);
////                             System.out.println("Email: " + updatedEmail);
////                             System.out.println("Address: " + updatedAddress);
////                         }
////                     }
////                 
////             } else {
////                 System.out.println("No record found with the given name or ID.");
////             }
////                     
////            }
////            
////            
////           
////	    }}
////
////
//
////package com.demo.CRUDmysql;
////
////
////
////import java.sql.PreparedStatement;
////import java.sql.SQLException;
////import java.util.Scanner;
////
////import com.demo.MysqlConnection.mysqlConnection;
////
////public class Update {
////    public static void main(String[] args) throws ClassNotFoundException, SQLException {
////        String updateQuery = "UPDATE faculty SET fac_email = ?, fac_address = ? WHERE fac_name = ?";
////        String name, email, address;
////        Scanner scanner = new Scanner(System.in);
////        
////        System.out.println("Enter name of the faculty to update:");
////        name = scanner.nextLine();
////        System.out.println("Enter new email:");
////        email = scanner.nextLine();
////        System.out.println("Enter new address:");
////        address = scanner.nextLine();
////        
////        PreparedStatement preparedStatement = mysqlConnection.getConnectionDetails().prepareStatement(updateQuery);
////        preparedStatement.setString(1, email);
////        preparedStatement.setString(2, address);
////        preparedStatement.setString(3, name);
////
////        int i = preparedStatement.executeUpdate();
////        if (i != 0)
////            System.out.println("Record updated successfully");
////        else
////            System.out.println("No record found with the given name");
////    }
////}
//
//
////package com.demo.CRUDmysql;
////
////import java.sql.PreparedStatement;
////import java.sql.SQLException;
////import java.util.Scanner;
////
////import com.demo.MysqlConnection.MysqlConnection;
////
////
////public class Update {
////    public static void main(String[] args) throws ClassNotFoundException, SQLException {
////        // Modify the query to update fac_name as well
////        String updateQuery = "UPDATE faculty SET fac_name = ?, fac_email = ?, fac_address = ? WHERE fac_name = ?";
////        String currentName, newName, email, address;
////        Scanner scanner = new Scanner(System.in);
////        
////        System.out.println("Enter current name of the faculty to update:");
////        currentName = scanner.nextLine();
////        System.out.println("Enter new name:");
////        newName = scanner.nextLine();
////        System.out.println("Enter new email:");
////        email = scanner.nextLine();
////        System.out.println("Enter new address:");
////        address = scanner.nextLine();
////        
////        // Prepare the statement with updated fields
////        
////        
////        PreparedStatement preparedStatement = MysqlConnection.getConnectionDetails().prepareStatement(updateQuery);
////        preparedStatement.setString(1, newName);  // Set new name
////        preparedStatement.setString(2, email);    // Set new email
////        preparedStatement.setString(3, address);  // Set new address
////        preparedStatement.setString(4, currentName); // Where current name is
////        
////        int i = preparedStatement.executeUpdate();
////        if (i != 0)
////            System.out.println("Record updated successfully");
////        else
////            System.out.println("No record found with the given name");
////    }
////}
//
//
////package com.demo.CRUDmysql;
////
////import java.sql.Connection;
////import java.sql.PreparedStatement;
////import java.sql.SQLException;
////import java.util.Scanner;
////
////import com.demo.MysqlConnection.MysqlConnection;
////
////public class Update {
////    public static void main(String[] args) throws ClassNotFoundException, SQLException {
////        // SQL query for updating the faculty record
////        String updateQuery = "UPDATE faculty SET fac_name = ?, fac_email = ?, fac_address = ? WHERE fac_name = ? OR id = ?";
////        
////        try (Scanner scanner = new Scanner(System.in)) {
////            // Gather input from the user
////            System.out.println("Enter current name of the faculty (press Enter to skip if using ID):");
////            String currentName = scanner.nextLine().trim();
////            
////            System.out.println("Enter faculty ID (enter 0 to skip if using name):");
////            int id = scanner.nextInt();
////            scanner.nextLine();  // Consume the newline character
////            
////            // Check if user provided either currentName or ID
////            if (currentName.isEmpty() && id == 0) {
////                System.out.println("You must provide either a name or ID to update the record.");
////                return;
////            }
////            
////            // Collect new details
////            System.out.println("Enter new name:");
////            String newName = scanner.nextLine().trim();
////            
////            System.out.println("Enter new email:");
////            String email = scanner.nextLine().trim();
////            
////            System.out.println("Enter new address:");
////            String address = scanner.nextLine().trim();
////            
////            // Prepare the statement with the gathered details
////            try (Connection conn = MysqlConnection.getConnectionDetails();
////                 PreparedStatement preparedStatement = conn.prepareStatement(updateQuery)) {
////                
////                preparedStatement.setString(1, newName);  // Set new name
////                preparedStatement.setString(2, email);    // Set new email
////                preparedStatement.setString(3, address);  // Set new address
////                preparedStatement.setString(4, currentName);  // Where current name
////                preparedStatement.setInt(5, id);  // OR Where ID
////                
////                int rowsUpdated = preparedStatement.executeUpdate();
////                
////                if (rowsUpdated > 0) {
////                    System.out.println("Record updated successfully");
////                } else {
////                    System.out.println("No record found with the given name or ID");
////                }
////            }
////        } catch (SQLException e) {
////            System.out.println("An error occurred while updating the record: " + e.getMessage());
////        }
////    }
////}
//
//
////package com.demo.CRUDmysql;
////
////import java.sql.Connection;
////import java.sql.PreparedStatement;
////import java.sql.ResultSet;
////import java.sql.SQLException;
////import java.util.Scanner;
////
////import com.demo.MysqlConnection.MysqlConnection;
////
////public class Update {
////    public static void main(String[] args) throws ClassNotFoundException, SQLException {
////        // SQL queries
////        String selectQuery = "SELECT id, fac_name, fac_email, fac_address FROM faculty WHERE fac_name = ? OR id = ?";
////        String updateQuery = "UPDATE faculty SET fac_name = ?, fac_email = ?, fac_address = ? WHERE fac_name = ? OR id = ?";
////
////        try (Scanner scanner = new Scanner(System.in)) {
////            // Gather input from the user
////            System.out.println("Enter current name of the faculty (press Enter to skip if using ID):");
////            String currentName = scanner.nextLine().trim();
////            
////            System.out.println("Enter faculty ID (enter 0 to skip if using name):");
////            int id = scanner.nextInt();
////            scanner.nextLine();  // Consume the newline character
////            
////            // Check if user provided either currentName or ID
////            if (currentName.isEmpty() && id == 0) {
////                System.out.println("You must provide either a name or ID to update the record.");
////                return;
////            }
////
////            // Show current record before updating
////            try (Connection conn = MysqlConnection.getConnectionDetails();
////                 PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
////
////                selectStmt.setString(1, currentName);  // Where current name
////                selectStmt.setInt(2, id);  // OR Where ID
////                
////                try (ResultSet rs = selectStmt.executeQuery()) {
////                    if (rs.next()) {
////                        // Display the current record, including id
////                        int currentId = rs.getInt("id");
////                        String currentFacName = rs.getString("fac_name");
////                        String currentEmail = rs.getString("fac_email");
////                        String currentAddress = rs.getString("fac_address");
////                        
////                        System.out.println("Current Record:");
////                        System.out.println("ID: " + currentId);
////                        System.out.println("Name: " + currentFacName);
////                        System.out.println("Email: " + currentEmail);
////                        System.out.println("Address: " + currentAddress);
////                    } else {
////                        System.out.println("No record found with the given name or ID.");
////                        return;
////                    }
////                }
////            }
////
////            // Now, collect the new details for updating
////            System.out.println("Enter new name (or press Enter to keep current):");
////            String newName = scanner.nextLine().trim();
////            System.out.println("Enter new email (or press Enter to keep current):");
////            String email = scanner.nextLine().trim();
////            System.out.println("Enter new address (or press Enter to keep current):");
////            String address = scanner.nextLine().trim();
////
////            // Update the record only if the user provides new values
////            try (Connection conn = MysqlConnection.getConnectionDetails();
////                 PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
////
////                // If the user didn't provide a new value, keep the old one
////                if (newName.isEmpty()) newName = currentName;
////                if (email.isEmpty()) email = null;  // You can set the default as the current email
////                if (address.isEmpty()) address = null;  // You can set the default as the current address
////
////                // Prepare the update statement
////                updateStmt.setString(1, newName);  // Set new name
////                updateStmt.setString(2, email);    // Set new email
////                updateStmt.setString(3, address);  // Set new address
////                updateStmt.setString(4, currentName);  // Where current name
////                updateStmt.setInt(5, id);  // OR Where ID
////
////                int rowsUpdated = updateStmt.executeUpdate();
////                if (rowsUpdated > 0) {
////                    System.out.println("Record updated successfully");
////                } else {
////                    System.out.println("No record found with the given name or ID.");
////                }
////            }
////        } catch (SQLException e) {
////            System.out.println("An error occurred: " + e.getMessage());
////        }
////    }
////}
//
////package com.demo.CRUDmysql;
////
////import java.sql.Connection;
////import java.sql.PreparedStatement;
////import java.sql.ResultSet;
////import java.sql.SQLException;
////import java.util.Scanner;
////
////import com.demo.MysqlConnection.MysqlConnection;
////
////public class Update {
////    public static void main(String[] args) throws ClassNotFoundException, SQLException {
////        // SQL queries
////        String selectQuery = "SELECT id, fac_name, fac_email, fac_address FROM faculty WHERE fac_name = ? OR id = ?";
////        String updateQuery = "UPDATE faculty SET fac_name = ?, fac_email = ?, fac_address = ? WHERE fac_name = ? OR id = ?";
////
////        try (Scanner scanner = new Scanner(System.in)) {
////            // Gather input from the user
////            System.out.println("Enter current name of the faculty (press Enter to skip if using ID):");
////            String currentName = scanner.nextLine().trim();
////            
////            System.out.println("Enter faculty ID (enter 0 to skip if using name):");
////            int id = scanner.nextInt();
////            scanner.nextLine();  // Consume the newline character
////            
////            // Check if user provided either currentName or ID
////            if (currentName.isEmpty() && id == 0) {
////                System.out.println("You must provide either a name or ID to update the record.");
////                return;
////            }
////
////            // Show current record before updating
////            try (Connection conn = MysqlConnection.getConnectionDetails();
////                 PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
////
////                selectStmt.setString(1, currentName);  // Where current name
////                selectStmt.setInt(2, id);  // OR Where ID
////                
////                try (ResultSet rs = selectStmt.executeQuery()) {
////                    if (rs.next()) {
////                        // Display the current record, including id
////                        int currentId = rs.getInt("id");
////                        String currentFacName = rs.getString("fac_name");
////                        String currentEmail = rs.getString("fac_email");
////                        String currentAddress = rs.getString("fac_address");
////                        
////                        System.out.println("Current Record:");
////                        System.out.println("ID: " + currentId);
////                        System.out.println("Name: " + currentFacName);
////                        System.out.println("Email: " + currentEmail);
////                        System.out.println("Address: " + currentAddress);
////                    } else {
////                        System.out.println("No record found with the given name or ID.");
////                        return;
////                    }
////                }
////            }
////
////            // Now, collect the new details for updating
////            System.out.println("Enter new name (or press Enter to keep current):");
////            String newName = scanner.nextLine().trim();
////            System.out.println("Enter new email (or press Enter to keep current):");
////            String email = scanner.nextLine().trim();
////            System.out.println("Enter new address (or press Enter to keep current):");
////            String address = scanner.nextLine().trim();
////
////            // Update the record only if the user provides new values
////            try (Connection conn = MysqlConnection.getConnectionDetails();
////                 PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
////
////                // If the user didn't provide a new value, keep the old one
////                if (newName.isEmpty()) newName = currentName;
////                if (email.isEmpty()) email = null;  // You can set the default as the current email
////                if (address.isEmpty()) address = null;  // You can set the default as the current address
////
////                // Prepare the update statement
////                updateStmt.setString(1, newName);  // Set new name
////                updateStmt.setString(2, email);    // Set new email
////                updateStmt.setString(3, address);  // Set new address
////                updateStmt.setString(4, currentName);  // Where current name
////                updateStmt.setInt(5, id);  // OR Where ID
////
////                int rowsUpdated = updateStmt.executeUpdate();
////                if (rowsUpdated > 0) {
////                    System.out.println("Record updated successfully");
////
////                    // Fetch and display the updated record
////                    try (PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
////                        selectStmt.setString(1, newName);  // Where new name (since the record is updated)
////                        selectStmt.setInt(2, id);  // OR Where ID
////                        
////                        try (ResultSet rs = selectStmt.executeQuery()) {
////                            if (rs.next()) {
////                                // Display the updated record, including id
////                                int updatedId = rs.getInt("id");
////                                String updatedFacName = rs.getString("fac_name");
////                                String updatedEmail = rs.getString("fac_email");
////                                String updatedAddress = rs.getString("fac_address");
////                                
////                                System.out.println("Updated Record:");
////                                System.out.println("ID: " + updatedId);
////                                System.out.println("Name: " + updatedFacName);
////                                System.out.println("Email: " + updatedEmail);
////                                System.out.println("Address: " + updatedAddress);
////                            }
////                        }
////                    }
////                } else {
////                    System.out.println("No record found with the given name or ID.");
////                }
////            }
////        } catch (SQLException e) {
////            System.out.println("An error occurred: " + e.getMessage());
////        }
////    }
////}
////
//
//
//
////package com.demo.OtherMethod;
////
////import java.sql.Connection;
////import java.sql.PreparedStatement;
////import java.sql.ResultSet;
////import java.sql.SQLException;
////import java.util.Scanner;
////
////import com.demo.MysqlConnection.MysqlConnection;
////
////public class UpdateNew {
////    public static void main(String[] args) throws ClassNotFoundException, SQLException {
////        // SQL queries for selecting and updating
////        String selectQueryByName = "SELECT id, fac_name, fac_email, fac_address FROM faculty WHERE fac_name = ?";
////        String selectQueryById = "SELECT id, fac_name, fac_email, fac_address FROM faculty WHERE id = ?";
////        String updateQueryByName = "UPDATE faculty SET fac_name = ?, fac_email = ?, fac_address = ? WHERE fac_name = ?";
////        String updateQueryById = "UPDATE faculty SET fac_name = ?, fac_email = ?, fac_address = ? WHERE id = ?";
////
////        try {
////        Scanner scanner = new Scanner(System.in); 
////            // Menu for selecting update option
////            System.out.println("Select an option:");
////            System.out.println("1. Update by name");
////            System.out.println("2. Update by ID");
////            int option = scanner.nextInt();
////            scanner.nextLine();  // Consume the newline character after the integer input
////
////            String currentName = null;
////            int id = 0;
////            String selectQuery = "";
////            String updateQuery = "";
////
////            // Get the necessary input based on user's choice
////            if (option == 1) { // Update by name
////                System.out.println("Enter current name of the faculty:");
////                currentName = scanner.nextLine().trim();
////
////                if (currentName.isEmpty()) {
////                    System.out.println("You must provide a name.");
////                    return;
////                }
////
////                selectQuery = selectQueryByName;
////                updateQuery = updateQueryByName;
////            } else if (option == 2) { // Update by ID
////                System.out.println("Enter faculty ID:");
////                id = scanner.nextInt();
////                scanner.nextLine();  // Consume the newline character
////
////                if (id == 0) {
////                    System.out.println("You must provide a valid ID.");
////                    return;
////                }
////
////                selectQuery = selectQueryById;
////                updateQuery = updateQueryById;
////            } else {
////                System.out.println("Invalid option. Please select either '1' or '2'.");
////                return;
////            }
////
////            // Show the current record before updating
////            try {
////            	Connection conn = MysqlConnection.getConnectionDetails();
////                 PreparedStatement selectStmt = conn.prepareStatement(selectQuery); 
////
////                if (option == 1) {
////                    selectStmt.setString(1, currentName);
////                } else {
////                    selectStmt.setInt(1, id);
////                }
////
////                try (ResultSet rs = selectStmt.executeQuery()) {
////                    if (rs.next()) {
////                        // Display the current record
////                        int currentId = rs.getInt("id");
////                        String currentFacName = rs.getString("fac_name");
////                        String currentEmail = rs.getString("fac_email");
////                        String currentAddress = rs.getString("fac_address");
////
////                        System.out.println("Current Record:");
////                        System.out.println("ID: " + currentId);
////                        System.out.println("Name: " + currentFacName);
////                        System.out.println("Email: " + currentEmail);
////                        System.out.println("Address: " + currentAddress);
////                    } else {
////                        System.out.println("No record found with the given name or ID.");
////                        return;
////                    }
////                }
////            
////
////            // Collect new details for updating
////            System.out.println("Enter new name (or press Enter to keep current):");
////            String newName = scanner.nextLine().trim();
////            System.out.println("Enter new email (or press Enter to keep current):");
////            String email = scanner.nextLine().trim();
////            System.out.println("Enter new address (or press Enter to keep current):");
////            String address = scanner.nextLine().trim();
////
////            // Update the record only if the user provides new values
////            try {
////            	Connection connn = MysqlConnection.getConnectionDetails();
////            
////                 PreparedStatement updateStmt = connn.prepareStatement(updateQuery);
////
////                if (newName.isEmpty()) newName = currentName;
////                if (email.isEmpty()) email = null;
////                if (address.isEmpty()) address = null;
////
////                // Prepare the update statement
////                updateStmt.setString(1, newName);
////                updateStmt.setString(2, email);
////                updateStmt.setString(3, address);
////
////                if (option == 1) {
////                    updateStmt.setString(4, currentName);
////                } else {
////                    updateStmt.setInt(4, id);
////                }
////
////                int rowsUpdated = updateStmt.executeUpdate();
////                if (rowsUpdated > 0) {
////                    System.out.println("Record updated successfully");
////
////                    // Fetch and display the updated record
////                    try {
////                    	PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
////                    
////                        if (option == 1) {
////                            selectStmt.setString(1, newName);
////                        } else {
////                            selectStmt.setInt(1, id);
////                        }
////
////                        try (ResultSet rs = selectStmt.executeQuery()) {
////                            if (rs.next()) {
////                                // Display the updated record
////                                int updatedId = rs.getInt("id");
////                                String updatedFacName = rs.getString("fac_name");
////                                String updatedEmail = rs.getString("fac_email");
////                                String updatedAddress = rs.getString("fac_address");
////
////                                System.out.println("Updated Record:");
////                                System.out.println("ID: " + updatedId);
////                                System.out.println("Name: " + updatedFacName);
////                                System.out.println("Email: " + updatedEmail);
////                                System.out.println("Address: " + updatedAddress);
////                            }
////                        
////                    
////                 else {
////                    System.out.println("No record found with the given name or ID.");
////                }
////            }
////        } catch (SQLException e) {
////            System.out.println("An error occurred: " + e.getMessage());
////        }
////                    
////                }
////
////
//
//
//package com.demo.OtherMethod;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//import com.demo.MysqlConnection.MysqlConnection;
//
//public class UpdateNew {
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        // SQL queries for selecting and updating
//        String selectQueryByName = "SELECT id, fac_name, fac_email, fac_address FROM faculty WHERE fac_name = ?";
//        String selectQueryById = "SELECT id, fac_name, fac_email, fac_address FROM faculty WHERE id = ?";
//        String updateQueryByName = "UPDATE faculty SET fac_name = ?, fac_email = ?, fac_address = ? WHERE fac_name = ?";
//        String updateQueryById = "UPDATE faculty SET fac_name = ?, fac_email = ?, fac_address = ? WHERE id = ?";
//
//        Scanner scanner = new Scanner(System.in);
//        Connection conn = null;
//
//        try {
//            // Menu for selecting update option
//            System.out.println("Select an option:");
//            System.out.println("1. Update by name");
//            System.out.println("2. Update by ID");
//            int option = scanner.nextInt();
//            scanner.nextLine();  // Consume the newline character after the integer input
//
//            String currentName = null;
//            int id = 0;
//            String selectQuery = "";
//            String updateQuery = "";
//
//            // Get the necessary input based on user's choice
//            if (option == 1) { // Update by name
//                System.out.println("Enter current name of the faculty:");
//                currentName = scanner.nextLine().trim();
//
//                if (currentName.isEmpty()) {
//                    System.out.println("You must provide a name.");
//                    return;
//                }
//
//                selectQuery = selectQueryByName;
//                updateQuery = updateQueryByName;
//            } else if (option == 2) { // Update by ID
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
//                updateQuery = updateQueryById;
//            } else {
//                System.out.println("Invalid option. Please select either '1' or '2'.");
//                return;
//            }
//
//            // Show the current record before updating
//            conn = MysqlConnection.getConnectionDetails();
//            try (PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
//                if (option == 1) {
//                    selectStmt.setString(1, currentName);
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
//                        System.out.println("Current Record:");
//                        System.out.println("ID: " + currentId);
//                        System.out.println("Name: " + currentFacName);
//                        System.out.println("Email: " + currentEmail);
//                        System.out.println("Address: " + currentAddress);
//                    } else {
//                        System.out.println("No record found with the given name or ID.");
//                        return;
//                    }
//                }
//            }
//
//            // Collect new details for updating
//            System.out.println("Enter new name (or press Enter to keep current):");
//            String newName = scanner.nextLine().trim();
//            System.out.println("Enter new email (or press Enter to keep current):");
//            String email = scanner.nextLine().trim();
//            System.out.println("Enter new address (or press Enter to keep current):");
//            String address = scanner.nextLine().trim();
//
//            // Update the record only if the user provides new values
//            try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
//                if (newName.isEmpty()) newName = currentName;
//                if (email.isEmpty()) email = null;
//                if (address.isEmpty()) address = null;
//
//                // Prepare the update statement
//                updateStmt.setString(1, newName);
//                updateStmt.setString(2, email);
//                updateStmt.setString(3, address);
//
//                if (option == 1) {
//                    updateStmt.setString(4, currentName);
//                } else {
//                    updateStmt.setInt(4, id);
//                }
//
//                int rowsUpdated = updateStmt.executeUpdate();
//                if (rowsUpdated > 0) {
//                    System.out.println("Record updated successfully");
//
//                    // Fetch and display the updated record
//                    try (PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
//                        if (option == 1) {
//                            selectStmt.setString(1, newName);
//                        } else {
//                            selectStmt.setInt(1, id);
//                        }
//
//                        try (ResultSet rs = selectStmt.executeQuery()) {
//                            if (rs.next()) {
//                                // Display the updated record
//                                int updatedId = rs.getInt("id");
//                                String updatedFacName = rs.getString("fac_name");
//                                String updatedEmail = rs.getString("fac_email");
//                                String updatedAddress = rs.getString("fac_address");
//
//                                System.out.println("Updated Record:");
//                                System.out.println("ID: " + updatedId);
//                                System.out.println("Name: " + updatedFacName);
//                                System.out.println("Email: " + updatedEmail);
//                                System.out.println("Address: " + updatedAddress);
//                            } else {
//                                System.out.println("No record found with the given name or ID.");
//                            }
//                        }
//                    }
//                } else {
//                    System.out.println("No record was updated.");
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("An error occurred: " + e.getMessage());
//        } finally {
//            if (conn != null) {
//                conn.close();
//            }
//            scanner.close();
//        }
//    }
//    
////  //Update
////  private static void performUpdate(Scanner scanner, Connection conn) throws SQLException {
////      // Query to select matching record before updating
////      String selectQuery = "SELECT * FROM faculty WHERE fac_name = ? OR id = ?";
////      // Query to update the record
////      String updateQuery = "UPDATE faculty SET fac_name = ?, fac_email = ?, fac_address = ? WHERE fac_name = ? OR id = ?";
////
////      // Ask for ID or name to search for the record
////      System.out.println("Enter the faculty ID (enter 0 if updating by name):");
////      int id = scanner.nextInt();
////      scanner.nextLine();  // Consume the newline
////      System.out.println("Enter current name (press Enter to skip if using ID):");
////      String currentName = scanner.nextLine();
////
////      if (id == 0 && currentName.isEmpty()) {
////          System.out.println("You must provide either a name or ID.");
////          return;
////      }
////
////      // Prepare and execute select query to show the matching record
////      PreparedStatement selectStatement = conn.prepareStatement(selectQuery);
////      selectStatement.setString(1, currentName);
////      selectStatement.setInt(2, id);
////
////      ResultSet resultSet = selectStatement.executeQuery();
////
////      // Check if record exists
////      if (!resultSet.isBeforeFirst()) {  // No data found
////          System.out.println("No matching record found.");
////          return;
////      }
////
////      // Show the current record to the user
////      while (resultSet.next()) {
////          System.out.println("Current Record - ID: " + resultSet.getInt("id") +
////                             ", Name: " + resultSet.getString("fac_name") +
////                             ", Email: " + resultSet.getString("fac_email") +
////                             ", Address: " + resultSet.getString("fac_address"));
////      }
////
////      // Proceed to update after showing the current record
////      System.out.println("Proceeding with the update...");
////
////      // Collect new data for update
////      System.out.println("Enter new name:");
////      String newName = scanner.nextLine();
////      System.out.println("Enter new email:");
////      String newEmail = scanner.nextLine();
////      System.out.println("Enter new address:");
////      String newAddress = scanner.nextLine();
////
////      // Prepare the update statement
////      PreparedStatement updateStatement = conn.prepareStatement(updateQuery);
////      updateStatement.setString(1, newName);
////      updateStatement.setString(2, newEmail);
////      updateStatement.setString(3, newAddress);
////      updateStatement.setString(4, currentName);
////      updateStatement.setInt(5, id);
////
////      // Execute the update
////      int result = updateStatement.executeUpdate();
////      if (result > 0) {
////          System.out.println("Record updated successfully.");
////      } else {
////          System.out.println("No record found with the given criteria.");
////      }
////  }
//
//
//
//  // Method to perform DELETE operation
////  private static void performDelete(Scanner scanner, Connection conn) throws SQLException {
////      String deleteQuery = "DELETE FROM faculty WHERE fac_name = ? OR id = ?";
////
////      System.out.println("Enter the faculty name (press Enter to skip if using ID):");
////      String name = scanner.nextLine();
////      System.out.println("Enter the faculty ID (enter 0 to skip if using name):");
////      int id = scanner.nextInt();
////      scanner.nextLine();  // Consume the newline
////
////      if (id == 0 && name.isEmpty()) {
////          System.out.println("You must provide either a name or ID to delete the record.");
////          return;
////      }
////
////      PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
////      preparedStatement.setString(1, name);
////      preparedStatement.setInt(2, id);
////
////      int result = preparedStatement.executeUpdate();
////      if (result > 0) {
////          System.out.println("Record deleted successfully.");
////      } else {
////          System.out.println("No record found with the given criteria.");
////      }
////  }
//  
//  
////  //Delete
////  private static void performDelete(Scanner scanner, Connection conn) throws SQLException {
////      String deleteQuery1 = "DELETE FROM faculty WHERE id = ?";
////      String deleteQuery2 = "DELETE FROM faculty WHERE fac_name = ?";
////
////      System.out.println("Enter the faculty name (press Enter to skip if using ID):");
////      String name = scanner.nextLine();
////      System.out.println("Enter the faculty ID (enter 0 to skip if using name):");
////      int id = scanner.nextInt();
////      scanner.nextLine();  // Consume the newline
////
////      PreparedStatement preparedStatement;
////
////      if (id == 0 && name.isEmpty()) {
////          System.out.println("You must provide either a name or ID to delete the record.");
////          return;
////      } else if (id != 0) {
////          // Use the ID to delete
////          preparedStatement = conn.prepareStatement(deleteQuery1);
////          preparedStatement.setInt(1, id);
////      } else {
////          // Use the name to delete
////          preparedStatement = conn.prepareStatement(deleteQuery2);
////          preparedStatement.setString(1, name);
////      }
////
////      int result = preparedStatement.executeUpdate();
////      if (result > 0) {
////          System.out.println("Record deleted successfully.");
////      } else {
////          System.out.println("No record found with the given criteria.");
////      }
////  }
//  
//
//}
