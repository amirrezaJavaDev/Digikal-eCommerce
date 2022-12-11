package com.digikalspring.digikalspring.digikalexception.error;

import com.digikalspring.digikalspring.digikalexception.DigikalException;
import com.digikalspring.digikalspring.digikalexception.DigikalType;

public class UserNotFoundException extends DigikalException {
    public UserNotFoundException(){
        super(DigikalType.USER_NOT_FOUND);
    }
}
