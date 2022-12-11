package com.digikalspring.digikalspring.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@Table(name = "tbl_payment")
@ToString
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_at")
    private Date paymentAt;

    @Enumerated(EnumType.STRING)
    private PaymentStatus payStatus;

    @OneToOne
    @JoinColumn(name = "user_payment_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
