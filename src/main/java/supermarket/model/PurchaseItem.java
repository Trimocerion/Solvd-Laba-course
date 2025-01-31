package supermarket.model;

import java.math.BigDecimal;

public class PurchaseItem {

    private long purchaseId;
    private long productId;
    private int quantity;
    private BigDecimal priceAtPurchase;

    public PurchaseItem() {
    }


    public PurchaseItem(long purchaseId, long productId, int quantity, BigDecimal priceAtPurchase) {
        this.purchaseId = purchaseId;
        this.productId = productId;
        this.quantity = quantity;
        this.priceAtPurchase = priceAtPurchase;
    }

    public long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPriceAtPurchase() {
        return priceAtPurchase;
    }

    public void setPriceAtPurchase(BigDecimal priceAtPurchase) {
        this.priceAtPurchase = priceAtPurchase;
    }
}
