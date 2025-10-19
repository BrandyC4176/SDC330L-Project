/*
* Author: Brandy Christopher
 * SDC330L Project
 * Date: 10/19/25
 * Purpose: Represents a friend contact.
 * Inherits from Contact and adds a short note about how you know the person.
 */

public class FriendContact extends Contact {
    private String howWeMet; // e.g., College, Neighbor

    public FriendContact(String firstName, String lastName, String phone, String email,
                         Address address, String howWeMet) {
        super(firstName, lastName, phone, email, address);
        this.howWeMet = howWeMet;
    }

    @Override
    public String getType() {
        return "Friend";
    }

    @Override
    public String toDisplayString() {
        String base = super.toDisplayString();
        String extra = (howWeMet != null && !howWeMet.isBlank()) ? " | Met through: " + howWeMet : "";
        return base + extra;
    }
}