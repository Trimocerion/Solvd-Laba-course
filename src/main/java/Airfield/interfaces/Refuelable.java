package Airfield.interfaces;

import Airfield.airport.FuelStation;

public interface Refuelable {
    void refuel(FuelStation fuelStation);
    void refuel(FuelStation fuelStation, double amount);
}
