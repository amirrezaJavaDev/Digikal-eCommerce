package ir.amirreza.ProjectException.erorr;

import ir.amirreza.ProjectException.DigikalExcepType;
import ir.amirreza.ProjectException.DigikalException;

public class WrongEntryException extends DigikalException {
    public WrongEntryException() {
        super(DigikalExcepType.WRONG_ENTRY);
    }
}
