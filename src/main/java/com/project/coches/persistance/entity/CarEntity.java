package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 *
 */
@Getter@Setter
@Entity
@Table(name = "coches")
public class CarEntity {


    @Id
    //Codigo que se genere automaticamente como si fuera en un catalogo, pero no unico
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_coche")
    private Integer codeCar;

    @Column(name = "marca_coche_id")
    private Integer brandCarId;

    @Column(name = "referencia")
    private  String reference;

    @Column(name = "precio")
    private Double price;

    @Column(name = "anio_modelo")
    private Double modelYear;

    @Column(name = "color")
    private String color;

    @Column(name = "numero_caballos_fuerza")
    private Double horsePower;

    @Column(name = "cantidad_puertas")
    private Double numberDoor;

    @Column(name = "cilindraje")
    private Double engineDisplacement;

    @Column(name = "transmision")
    private String transmission;

    @Column(name = "combustible")
    private String fuelType;

    @Column(name = "cantidad_asientos")
    private Integer numberSeats;

    @Column(name = "traccion")
    private  Integer traction;

    @Column(name = "direccion")
    private String steering;

    @Column(name = "categoria")
    private String category;

    @Column(name = "ruta_imagen")
    private String imagePath;


    //
    @ManyToOne
    @JoinColumn(name = "marca_coche_id", insertable = false, updatable = false)
    private BrandCarEntity brandCarEntity;

    @OneToMany(mappedBy = "carEntity")
    private List<CarPurchaseEntity> carPurchaseEntity;

}
