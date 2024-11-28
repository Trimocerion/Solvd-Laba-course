package Airfield.airport;

import Airfield.aircraft.Aircraft;
import Airfield.exceptions.HangarFullException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hangar {
    private String hangarId;
    private final Map<String, Integer> aircraftSlots;
    private final List<Aircraft> aircraftList;



    public Hangar(){
        this.aircraftSlots = new HashMap<>();
        this.aircraftList = new ArrayList<>();
    }


    public Hangar(String hangarId, Map<String, Integer> aircraftSlots){
        this.hangarId=hangarId;
        this.aircraftSlots = aircraftSlots;
        this.aircraftList = new ArrayList<>();
    }

    public String getHangarId() {
        return hangarId;
    }

    public void setHangarId(String hangarId) {
        this.hangarId = hangarId;
    }


    public Map<String, Integer> getAircraftSlots() {
        return aircraftSlots;
    }

    public List<Aircraft> getAircraftList() {
        return aircraftList;
    }

    public void addAircraftSlots(String aircraftType, int slots){
        this.aircraftSlots.put(aircraftType,slots);
    }

    public int getSlotsForAircraftType(String aircraftType){
        return aircraftSlots.getOrDefault(aircraftType, 0);
    }

    public void addAircraft(Aircraft aircraft) {
        String aircraftType = aircraft.getType();

        if (aircraftSlots.containsKey(aircraftType)) {
            int availableSlots = aircraftSlots.get(aircraftType);
            if (availableSlots > 0) {
                aircraftList.add(aircraft);
                aircraftSlots.put(aircraftType, availableSlots - 1);
                System.out.println("Aircraft of type " + aircraft.getType() + " added: " + aircraft.getRegistration() + ". Available slots: " + (availableSlots - 1));
            }
            else {
                throw new HangarFullException("No more available slots ");
            }
        }
        System.out.println("No slots defined for aircraft type: " + aircraftType);
    }



}
