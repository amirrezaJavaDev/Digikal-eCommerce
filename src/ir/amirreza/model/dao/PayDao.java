package ir.amirreza.model.dao;

import ir.amirreza.model.Payment;

public class PayDao extends Dao<Payment>{
    @Override
    protected String getFileName() {
        return "Pay.data";
    }
}
