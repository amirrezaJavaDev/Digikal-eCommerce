package ir.amirreza.model.dao;

import ir.amirreza.model.Order;

public class OrderDao extends Dao<Order>{

    @Override
    protected String getFileName() {
        return "Order.data";
    }
}
