package airfield.aircraft;

public enum AircraftType {
    COMMERCIAL("Commercial", 5000),
    CARGO("Cargo", 7000),
    PRIVATE("Private", 2000);

    private final String type;
    private final int maxRange;

    AircraftType(String type, int maxRange) {
        this.type = type;
        this.maxRange = maxRange;
    }

    public String getType() {
        return type;
    }

    public int getMaxRange() {
        return maxRange;
    }
}
