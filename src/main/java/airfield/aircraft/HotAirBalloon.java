package airfield.aircraft;

public final class HotAirBalloon extends Aircraft {

    private double envelopeVolume;
    private int burnerOutput;
    private double maxLiftCapacity;


    public HotAirBalloon() {
    }

    @Override
    public void takeOff() {
        System.out.println(getModel() + " is taking off.");
    }

    @Override
    public void land() {
        System.out.println(getModel() + " is landing.");
    }


    public HotAirBalloon(Registration registration, String model, String engineType, int numOfEngines, int maxFuelLevel, double envelopeVolume, int burnerOutput, double maxLiftCapacity, AircraftType type) {
        super(registration, model, engineType, numOfEngines, maxFuelLevel, type);
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
