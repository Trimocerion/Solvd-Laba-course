package airfield.exceptions;

public class FlightOverbookedException extends Exception{
    public FlightOverbookedException(String message){
        super(message);
    }
}
