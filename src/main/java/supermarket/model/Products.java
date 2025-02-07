package supermarket.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"product_id", "name", "description", "price", "quantity", "category_id"})
public class Products {

    @XmlElement(name = "product_id")
    @JsonProperty("product_id")
    private long productId;
    @XmlElement(name = "name")
    @JsonProperty("name")
    private String name;
    @XmlElement(name = "description")
    @JsonProperty("description")
    private String description;
    @XmlElement(name = "price")
    @JsonProperty("price")
    private double price;
    @XmlElement(name = "quantity")
    @JsonProperty("quantity")
    private int quantity;
    @XmlElement(name = "category_id")
    @JsonProperty("category_id")
    private long categoryId;

    public Products() {
    }

    public Products(String name, String description, double price, long categoryId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
    }


    public Products(long productId, String name, String description, double price, long categoryId) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;

    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
