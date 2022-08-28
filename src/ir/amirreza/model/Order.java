package ir.amirreza.model;

import java.util.Date;
import java.util.Objects;

public class Order implements Entity {
    private long id;
    private Date orderCreateAt;
    private String bio;
    private final OrdersStatus status;
    private final User ordener;

    public Order(Date orderAt, String orderAvatar, String bio, OrdersStatus status, User ordener) {
        this.orderCreateAt = orderAt;
        this.bio = bio;
        this.status = status;
        this.ordener = ordener;
    }

    public Order(long id, Date orderAt, String orderAvatar, String bio, OrdersStatus status, User ordener) {
        this.id = id;
        this.orderCreateAt = orderAt;
        this.bio = bio;
        this.status = status;
        this.ordener = ordener;
    }

    @Override
    public Long getId(){return id;}
    public void setId(long id) {
        this.id = id;
    }

    public Date getOrderCreateAt() {
        return orderCreateAt;
    }

    public void setOrderCreateAt(Date orderCreateAt) {
        this.orderCreateAt = orderCreateAt;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public OrdersStatus getStatus() {
        return status;
    }

    public User getOrdener() {
        return ordener;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderAt=" + orderCreateAt +'\'' +
                ", bio='" + bio + '\'' +
                ", status=" + status +
                ", ordener=" + ordener +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order orders = (Order) o;
        return getOrdener().equals(orders.getOrdener());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrdener());
    }
}
