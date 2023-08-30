package com.project.coches.exception;

import com.project.coches.domain.dto.CustomerDto;

public class UnauthorizedException extends RuntimeException{

    public UnauthorizedException (){
        super("No esta autorizado");
    }

}
