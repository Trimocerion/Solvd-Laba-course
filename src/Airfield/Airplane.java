package Airfield;

public class Airplane extends Aircraft {

    private Airline airline;

    public Airplane(){}

    public Airplane(String registration, String model, int capacity, Airline airline){
        super(registration, model, capacity);
        this.airline = airline;
    }


    @Override
    public void fly() {
        System.out.println("Airplane flying");
    }

    @Override
    public void showInfo() {
        System.out.println("Airplane: " + getModel() +", Airline: " + getAirline());
    }

    public String getAirline() {
        return airline.getName();
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
