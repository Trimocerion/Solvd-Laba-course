package Airfield;

public class Helicopter extends Aircraft{

    private double rotorDiameter;




    public Helicopter(){}

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
}
