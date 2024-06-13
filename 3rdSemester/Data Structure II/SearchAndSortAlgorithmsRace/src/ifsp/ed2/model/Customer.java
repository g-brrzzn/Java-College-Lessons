package ifsp.ed2.model;

public class Customer implements Comparable<Customer>{
    private int id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String country;
    private String companyName;
    private String occupation;
    
    public Customer(int id, String firstName, String lastName, String eMail, String country, String companyName,
            String occupation) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.country = country;
        this.companyName = companyName;
        this.occupation = occupation;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getOccupation() {
        return occupation;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public int compareTo(Customer other) {
        return Integer.compare(this.id, other.id);
    }

}
