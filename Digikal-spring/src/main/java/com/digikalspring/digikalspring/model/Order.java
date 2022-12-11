package com.digikalspring.digikalspring.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "tbl_order")
@ToString
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_address")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_user_id")
    private User customer;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "order_detail")
    private String moreDetail;

    @Column(name = "order_created_at")
    private Date orderCreatedAt;


}
