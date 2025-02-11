package supermarket.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "checkout")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"checkout_id", "store_id", "is_active"})
public class Checkout {

    @XmlElement(name = "checkout_id")
    @JsonProperty("checkout_id")
    private long checkoutId;

    @XmlElement(name = "store_id")
    @JsonProperty("store_id")
    private long storeId;

    @XmlElement(name = "is_active")
    @JsonProperty("is_active")
    private boolean isActive;

    public Checkout() {}

    public Checkout(long storeId, boolean isActive) {
        this.storeId = storeId;
        this.isActive = isActive;
    }

    public Checkout(long checkoutId, long storeId, boolean isActive) {
        this.checkoutId = checkoutId;
        this.storeId = storeId;
        this.isActive = isActive;
    }

    public long getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(long checkoutId) {
        this.checkoutId = checkoutId;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        this.isActive = active;
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "checkoutId=" + checkoutId +
                ", storeId=" + storeId +
                ", isActive=" + isActive +
                '}';
    }
}
