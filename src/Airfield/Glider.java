package Airfield;

public class Glider extends Aircraft{

    private double wingspan;


    public Glider(){}

    public Glider(String registration, String model,int capacity, double wingspan) {
        super(registration, model, capacity);
        this.wingspan = wingspan;
    }


    @Override
    public void fly() {
        System.out.println("Glider flying...");
    }

    @Override
    public void showInfo() {
        System.out.println("Glider Model: " + getModel() + ", Wingspan: " + wingspan + "m");
    }
}
