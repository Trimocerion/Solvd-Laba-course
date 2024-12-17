package airfield.aircraft;

import airfield.exceptions.PassengerExceededException;
import airfield.interfaces.PassengerHandler;
import airfield.person.Passenger;

import java.util.List;
import java.util.Objects;

public final class PassengerPlane extends Aircraft implements PassengerHandler {


    private boolean hasWifi;
    private int maxPassengers;


    public PassengerPlane() {
    }

    @Override
    public void takeOff() {
        System.out.println(getModel() + " is taking off.");
    }

    public PassengerPlane(Registration registration, String model, String engineType, int numOfEngines, int maxFuelLevel, int maxPassengers, boolean hasWifi, AircraftType type) {
        super(registration, model, engineType, numOfEngines, maxFuelLevel, type);
        this.maxPassengers = maxPassengers;
        this.hasWifi = hasWifi;
    }


    @Override
    public void fly() {
        System.out.println("Airplane flying");
    }


    @Override
    public String toString() {
        return "PassengerPlane{" +
                "model='" + getModel() + '\'' +
                ", registration=" + getRegistration() +
                ", type=" + getType() +
                ", hasWifi=" + hasWifi +
                ", maxPassengers=" + maxPassengers +
                ", engineType='" + getEngineType() + '\'' +
                ", numOfEngines=" + getNumOfEngines() +
                ", currentFuelLevel=" + getCurrentFuelLevel() +
                ", maxFuelLevel=" + getMaxFuelLevel() +
                ", passengers=" + getPassengerList() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerPlane passengerPlane = (PassengerPlane) o;
        return getNumOfEngines() == passengerPlane.getNumOfEngines() && Double.compare(getCurrentFuelLevel(), passengerPlane.getCurrentFuelLevel()) == 0 && Objects.equals(getEngineType(), passengerPlane.getEngineType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEngineType(), getNumOfEngines(), getCurrentFuelLevel());
    }


    @Override
    public void land() {
        System.out.println("Passenger plane " + getModel() + " is landing.");
    }

    @Override
    public void performMaintenance() {
        System.out.println(" Maintenance of " + getModel() + "Passenger plane ");

    }


    @Override
    public void boardPassenger(Passenger passenger) {

        List<Passenger> passengerListAircraft = getPassengerList();

        if (passengerListAircraft.size() >= maxPassengers) {
            throw new PassengerExceededException("Exceeded the number of passengers");
        } else {
            passengerListAircraft.add(passenger);
            System.out.println("Passenger added");
        }
    }

    @Override
    public void boardPassengers(List<Passenger> passengerList) {

        List<Passenger> passengerListAircraft = getPassengerList();

        if (passengerList.size() >= maxPassengers) {
            throw new PassengerExceededException("Exceeded the number of passengers.");
        } else {
            passengerListAircraft.addAll(passengerList);
            System.out.println("Passenger list added");
        }

    }

    @Override
    public void deboardPassenger(Passenger passenger) {

        List<Passenger> passengerListAircraft = getPassengerList();

        if (passenger == null) throw new IllegalArgumentException("Passenger null");

        passengerListAircraft.remove(passenger);
        System.out.println("removed passenger from the airplane.");

    }

    @Override
    public void deboardPassengers() {
        List<Passenger> passengerListAircraft = getPassengerList();

        if (!passengerListAircraft.isEmpty()) {
            passengerListAircraft.clear();

            System.out.println("All passengers deboarded.");
        } else {
            System.out.println("Passenger list is already empty.");
        }

    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }
}
