package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//entity para indicar que es una entidad y table para agragarle la entidad de la base de datos
@Entity
@Table(name = "marca_coche")
public class BrandCarEntity {
    //hay que manejarlo con tipo de datos wraper, tipos primitivos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //el que hace que sea autoincrementable
    private Integer id;

    /**
     * Descripcion de la marca
     */
    @Column(name = "descripcion")
    private String description;

    @OneToMany(mappedBy = "brandCarEntity", orphanRemoval = true)
    private List<CarEntity> carEntities;

}
