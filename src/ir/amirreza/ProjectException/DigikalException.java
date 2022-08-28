package ir.amirreza.ProjectException;

public class DigikalException extends RuntimeException{
    private final DigikalExcepType erorrType;
    public DigikalException(DigikalExcepType type){this.erorrType=type;}
    public DigikalExcepType getErorrType(){return erorrType;}
}
