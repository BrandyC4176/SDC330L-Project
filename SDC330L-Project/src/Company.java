/*
 * Author: Brandy Christopher
 * SDC330L Project
 * Date: 10/19/25
 * Purpose: Represents a company.
 * Used as part of a BusinessContact to show composition.
 */

public class Company implements Interface {
    private String name;
    private String mainPhone;

    public Company(String name, String mainPhone) {
        this.name      = name;
        this.mainPhone = mainPhone;
    }

    // INTERFACE IMPLEMENTATION: Interface
    @Override
    public String toDisplayString() {
        return String.format("%s (Main: %s)", name, mainPhone);
    }

    @Override
    public String toString() {
        return toDisplayString();
    }
}
