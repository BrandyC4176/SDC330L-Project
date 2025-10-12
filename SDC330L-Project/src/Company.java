/*
 * Author: Brandy Christopher
 * SDC330L Project
 * Date: 10/09/25
 * Purpose: Represents a company.
 * Used as part of a BusinessContact to show composition.
 */

public class Company {
    private String name;
    private String mainPhone;

    public Company(String name, String mainPhone) {
        this.name = name;
        this.mainPhone = mainPhone;
    }

    @Override
    public String toString() {
        return String.format("%s (Main: %s)", name, mainPhone);
    }
}
