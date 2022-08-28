package ir.amirreza.model;

import java.util.Date;
import java.util.Objects;

public class Payment implements Entity {
    private Long id;
    private Date paymentAt;
    private final PaymentStatus payStatus;
    private final User payByUser;

    public Payment(Date paymentAt, PaymentStatus payStatus, User payByUser) {
        this.paymentAt = paymentAt;
        this.payStatus = payStatus;
        this.payByUser = payByUser;
    }

    public Payment(Long id, Date paymentAt, PaymentStatus payStatus, User payByUser) {
        this.id = id;
        this.paymentAt = paymentAt;
        this.payStatus = payStatus;
        this.payByUser = payByUser;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPaymentAt() {
        return paymentAt;
    }

    public void setPaymentAt(Date paymentAt) {
        this.paymentAt = paymentAt;
    }

    public PaymentStatus getPayStatus() {
        return payStatus;
    }

    public User getPayByUser() {
        return payByUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payments = (Payment) o;
        return getPaymentAt().equals(payments.getPaymentAt()) && getPayStatus() == payments.getPayStatus() && getPayByUser().equals(payments.getPayByUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaymentAt(), getPayStatus(), getPayByUser());
    }
}
