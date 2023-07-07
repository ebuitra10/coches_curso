package com.project.coches.domain.repository;

import com.project.coches.domain.dto.CustomerDto;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de repositorio de marca coche
 */

public interface ICustomerRepository {

    /**
     * Devuelve una lista con todos los clientes
     * @return lista con clientes
     */
    List<CustomerDto> getAll();

    Optional<CustomerDto> getCustomerByCardId(String cardId);

    Optional<CustomerDto> getCustomerByEmail(String email);

    CustomerDto save(CustomerDto newCustomer);

    void delete(String cardId);
}
