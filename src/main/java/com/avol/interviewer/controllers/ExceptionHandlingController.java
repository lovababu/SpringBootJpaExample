package com.avol.interviewer.controllers;

import com.avol.interviewer.utils.exceptions.InvalidJsonException;
import com.avol.interviewer.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidJsonException.class)
    protected ResponseEntity<ErrorMessage> handleInvalidRequest(RuntimeException e, WebRequest request) {
        return new ResponseEntity<>(new ErrorMessage("invalid json"), HttpStatus.BAD_REQUEST);
    }
}
