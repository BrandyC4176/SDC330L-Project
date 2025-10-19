/*
* Author: Brandy Christopher
 * SDC330L Project
 * Date: 10/18/25
 * Purpose: Represents an address.
 * Used through composition by Contact classes.
 */

public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city   = city;
        this.state  = state;
        this.zip    = zip;
    }

    @Override
    public String toString() {
        return String.format("Address: %s, %s, %s %s", street, city, state, zip);
    }
}