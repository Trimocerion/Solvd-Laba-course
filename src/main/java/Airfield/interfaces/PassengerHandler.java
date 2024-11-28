package Airfield.interfaces;

import Airfield.person.Passenger;

import java.util.List;

public interface PassengerHandler {
    void boardPassenger(Passenger passenger);
    void boardPassengers(List<Passenger> passengerList);
    void deboardPassenger(Passenger passenger);
    void deboardPassengers();
}
