package Airfield;

import Airfield.aircraft.*;
import Airfield.airport.Airport;
import Airfield.airport.Gate;
import Airfield.airport.Hangar;
import Airfield.airport.Terminal;
import Airfield.flights.Airline;
import Airfield.flights.Flight;
import Airfield.person.Passenger;
import Airfield.flights.Ticket;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.*;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        //Airlines
       Airline lot =  new Airline("Lot","Lot123");
       Airline wizzair = new Airline("Wizzair","wizz");

        //Aircraft
        Aircraft airplane = new PassengerPlane(new Registration("N12345"), "Commercial Jet", "XXX", 2, 2000, 165, false);
        Aircraft airplane2 = new PassengerPlane(new Registration("N12345"), "Commercial Jet", "XXX", 2, 2137, 178, true);
        Aircraft helicopter = new Helicopter(new Registration("H45678"), "Rescue Helicopter", "Jet", 1, 250, 15);
        Aircraft hotAirBalloon = new HotAirBalloon(new Registration("B78901"), "Tour Balloon","XX" ,444, 1200, 150, 15, 111);



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


        //Hangar and runway maangaementdsa



     Map<String, Integer> has = new HashMap<String, Integer>();

     has.put("airplane", 3);
     has.put("hotAirBalloon", 1);

     Hangar hangar1 = new Hangar("Main", has);

     System.out.println(hangar1.getAircraftSlots());
     hangar1.addAircraft(airplane);


     airport1.addHangar(hangar1);
        airport1.addRunway(1,500);

        //passengers
        Passenger passenger1 = new Passenger("Thomas Doe", new Date("2000/12/12"), "DSA12w3123");
        Passenger passenger2 = new Passenger("Markus", new Date("2000/12/12"), "P123456789");

        //add luggage to passengers
        passenger1.addLuggage("LUG123",20.4);

        passenger1.listLuggage();

        //creating a flight
        Flight flight1 = new Flight("1D",lot,airport1,airport2, Date.from(LocalDateTime.of(2024, Month.DECEMBER,20,12,0,0).atZone(ZoneId.systemDefault()).toInstant()));

         airport1.addFlight(flight1);
         airport1.addFlight(flight1);

     System.out.println("list of flights:");


         airport1.showAllFlights();

     System.out.println("--------------");



        //issuing tickets for passengers
        Ticket ticket1 = new Ticket("123xc",flight1,passenger1,"12E");
        Ticket ticket2 = new Ticket("123xc",flight1,passenger2,"12F");



     airport1.departFlight(flight1);
        flight1.arrive();
        flight1.complete();



        airport1.exportFlightDetails("exported.txt");










    }
}