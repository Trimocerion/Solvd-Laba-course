package Airfield.airport;

import Airfield.aircraft.Aircraft;
import Airfield.exceptions.FlightDelayException;
import Airfield.exceptions.FlightOverbookedException;
import Airfield.exceptions.HangarException;
import Airfield.flights.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.ServerError;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AirportController {

    protected Airport airport;
    protected List<Flight> flights;
    protected List<Hangar> hangars;
    protected List<Runway> runways;
    protected ControlTower controlTower;
    protected FuelStation fuelStation;
    private static final Logger logger = Logger.getLogger(AirportController.class.getName());

    static{
        try {
            FileHandler fileHandler = new FileHandler("airport_logs.log",true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        }
        catch (Exception e){
            System.err.println("Failed to setup: " + e.getMessage());
        }
    }


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
        try {
            if (!flights.contains(flight)) {
                flights.add(flight);
                System.out.println("Flight " + flight.getFlightNumber() + " added to the schedule for " + flight.getOrigin().getName());
            }
            else {
                throw new FlightOverbookedException("Flight " + flight.getFlightNumber() + " is already scheduled.");
            }
        }
        catch (FlightOverbookedException e){
            logger.severe("Error adding flight: " + e.getMessage());
            System.err.println(e.getMessage());
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
        try {
            if (flights.contains(flight)) {
                Runway availableRunway = getAvailableRunway();
                if (availableRunway != null) {
                    availableRunway.occupy();
                    flights.remove(flight);
                    flight.updateFlightStatus(FlightStatus.IN_AIR);
                    System.out.println("Flight " + flight.getFlightNumber() + " has departed from " + flight.getOrigin().getName());
                    availableRunway.free();
                } else {
                    throw new Exception("Flight " + flight.getFlightNumber() + " is not scheduled.");
                }

            }
            else{
                throw new Exception("No available runways for flight " + flight.getFlightNumber());

            }
        }
        catch (Exception e) {
            logger.severe("Error during flight departure: " + e.getMessage());
            System.err.println(e.getMessage());
        }
    }

    public void freeRunway(Runway runway) {
        try {
            if (runway != null) {
                runway.free();
                logger.info("Runway " + runway.getId() + " is now free.");
                System.out.println("Runway " + runway.getId() + " is now free.");
            } else {
                throw new Exception("Runway object is null.");
            }
        } catch (Exception e) {
            logger.warning("Error freeing runway: " + e.getMessage());
            System.err.println(e.getMessage());
        }
    }
    public void checkInLuggage(Passenger passenger) {
        try {
            if (passenger == null || passenger.getLuggageList() == null) {
                throw new Exception("Passenger or luggage information is missing.");
            }
            System.out.println("Checking in luggage for passenger " + passenger.getName());
            for (Luggage luggage : passenger.getLuggageList()) {
                System.out.println("Luggage ID: " + luggage.getId() + ", weight: " + luggage.getWeight() + "kg");
            }
            logger.info("Checked in luggage for passenger " + passenger.getName());
        } catch (Exception e) {
            logger.warning("Error during luggage check-in: " + e.getMessage());
            System.err.println(e.getMessage());
        }
    }

    public void assignHangarToAircraft(Aircraft aircraft, Hangar hangar) throws HangarException {
            if (aircraft == null) {
                throw new HangarException("cannot park: aircraft is null");
            }
            if (hangar == null) {
                throw new HangarException("cannot park: hangar is null");
            }
            logger.info("Aircraft " + aircraft.getRegistration() + " parked at " + hangar.getHangarId());
    }

    public void cancelFlight(Flight flight) {
        try {
            if (flights.contains(flight)) {
                flights.remove(flight);
                flight.updateFlightStatus(FlightStatus.CANCELED);
                logger.info("Flight " + flight.getFlightNumber() + " has been canceled.");
            } else {
                throw new Exception("Flight " + flight.getFlightNumber() + " is not in the schedule.");
            }
        } catch (Exception e) {
            logger.warning("Error canceling flight: " + e.getMessage());
            System.err.println(e.getMessage());
        }
    }

    public void delayFlight(Flight flight, int delayMinutes) throws FlightDelayException {
        if(flight == null) throw new FlightDelayException("Cannot delay flight");

        if (flights.contains(flight)) {
                flight.delayFlight(delayMinutes);
                logger.info("Flight " + flight.getFlightNumber() + " has been delayed by " + delayMinutes + " minutes.");
            } else {
                throw new FlightDelayException("Flight " + flight.getFlightNumber() + " is not in the schedule.");
            }
        flight.delayFlight(delayMinutes);
        logger.info("Flight " + flight.getFlightNumber() + " delayed by " + delayMinutes + " minutes.");
    }

    public void showAllFlights() {
        if (flights.isEmpty()) {
            logger.info("No flights available in the schedule.");
        } else {
            logger.info("Displaying all scheduled flights.");
            for (Flight flight : flights) {
                System.out.println("Flight: " + flight.getFlightNumber() + " status: " + flight.getStatus());
            }
        }
    }

    public void exportFlightDetails(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Flight flight : flights) {
                writer.write("Flight Number: " + flight.getFlightNumber());
                writer.newLine();
                writer.write("Departure Date: " + flight.getDepartureTime());
                writer.newLine();
                writer.write("----------------------------");
                writer.newLine();
            }
            System.out.println("Flight details successfully exported to " + filePath);
        } catch (IOException e) {
            logger.warning("Error exporting flight details: " + e.getMessage());
            System.err.println("Failed to export flight details: " + e.getMessage());
        }
    }



        public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}
