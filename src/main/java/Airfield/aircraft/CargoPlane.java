package Airfield.aircraft;

import Airfield.interfaces.CargoHandler;


public class CargoPlane extends Aircraft implements CargoHandler {

    private double maxCargoCapacity;
    private double currentCargoWeight;


    public CargoPlane() {
    }

    public CargoPlane(Registration registration, String model, String engineType, int numOfEngines, int maxFuelLevel, double maxCargoCapacity) {
        super(registration, model, engineType, numOfEngines, maxFuelLevel);
        this.maxCargoCapacity = maxCargoCapacity;
        setType("aircraft");
        currentCargoWeight = 0;
    }


    @Override
    public void takeOff() {
        System.out.println("Plane taking off.");
    }

    @Override
    public void land() {
        System.out.println("Plane landing.");
    }

    @Override
    public void fly() {
        System.out.println("Plane flying");
    }

    @Override
    public void loadCargo(double weight) {

        if (maxCargoCapacity <= currentCargoWeight) {
            System.out.println("Cargo already full");
        } else {
            currentCargoWeight += weight;
            System.out.println("Cargo added with weight of " + weight);
            System.out.println("Max cargo capacity: " + maxCargoCapacity);
        }
    }

    @Override
    public void unloadCargo() {
        currentCargoWeight = 0;
        System.out.println("Cargo unloaded.");

    }

    @Override
    public void unloadCargo(double weight) {
        currentCargoWeight -= weight;
        System.out.println("Unloaded cargo with weight of " + weight);
    }


    public double getMaxCargoCapacity() {
        return maxCargoCapacity;
    }


    public void setCurrentCargoWeight(double currentCargoWeight) {
        this.currentCargoWeight = currentCargoWeight;
    }
}
