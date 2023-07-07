package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto que modela un carro
 */
@Getter@Setter
public class CarDto {

    private Integer codeCar;

    private Integer brandCarId;

    private  String reference;

    private Double price;

    private Double modelYear;

    private String color;

    private Double horsePower;

    private Double numberDoor;

    private Double engineDisplacement;

    private String transmission;

    private String fuelType;

    private Integer numberSeats;

    private  Integer traction;

    private String steering;

    private String category;

    private String imagePath;

}
