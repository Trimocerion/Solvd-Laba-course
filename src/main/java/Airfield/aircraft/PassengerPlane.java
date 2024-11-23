package Airfield.aircraft;

import Airfield.interfaces.PassengerHandler;
import Airfield.interfaces.Refuelable;

import java.util.Objects;

public final class PassengerPlane extends Aircraft implements Refuelable, PassengerHandler {

    private String engineType;
    private int numOfEngines;
    private double currentFuelLevel;

    public PassengerPlane(){}

    @Override
    public void takeOff() {
        System.out.println(getModel() + " is taking off.");
    }

    public PassengerPlane(Registration registration, String model, int numOfSeats, String engineType, int numOfEngines){
        super(registration, model, numOfSeats);
        this.engineType = engineType;
        this.numOfEngines = numOfEngines;
        this.currentFuelLevel = 0;
    }


    @Override
    public void fly() {
        System.out.println("Airplane flying");
    }


    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getNumOfEngines() {
        return numOfEngines;
    }

    public void setNumOfEngines(int numOfEngines) {
        this.numOfEngines = numOfEngines;
    }

    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public void setCurrentFuelLevel(double currentFuelLevel) {
        this.currentFuelLevel = currentFuelLevel;
    }


    @Override
    public String toString() {
        return "Airplane{" +
                "engineType='" + engineType + '\'' +
                ", numOfEngines=" + numOfEngines +
                ", currentFuelLevel=" + currentFuelLevel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerPlane passengerPlane = (PassengerPlane) o;
        return numOfEngines == passengerPlane.numOfEngines && Double.compare(currentFuelLevel, passengerPlane.currentFuelLevel) == 0 && Objects.equals(engineType, passengerPlane.engineType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engineType, numOfEngines, currentFuelLevel);
    }


    @Override
    public void land() {
        System.out.println("Passenger plane " + getModel() + " is landing.");
    }

    @Override
    public void performMaintenance() {
        System.out.println(" Maintenance of " + getModel() + "Passenger plane ");

    }

    @Override
    public void refuel() {
        System.out.println("Passenger plane " + getModel() + " is being refueled.");
    }

    @Override
    public void boardPassengers() {
        System.out.println(getModel() + " is boarding passengers.");
    }

    @Override
    public void deboardPassengers() {
        System.out.println(getModel() + " is deboarding passengers.");
    }
}
