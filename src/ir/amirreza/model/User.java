package ir.amirreza.model;

import java.util.Date;
import java.util.Objects;

public class User implements Entity {
    private Long id;
    private  String userName;
    private  String userEmail;
    private String userPassword;
    private String userAvatar;
    private Date createdAt_user;
    public User(Long id, String userName, String userEmail, String userPassword, Date createdAt_user) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.createdAt_user = createdAt_user;
    }

    public User(String userName, String userEmail, String userPassword, String defultAvatar) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userAvatar = defultAvatar;
        //this.createdAt_user = createdAt_user;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getCreatedAt_user() {
        return createdAt_user;
    }

    public void setCreatedAt_user(Date createdAt_user) {
        this.createdAt_user = createdAt_user;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + "********" + '\'' +
                ", createdAt_user=" + createdAt_user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User users = (User) o;
        return getUserName().equals(users.getUserName()) && getUserEmail().equals(users.getUserEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getUserEmail());
    }
}
