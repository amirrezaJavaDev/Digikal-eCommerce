package ir.amirreza.ProjectException.erorr;

import ir.amirreza.ProjectException.DigikalExcepType;
import ir.amirreza.ProjectException.DigikalException;

public class FileNotFoundException extends DigikalException {
    public FileNotFoundException() {
        super(DigikalExcepType.FILE_NOT_FOUND);
    }
}
