package Airfield;

import java.util.ArrayList;
import java.util.List;

public class Hangar {
    private String hangarId;
    private int airplaneSlots;
    private int gliderSlots;
    private int helicopterSlots;
    private int hotAirBalloonSlots;
    private final List<Aircraft> aircraftList;



    public Hangar(){
        this.aircraftList = new ArrayList<>();
    }


    public Hangar(String hangarId, int airplaneSlots, int gliderSlots, int helicopterSlots, int hotAirBalloonSlots){
        this.hangarId=hangarId;
        this.airplaneSlots = airplaneSlots;
        this.gliderSlots = gliderSlots;
        this.helicopterSlots = helicopterSlots;
        this.hotAirBalloonSlots = hotAirBalloonSlots;
        this.aircraftList = new ArrayList<>();
    }

    public String getHangarId() {
        return hangarId;
    }

    public void setHangarId(String hangarId) {
        this.hangarId = hangarId;
    }

    public int getAirplaneSlots() {
        return airplaneSlots;
    }

    public void setAirplaneSlots(int airplaneSlots) {
        this.airplaneSlots = airplaneSlots;
    }

    public int getGliderSlots() {
        return gliderSlots;
    }

    public void setGliderSlots(int gliderSlots) {
        this.gliderSlots = gliderSlots;
    }

    public int getHelicopterSlots() {
        return helicopterSlots;
    }

    public void setHelicopterSlots(int helicopterSlots) {
        this.helicopterSlots = helicopterSlots;
    }

    public int getHotAirBalloonSlots() {
        return hotAirBalloonSlots;
    }

    public void setHotAirBalloonSlots(int hotAirBalloonSlots) {
        this.hotAirBalloonSlots = hotAirBalloonSlots;
    }
}
