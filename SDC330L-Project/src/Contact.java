/*
* Author: Brandy Christopher
 * SDC330L Project
 * Date: 10/19/25
 * Purpose: Base class for all contacts in the Rolodex app.
 * Shows inheritance by being the parent class for Business, Family, and Friend contacts.
 * Also shows composition since each Contact has an Address.
 */

public abstract class Contact implements Displayable {
    protected String firstName;
    protected String lastName;
    protected String phone;
    protected String email;
    protected Address address; // Composition: a Contact "has an" Address

    public Contact(String firstName, String lastName, String phone, String email, Address address) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.phone     = phone;
        this.email     = email;
        this.address   = address;
    }

    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }
    public String getPhone()     { return phone; }
    public String getEmail()     { return email; }
    public Address getAddress()  { return address; }

    // Each subclass identifies its own type (Business, Family, Friend)
    public abstract String getType();

    // INTERFACE IMPLEMENTATION: Displayable
    @Override
    public String toDisplayString() {
        String addr = (address != null ? address.toString() : "No Address");
        return String.format("%s Contact | %s %s | Phone: %s | Email: %s | %s",
                getType(), firstName, lastName, phone, email, addr);
    }
}