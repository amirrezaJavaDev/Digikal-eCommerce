package ir.amirreza.ProjectException.erorr;

import ir.amirreza.ProjectException.DigikalExcepType;
import ir.amirreza.ProjectException.DigikalException;

public class LoginFiledException extends DigikalException {
    public LoginFiledException() {
        super(DigikalExcepType.AUTHENTICATION_FAILED);
    }
}
