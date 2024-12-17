package airfield.airport;

import airfield.exceptions.RunwayNotAvailableException;
import airfield.flights.Flight;

import java.util.ArrayList;
import java.util.List;

public class ControlTower {

    private String towerName;
    private List<Runway> monitoredRunways;
    private List<Flight> managedFlights;


    public ControlTower() {
        this.monitoredRunways = new ArrayList<>();
        this.managedFlights = new ArrayList<>();
    }

    public ControlTower(String towerName){
        this();
        this.towerName = towerName;
    }

    public void addRunway(Runway runway) {
        if (!monitoredRunways.contains(runway)) {
            monitoredRunways.add(runway);
            System.out.println("Runway " + runway.getId() + " is now being monitored by " + towerName);
        } else {
            System.out.println("Runway " + runway.getId() + " is already monitored.");
        }
    }

    public void addFlight(Flight flight){
        if(!managedFlights.contains(flight)){
            managedFlights.add(flight);
            System.out.println("Flight " + flight.getFlightNumber() + " has been added to the control tower " + getTowerName());
        }
    }

    public void removeFlight(Flight flight) {
        if (managedFlights.contains(flight)) {
            managedFlights.remove(flight);
            System.out.println("Flight " + flight.getFlightNumber() + " has been removed from management.");
        } else {
            System.out.println("Flight " + flight.getFlightNumber() + " is not being managed by this control tower.");
        }
    }


    public void assignRunway(Runway runway, Flight flight, WeatherCondition weatherCondition) throws RunwayNotAvailableException {
        if (!weatherCondition.isSafeForTakeoff()) {
            throw new RuntimeException("Takeoff not allowed due to unsafe weather conditions.");
        }
        if (runway != null && managedFlights.contains(flight)) {
            if (runway.getRunwayStatus() == RunwayStatus.AVAILABLE) {
                runway.occupy();
                System.out.println("Runway " + runway.getId() + " has been assigned to flight " + flight.getFlightNumber());
                managedFlights.remove(flight);
            } else {
                throw new RunwayNotAvailableException("Runway " + runway.getId() + " is not available.");
            }
        } else {
            System.out.println("Either runway is null or flight is not being managed by this control tower.");
        }
    }


    public void releaseRunway(Runway runway) {
        if (runway != null) {
            if (runway.getRunwayStatus() == RunwayStatus.OCCUPIED) {
                runway.free();
                System.out.println("Runway " + runway.getId() + " is now free.");
            } else {
                System.out.println("Runway " + runway.getId() + " is already free.");
            }
        } else {
            System.out.println("Error: Runway is null.");
        }
    }

    public String getTowerName() {
        return towerName;
    }

    public void setTowerName(String towerName) {
        this.towerName = towerName;
    }

    public List<Runway> getMonitoredRunways() {
        return monitoredRunways;
    }

    public void setMonitoredRunways(List<Runway> monitoredRunways) {
        this.monitoredRunways = monitoredRunways;
    }

    public List<Flight> getManagedFlights() {
        return managedFlights;
    }

    public void setManagedFlights(List<Flight> managedFlights) {
        this.managedFlights = managedFlights;
    }
}
