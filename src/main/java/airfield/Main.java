package airfield;

import airfield.aircraft.*;
import airfield.airport.*;
import airfield.flights.Airline;
import airfield.flights.Flight;
import airfield.flights.FlightStatus;
import airfield.flights.Ticket;
import airfield.person.Employee;
import airfield.person.Passenger;
import airfield.person.Role;
import airfield.utilities.functions.Counter;
import airfield.utilities.functions.Sorter;
import airfield.utilities.functions.Transform;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        //Airlines
        Airline lotAirline = new Airline("Lot", "Lot123");
        Airline wizzairAirline = new Airline("Wizzair", "wizz123");

        //Aircraft
        Aircraft airplane = new PassengerPlane(new Registration("N12345"), "Commercial Jet", "XXX", 2, 2000, 165, false, AircraftType.COMMERCIAL);
        Aircraft airplane2 = new PassengerPlane(new Registration("N12345"), "Commercial Jet", "XXX", 2, 2137, 178, true, AircraftType.COMMERCIAL);
        Aircraft helicopter = new Helicopter(new Registration("H45678"), "Rescue Helicopter", "Jet", 1, 250, 15, AircraftType.CARGO);
        Aircraft hotAirBalloon = new HotAirBalloon(new Registration("B78901"), "Tour Balloon", "XX", 444, 1200, 150, 15, 111, AircraftType.COMMERCIAL);


        // Gates
        List<Gate> gates = new ArrayList<>();
        gates.add(new Gate("Gate A1"));
        gates.add(new Gate("Gate A2"));
        gates.add(new Gate("Gate B1"));

        // Terminals
        Terminal mainTerminal = new Terminal("Main Terminal", gates);
        Terminal regionalTerminal = new Terminal("Regional Terminal", gates);

        List<Terminal> terminals1 = new ArrayList<>();
        terminals1.add(mainTerminal);
        terminals1.add(regionalTerminal);


        List<Terminal> terminals2 = new ArrayList<>();
        terminals2.add(mainTerminal);

        //airports
        Airport airport1 = new Airport("International airport", "Poland");
        Airport airport2 = new Airport("Regional Airport", "Hungary");
        Airport airport3 = new Airport("Test airport", "Poland");

        airport1.setTerminals(terminals1);
        airport2.setTerminals(terminals2);


        Map<AircraftType, Integer> has = new HashMap<>();

        has.put(AircraftType.COMMERCIAL, 3);
        has.put(AircraftType.PRIVATE, 1);

        Hangar hangar1 = new Hangar("Main", has);

        System.out.println(hangar1.getAircraftSlots());
        hangar1.addAircraft(airplane);


        airport1.addHangar(hangar1);
        Runway run = new Runway(1, 500, RunwayType.ASPHALT);
        airport1.addRunway(run);

        //passengers
        Passenger passenger1 = new Passenger("Thomas Doe", new Date("2000/12/12"), "DSA12w3123");
        Passenger passenger2 = new Passenger("Markus", new Date("2000/12/12"), "P123456789");

        Employee employee1 = new Employee("123","Tom", Role.SECURITY);
        Employee employee2 = new Employee("123","Tom", Role.SECURITY);
        Employee employee3 = new Employee("123","Tom", Role.SECURITY);

        airport1.setEmployees(List.of(employee1,employee2,employee3));
        

        //add luggage to passengers
        passenger1.addLuggage("LUG123", 20.4);

        passenger1.listLuggage();

        //creating a flight
        Flight flight1 = new Flight("1D", lotAirline, airport1, airport2, Date.from(LocalDateTime.of(2024, Month.DECEMBER, 20, 12, 0, 0).atZone(ZoneId.systemDefault()).toInstant()));

        flight1.setStatus(FlightStatus.CANCELED);
        airport1.addFlight(flight1);

        airplane.addPassenger(passenger1);


        airplane.displayPassengers();

        //lambda usage

        List<Airport> airports = new ArrayList<>();
        airports.add(airport1);
        airports.add(airport2);
        airports.add(airport3);

        System.out.println("---");

        //1
        Predicate<Aircraft> hasPassengers = aircraft -> !aircraft.getPassengerList().isEmpty();
        System.out.println("Aircraft " + helicopter.getModel() + " have passengers: " + hasPassengers.test(helicopter));

        //2
        Function<Airport, String> getLocation = Airport::getLocation;

        for (Airport airport : airports) {
            System.out.println(getLocation.apply(airport));
        }

        //3
        Consumer<Airport> printAirportEmployeesNum = airport -> System.out.println(airport.getName() + " has " + airport.getEmployees().size() + " employees.");
        airports.forEach(printAirportEmployeesNum);


        //4
        Consumer<Airport> printHangarNumber = airport -> System.out.println(airport.getName() + ": " + airport.getHangars().size() + (airport.getHangars().size() == 1 ? " hangar" : " hangars"));
        airports.forEach(printHangarNumber);

        //5
        Predicate<Airport> checkIfRunwayFree = airport -> airport.getLocation().equals("Poland");
        System.out.println("Poland or not");
        for (Airport airport : airports) {
            System.out.println(airport.getName() + " located in Poland:" + checkIfRunwayFree.test(airport));
        }

        //custom lambdas

        //1
        Sorter<Airport> sorterByHangarAmount = (a1, a2) -> Integer.compare(a1.getHangars().size(), a2.getHangars().size());

        System.out.println("not sorted airports");
        for (Airport airport : airports){
            System.out.println(airport.getName());
        }

        System.out.println("Sorted airports:");
        airports.sort(sorterByHangarAmount::compare);

        for (Airport airport : airports) {
            System.out.println(airport.getName());
        }

        //2
        Transform<Airport, String> airportStringTransform = (a) -> a.getName() + "===" +  a.getEmployees();

        for (Airport a : airports){
            System.out.println(airportStringTransform.run(a));
        }

        //3
        Counter<Airport, Integer> countAllSecurity = (a) -> (int) a.getEmployees().stream().filter(e -> e.getRole().equals(Role.SECURITY)).count();

        System.out.println("Security: " + countAllSecurity.run(airport1));


        airport1.addFlight(flight1);
        airport1.showAllFlights();

        System.out.println("--------------");

        airport1.exportFlightDetails("exported.txt");


        //issuing tickets for passengers
        Ticket ticket1 = new Ticket("123xc", flight1, passenger1, "12E");
        Ticket ticket2 = new Ticket("123xc", flight1, passenger2, "12F");


        airport1.departFlight(flight1);
        flight1.arrive();
    }
}