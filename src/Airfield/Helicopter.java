package Airfield;

public class Helicopter extends Aircraft{

    private double rotorDiameter;




    public Helicopter(){}

    public Helicopter(String registration, String model, int seats, double rotorDiameter){
        super(registration, model, seats);
        this.rotorDiameter = rotorDiameter;
    }

    @Override
    public void fly() {
        System.out.println("Helicopter flying");
    }

    @Override
    public void showInfo() {

    }

    public double getRotorDiameter() {
        return rotorDiameter;
    }

    public void setRotorDiameter(double rotorDiameter) {
        this.rotorDiameter = rotorDiameter;
    }
}
