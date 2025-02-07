package supermarket.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;


@XmlRootElement(name = "purchase_item")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"purchase_id", "product_id", "quantity", "price_at_Purchase"})
public class PurchaseItem {

    @XmlElement(name = "purchase_id")
    @JsonProperty("purchase_id")
    private long purchaseId;
    @XmlElement(name = "product_id")
    @JsonProperty("product_id")
    private long productId;
    @XmlElement(name = "quantity")
    @JsonProperty("quantity")
    private int quantity;
    @XmlElement(name = "price_at_purchase")
    @JsonProperty("price_at_purchase")
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
