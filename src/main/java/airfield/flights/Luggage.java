package airfield.flights;

import airfield.person.Passenger;

public class Luggage {
    private String id;
    private double weight;
    private Passenger owner;

    public Luggage(){}

    public Luggage(String id, double weight, Passenger owner){
        this.id = id;
        this.weight = weight;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Luggage{" +
                "id='" + id + '\'' +
                ", weight=" + weight +
                '}';
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Passenger getOwner() {
        return owner;
    }

    public void setOwner(Passenger owner) {
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
