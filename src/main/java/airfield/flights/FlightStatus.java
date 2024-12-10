package airfield.flights;

public enum FlightStatus {
    SCHEDULED,
    BOARDING,
    DEPARTED,
    DELAYED,
    CANCELED,
    IN_AIR,
    LANDED,
    COMPLETED;

    public boolean isFinished() {
        return this == CANCELED || this == COMPLETED;
    }
}
