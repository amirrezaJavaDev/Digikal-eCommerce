package ir.amirreza.model.dao;

import ir.amirreza.model.Product;

public class ProductsDao extends Dao<Product>{
    @Override
    protected String getFileName() {
        return "Product.data";
    }
}
