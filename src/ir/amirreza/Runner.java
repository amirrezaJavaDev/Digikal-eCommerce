package ir.amirreza;

import ir.amirreza.ProjectException.DigikalException;
import ir.amirreza.ProjectException.erorr.LoginFiledException;
import ir.amirreza.model.Product;
import ir.amirreza.model.User;
import ir.amirreza.model.dao.OrderDao;
import ir.amirreza.model.dao.PayDao;
import ir.amirreza.model.dao.ProductsDao;
import ir.amirreza.model.dao.UserDao;
import ir.amirreza.service.AdminManager;
import ir.amirreza.service.IdGenerator;
import ir.amirreza.service.UserManager;

import java.util.Scanner;

public class Runner {
    private static User user = null;
    private static Scanner scan;
    private static UserManager userManager;
    private static AdminManager adminManager;
    public static void main(String[] args) {
        // add all extend Dao
        OrderDao orderDao = new OrderDao();
        PayDao payDao = new PayDao();
        ProductsDao productsDao = new ProductsDao();
        UserDao  userDao = new UserDao();
        IdGenerator<User> userIdGenerator = new IdGenerator<>(userDao);
        // add all service Managers

        userManager = new UserManager(userDao,productsDao,orderDao,userIdGenerator);
        adminManager = new AdminManager(productsDao,orderDao,payDao);
        scan = new Scanner(System.in);
        //show Menu with do-while
      do{
        try {
            showMenu();
            int choose = scan.nextInt();
            if(choose == 1){
                login();
            }else if(choose == 2) {
                register();
            } else if ( choose == 9) {
               loginAdmin();

               break;}

            showFeeduser();
        } catch (DigikalException e ) {
            System.out.println(e.getErorrType().getMessageFa());
            break;
        }
      }while (true);
    System.out.println("See you soon");
    }
    public static void showMenu(){
        System.out.println("======== Welcome to  Digikala ========");
        System.out.print("1)Login Page\n2)Register Page\n3)Exit\n *Please  Enter 1 to 3 number:>>>");
    }
    public static void login() throws LoginFiledException {
        System.out.println("نام کاربری خود را وارد کنید:");
        String username = scan.next();
        System.out.println("رمز عبور خود را وارد کنید");
        String password = scan.next();
        // take user detail
        user = userManager.login(username,password);
    }
    public static void register(){
        System.out.println("نام کاربری خود را وارد کنید");
        String username = scan.next();
        System.out.println("ایمیل خود را وارد کنید");
        String email = scan.next();
        System.out.println("رمز عبور خود را وارد کنید");
        String password = scan.next();
        // take user detail after registering info
        user = userManager.register(username,email,password);
    }
    public static void showFeeduser(){
        System.out.println("======== منو محصولات ========"+"\t"+user.getUserName()+"کاربر");

    }
    public static void loginAdmin(){
        System.out.println("نام کاربری خود را وارد کنید:");
        String usernme = scan.next();
        System.out.println("رمز عبور خود را وارد کنید");
        String passwrd = scan.next();
        if(usernme.equals(adminManager.username) && passwrd.equals(adminManager.password)){
            adminMenuPanel();
        }else{
            throw  new LoginFiledException();
        }
    }
    private static void adminMenuPanel(){
        System.out.println("ADMIN panel (Welcome)\n1)add product\n2)delete product\n3)exit");
        int ch = scan.nextInt();
        boolean con = true;
        do {
            if(ch == 1){
                addProduct();
            } else if (ch == 2) {
                System.out.println("delete product soon...");
            } else if (ch == 3) {con = false;break;}
            adminMenuPanel();
        }while (con);
    }
    private static void addProduct(){

        System.out.println("Enter Product Name:");
        String pname= scan.next();
        String avatarProduct = "https://amirreza.digikal.ir/avatar/defultp.png";
        System.out.println("Enter Discripton product:");
        String dis = scan.nextLine();scan.nextLine();
        System.out.println("Enter Category list:");
        String category = scan.nextLine();scan.nextLine();
        System.out.println("Enter price:");
        Long price = scan.nextLong();
        Product products = new Product(pname,avatarProduct,dis,category,price);
        adminManager.addProduct(products);
    }
    private static void deleteProduct(){

    }

}
