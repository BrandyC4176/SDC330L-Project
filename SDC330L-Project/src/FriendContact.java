/*
* Author: Brandy Christopher
 * SDC330L Project
 * Date: 10/09/25
 * Purpose: Represents a friend contact.
 * Inherits from Contact and adds a short note about how you know the person.
 */

public class FriendContact extends Contact {
    private String howWeMet;

    public FriendContact(String firstName, String lastName, String phone, String email,
                         Address address, String howWeMet) {
        super(firstName, lastName, phone, email, address);
        this.howWeMet = howWeMet;
    }

    @Override
    public String getType() { return "Friend"; }

    @Override
    public String summary() {
        String base = super.summary();
        String extra = (howWeMet != null && !howWeMet.isBlank()) ? " | Met through: " + howWeMet : "";
        return base + extra;
    }
}
