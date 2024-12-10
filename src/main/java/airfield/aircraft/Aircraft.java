package airfield.aircraft;

import airfield.airport.FuelStation;
import airfield.interfaces.Flyable;
import airfield.interfaces.Maintainable;
import airfield.interfaces.Refuelable;
import airfield.person.Employee;
import airfield.person.Passenger;
import java.util.ArrayList;
import java.util.List;

public abstract class Aircraft implements Flyable, Maintainable, Refuelable {

    private Registration registration;
    private String model;
    private String engineType;
    private int numOfEngines;
    private double maxFuelLevel;
    private double currentFuelLevel;
    private List<Employee> crewMembers;
    private List<Passenger> passengerList;
    private AircraftType type;


    public Aircraft(){}

    public Aircraft(Registration registration, String model, String engineType, int numOfEngines, double maxFuelLevel, AircraftType type){
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


    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
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

    public List<Employee> getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(List<Employee> crewMembers) {
        this.crewMembers = crewMembers;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public void addPassenger(Passenger passenger){
        passengerList.add(passenger);
    }

    public void displayPassengers(){
        passengerList.forEach(System.out::println);
    }

    public AircraftType getType() {
        return type;
    }

    public void setType(AircraftType type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCurrentFuelLevel(){
        return currentFuelLevel;
    }

    public void setCurrentFuelLevel(double currentFuelLevel){
        this.currentFuelLevel = currentFuelLevel;
    }

}
