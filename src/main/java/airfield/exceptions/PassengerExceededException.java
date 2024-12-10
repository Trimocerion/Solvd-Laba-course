package airfield.exceptions;

public class PassengerExceededException extends RuntimeException {
    public PassengerExceededException(String message) {
        super(message);
    }
}
