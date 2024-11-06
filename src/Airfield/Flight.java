package Airfield;

import java.util.Date;

public class Flight {
    private String flightNumber;
    private Aircraft aircraft;
    private Airline airline;
    private Airport origin;
    private Airport destination;
    private Date departureTime;
    private FlightStatus status;


    public Flight(){}

    public Flight(String flightNumber,Airline airline, Airport origin, Airport destination, Date departureTime){
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.status=FlightStatus.SCHEDULED;
    }

    public void assignAircraft(Aircraft aircraft){
        this.aircraft = aircraft;
        System.out.println("Aircraft " + aircraft.getRegistration() + " has been assigned to flight " + flightNumber);
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void updateFlightStatus(FlightStatus status) {
        this.status = status;
        System.out.println("Flight " + flightNumber + " status updated to " + status);
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public void getStatus() {
        System.out.println("Flight status: " + flightNumber+ " - " + status.toString());
    }

    public void arrive(){
        if (status == FlightStatus.IN_AIR) {
            status = FlightStatus.LANDED;
            System.out.println("Flight " + flightNumber + " has arrived at " + destination.getName());
        } else {
            System.out.println("Cannot arrive. Flight status: " + status);
        }
    }

    public void complete() {
        if (status == FlightStatus.LANDED) {
            status = FlightStatus.COMPLETED;
            System.out.println("Flight " + flightNumber + " has completed its journey.");


        } else {
            System.out.println("Cannot complete flight. Flight status: " + status);
        }
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }
}
