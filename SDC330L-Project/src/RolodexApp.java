/*
 * Author: Brandy Christopher
 * SDC330L Project
 * Date: 10/09/25
 * Purpose: Main entry point for the Rolodex Application.
 * Prints a header, a welcome message, and a simple menu.
 * Demonstrates inheritance and composition
 */

import java.util.*;
import java.util.stream.Collectors;

public class RolodexApp {

    // Scanner for user input
    private static final Scanner SCAN = new Scanner(System.in);

    // Stores all our contacts in a simple list
    private static final List<Contact> CONTACTS = new ArrayList<>();

    public static void main(String[] args) {
        printHeader();          // Project title and author
        preloadSampleData();    // Add some example contacts
        printWelcome();         // Say hello and explain what’s going on

        // Simple menu loop so the user can choose what to do
        boolean running = true;
        while (running) {
            printMenu();
            String choice = SCAN.nextLine().trim();

        switch (choice) {
                case "1":
                    displayAll();
                    break;
                case "2":
                    displayByType();
                    break;
                case "3":
                    displayByLastNameLetter();
                    break;
                case "4":
                    running = false;
                    break;
                default:
                    System.out.println("Please enter a valid option (1–4).");
                    break;
            }
        }

        // Closing message
        System.out.println("\nThanks for checking out the Rolodex App! Goodbye.");
    }

    // Prints title, project week, and your name
    private static void printHeader() {
        System.out.println(" Project Week 1  |  Rolodex/Contacts App Demo ");
        System.out.println(" Author: Brandy Christopher");
    }

    // Friendly intro message
    private static void printWelcome() {
        System.out.println("Welcome to the Rolodex App");
        System.out.println("Pick a menu option to view your contacts.\n");
    }

    // Shows the main menu
    private static void printMenu() {
        System.out.println("Menu:");
        System.out.println("  1) Display ALL contacts");
        System.out.println("  2) Display by TYPE (Business, Family, or Friend)");
        System.out.println("  3) Display by LAST NAME letter");
        System.out.println("  4) Exit");
        System.out.print("Enter your choice: ");
    }

    // Adds some sample contacts to the list for demonstration
    private static void preloadSampleData() {
        // Composition: each contact “has an” Address
        Address a1 = new Address("123 Market St", "High Point", "NC", "37220");
        Address a2 = new Address("88 Pine Ave", "Modesto", "CA", "95351");
        Address a3 = new Address("42 River Rd", "Newport News", "VA", "23601");
        Address a4 = new Address("75 Maple Dr", "Dallas", "TC", "73451");

        // Composition again: BusinessContact also “has a” Company
        Company trendify = new Company("Trendify Marketing Co ", "888-555-9999");

        // Inheritance in action — different types of contacts share base behavior
        CONTACTS.add(new BusinessContact(
                "Sarah", "Johnson", "888-555-1122", "sarah.j@trendify.com", a1, trendify, "Marketing Manager"));

        CONTACTS.add(new FamilyContact(
                "Brian", "Christopher", "757-555-3210", "brian.christopher@email.com", a2, "Brother"));

        CONTACTS.add(new FamilyContact(
                "Emily", "Davis", "757-555-7755", "emily.davis@mail.com", a3, "Sister"));

        CONTACTS.add(new FriendContact(
                "Jason", "Miller", "757-555-9011", "jmiller@chatmail.com", a4, "College"));
    }

    // Prints all contacts
    private static void displayAll() {
        System.out.println("--- All Contacts ---");
        if (CONTACTS.isEmpty()) {
            System.out.println("No contacts yet.");
        } else {
            CONTACTS.forEach(c -> System.out.println(c.summary()));
        }
        System.out.println();
    }

    // Filters contacts by type (Business, Family, or Friend)
    private static void displayByType() {
        System.out.print("\nEnter type (Business/Family/Friend): ");
        String type = SCAN.nextLine().trim();
        List<Contact> filtered = CONTACTS.stream()
                .filter(c -> c.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());

        System.out.println("\n--- Contacts of type: " + type + " ---");
        if (filtered.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            filtered.forEach(c -> System.out.println(c.summary()));
        }
        System.out.println();
    }

    // Filters contacts by the first letter of their last name
    private static void displayByLastNameLetter() {
        System.out.print("\nEnter the first letter of the last name: ");
        String s = SCAN.nextLine().trim();

        if (s.isEmpty()) {
            System.out.println("Please enter at least one letter.\n");
            return;
        }

        char letter = Character.toUpperCase(s.charAt(0));
        List<Contact> filtered = CONTACTS.stream()
                .filter(c -> !c.getLastName().isEmpty()
                        && Character.toUpperCase(c.getLastName().charAt(0)) == letter)
                .collect(Collectors.toList());

        System.out.println("\n--- Contacts with last names starting with '" + letter + "' ---");
        if (filtered.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            filtered.forEach(c -> System.out.println(c.summary()));
        }
        System.out.println();
    }
}
