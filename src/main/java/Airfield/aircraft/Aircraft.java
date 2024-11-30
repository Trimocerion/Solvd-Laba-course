package Airfield.aircraft;

import Airfield.airport.FuelStation;
import Airfield.interfaces.Flyable;
import Airfield.interfaces.Maintainable;
import Airfield.interfaces.Refuelable;
import Airfield.person.Employee;
import Airfield.person.Passenger;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Aircraft implements Flyable, Maintainable, Refuelable {

    private Registration registration;
    private String model;
    private String engineType;
    private int numOfEngines;
    private double maxFuelLevel;
    private double currentFuelLevel;
    private List<Employee> crewMembers;
    private List<Passenger> passengerList;
    private String type;


    public Aircraft(){}

    public Aircraft(Registration registration, String model, String engineType, int numOfEngines, double maxFuelLevel){
        this.registration = registration;
        this.model = model;
        this.engineType = engineType;
        this.numOfEngines = numOfEngines;
        this.maxFuelLevel = maxFuelLevel;
        this.currentFuelLevel = 0;
        crewMembers = new ArrayList<>();
        passengerList = new ArrayList<>();
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
