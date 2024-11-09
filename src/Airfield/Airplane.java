package Airfield;

import java.util.Objects;

public class Airplane extends Aircraft {

    private String engineType;
    private int numOfEngines;
    private double currentFuelLevel;

    public Airplane(){}

    public Airplane(Registration registration, String model, int numOfSeats, String engineType, int numOfEngines){
        super(registration, model, numOfSeats);
        this.engineType = engineType;
        this.numOfEngines = numOfEngines;
        this.currentFuelLevel = 0;
    }


    @Override
    public void fly() {
        System.out.println("Airplane flying");
    }


    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getNumOfEngines() {
        return numOfEngines;
    }

    public void setNumOfEngines(int numOfEngines) {
        this.numOfEngines = numOfEngines;
    }

    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public void setCurrentFuelLevel(double currentFuelLevel) {
        this.currentFuelLevel = currentFuelLevel;
    }


    @Override
    public String toString() {
        return "Airplane{" +
                "engineType='" + engineType + '\'' +
                ", numOfEngines=" + numOfEngines +
                ", currentFuelLevel=" + currentFuelLevel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return numOfEngines == airplane.numOfEngines && Double.compare(currentFuelLevel, airplane.currentFuelLevel) == 0 && Objects.equals(engineType, airplane.engineType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engineType, numOfEngines, currentFuelLevel);
    }
}
