package airfield.aircraft;

public final class Helicopter extends Aircraft {

    private double rotorDiameter;


    public Helicopter() {
    }


    @Override
    public void takeOff() {
        System.out.println(getModel() + " is taking off.");
    }

    @Override
    public void land() {
        System.out.println(getModel() + " is landing.");
    }

    public Helicopter(Registration registration, String model, String engineType, int numOfEngines, int maxFuelLevel, double rotorDiameter, AircraftType type) {
        super(registration, model, engineType, numOfEngines, maxFuelLevel, type);
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
