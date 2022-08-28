package ir.amirreza.model;

import java.util.Date;
import java.util.Objects;

public class Product implements Entity {
    private Long id;
    private Date productCreateAt;
    private String productName;
    private String productAvatar;
    private Category category;
    private long price;
    private String productDescription;

    public Product(String productName, String productAvatar, String productDescription, String category,long price) {
        //add time milis to this.productAt = productAt;
        this.productName = productName;
        this.productAvatar = productAvatar;
        this.productDescription = productDescription;
        this.category =  new Category(category);
        this.price = price;
    }

    public Product(Long id, Date productAt, String productName, String productAvatar, String productDescription, String category,long price) {
        this.id = id;
        this.productCreateAt = productAt;
        this.productName = productName;
        this.productAvatar = productAvatar;
        this.productDescription = productDescription;
        this.category =  new Category(category);
        this.price = price;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getProductAt() {
        return productCreateAt;
    }

    public void setProductAt(Date productAt) {
        this.productCreateAt = productAt;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductAvatar() {
        return productAvatar;
    }

    public void setProductAvatar(String productAvatar) {
        this.productAvatar = productAvatar;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Date getProductCreateAt() {
        return productCreateAt;
    }

    public void setProductCreateAt(Date productCreateAt) {
        this.productCreateAt = productCreateAt;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", productAt=" + productCreateAt +
                ", productName='" + productName + '\'' +
                ", productAvatar='" + productAvatar + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product products = (Product) o;
        return getProductName().equals(products.getProductName()) && getProductAvatar().equals(products.getProductAvatar()) && getProductDescription().equals(products.getProductDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProductAt(), getProductName(), getProductAvatar(), getProductDescription());
    }
}
