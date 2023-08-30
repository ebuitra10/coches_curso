package com.project.coches.exception;

public class CustomerNotExistException extends RuntimeException{

    public CustomerNotExistException (){
        super("El cliente no existe");
    }

}
