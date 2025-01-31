package supermarket.model;

public class Roles {
    private long roleId;
    private String name;
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
