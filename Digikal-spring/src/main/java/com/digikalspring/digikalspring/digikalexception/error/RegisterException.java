package com.digikalspring.digikalspring.digikalexception.error;

import com.digikalspring.digikalspring.digikalexception.DigikalException;
import com.digikalspring.digikalspring.digikalexception.DigikalType;

public class RegisterException extends DigikalException {
        public RegisterException(){
            super(DigikalType.REGISTERATION_FAIL);
        }
}
