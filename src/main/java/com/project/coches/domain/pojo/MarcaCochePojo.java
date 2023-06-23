package com.project.coches.domain.pojo;

import lombok.Getter;
import lombok.Setter;
//el pojo viene a hacer parte del desacoplamiento
//esto lo hacemos con el fin de depender de pojos y no de entidades
//para los getter and setters (no usar el @Data)
@Getter
@Setter
//pojo de marcha_coche
public class MarcaCochePojo {

    //id de la marca
    private Integer id;
    //descpricion de la marca
    private String description;
}
