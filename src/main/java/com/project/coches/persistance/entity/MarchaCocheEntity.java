package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//entity para indicar que es una entidad y table para agragarle la entidad de la base de datos
@Entity
@Table(name = "marca_coche")
public class MarchaCocheEntity {
    //hay que manejarlo con tipo de datos wraper, tipos primitivos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //el que hace que sea autoincrementable
    private Integer id;
    @Column(name = "descripcion")
    private String description;

}
