package Airfield.airport;

public class Runway {

    private int id;
    private int length;
    private boolean isOccupied;


    public Runway(){}

    public Runway(int id, int length){
        this.id=id;
        this.length=length;
        this.isOccupied=false;
    }

    public void occupy() {
        if (!isOccupied) {
            isOccupied = true;
            System.out.println("Runway " + id + " is now occupied.");
        } else {
            System.out.println("Runway " + id + " is already occupied.");
        }
    }

    public void free() {
        if (isOccupied) {
            isOccupied = false;
            System.out.println("Runway " + id + " is now free.");
        } else {
            System.out.println("Runway " + id + " is already free.");
        }
    }

    @Override
    public String toString() {
        return "Runway{" +
                "id=" + id +
                ", length=" + length +
                ", isOccupied=" + isOccupied +
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

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

}
