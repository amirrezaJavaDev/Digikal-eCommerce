package com.digikalspring.digikalspring.digikalexception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class DigikalExceptionHandler {

    @ExceptionHandler(DigikalException.class)
    @ResponseBody
    public ResponseEntity<String> handleExceptionDigikal(DigikalException e){
        return ResponseEntity.ok(e.getType().getMessageEng());
    }



}
