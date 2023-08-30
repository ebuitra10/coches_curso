package com.project.coches.exception;

public class CustomerExistsException extends RuntimeException{

    public CustomerExistsException(){
        super("El cliente existe");

    }
}
