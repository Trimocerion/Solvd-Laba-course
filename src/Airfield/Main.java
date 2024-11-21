package Airfield;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Airlines
       Airline lot =  new Airline("Lot","Lot123");
       Airline wizzair = new Airline("Wizzair","wizz");


        //Aircraft
        Aircraft airplane = new PassengerPlane(new Registration("N12345"), "Commercial Jet", 180, "XXX", 2);
        Aircraft airplane2 = new PassengerPlane(new Registration("N12345"), "Commercial Jet", 180, "XX", 4);
        Aircraft helicopter = new Helicopter(new Registration("H45678"), "Rescue Helicopter", 6, 18);
        Aircraft glider = new Glider(new Registration("G56789"), "Sport Glider", 1, 15);
        Aircraft hotAirBalloon = new HotAirBalloon(new Registration("B78901"), "Tour Balloon",8, 444, 1200, 150);



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

        gates.removeLast();
        gates.removeLast();

        List<Terminal> terminals2 = new ArrayList<>();
        terminals2.add(mainTerminal);

        //airports
        Airport airport1 = new Airport("International airport", "Poland", terminals1);
        Airport airport2 = new Airport("Regional Airport", "Hungary", terminals2);

        //airport controller
        AirportController airportController = new AirportController(airport1);

        //Hangar and runway maangaementdsa
        airportController.addHangar("Main hangar", 25, 12, 2, 2);
        airportController.addRunway(1,500);

        //passengers
        Passenger passenger1 = new Passenger("Thomas Doe", "DSA12w3123");
        Passenger passenger2 = new Passenger("Markus", "P123456789");

        //add luggage to passengers
        passenger1.addLuggage("LUG123",20.4);

        passenger1.listLuggage();

        //creating a flight
        Flight flight1 = new Flight("1D",lot,airport1,airport2, Date.from(LocalDateTime.of(2024, Month.DECEMBER,20,12,0,0).atZone(ZoneId.systemDefault()).toInstant()));

        airportController.addFlight(flight1);

        //issuing tickets for passengers
        Ticket ticket1 = new Ticket("123xc",flight1,passenger1,"12E");
        Ticket ticket2 = new Ticket("123xc",flight1,passenger2,"12F");


        airportController.departFlight(flight1);
        flight1.arrive();
        flight1.complete();
        

    }
}