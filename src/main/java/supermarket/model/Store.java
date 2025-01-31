package supermarket.model;

public class Store {

    private long storeId;
    private String address;
    private String postalCode;

    public Store() {
    }

    public Store(String name, String address, String postalCode) {
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
}
