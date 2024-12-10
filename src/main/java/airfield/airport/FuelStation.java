package airfield.airport;

public class FuelStation {

    private String stationId;
    private double fuelCapacity;
    private double currentFuelLevel;


    public FuelStation(){}

    public FuelStation(String stationId, double fuelCapacity){
        this.stationId=stationId;
        this.fuelCapacity=fuelCapacity;
        this.currentFuelLevel=0;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public void setCurrentFuelLevel(double currentFuelLevel) {
        this.currentFuelLevel = currentFuelLevel;
    }

    public void refuel(double amount) {
        if (amount <= currentFuelLevel) {
            currentFuelLevel -= amount;
            System.out.println("Refueled " + amount + " liters. Current fuel level: " + currentFuelLevel);
        } else {
            System.out.println("Not enough fuel available.");
        }
    }

    public void replenishFuel() {
        currentFuelLevel = fuelCapacity;
        System.out.println("Fuel station " + stationId + " refilled to full capacity.");
    }


}
