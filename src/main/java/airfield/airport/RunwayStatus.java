package airfield.airport;

public enum RunwayStatus {
    AVAILABLE("A", 1, "Runway is free and ready for use."),
    OCCUPIED("O", 2, "Runway is currently in use by an aircraft."),
    MAINTENANCE("M", 3, "Runway is under maintenance and unavailable.");


    RunwayStatus(String code, int priority, String description) {
        this.code = code;
        this.priority = priority;
        this.description = description;
    }

    private final String code;
    private final int priority;
    private final String description;

    public String getCode() {
        return code;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format(
                "%s [Code: %s, Priority: %d, Description: %s]",
                this.name(), code, priority, description
        );
    }
}
