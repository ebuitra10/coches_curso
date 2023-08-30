package com.project.coches.persistance.repository.crud;

import com.project.coches.persistance.entity.PurchaseEntity;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IPurchaseCrudRepository extends JpaRepository<PurchaseEntity, Integer> {
    List<PurchaseEntity> findAll();
    List<PurchaseEntity> findAllByCardIdCustomer(String idCustomer);

    Optional<PurchaseEntity> findById(Integer numberBill);

}
