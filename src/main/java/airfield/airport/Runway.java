package airfield.airport;

public class Runway {

    private int id;
    private int length;
    private RunwayType runwayType;
    private RunwayStatus runwayStatus;


    public Runway(){}

    public Runway(int id, int length, RunwayType runwayType){
        this.id=id;
        this.length=length;
        this.runwayStatus=RunwayStatus.AVAILABLE;
        this.runwayType = runwayType;
    }

    public void occupy() {
        if (runwayStatus == RunwayStatus.AVAILABLE) {
            runwayStatus = RunwayStatus.OCCUPIED;
            System.out.println("Runway " + id + " is now occupied.");
        } else {
            System.out.println("Runway " + id + " is already occupied.");
        }
    }

    public void free() {
        if (runwayStatus == RunwayStatus.OCCUPIED) {
            runwayStatus = RunwayStatus.AVAILABLE;
            System.out.println("Runway " + id + " is now free.");
        }
        else{
            System.out.println("Runway " + id + " is not occupied / able to be used");
        }
    }

    @Override
    public String toString() {
        return "Runway{" +
                "id=" + id +
                ", length=" + length +
                ", runwayStatus=" + runwayStatus +
                '}';
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public RunwayType getRunwayType() {
        return runwayType;
    }

    public void setRunwayType(RunwayType runwayType) {
        this.runwayType = runwayType;
    }

    public RunwayStatus getRunwayStatus() {
        return runwayStatus;
    }

    public void setRunwayStatus(RunwayStatus runwayStatus) {
        this.runwayStatus = runwayStatus;
    }
}
