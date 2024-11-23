package Airfield;

public class Gate {

    private String gateNumber;
    private boolean isAvailable;

    public Gate(String gateNumber){
        this.gateNumber = gateNumber;
        this.isAvailable = true;
    }


    public void openGate(){
        isAvailable = true;
    }

    public void closeGate(){
        isAvailable = false;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }
}
