package airfield.exceptions;

public class HangarFullException extends RuntimeException{
    public HangarFullException(String message){
        super(message);
    }
}
