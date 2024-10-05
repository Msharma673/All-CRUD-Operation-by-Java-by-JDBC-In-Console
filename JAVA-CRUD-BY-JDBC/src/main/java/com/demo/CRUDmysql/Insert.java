////package com.demo.CRUDmysql;
////
////import java.sql.PreparedStatement;
////import java.sql.SQLException;
////import java.util.Scanner;
////
////import com.demo.MysqlConnection.MysqlConnection;
////
////public class Insert {
////	
////	 public static void main(String[] args) throws ClassNotFoundException, SQLException {
////	        String insertQuery = "insert into faculty (fac_name, fac_email, fac_address) values (?, ?, ?)";
////	        String name, email, address;
////	        Scanner scanner = new Scanner(System.in);
////	        System.out.println("Enter name");
////	        name = scanner.nextLine();
////	        System.out.println("Enter email");
////	        email = scanner.nextLine();
////	        System.out.println("Enter address");
////	        address = scanner.nextLine();
////
////	        PreparedStatement preparedStatement = MysqlConnection.getConnectionDetails().prepareStatement(insertQuery);
////	        preparedStatement.setString(1, name);
////	        preparedStatement.setString(2, email);
////	        preparedStatement.setString(3, address);
////
////	        int i = preparedStatement.executeUpdate();
////	        if (i != 0)
////	            System.out.println("Record inserted successfully");
////	    }
////
////}
//
//
//package com.demo.CRUDmysql;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//import com.demo.MysqlConnection.MysqlConnection;
//
//public class Insert {
//	
//    public static void main(String[] args) {
//        // SQL query for inserting a record into the faculty table
//        String insertQuery = "INSERT INTO faculty (fac_name, fac_email, fac_address) VALUES (?, ?, ?)";
//        
//        try (Scanner scanner = new Scanner(System.in);
//             Connection conn = MysqlConnection.getConnectionDetails()) {
//
//            // Ask the user for input to insert a new record
//            System.out.println("Enter name:");
//            String name = scanner.nextLine().trim();
//            
//            System.out.println("Enter email:");
//            String email = scanner.nextLine().trim();
//            
//            System.out.println("Enter address:");
//            String address = scanner.nextLine().trim();
//
//            // Check if the user provided valid input for all fields
//            if (name.isEmpty() || email.isEmpty() || address.isEmpty()) {
//                System.out.println("All fields (name, email, address) are required.");
//                return;
//            }
//
//            // Prepare the SQL statement
//            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, email);
//            preparedStatement.setString(3, address);
//
//            // Execute the insertion and check if successful
//            int result = preparedStatement.executeUpdate();
//            if (result > 0) {
//                System.out.println("Record inserted successfully.");
//                // Optionally, you can display the inserted record details
//                System.out.println("Inserted Record -> Name: " + name + ", Email: " + email + ", Address: " + address);
//            } else {
//                System.out.println("Failed to insert the record.");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();  // Handle SQL exceptions
//        }
//    }
//}
