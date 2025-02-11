package supermarket.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"supplier_id", "name", "contact_number", "email", "address"})
public class Supplier {

    @XmlElement(name = "supplier_id")
    @JsonProperty("supplier_id")
    private long supplierId;
    @XmlElement(name = "name")
    @JsonProperty("name")
    private String name;
    @XmlElement(name = "contact_number")
    @JsonProperty("contact_number")
    private String contactNumber;
    @XmlElement(name = "email")
    @JsonProperty("email")
    private String email;
    @XmlElement(name = "address")
    @JsonProperty("address")
    private String address;

    public Supplier(long supplierId, String name, String contactNumber, String email, String address) {
        this.supplierId = supplierId;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
