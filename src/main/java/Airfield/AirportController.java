package Airfield;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AirportController {

    protected Airport airport;
    protected List<Flight> flights;
    protected List<Hangar> hangars;
    protected List<Runway> runways;
    protected ControlTower controlTower;
    protected FuelStation fuelStation;

    public AirportController(){}

    public AirportController(Airport airport){
        this.airport = airport;
        this.flights = new ArrayList<>();
        this.hangars = new ArrayList<>();
        this.runways = new ArrayList<>();
        this.controlTower = new ControlTower("Main Control Tower");
        this.fuelStation = new FuelStation("Fuel Station 1", 5000);
    }

    public Flight createFlight(String flightNumber, Airline airline, Airport origin, Airport destination, Date departureDate) {
        Flight flight = new Flight(flightNumber, airline, origin, destination, departureDate);
        flights.add(flight);
        return flight;
    }

    public void addFlight(Flight flight) {
        if (!flights.contains(flight)) {
            flights.add(flight);
            System.out.println("Flight " + flight.getFlightNumber() + " added to the schedule for " + flight.getOrigin().getName());
        } else {
            System.out.println("Flight " + flight.getFlightNumber() + " is already scheduled.");
        }
    }


    public void addHangar(String hangarId, int airplaneSlots, int gliderSlots, int helicopterSlots, int hotAirBalloonSlots) {
        Hangar hangar = new Hangar(hangarId, airplaneSlots, gliderSlots,helicopterSlots,hotAirBalloonSlots);
        hangars.add(hangar);
    }

    public void addRunway(int runwayName, int length) {
        Runway runway = new Runway(runwayName, length);
        runways.add(runway);
    }

    public void showRunways(){
        for(Runway x : runways){
            System.out.println(x.getId());
        }
    }

    public Runway getAvailableRunway() {
        for (Runway runway : runways) {
            if (!runway.isOccupied()) {
                return runway;
            }
        }
        return null;
    }

    public void departFlight(Flight flight) {
        if (flights.contains(flight)) {
            Runway availableRunway = getAvailableRunway();
            if(availableRunway != null){
                availableRunway.occupy();
                flights.remove(flight);
                flight.updateFlightStatus(FlightStatus.IN_AIR);
                System.out.println("Flight " + flight.getFlightNumber() + " has departed from " + flight.getOrigin().getName());
                availableRunway.free();
            }
            else {
                System.out.println("Flight " + flight.getFlightNumber() + " is not scheduled in the current flight list.");
            }
        }
    }

    public void freeRunway(Runway runway){
        runway.free();
    }
    public void checkInLuggage(Passenger passenger){
        System.out.println("checking in luggage for passenger " + passenger.getName());
        for(Luggage luggage : passenger.getLuggageList()){
            System.out.println("Luggage id: " + luggage.getId() + ", weight: " + luggage.getWeight() + "kg");
        }
    }

    public void assignParkingToAircraft(Aircraft aircraft, Hangar hangar){

        System.out.println(aircraft.getRegistration() + " parked at " + hangar.getHangarId());
    }

    public void cancelFlight(Flight flight){

    }

    public void delayFlight(Flight flight, int delayMinutes){

    }


    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}
