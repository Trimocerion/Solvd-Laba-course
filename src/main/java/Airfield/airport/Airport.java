package Airfield.airport;

import Airfield.aircraft.Aircraft;
import Airfield.exceptions.FlightNotFoundException;
import Airfield.exceptions.FlightOverbookedException;
import Airfield.flights.Flight;
import Airfield.flights.FlightStatus;
import Airfield.flights.Luggage;
import Airfield.person.Employee;
import Airfield.person.Passenger;
import Airfield.utilities.LoggerUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Airport {


    private static final int MAX_AIRPORTS = 100;
    private static int totalAirports;
    private String name;
    private String location;
    private List<Terminal> terminals;
    private List<Employee> employees;
    protected List<Flight> flights;
    protected List<Hangar> hangars;
    protected List<Runway> runways;
    protected ControlTower controlTower;
    protected FuelStation fuelStation;
    private static final Logger logger = LoggerUtil.getLogger(Airport.class);

    static {
        totalAirports = 0;
        System.out.println("Static block executed");
    }


    public Airport() {

        if (totalAirports >= MAX_AIRPORTS) {
            throw new IllegalStateException("cannot create more than " + MAX_AIRPORTS + " airports.");
        }

        totalAirports++;
    }


    public Airport(String name, String location) {

        if (totalAirports >= MAX_AIRPORTS) {
            throw new IllegalStateException("cannot create more than " + MAX_AIRPORTS + " airports.");
        }

        this.name = name;
        this.location = location;
        this.terminals = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.flights = new ArrayList<>();
        this.hangars = new ArrayList<>();
        this.runways = new ArrayList<>();
        this.controlTower = new ControlTower("Main Control Tower");
        this.fuelStation = new FuelStation("Main Fuel Station", 2500);

        totalAirports++;
    }


    public Runway getAvailableRunway() {
        for (Runway runway : runways) {
            if (!runway.isOccupied()) {
                return runway;
            }
        }
        return null;
    }

    public void addFlight(Flight flight) {
        try {
            if (!flights.contains(flight)) {
                flights.add(flight);
                System.out.println("Flight " + flight.getFlightNumber() + " added to the schedule for " + flight.getOrigin().getName());
            } else {
                throw new FlightOverbookedException("Flight " + flight.getFlightNumber() + " is already scheduled.");
            }
        } catch (FlightOverbookedException e) {
            logger.severe("Error adding flight: " + e.getMessage());
        }

    }


    public void addRunway(int runwayName, int length) {
        Runway runway = new Runway(runwayName, length);
        runways.add(runway);
    }

    public void addHangar(Hangar hangar) {
        hangars.add(hangar);
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

            } else {
                throw new Exception("No available runways for flight " + flight.getFlightNumber());

            }
        } catch (Exception e) {
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

    public void assignHangarToAircraft(Aircraft aircraft, Hangar hangar) {
        if (aircraft == null) {
            throw new NullPointerException("cannot park: aircraft is null");
        }
        if (hangar == null) {
            throw new NullPointerException("cannot park: hangar is null");
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
                throw new FlightNotFoundException("Flight " + flight.getFlightNumber() + " is not in the schedule.");
            }
        } catch (Exception e) {
            logger.warning("Error canceling flight: " + e.getMessage());
            System.err.println(e.getMessage());
        }
    }

    public void delayFlight(Flight flight, int delayMinutes) throws FlightNotFoundException {
        if (flight == null) throw new NullPointerException("Cannot delay flight. flight is null");
        if (flights.contains(flight)) {
            flight.delayFlight(delayMinutes);
            logger.info("Flight " + flight.getFlightNumber() + " delayed by " + delayMinutes + " minutes.");
        } else {
            throw new FlightNotFoundException("Flight " + flight.getFlightNumber() + " is not in the schedule.");
        }
    }

    public void showAllFlights() {
//        if (flights.isEmpty()) {
//            logger.info("No flights available in the schedule.");
//        } else {
//            logger.info("Displaying all scheduled flights.");
            for (Flight flight : flights) {
                System.out.println("Flight: " + flight.getFlightNumber() + " status: " + flight.getStatus());
            }
//        }
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

    public static int getTotalAirports() {
        return totalAirports;
    }

    public static int getMaxAirports() {
        return MAX_AIRPORTS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Terminal> getTerminals() {
        return terminals;
    }

    public void setTerminals(List<Terminal> terminals) {
        this.terminals = terminals;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(name, airport.name) && Objects.equals(location, airport.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", terminals=" + terminals +
                ", employees=" + employees +
                '}';
    }
}
