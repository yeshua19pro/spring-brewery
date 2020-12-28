package spring.brewery.web.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * This method is gonna advice spring MVC that's an exceptionHandler
 */
@ControllerAdvice
public class MvcExceptionHandler {

    /**
     * This method returns a list of errors
     * @param e error class
     * @return a list of errors
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e){

        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage() );
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * This gonna make a Json and display it to the client
     * @param ex BindException
     * @return a list of errors
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<List> handleBindException (org.springframework.validation.BindException ex){

        return new ResponseEntity(ex.getAllErrors(), HttpStatus.BAD_REQUEST);
    }
}
