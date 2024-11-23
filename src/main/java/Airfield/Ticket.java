package Airfield;

public class Ticket {

    private String ticketNumber;
    private Flight flight;
    private Passenger passenger;
    private String seat;


    public Ticket(){}

    public Ticket(String ticketNumber, Flight flight, Passenger passenger, String seat){
        this.ticketNumber=ticketNumber;
        this.flight=flight;
        this.passenger=passenger;
        this.seat=seat;
    }


    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
