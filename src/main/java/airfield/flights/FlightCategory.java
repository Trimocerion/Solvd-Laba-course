package airfield.flights;

public enum FlightCategory {

    SHORT_HAUL("SH", "Domestic", 1500),
    MEDIUM_HAUL("MH", "International", 5000),
    LONG_HAUL("LH", "International", 12000),
    CARGO("CG", "International", 10000),
    CHARTER("CH", "Domestic", 3000);

    private final String code;
    private final String flightType;
    private final int maxDistance;

    FlightCategory(String code, String flightType, int maxDistance) {
        this.code = code;
        this.flightType = flightType;
        this.maxDistance = maxDistance;
    }


    public String getCode() {
        return code;
    }

    public String getFlightType() {
        return flightType;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    @Override
    public String toString() {
        return String.format(
                "%s [Code: %s, Type: %s, Max Distance: %d km]",
                this.name(), code, flightType, maxDistance
        );
    }
}