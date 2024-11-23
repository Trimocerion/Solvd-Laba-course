package Airfield.aircraft;

import Airfield.interfaces.Flyable;
import Airfield.interfaces.Maintainable;

public abstract class Aircraft implements Flyable, Maintainable {


    private Registration registration;
    private String model;
    private int numOfSeats;

    public Aircraft(){};

    public Aircraft(Registration registration, String model, int numOfSeats){
        this.registration = registration;
        this.model = model;
        this.numOfSeats = numOfSeats;
    }

    @Override
    public abstract void takeOff();

    @Override
    public abstract void land();

    @Override
    public void performMaintenance() {
        System.out.println(model + " is undergoing maintenance.");
    }



    public abstract void fly();

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }
}
