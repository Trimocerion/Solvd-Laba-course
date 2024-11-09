package Airfield;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Airport {


    private String name;
    private String location;
    private List<Terminal> terminals;
    private List<Employee> employees;


    public Airport(){}


    public Airport(String name, String location, List<Terminal>terminals){
        this.name = name;
        this.location=location;
        this.terminals = terminals;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Terminal> getTerminals() {
        return terminals;
    }

    public void setTerminals(List<Terminal> terminals) {
        this.terminals = terminals;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(name, airport.name) && Objects.equals(location, airport.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", terminals=" + terminals +
                ", employees=" + employees +
                '}';
    }
}
