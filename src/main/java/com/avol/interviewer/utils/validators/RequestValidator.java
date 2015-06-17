package com.avol.interviewer.utils.validators;


import com.avol.interviewer.utils.exceptions.InvalidJsonException;
import org.springframework.validation.BindingResult;

public class RequestValidator {

    public static Boolean validate(BindingResult result) {
        if(result.hasErrors()) {
            throw new InvalidJsonException();
        }
        return Boolean.TRUE;
    }

}
