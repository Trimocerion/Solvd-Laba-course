package supermarket.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "roles")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"role_id", "name", "description"})
public class Roles {

    @XmlElement(name = "role_id")
    @JsonProperty("role_id")
    private long roleId;
    @XmlElement(name = "name")
    @JsonProperty("name")
    private String name;
    @XmlElement(name = "description")
    @JsonProperty("description")
    private String description;

    public Roles() {
    }

    public Roles(String roleName, String description) {
        this.name = roleName;
        this.description = description;
    }

    public Roles(long roleId, String roleName, String description) {
        this.roleId = roleId;
        this.name = roleName;
        this.description = description;
    }



    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
