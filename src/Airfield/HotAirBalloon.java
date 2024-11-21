package Airfield;

public class HotAirBalloon extends  Aircraft implements Refuelable{

    private double envelopeVolume;
    private int burnerOutput;
    private double maxLiftCapacity;



    public HotAirBalloon(){}

    @Override
    public void takeOff() {
        System.out.println(getModel() + " is taking off.");
    }

    @Override
    public void land() {
        System.out.println(getModel() + " is landing.");
    }


    public HotAirBalloon(Registration registration, String model, int numOfSeats, double envelopeVolume, int burnerOutput, double maxLiftCapacity) {
        super(registration, model,numOfSeats);
        this.envelopeVolume = envelopeVolume;
        this.burnerOutput = burnerOutput;
        this.maxLiftCapacity = maxLiftCapacity;
    }

    @Override
    public void fly() {
        System.out.println("Hot air balloon flying...");
    }



    public int getBurnerOutput() {
        return burnerOutput;
    }

    public void setBurnerOutput(int burnerOutput) {
        this.burnerOutput = burnerOutput;
    }

    public double getEnvelopeVolume() {
        return envelopeVolume;
    }

    public void setEnvelopeVolume(double envelopeVolume) {
        this.envelopeVolume = envelopeVolume;
    }

    public double getMaxLiftCapacity() {
        return maxLiftCapacity;
    }

    public void setMaxLiftCapacity(double maxLiftCapacity) {
        this.maxLiftCapacity = maxLiftCapacity;
    }

    @Override
    public void refuel() {

    }
}
