package ir.amirreza.model.dao;

import ir.amirreza.model.Category;

public class CategoryDao extends Dao<Category> {
    @Override
    protected String getFileName() {
        return "category.data";
    }
}
