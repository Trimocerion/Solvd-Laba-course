package supermarket.model;

import java.sql.Time;

public class Users {

    private long userId;
    private String username;
    private String email;
    private String password;
    private long roleId;
    private long storeId;
    private Time createdAt;


    public Users() {
    }

    public Users(String username, String email, String password, long roleId, long storeId) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.storeId = storeId;
    }

    public Users(long userId, String username, String email, String password, long roleId, long storeId, Time createdAt) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.storeId = storeId;
        this.createdAt = createdAt;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public Time getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Time createdAt) {
        this.createdAt = createdAt;
    }
}
