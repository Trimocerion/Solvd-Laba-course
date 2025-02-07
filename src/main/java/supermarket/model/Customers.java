package supermarket.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.sql.Time;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"customerId", "firstName", "lastName", "email", "birthDate", "contactNumber"})
public class Customers {

    @XmlElement(name = "customer_id")
    @JsonProperty("customer_id")
    private long customerId;
    @XmlElement(name = "first_name")
    @JsonProperty("first_name")
    private String firstName;
    @XmlElement(name = "last_name")
    @JsonProperty("last_name")
    private String lastName;
    @XmlElement(name = "email")
    @JsonProperty("email")
    private String email;
    @XmlElement(name = "birth_date")
    @JsonProperty("birth_date")
    private Time birthDate;
    @XmlElement(name = "contact_number")
    @JsonProperty("contact_number")
    private String contactNumber;

    public Customers() {
    }

    public Customers(String firstName, String lastName, String email, Time birthDate, String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.contactNumber = contactNumber;
    }

    public Customers(long customerId, String firstName, String lastName, String email, Time birthDate, String contactNumber) {
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
}
