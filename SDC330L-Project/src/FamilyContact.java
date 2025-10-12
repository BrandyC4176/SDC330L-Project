/*
* Author: Brandy Christopher
 * SDC330L Project
 * Date: 10/09/25
 * Purpose: Represents a family contact.
 * Inherits from Contact and adds a “relationship” field.
 */

public class FamilyContact extends Contact {
    private String relationship;

    public FamilyContact(String firstName, String lastName, String phone, String email,
                         Address address, String relationship) {
        super(firstName, lastName, phone, email, address);
        this.relationship = relationship;
    }

    @Override
    public String getType() { return "Family"; }

    @Override
    public String summary() {
        String base = super.summary();
        String rel = (relationship != null && !relationship.isBlank() ? " | Relationship: " + relationship : "");
        return base + rel;
    }
}
