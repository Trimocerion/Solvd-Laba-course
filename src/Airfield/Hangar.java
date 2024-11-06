package Airfield;

public class Hangar {
    private String hangarId;
    private int capacity;
    private int currentAircraftCount;


    public Hangar(){}


    public Hangar(String hangarId, int capacity){
        this.hangarId=hangarId;
        this.capacity=capacity;
        this.currentAircraftCount=0;
    }

    public String getHangarId() {
        return hangarId;
    }

    public void setHangarId(String hangarId) {
        this.hangarId = hangarId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentAircraftCount() {
        return currentAircraftCount;
    }

    public void setCurrentAircraftCount(int currentAircraftCount) {
        this.currentAircraftCount = currentAircraftCount;
    }

    public boolean addAircraft() {
        if (currentAircraftCount < capacity) {
            currentAircraftCount++;
            System.out.println("Aircraft added to hangar " + hangarId);
            return true;
        } else {
            System.out.println("Hangar " + hangarId + " is full.");
            return false;
        }
    }

    public boolean removeAircraft() {
        if (currentAircraftCount > 0) {
            currentAircraftCount--;
            System.out.println("Aircraft removed from hangar " + hangarId);
            return true;
        } else {
            System.out.println("Hangar " + hangarId + " is empty.");
            return false;
        }
    }

}
