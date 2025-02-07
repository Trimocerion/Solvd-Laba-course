package supermarket.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.sql.Time;


@XmlRootElement(name = "purchase")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"purchase_id", "payment_Method_id", "customer_id", "checkout_id", "store_id", "user_id", "created_at"})
public class Purchase {

    @XmlElement(name = "purchase_id")
    @JsonProperty("purchase_id")
    private long purchaseId;
    @XmlElement(name = "payment_method_id")
    @JsonProperty("payment_method_id")
    private long paymentMethodId;
    @XmlElement(name = "customer_id")
    @JsonProperty("customer_id")
    private long customerId;
    @XmlElement(name = "checkout_id")
    @JsonProperty("checkout_id")
    private long checkoutId;
    @XmlElement(name = "store_id")
    @JsonProperty("store_id")
    private long storeId;
    @XmlElement(name = "user_id")
    @JsonProperty("user_id")
    private long userId;
    @XmlElement(name = "created_at")
    @JsonProperty("created_at")
    private Time createdAt;

    public Purchase() {
    }

    public Purchase(long paymentMethodId, long customerId, long checkoutId, long storeId, long userId, Time createdAt) {
        this.paymentMethodId = paymentMethodId;
        this.customerId = customerId;
        this.checkoutId = checkoutId;
        this.storeId = storeId;
        this.userId = userId;
        this.createdAt = createdAt;
    }



    public Purchase(long purchaseId, long paymentMethodId, long customerId, long checkoutId, long storeId, long userId, Time createdAt) {
        this.purchaseId = purchaseId;
        this.paymentMethodId = paymentMethodId;
        this.customerId = customerId;
        this.checkoutId = checkoutId;
        this.storeId = storeId;
        this.userId = userId;
        this.createdAt = createdAt;
    }


    public long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Time getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Time createdAt) {
        this.createdAt = createdAt;
    }
}
