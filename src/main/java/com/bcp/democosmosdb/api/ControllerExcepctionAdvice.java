package com.bcp.democosmosdb.api;

import com.azure.cosmos.implementation.NotFoundException;
import com.bcp.democosmosdb.core.dto.ErrorResponse;
import com.bcp.democosmosdb.core.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExcepctionAdvice {
    //Cuando ocurra el error StudentNotFoundException entrará a este metodo
    @ExceptionHandler(value= StudentNotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    public void error(StudentNotFoundException ex){
        new ErrorResponse(1,ex.getMessage());
    }

    @ExceptionHandler(value= NotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    public void error(NotFoundException ex){
        new ErrorResponse(2,ex.getMessage());
    }
}
