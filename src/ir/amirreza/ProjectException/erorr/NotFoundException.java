package ir.amirreza.ProjectException.erorr;

import ir.amirreza.ProjectException.DigikalExcepType;
import ir.amirreza.ProjectException.DigikalException;

public class NotFoundException extends DigikalException {
    public NotFoundException() {
        super(DigikalExcepType.NOT_FOUND);
    }
}
