package airfield.airport;

import airfield.aircraft.Aircraft;
import airfield.aircraft.AircraftType;
import airfield.exceptions.HangarFullException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hangar {
    private String hangarId;
    private final Map<AircraftType, Integer> aircraftSlots;
    private final List<Aircraft> aircraftList;



    public Hangar(){
        this.aircraftSlots = new HashMap<>();
        this.aircraftList = new ArrayList<>();
    }


    public Hangar(String hangarId, Map<AircraftType, Integer> aircraftSlots){
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


    public Map<AircraftType, Integer> getAircraftSlots() {
        return aircraftSlots;
    }

    public List<Aircraft> getAircraftList() {
        return aircraftList;
    }

    public void addAircraftSlots(AircraftType aircraftType, int slots){
        this.aircraftSlots.put(aircraftType,slots);
    }

    public int getSlotsForAircraftType(AircraftType aircraftType){
        return aircraftSlots.getOrDefault(aircraftType, 0);
    }

    public void addAircraft(Aircraft aircraft) {
        AircraftType aircraftType = aircraft.getType();

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
    }



}
