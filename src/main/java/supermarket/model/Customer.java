package supermarket.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.*;

import java.sql.Time;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"_id", "_first_name", "_last_name", "_email", "_birth_date", "_contact_number"})
public class Customer {

    @XmlAttribute(name = "id")
    @JsonProperty("_id")
    private long customerId;
    @XmlAttribute(name = "first_name")
    @JsonProperty("_first_name")
    private String firstName;
    @XmlAttribute(name = "last_name")
    @JsonProperty("_last_name")
    private String lastName;
    @XmlAttribute(name = "_email")
    @JsonProperty("_email")
    private String email;
    @XmlElement(name = "birth_date")
    @JsonProperty("_birth_date")
    private Time birthDate;
    @XmlAttribute(name = "contact_number")
    @JsonProperty("_contact_number")
    private String contactNumber;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, Time birthDate, String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.contactNumber = contactNumber;
    }

    public Customer(long customerId, String firstName, String lastName, String email, Time birthDate, String contactNumber) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.contactNumber = contactNumber;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Time getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Time birthDate) {
        this.birthDate = birthDate;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
