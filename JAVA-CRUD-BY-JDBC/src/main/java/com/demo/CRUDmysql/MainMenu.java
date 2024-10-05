//package com.demo.CRUDmysql;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//import com.demo.MysqlConnection.MysqlConnection;
//
//public class MainMenu {
//
//	public static void main(String[] args) throws ClassNotFoundException {
//        try (Scanner scanner = new Scanner(System.in);
//             Connection conn = MysqlConnection.getConnectionDetails()) {
//            boolean continueOperations = true;
//
//            // Instantiate operation classes
//            Insert insert = new Insert();
//            Select select = new Select();
//            Update update = new Update();
//            Delete delete = new Delete();
//
//            while (continueOperations) {
//                // Display menu for user to select an operation
//                System.out.println("Select an operation:");
//                System.out.println("1. Select Records");
//                System.out.println("2. Insert Record");
//                System.out.println("3. Update Record");
//                System.out.println("4. Delete Record");
//                System.out.println("5. Exit");
//                int choice = scanner.nextInt();
//                scanner.nextLine();  // Consume the newline
//
//                switch (choice) {
//                    case 1:
//                        select.main(args);
//                        break;
//                    case 2:
//                        insert.main(args);;
//                        break;
//                    case 3:
//                        update.main(args);
//                        break;
//                    case 4:
//                        delete.main(args);
//                        break;
//                    case 5:
//                        System.out.println("Exiting program...");
//                        return;  // Exit the program
//                    default:
//                        System.out.println("Invalid choice. Please select a valid option.");
//                        break;
//                }
//
//                // Ask the user if they want to perform another operation
//                System.out.println("Do you want to perform another operation? (yes/no)");
//                String continueResponse = scanner.nextLine().trim().toLowerCase();
//                if (!continueResponse.equals("yes")) {
//                    continueOperations = false;
//                    System.out.println("Program terminated.");
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
