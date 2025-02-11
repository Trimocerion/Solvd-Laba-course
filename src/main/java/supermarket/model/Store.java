package supermarket.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "store")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"store_id", "address", "postal_code"})
public class Store {

    @XmlAttribute(name = "id")
    @JsonProperty("store_id")
    private long storeId;
    @XmlAttribute(name = "address")
    @JsonProperty("address")
    private String address;
    @XmlAttribute(name = "postal_code")
    @JsonProperty("postal_code")
    private String postalCode;

    public Store() {
    }

    public Store(String address, String postalCode) {
        this.address = address;
        this.postalCode = postalCode;
    }

    public Store(long storeId, String address, String postalCode) {
        this.storeId = storeId;
        this.address = address;
        this.postalCode = postalCode;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    @Override
    public String toString() {
        return "Store{" +
                "storeId=" + storeId +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
