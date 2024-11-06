package Airfield;

public class HotAirBalloon extends  Aircraft{
    private int maxAltitude;

    public HotAirBalloon(){}


    public HotAirBalloon(String registration, String model, int capacity, int maxAltitude) {
        super(registration, model, capacity);
        this.maxAltitude = maxAltitude;
    }

    @Override
    public void fly() {
        System.out.println("Hot air balloon flying...");
    }

    @Override
    public void showInfo() {
        System.out.println("Hot Air Balloon Model: " + getModel() + ", Max Altitude: " + maxAltitude + " feet");
    }









}
