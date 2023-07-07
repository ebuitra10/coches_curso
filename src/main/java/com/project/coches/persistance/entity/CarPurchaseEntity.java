package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter@Setter
@Entity
@Table(name = "coches_compras")
public class CarPurchaseEntity  {


    @EmbeddedId
    private CarPurchasePK id;

    @Column(name = "cantidad")
    private Integer quantity;

    private  Integer totalPriceCars;

    //si esto es una compra debo hacer referencia a la columna de comprasnumero_factura, la debo mapear asi
    @ManyToOne
    /*a nivel de backend yo le voy a mandar la compra para que me tome el id y con el id lo guardo en
    purchaseNumberBill que esta en CarPurchasePK*/
    @MapsId(value = "purchaseNumberBill")
    @JoinColumn(name = "comprasnumero_factura", insertable = false, updatable = false)
    private PurchaseEntity purchaseEntity;

    @ManyToOne
    @JoinColumn(name = "comprascodigo_coche", insertable = false, updatable = false)
    private CarEntity carEntity;


}
