package ir.amirreza.model.dao;

import ir.amirreza.model.User;

public class UserDao extends Dao<User>{
    @Override
    protected String getFileName() {
        return "User.data";
    }
}
