package ir.amirreza.service;

import ir.amirreza.ProjectException.erorr.LoginFiledException;
import ir.amirreza.model.User;
import ir.amirreza.model.dao.OrderDao;
import ir.amirreza.model.dao.ProductsDao;
import ir.amirreza.model.dao.UserDao;
import java.util.Date;

public class UserManager {
    private UserDao userdao;
    private ProductsDao productsDao;
    private OrderDao orderDao;
    private IdGenerator<User> userIdGenerator;
    public UserManager(UserDao userDao,ProductsDao productsDao,OrderDao orderDao,IdGenerator<User> userIdGenerator){
        this.userdao = userDao;
        this.productsDao = productsDao;
        this.orderDao = orderDao;
        this.userIdGenerator = userIdGenerator;
    }
    public User login(String username, String password){
        return  userdao.getAll().stream()
                    .filter(u -> u.getUserName().equals(username)&& u.getUserPassword().equals(password))
                    .findFirst()
                    .orElseThrow(() -> new LoginFiledException());
    }
    public User register(String username,String email,String password){
        User user = new User(username,email,password,"https://amirreza.digikal.ir/avatar/defult.png");
        //userId generator
        user.setId(userIdGenerator.getNextId());
        //add user to Collection
       this.userdao.save(user);
        //  return user;
        return user;
    }
}
