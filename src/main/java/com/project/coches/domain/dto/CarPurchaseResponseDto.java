package com.project.coches.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Dto del guardado de los carros de una compra
 */
@AllArgsConstructor
@Getter@Setter
public class CarPurchaseResponseDto {

    private String referenceCar;

    private Integer quantity;

    private Integer total;
}
