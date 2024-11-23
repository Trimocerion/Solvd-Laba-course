package Airfield.aircraft;

import Airfield.interfaces.Refuelable;

public final class Helicopter extends Aircraft implements Refuelable {

    private double rotorDiameter;




    public Helicopter(){}


    @Override
    public void takeOff() {
        System.out.println(getModel() + " is taking off.");
    }

    @Override
    public void land() {
        System.out.println(getModel() + " is landing.");
    }

    public Helicopter(Registration registration, String model, int numOfSeats, double rotorDiameter){
        super(registration, model, numOfSeats);
        this.rotorDiameter = rotorDiameter;
    }

    @Override
    public void fly() {
        System.out.println("Helicopter flying");
    }


    public double getRotorDiameter() {
        return rotorDiameter;
    }

    public void setRotorDiameter(double rotorDiameter) {
        this.rotorDiameter = rotorDiameter;
    }

    @Override
    public void refuel() {
        System.out.println(getModel() + " is being refueled.");
    }
}
