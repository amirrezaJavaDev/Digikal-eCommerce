package com.digikalspring.digikalspring.digikalexception;

public class DigikalException extends RuntimeException{
    private final DigikalType type;
    public DigikalException(DigikalType exceptionType) {
        this.type = exceptionType;
    }
    public DigikalType getType(){
        return type;
    }
}
