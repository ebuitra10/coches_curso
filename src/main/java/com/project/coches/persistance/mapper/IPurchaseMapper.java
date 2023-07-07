package com.project.coches.persistance.mapper;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.PurchaseRequestDto;
import com.project.coches.persistance.entity.CustomerEntity;
import com.project.coches.persistance.entity.PurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPurchaseMapper {

    PurchaseRequestDto toPurchaseRequestDto(PurchaseEntity PurchaseEntity);

    @Mapping(target = "customerEntity", ignore = true)
    PurchaseEntity toPurchaseEntity(PurchaseRequestDto purchaseRequestDto);

    List<PurchaseRequestDto> toPurchaseRequestDto(List<PurchaseEntity> toPurchaseEntity);
}
