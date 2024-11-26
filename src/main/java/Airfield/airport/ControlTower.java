package Airfield.airport;

import Airfield.exceptions.RunwayNotAvailableException;

public class ControlTower {

    private String towerName;


    public ControlTower(){}
    public ControlTower(String towerName){
        this.towerName = towerName;
    }

    public void assignRunway(Runway runway) throws RunwayNotAvailableException {
        if(!runway.isOccupied()){
            runway.occupy();
            System.out.println("runway " + runway.getId() + " has been assigned succesfully.");
        }
        else{
            throw new RunwayNotAvailableException("Runway is not available");
        }
    }

    public void releaseRunway(Runway runway){
        if(runway.isOccupied()){
            runway.free();
            System.out.println("runway " + runway.getId() + " is now free.");
        }
        else{
            System.out.println("runway " + runway.getId() + " is already free.");
        }
    }
    public String getTowerName() {
        return towerName;
    }

    public void setTowerName(String towerName) {
        this.towerName = towerName;
    }
}
