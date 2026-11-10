package com.hibernate.p02_xml_configuration;



import com.hibernate.p02_xml_configuration.dao.UserDAO;
import com.hibernate.p02_xml_configuration.entity.User;
import com.hibernate.p02_xml_configuration.config.HibernateUtil;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        boolean exit = false;

        System.out.println("==== Hibernate Console App ====");

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create User");
            System.out.println("2. View All Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    // Create user
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    User newUser = new User();
                    newUser.setName(name);
                    newUser.setEmail(email);

                    userDAO.saveUser(newUser);
                    System.out.println("User saved successfully.");
                    break;

                case 2:
                    // Read users
                    List<User> users = userDAO.getUsers();
                    System.out.println("All Users:");
                    for (User user : users) {
                        System.out.println("ID: " + user.getId() +
                                           ", Name: " + user.getName() +
                                           ", Email: " + user.getEmail());
                    }
                    break;

                case 3:
                    // Update user
                    System.out.print("Enter user ID to update: ");
                    Long updateId = Long.parseLong(scanner.nextLine());
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    userDAO.updateUser(updateId, newName);
                    System.out.println("User updated successfully.");
                    break;

                case 4:
                    // Delete user
                    System.out.print("Enter user ID to delete: ");
                    Long deleteId = Long.parseLong(scanner.nextLine());
                    userDAO.deleteUser(deleteId);
                    System.out.println("User deleted successfully.");
                    break;

                case 5:
                    // Exit
                    exit = true;
                    HibernateUtil.getSessionFactory().close(); // Good practice to close
                    System.out.println("Exiting the application...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
