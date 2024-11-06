package Airfield;

public abstract class Aircraft {


    private String registration;
    private String model;
    private int capacity;


    public Aircraft(){};

    public Aircraft(String registration, String model, int capacity){
        this.registration = registration;
        this.model = model;
        this.capacity=capacity;
    }


    public abstract void fly();
    public abstract void showInfo();

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
