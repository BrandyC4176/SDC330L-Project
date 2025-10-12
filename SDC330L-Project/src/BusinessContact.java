/*
 * Author: Brandy Christopher
 * SDC330L Project
 * Date: 10/09/25
 * Purpose: Represents a business contact.
 * Inherits from Contact and adds company/job title info.
 * Also shows composition since it includes a Company object.
 */

public class BusinessContact extends Contact {
    private Company company;
    private String jobTitle;

    public BusinessContact(String firstName, String lastName, String phone, String email,
                           Address address, Company company, String jobTitle) {
        super(firstName, lastName, phone, email, address);
        this.company = company;
        this.jobTitle = jobTitle;
    }

    @Override
    public String getType() { return "Business"; }

    @Override
    public String summary() {
        String base = super.summary();
        String companyPart = (company != null ? " | Company: " + company.toString() : "");
        String titlePart = (jobTitle != null && !jobTitle.isBlank() ? " | Title: " + jobTitle : "");
        return base + companyPart + titlePart;
    }
}
