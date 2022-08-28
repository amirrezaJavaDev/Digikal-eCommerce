package ir.amirreza.service;
//entitiy realtion database
import ir.amirreza.ProjectException.erorr.LoginFiledException;
import ir.amirreza.model.Product;
import ir.amirreza.model.dao.OrderDao;
import ir.amirreza.model.dao.PayDao;
import ir.amirreza.model.dao.ProductsDao;

import java.util.Scanner;

public class AdminManager {
    private Scanner  scn = new Scanner(System.in);
    private Product products;
    private ProductsDao productsDao;
    public static String username = "admin";
    public static String password = "admin";
    private  OrderDao orderDao;
    private  PayDao payDao;
    public AdminManager(ProductsDao productsDao, OrderDao orderDao, PayDao payDao) {
        this.productsDao = productsDao;
        this.orderDao = orderDao;
        this.payDao = payDao;
    }
    public void addProduct(Product product){
        this.productsDao.save(product);
        System.out.println("Product add Successful");
    }
}
