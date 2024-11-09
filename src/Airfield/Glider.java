package Airfield;

public class Glider extends Aircraft{

    private double wingspan;


    public Glider(){}

    public Glider(Registration registration, String model,int numOfSeats, double wingspan) {
        super(registration, model, numOfSeats);
        this.wingspan = wingspan;
    }


    @Override
    public void fly() {
        System.out.println("Glider flying...");
    }
}
