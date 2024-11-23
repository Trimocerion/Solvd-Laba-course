package Airfield.flights;

import Airfield.aircraft.Aircraft;

import java.util.ArrayList;
import java.util.List;

public class Airline {
    private String name;
    private String code;
    private final List<Aircraft> aircraftList;

    public Airline(){
        this.aircraftList = new ArrayList<>();
    }

    public Airline(String name, String code){
        this.name = name;
        this.code = code;
        this.aircraftList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Aircraft> getAircraftList() {
        return aircraftList;
    }

    public void addAircraft(Aircraft aircraft) {
        aircraftList.add(aircraft);
    }

    public void removeAircraft(Aircraft aircraft) {
        aircraftList.remove(aircraft);
    }

}
