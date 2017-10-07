package com.parking.exceptions.handler;

import com.parking.exceptions.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Data not found")
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {DataNotFoundException.class})
    protected void handleDataNotFound() {
    }
}
