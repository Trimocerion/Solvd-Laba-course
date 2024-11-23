package Airfield.airport;

import java.util.List;

public class Terminal {
    private String name;

    private List<Gate> gates;

    public Terminal(){}

    public Terminal(String name, List<Gate>gates){
        this.name=name;
        this.gates = gates;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
