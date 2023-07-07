package com.project.coches.persistance.repository.crud;

import com.project.coches.persistance.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ICustomerCrudRepository extends JpaRepository<CustomerEntity, String> {
    /*Hereda de jpa que es el que convierte las consultas, le pones que tipo de entidad y el tipo de la llave primaria
    (Seria String en este caso por CardId)*/


    //Esto es un Query method para hacer la consulta la base de datos y buscar por Email en este caso
    //esto es lo que tocaria hacer normalmente pero la firma de abajo del metodo de peticion ya lo entiende
    //@Query("SELECT c FROM CustomerEntity c WHERE c.CarId = ?1")
    Optional<CustomerEntity> findByEmail(String email);
}
