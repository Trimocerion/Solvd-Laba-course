package Airfield;

import java.util.ArrayList;
import java.util.List;

public class Passenger {

    private String name;
    private String passportNumber;
    private List<Luggage> luggageList;

    public Passenger(){}

    public Passenger(String name, String passportNumber){
        this.name = name;
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
        System.out.println(name);
        for(Luggage x : luggageList){
            System.out.println(x.getId() + " " + x.getWeight());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
