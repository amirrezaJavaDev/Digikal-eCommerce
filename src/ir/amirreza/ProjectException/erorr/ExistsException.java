package ir.amirreza.ProjectException.erorr;

import ir.amirreza.ProjectException.DigikalExcepType;
import ir.amirreza.ProjectException.DigikalException;

public class ExistsException extends DigikalException {
    public ExistsException() {
        super(DigikalExcepType.DUPLICATION_USER);}
}
