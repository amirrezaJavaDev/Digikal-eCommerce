package com.digikalspring.digikalspring.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
@Builder
public class FeedProductDto {
    private Long   id;
    private String product_name;
    private String product_category;
    private String product_image;
    private Long   product_price;
    private Date   product_created_at;
}
