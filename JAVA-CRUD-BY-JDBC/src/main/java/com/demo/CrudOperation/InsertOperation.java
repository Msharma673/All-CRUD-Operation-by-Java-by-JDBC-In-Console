//package com.demo.CrudOperation;
//
//
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//public class InsertOperation {
//    public void performInsert(Scanner scanner, Connection conn) throws SQLException {
//        String insertQuery = "INSERT INTO faculty (fac_name, fac_email, fac_address) VALUES (?, ?, ?)";
//
//        System.out.println("Enter name:");
//        String name = scanner.nextLine();
//        System.out.println("Enter email:");
//        String email = scanner.nextLine();
//        System.out.println("Enter address:");
//        String address = scanner.nextLine();
//
//        if (name.isEmpty() || email.isEmpty() || address.isEmpty()) {
//            System.out.println("All fields (name, email, address) are required.");
//            return;
//        }
//
//        PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
//        preparedStatement.setString(1, name);
//        preparedStatement.setString(2, email);
//        preparedStatement.setString(3, address);
//
//        int result = preparedStatement.executeUpdate();
//        if (result > 0) {
//            System.out.println("Record inserted successfully.");
//            System.out.println("Inserted Record -> Name: " + name + ", Email: " + email + ", Address: " + address);
//        } else {
//            System.out.println("Failed to insert the record.");
//        }
//    }
//}
//
//

//package com.demo.CrudOperation;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//public class InsertOperation {
//    public void performInsert(Scanner scanner, Connection conn) throws SQLException {
//        String insertQuery = "INSERT INTO faculty (fac_name, fac_email, fac_address) VALUES (?, ?, ?)";
//
//        System.out.println("Enter name:");
//        String name = scanner.nextLine();
//        System.out.println("Enter email:");
//        String email = scanner.nextLine();
//        System.out.println("Enter address:");
//        String address = scanner.nextLine();
//
//        if (name.isEmpty() || email.isEmpty() || address.isEmpty()) {
//            System.out.println("All fields (name, email, address) are required.");
//            return;
//        }
//
//        // Display the data to be inserted and ask for confirmation
//        System.out.println("You have entered the following details:");
//        System.out.println("Name: " + name);
//        System.out.println("Email: " + email);
//        System.out.println("Address: " + address);
//        System.out.println("Do you want to insert this record? (yes/no)");
//        String confirmInsert = scanner.nextLine();
//
//        if (!confirmInsert.equalsIgnoreCase("yes")) {
//            System.out.println("Insert operation canceled.");
//            return; // Exit the method if the user does not want to insert
//        }
//
//        PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
//        preparedStatement.setString(1, name);
//        preparedStatement.setString(2, email);
//        preparedStatement.setString(3, address);
//
//        int result = preparedStatement.executeUpdate();
//        if (result > 0) {
//            System.out.println("Record inserted successfully.");
//            System.out.println("Inserted Record -> Name: " + name + ", Email: " + email + ", Address: " + address);
//        } else {
//            System.out.println("Failed to insert the record.");
//        }
//    }
//}


package com.demo.CrudOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertOperation {
    public void performInsert(Scanner scanner, Connection conn) throws SQLException {
        // Initial confirmation prompt
        System.out.println("Do you want to insert a new faculty record? (yes/no)");
        String confirmInsert = scanner.nextLine();

        if (!confirmInsert.equalsIgnoreCase("yes")) {
            System.out.println("Insert operation canceled.");
            return; // Exit the method if the user does not want to insert
        }

//        String insertQuery = "INSERT INTO faculty (fac_name, fac_email, fac_address) VALUES (?, ?, ?)";
        
//        String insertQuery1 = QueryClassConstant.insertQuery;

        // Collect user input for new record
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter address:");
        String address = scanner.nextLine();

        // Validate user input
        if (name.isEmpty() || email.isEmpty() || address.isEmpty()) {
            System.out.println("All fields (name, email, address) are required.");
            return;
        }

        // Display the data to be inserted and ask for confirmation
        System.out.println("You have entered the following details:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("Do you want to insert this record? (yes/no)");
        confirmInsert = scanner.nextLine();

        if (!confirmInsert.equalsIgnoreCase("yes")) {
            System.out.println("Insert operation canceled.");
            return; // Exit the method if the user does not want to insert
        }

        // Prepare the insert statement
        PreparedStatement preparedStatement = conn.prepareStatement(QueryClassConstant.insertQuery);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, address);

        // Execute the insert operation
        int result = preparedStatement.executeUpdate();
        if (result > 0) {
            System.out.println("Record inserted successfully.");
            System.out.println("Inserted Record -> Name: " + name + ", Email: " + email + ", Address: " + address);
        } else {
            System.out.println("Failed to insert the record.");
        }
    }
}


