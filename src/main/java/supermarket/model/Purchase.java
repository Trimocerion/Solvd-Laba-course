package supermarket.model;

import java.sql.Time;

public class Purchase {

    private long purchaseId;
    private long paymentMethodId;
    private long customerId;
    private long checkoutId;
    private long storeId;
    private long userId;
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
