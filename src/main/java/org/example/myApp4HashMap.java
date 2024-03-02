package org.example;

import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException;

/*
Name: Anh-Thien Nguyen
Student Id: 202660307
Date: 1/23/24
Description: This program is a Restaurant Menu Manager that allows you to make a menu in a very easy way!
To press 1, This program allows you to add an ID, a category, a name, and a price of  your dish for the menu of a
restaurant. To press 2, this program also allows you to remove a dish from your restaurant by
inputting the dish ID. To press 3, this program allows you to search for your dish, and you can choose what info you
want  to receive about your dish, such as the Category, Name, Price, or even all three! To press 4, this program will
show  every dish and its information. To press 5 is to quit. This program is created by using a Hashmap to add and
remove data as a way of storing data. The scanner is used for the user to decide what data should be stored in Hashmap.
 */


public class myApp4HashMap {

    private static HashMap<String, basicInfo> menuItems = new HashMap<>(); //create Hashmap named "menuItems"
    private static Scanner input = new Scanner(System.in); //create scanner object named input

    public static void main(String[] args) {
        System.out.println("Welcome to the Restaurant Menu Manager!");
        int choice; // create variable choice
        do {
            System.out.println("\nChoose an option: 1) Add 2) Remove 3) Search 4) Show All 5) Quit");
            choice = input.nextInt(); // gives space for you to input your response

            if (choice == 1) {
                addMenuItem(); //plays method
                showAllMenuItems(); //plays method
            } else if (choice == 2) {
                removeMenuItem(); //plays method
                showAllMenuItems(); //plays method
            } else if (choice == 3) {
                searchMenuItem(); //plays method
            } else if (choice == 4) {
                showAllMenuItems(); //plays method
            } else if (choice == 5) {
                System.out.println("Exiting. Goodbye!"); //nothing else after print so it ends
            } else {
                System.out.println("Invalid choice. Please choose between 1 - 5.");
            }
        } while (choice != 5);
    }

    public static void addMenuItem() {
        System.out.println("\nAdding a new menu item.");
        input.nextLine(); // Clear the buffer

        System.out.println("Enter item ID:");
        String id = input.nextLine();

        if (menuItems.containsKey(id)) {
            System.out.println("ID already in use. Try a different ID.");
            return;
        }
        System.out.println("Enter item category:");
        String category = input.nextLine();

        System.out.println("Enter item name:");
        String name = input.nextLine();

        System.out.println("Enter item price:");
        double price;
        try {
            price = input.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid price. Please enter a numeric value.");
            input.nextLine(); // Clear the buffer
            return;
        }

        basicInfo newItem = new basicInfo(id, name, price, category);
        menuItems.put(id, newItem);
        System.out.println("Item added successfully: " + newItem);
    }

    public static void removeMenuItem() {
        System.out.println("\nRemoving a menu item.");
        if (menuItems.isEmpty()) {
            System.out.println("The menu is currently empty. No items to remove.");
            return;
        }

        System.out.println("Enter the ID of the item to remove:");
        String id = input.next();

        if (menuItems.containsKey(id)) {
            menuItems.remove(id);
            System.out.println("Item with ID " + id + " has been removed.");
        } else {
            System.out.println("Item with ID " + id + " not found.");
        }
    }

    public static void searchMenuItem() {
        System.out.println("\nSearching for a menu item.");
        if (menuItems.isEmpty()) {
            System.out.println("The menu is currently empty. No items to search.");
            return;
        }

        System.out.println("Enter the ID of the item to search for:");
        String id = input.next();
        input.nextLine(); // Clear the buffer

        if (!menuItems.containsKey(id)) {
            System.out.println("Item with ID " + id + " not found.");
            return;
        }

        System.out.println("What do you want to know from ID-" + id + "? 1) Category 2) Name 3) Price 4) All Info");
        int detailChoice = input.nextInt();
        basicInfo item = menuItems.get(id);

        if (detailChoice == 1) {
            System.out.println("Category: " + item.getCategory());
        } else if (detailChoice == 2) {
            System.out.println("Name: " + item.getName());
        } else if (detailChoice == 3) {
            System.out.println("Price: $" + item.getPrice());
        } else if (detailChoice == 4) {
            System.out.println("Item details: " + item); // This will print all info using the toString method of MenuItem
        } else {
            System.out.println("Invalid choice. Please choose between 1 - 4.");
        }
    }


    public static void showAllMenuItems() {
        System.out.println("\nCurrent Menu Items:");
        if (menuItems.isEmpty()) {
            System.out.println("The menu is currently empty.");
        } else {
            for (basicInfo item : menuItems.values()) {
                System.out.println(item); // This will call the updated toString method in MenuItem
            }
        }
    }
}

