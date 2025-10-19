/*
 * Author: Brandy Christopher
 * SDC330L Project
 * Date: 10/19/25
 * Purpose: In-memory repository to add, update, remove, and query contacts.
 * Keeps UI logic out of data management (clean separation).
 */

import java.util.*;
import java.util.stream.Collectors;

public class ContactRepository {
    private final List<Contact> contacts = new ArrayList<>();

    public void add(Contact c) { contacts.add(c); }

    public List<Contact> getAll() { return new ArrayList<>(contacts); }

    public List<Contact> getByType(String type) {
        return contacts.stream()
                .filter(c -> c.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    public List<Contact> getByLastNameInitial(char letter) {
        char target = Character.toUpperCase(letter);
        return contacts.stream()
                .filter(c -> !c.getLastName().isEmpty() &&
                        Character.toUpperCase(c.getLastName().charAt(0)) == target)
                .collect(Collectors.toList());
    }
}