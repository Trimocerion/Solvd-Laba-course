package Airfield.person;

import Airfield.flights.Luggage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Passenger extends Person {

    private String passportNumber;
    private List<Luggage> luggageList;

    public Passenger(){}

    public Passenger(String name, Date birthDate, String passportNumber){
        super(name,birthDate);
        this.passportNumber = passportNumber;
        this.luggageList = new ArrayList<>();
    }

    public void addLuggage(String luggageId, double weight){
        Luggage luggage = new Luggage(luggageId,weight,this);
        luggageList.add(luggage);
    }

    public List<Luggage> getLuggageList(){
        return luggageList;
    }

    public void listLuggage(){
        System.out.println(getName());
        for(Luggage x : luggageList){
            System.out.println(x.getId() + " " + x.getWeight());
        }
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
