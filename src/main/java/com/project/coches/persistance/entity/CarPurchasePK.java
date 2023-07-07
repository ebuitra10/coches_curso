package com.project.coches.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter@Setter
@Embeddable
public class CarPurchasePK implements Serializable {

    /*toca dejar esta constante por defecto que es un serializable que me permite traerme
    de forma embebida los id de la entidad pk*/
    @Serial
    private static final long serialVersionUID = -2145479604343286721L;


    @Column(name = "comprasnumero_factura")
    private Integer purchaseNumberBill;

    @Column(name = "cochescodigo_coche")
    private Integer codeCar;
}
