package com.project.coches.exception;

public class PurchaseNotExistException extends RuntimeException{

    public PurchaseNotExistException(){
        super("No existe la compra");
    }
}
