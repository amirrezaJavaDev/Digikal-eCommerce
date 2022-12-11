package com.digikalspring.digikalspring.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_product")
@ToString
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "category")
    private ProductCategory category;
    @Column(name = "description")
    private String productDescription;
    @Column(name = "product_avatar")
    private String productAvatar;
    @Column(name = "product_price")
    private Long price;
    @Column(name = "created_at")
    private Date productCreateAt;

    public Product(String productName, ProductCategory category, String productDescription, String productAvatar, Long price, Date productCreateAt) {
        this.productName = productName;
        this.category = category;
        this.productDescription = productDescription;
        this.productAvatar = productAvatar;
        this.price = price;
        this.productCreateAt = productCreateAt;
    }
}
