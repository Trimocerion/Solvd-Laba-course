package supermarket.model;

public class Checkout {
    private long checkoutId;
    private long storeId;
    private boolean isActive;

    public Checkout() {
    }

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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
