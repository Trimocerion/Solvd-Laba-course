package Airfield.person;

import java.util.Objects;

public class Employee extends Person {

    private String employeeId;
    private String name;
    private Role role;

    public Employee(){}

    public Employee(String employeeId, String name, Role role ){
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
    }


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Employee{id='" + employeeId + "', name='" + name + "', role='" + role + "'}";
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(employeeId);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return true;
        Employee e = (Employee) o;
        return Objects.equals(employeeId, e.employeeId) && Objects.equals(name, e.name);
    }

}
