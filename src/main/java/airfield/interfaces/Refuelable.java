package airfield.interfaces;

import airfield.airport.FuelStation;

public interface Refuelable {
    void refuel(FuelStation fuelStation);
    void refuel(FuelStation fuelStation, double amount);
}
