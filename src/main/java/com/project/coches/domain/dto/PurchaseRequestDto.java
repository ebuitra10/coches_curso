package com.project.coches.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Dto de la consulta para el guardado de una compra
 */
@Getter@Setter
@AllArgsConstructor
public class PurchaseRequestDto {

    private Integer numberBill;

    private String cardIdCustomer;

    private LocalDateTime date;

    private Double total;

    private String paymentMethod;

    private List<CarPurchaseRequestDto> carPurchase;

}
