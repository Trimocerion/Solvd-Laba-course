package Airfield;

public class BaggageClaim {

    private int idNumber;
    private boolean isActive;


    public BaggageClaim(){}

    public BaggageClaim(int idNumber){
        this.idNumber = idNumber;
        this.isActive = false;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void activate() {
        this.isActive = true;
        System.out.println("Belt " + idNumber + " is now active.");
    }

    public void deactivate() {
        this.isActive = false;
        System.out.println("Belt " + idNumber + " is now inactive.");
    }
}
