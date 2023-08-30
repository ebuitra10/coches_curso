package com.project.coches.domain.useCase;

import com.project.coches.domain.dto.PurchaseBillResponseDto;
import com.project.coches.domain.dto.PurchaseRequestDto;
import com.project.coches.domain.dto.PurchaseResponseDto;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.List;
import java.util.Optional;

public interface IPurchaseUseCase {

    List<PurchaseResponseDto> getAll();

    List<PurchaseResponseDto> getByIdCustomer(String idCustomer);

    PurchaseResponseDto getByNumberBill(Integer numberBill);

    PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto);




}
