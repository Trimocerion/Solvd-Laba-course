package supermarket.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.*;

import java.sql.Time;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"user_id", "username", "email", "password", "role_id", "store_id", "created_at"})
public class User {

    @XmlAttribute(name = "id")
    @JsonProperty("user_id")
    private long userId;
    @XmlAttribute(name = "username")
    @JsonProperty("username")
    private String username;
    @XmlAttribute(name = "email")
    @JsonProperty("email")
    private String email;
    @XmlAttribute(name = "password")
    @JsonProperty("password")
    private String password;
    @XmlAttribute(name = "role_id")
    @JsonProperty("role_id")
    private long roleId;
    @XmlAttribute(name = "store_id")
    @JsonProperty("store_id")
    private long storeId;
    @XmlElement(name = "created_at")
    @JsonProperty("created_at")
    private Time createdAt;


    public User() {
    }

    public User(String username, String email, String password, long roleId, long storeId) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.storeId = storeId;
    }

    public User(long userId, String username, String email, String password, long roleId, long storeId, Time createdAt) {
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

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", storeId=" + storeId +
                ", createdAt=" + createdAt +
                '}';
    }
}
