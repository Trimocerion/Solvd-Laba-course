package Airfield;

public abstract class Aircraft {


    private Registration registration;
    private String model;
    private int numOfSeats;


    public Aircraft(){};

    public Aircraft(Registration registration, String model, int numOfSeats){
        this.registration = registration;
        this.model = model;
        this.numOfSeats = numOfSeats;
    }


    public abstract void fly();

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }
}
