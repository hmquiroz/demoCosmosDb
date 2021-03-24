package com.bcp.democosmosdb.core.exception;

import java.text.MessageFormat;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String id){
        //super("El sistema no encuentra el usuario" + id);
        super(MessageFormat.format("Usuario no encontrado {0}" , id));
    }
}
