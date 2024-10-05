package com.demo.CrudOperation;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.demo.MysqlConnection.MysqlConnection;

public class Operations {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             Connection conn = MysqlConnection.getConnectionDetails()) {
            boolean continueOperations = true;

            // Instantiate operation classes
            InsertOperation insert = new InsertOperation();
            SelectOperation select = new SelectOperation();
            UpdateOperation update = new UpdateOperation();
            DeleteOperation delete = new DeleteOperation();

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
                        select.performSelect(scanner, conn);
                        break;
                    case 2:
                        insert.performInsert(scanner, conn);
                        break;
                    case 3:
                        update.performUpdate(scanner, conn);
                        break;
                    case 4:
                        delete.performDelete(scanner, conn);
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
}
