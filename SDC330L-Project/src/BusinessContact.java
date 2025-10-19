/*
 * Author: Brandy Christopher
 * SDC330L Project
 * Date: 10/19/25
 * Purpose: Represents a business contact.
 * Inherits from Contact and adds company/job title info.
 * Also shows composition since it includes a Company object.
 */

public class BusinessContact extends Contact {
    private Company company;  // Composition
    private String jobTitle;

    public BusinessContact(String firstName, String lastName, String phone, String email,
                           Address address, Company company, String jobTitle) {
        super(firstName, lastName, phone, email, address);
        this.company  = company;
        this.jobTitle = jobTitle;
    }

    public Company getCompany() { return company; }

    @Override
    public String getType() {
        return "Business";
    }

    @Override
    public String toDisplayString() {
        String base = super.toDisplayString();
        String co   = (company != null ? " | Company: " + company.toDisplayString() : "");
        String jt   = (jobTitle != null && !jobTitle.isBlank() ? " | Title: " + jobTitle : "");
        return base + co + jt;
    }
}
