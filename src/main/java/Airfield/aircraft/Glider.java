package Airfield.aircraft;

public final class Glider extends Aircraft{

    private double wingspan;


    public Glider(){}

    @Override
    public void takeOff() {
        System.out.println(getModel() + " is taking off.");
    }

    @Override
    public void land() {
        System.out.println(getModel() + " is landing.");
    }

    public Glider(Registration registration, String model, int numOfSeats, double wingspan) {
        super(registration, model, numOfSeats);
        this.wingspan = wingspan;
    }


    @Override
    public void fly() {
        System.out.println("Glider flying...");
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }
}
