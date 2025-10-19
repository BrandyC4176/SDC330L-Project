/*
 * Author: Brandy Christopher
 * SDC330L Project
 * Date: 10/19/25
* Purpose: Main entry point for the Rolodex application (WEEK 2).
 * - Displays Week 2 header & welcome/instructions.
 * - Demonstrates INTERFACE via Displayable.
 * - Demonstrates POLYMORPHISM by:
 *     (a) treating Business/Family/Friend as Contact and Displayable
 *     (b) rendering a mixed List<Displayable> (Contacts + Companies)
 * - Reuses Week 1 inheritance/composition classes.
 */

import java.util.*;

public class RolodexApp {

    private static final Scanner SCAN = new Scanner(System.in);
    private static final ContactRepository REPO = new ContactRepository();

    public static void main(String[] args) {
        printHeader();
        preloadData();
        printWelcome();

        boolean running = true;
        while (running) {
            printMenu();
            String choice = SCAN.nextLine().trim();

            switch (choice) {
                case "1":
                    displayAllContacts();
                    break;
                case "2":
                    displayByType();
                    break;
                case "3":
                    displayDirectoryView();
                    break;
                case "4":
                    running = false;
                    break;
                default:
                    System.out.println("Please enter 1–4.");
                    break;
            }
        }

        System.out.println("\nThanks for using the Rolodex App (Week 2). Goodbye!");
    }

    private static void printHeader() {
        System.out.println("==================================================");
        System.out.println(" Project Week 2 | Rolodex/Contacts App (Interfaces & Polymorphism)");
        System.out.println(" Author: Brandy Lockhart");
        System.out.println("==================================================\n");
    }

    private static void printWelcome() {
        System.out.println("Welcome! This demo builds on Week 1 and shows an interface (Displayable)");
        System.out.println("and polymorphism using both the Contact hierarchy and a mixed Displayable list.\n");
        System.out.println("Instructions:");
        System.out.println("  - Choose an option to view contacts in different ways.");
        System.out.println("  - Option 3 mixes Contacts and Companies to show interface-based polymorphism.\n");
    }

    private static void printMenu() {
        System.out.println("Menu:");
        System.out.println("  1) Display ALL Contacts");
        System.out.println("  2) Display Contacts by TYPE (Business/Family/Friend)");
        System.out.println("  3) Display DIRECTORY (mixed Displayable: Contacts + Companies)");
        System.out.println("  4) Exit");
        System.out.print("Enter your choice: ");
    }

    private static void preloadData() {
        Address a1 = new Address("123 Market St", "Richmond", "VA", "23220");
        Address a2 = new Address("88 Pine Ave", "Norfolk", "VA", "23510");
        Address a3 = new Address("42 River Rd", "Newport News", "VA", "23601");
        Address a4 = new Address("75 Maple Dr", "Virginia Beach", "VA", "23451");

        Company trendify = new Company("Trendify Marketing", "804-555-0199");

        REPO.add(new BusinessContact(
                "Sarah", "Johnson", "804-555-1122", "sarah.j@trendify.com", a1, trendify, "Marketing Manager"));
        REPO.add(new FamilyContact(
                "Brian", "Lockhart", "757-555-3210", "brian.lockhart@email.com", a2, "Cousin"));
        REPO.add(new FamilyContact(
                "Emily", "Davis", "757-555-7755", "emily.davis@mail.com", a3, "Sister"));
        REPO.add(new FriendContact(
                "Jason", "Miller", "757-555-9011", "jmiller@chatmail.com", a4, "College"));
    }

    private static void displayAllContacts() {
        System.out.println("\n--- All Contacts ---");
        for (Contact c : REPO.getAll()) {
            System.out.println(c.toDisplayString());
        }
        System.out.println();
    }

    private static void displayByType() {
        System.out.print("\nEnter type (Business/Family/Friend): ");
        String type = SCAN.nextLine().trim();
        List<Contact> filtered = REPO.getByType(type);

        System.out.println("\n--- Contacts of type: " + type + " ---");
        if (filtered.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            for (Contact c : filtered) {
                System.out.println(c.toDisplayString());
            }
        }
        System.out.println();
    }

    private static void displayDirectoryView() {
        System.out.println("\n--- Directory (Displayable polymorphism) ---");

        List<Displayable> items = new ArrayList<>();
        items.addAll(REPO.getAll());
        items.add(new Company("Coastal Freight", "757-555-2200"));
        items.add(new Company("Peninsula Health", "757-555-3344"));

        for (Displayable d : items) {
            System.out.println(d.toDisplayString());
        }
        System.out.println();
    }
}
