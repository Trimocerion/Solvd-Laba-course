package Airfield.aircraft;

import Airfield.airport.FuelStation;
import Airfield.interfaces.Flyable;
import Airfield.interfaces.Maintainable;
import Airfield.interfaces.Refuelable;
import Airfield.person.Employee;
import Airfield.person.Passenger;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public abstract class Aircraft implements Flyable, Maintainable, Refuelable {

    @Setter
    @Getter
    private Registration registration;
    @Setter
    private String model;
    @Getter
    @Setter
    private String engineType;
    @Getter
    @Setter
    private int numOfEngines;
    @Getter
    private double maxFuelLevel;
    @Getter
    @Setter
    private double currentFuelLevel;
    @Getter
    @Setter
    private List<Employee> crewMembers;
    @Getter
    @Setter
    private List<Passenger> passengerList;
    @Getter
    @Setter
    private String type;


    public Aircraft(){};

    public Aircraft(Registration registration, String model, String engineType, int numOfEngines, double maxFuelLevel, String type){
        this.registration = registration;
        this.model = model;
        this.engineType = engineType;
        this.numOfEngines = numOfEngines;
        this.maxFuelLevel = maxFuelLevel;
        this.currentFuelLevel = 0;
        crewMembers = new ArrayList<>();
        passengerList = new ArrayList<>();
        this.type = type;
    }

    public abstract void fly();
    @Override
    public abstract void takeOff();

    @Override
    public abstract void land();

    @Override
    public  void refuel(FuelStation fuelStation){
        performRefuel(fuelStation, maxFuelLevel - currentFuelLevel);
    }

    @Override
    public void refuel(FuelStation fuelStation, double amount) {
        performRefuel(fuelStation, amount);
    }

    private void performRefuel (FuelStation fuelStation, double amount){
        if (currentFuelLevel >= maxFuelLevel) {
            System.out.println("Tank is already full.");
            return;
        }

        if (amount <= 0) {
            System.out.println("Invalid fuel amount specified. Please enter a positive value.");
            return;
        }

        double fuelAvailable = fuelStation.getCurrentFuelLevel();
        double fuelNeeded = maxFuelLevel - currentFuelLevel;

        if (amount > fuelNeeded) {
            System.out.println("Amount > fuel needed. ");
            System.out.println("Fuel needed: " + fuelNeeded + " Max tank: " + maxFuelLevel);
            amount = 0;
        }

        if (amount > fuelAvailable) {
            System.out.println("Not enough fuel in the fuel station");
            System.out.println("Fuel available in station: " + fuelAvailable);
            amount = 0;
        }

        fuelStation.setCurrentFuelLevel(fuelAvailable - amount);
        currentFuelLevel += amount;

        System.out.println("Aircraft " + model + " refueled.");
        System.out.println("Fuel added: " + amount);
        System.out.println("Current fuel level: " + currentFuelLevel);
        System.out.println("Remaining fuel in station: " + fuelStation.getCurrentFuelLevel());
    }

    @Override
    public void performMaintenance() {
        System.out.println(model + " is undergoing maintenance.");
    }


}
