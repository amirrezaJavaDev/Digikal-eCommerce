package com.digikalspring.digikalspring.digikalexception.error;

import com.digikalspring.digikalspring.digikalexception.DigikalException;
import com.digikalspring.digikalspring.digikalexception.DigikalType;

public class UserRegistedException extends DigikalException {
    public UserRegistedException(){
        super(DigikalType.USER_REGISTED);
    }
}
