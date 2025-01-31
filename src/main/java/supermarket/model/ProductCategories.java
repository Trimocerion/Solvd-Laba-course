package supermarket.model;

public class ProductCategories {
    private long categoryId;
    private String name;
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
