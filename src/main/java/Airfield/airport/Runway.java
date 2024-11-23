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

    public void occupy(){
        isOccupied = true;
    }

    public void free(){
        isOccupied = false;
    }



}
