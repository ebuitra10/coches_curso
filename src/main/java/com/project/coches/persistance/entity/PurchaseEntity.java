package com.project.coches.persistance.entity;

import com.project.coches.domain.dto.CarPurchaseRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entity de compra
 */

@Getter@Setter
@Entity
@Table(name = "compras")
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_factura")
    private Integer numberBill;


    @Column(name = "cliente_cedula")
    private String cardIdCustomer;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    @Column(name = "total")
    private Double total;

    @Column(name = "tipo_de_pago")
    private String paymentMethod;

    /*para que sea en cascada ya que si voy a eliminar la compra se me deben de eliminar todos los registros
    de la compra en la table de coches_compras*/
    /*esta realacion de uno a muchos ese mapped es lo que debe pegar*/
    @OneToMany(mappedBy = "purchaseEntity", cascade = {CascadeType.ALL})
    private List<CarPurchaseEntity> carPurchase;

    @ManyToOne
    @JoinColumn(name = "cliente_cedula", insertable = false, updatable = false)
    private CustomerEntity customerEntity;


}
