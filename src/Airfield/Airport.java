package Airfield;

import java.util.List;

public class Airport {


    private String name;
    private String location;
    private List<Terminal> terminals;


    public Airport(String name, String location, List<Terminal>terminals){
        this.name = name;
        this.location=location;
        this.terminals = terminals;
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
}
