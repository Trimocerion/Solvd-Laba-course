package Airfield;

public class HotAirBalloon extends  Aircraft{

    private double envelopeVolume;
    private int burnerOutput;
    private double maxLiftCapacity;



    public HotAirBalloon(){}


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
}
