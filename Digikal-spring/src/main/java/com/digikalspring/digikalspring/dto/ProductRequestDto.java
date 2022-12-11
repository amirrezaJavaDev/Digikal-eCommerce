package com.digikalspring.digikalspring.dto;

import com.digikalspring.digikalspring.model.ProductCategory;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
@Data
@ToString
@Builder
public class ProductRequestDto {
    @JsonProperty("product_name")
    private String productName;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    @JsonProperty("product_desc")
    private String productDescription;
    @JsonProperty("product_image")
    private String productAvatar;
    private Long price;
    @JsonProperty("product_created_at")
    private Date productCreateAt;
}
