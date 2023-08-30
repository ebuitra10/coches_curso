package com.project.coches.domain.services;

import com.project.coches.domain.dto.PurchaseBillResponseDto;
import com.project.coches.domain.dto.PurchaseRequestDto;
import com.project.coches.domain.dto.PurchaseResponseDto;
import com.project.coches.domain.repository.IPurchaseRepository;
import com.project.coches.domain.useCase.IPurchaseUseCase;
import com.project.coches.exception.PurchaseNotExistException;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PurchaseService implements IPurchaseUseCase {


    private final IPurchaseRepository iPurchaseRepository;
    @Override
    public List<PurchaseResponseDto> getAll() {
        return iPurchaseRepository.getAll();
    }

    @Override
    public List<PurchaseResponseDto> getByIdCustomer(String idCustomer) {
        return iPurchaseRepository.getByIdCustomer(idCustomer);
    }

    @Override
    public PurchaseResponseDto getByNumberBill(Integer numberBill) {
        PurchaseResponseDto purchaseResponseDto = iPurchaseRepository.getByNumberBill(numberBill);

        if (purchaseResponseDto == null){
            throw new PurchaseNotExistException();
        }

        return purchaseResponseDto;
    }

    @Override
    public PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto) {
        return iPurchaseRepository.save(purchaseRequestDto);
    }
}
