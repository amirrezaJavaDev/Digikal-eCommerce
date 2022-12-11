package com.digikalspring.digikalspring.digikalexception.error;

import com.digikalspring.digikalspring.digikalexception.DigikalException;
import com.digikalspring.digikalspring.digikalexception.DigikalType;

public class LoginOperationFailException extends DigikalException {
    public LoginOperationFailException(){
        super(DigikalType.LOGIN_OPERATION_FAIL);
    }
}
