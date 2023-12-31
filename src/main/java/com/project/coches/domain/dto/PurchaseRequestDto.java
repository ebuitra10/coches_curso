package com.project.coches.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Dto de la consulta para el guardado de una compra
 */
public class PurchaseRequestDto {

    private Integer numberBill;

    private String cardIdCustomer;

    private LocalDateTime date;

    private Double total;

    private String paymentMethod;

    private List<CarPurchaseRequestDto> carPurchase;

}
