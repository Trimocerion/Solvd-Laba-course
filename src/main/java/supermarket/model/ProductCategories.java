package supermarket.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product_categories")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"categoryId", "name", "description"})
public class ProductCategories {
    @XmlElement(name = "category_id")
    @JsonProperty("category_id")
    private long categoryId;
    @XmlElement(name = "name")
    @JsonProperty("name")
    private String name;
    @XmlElement(name = "description")
    @JsonProperty("description")
    private String description;

    public ProductCategories() {
    }

    public ProductCategories(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ProductCategories(long categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
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
}
