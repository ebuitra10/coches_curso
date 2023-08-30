package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.CarPurchaseResponseDto;
import com.project.coches.domain.dto.PurchaseBillResponseDto;
import com.project.coches.domain.dto.PurchaseRequestDto;
import com.project.coches.domain.dto.PurchaseResponseDto;
import com.project.coches.domain.repository.IPurchaseRepository;
import com.project.coches.persistance.entity.PurchaseEntity;
import com.project.coches.persistance.mapper.IPurchaseMapper;
import com.project.coches.persistance.repository.crud.IPurchaseCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class PurchaseRepository implements IPurchaseRepository {

    private IPurchaseCrudRepository iPurchaseCrudRepository;

    private IPurchaseMapper iPurchaseMapper;


    public List<PurchaseResponseDto> getAll(){

        List<PurchaseEntity> lisPurchaseEntity = iPurchaseCrudRepository.findAll();
        List<PurchaseResponseDto> listPurchaseResponseDto = new ArrayList<>();

        lisPurchaseEntity.forEach(purchaseEntity -> listPurchaseResponseDto.add(toPurchaseResponseDtoByEntity(purchaseEntity)));

        return listPurchaseResponseDto;
    }

    public List<PurchaseResponseDto> getByIdCustomer(String idCustomer){
        List<PurchaseEntity> listPurchaseEntity = iPurchaseCrudRepository.findAllByCardIdCustomer(idCustomer);
        List<PurchaseResponseDto> listPurchaseResponseDto = new ArrayList<>();

        listPurchaseEntity.forEach(purchaseEntity -> listPurchaseResponseDto.add(toPurchaseResponseDtoByEntity(purchaseEntity)));

        return listPurchaseResponseDto;

    }

    public PurchaseResponseDto getByNumberBill(Integer numberBill){
        Optional<PurchaseEntity> purchaseEntitySearch = iPurchaseCrudRepository.findById(numberBill);

        if (purchaseEntitySearch.isEmpty()){
            return null;
        }

        return toPurchaseResponseDtoByEntity(purchaseEntitySearch.get());
    }

    public PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto){
        PurchaseEntity purchaseEntity = iPurchaseMapper.toPurchaseEntity(purchaseRequestDto);

        purchaseEntity.getCarPurchase().forEach(carPurchaseEntity -> carPurchaseEntity.setPurchaseEntity(purchaseEntity));

        PurchaseEntity purchaseEntitySave = iPurchaseCrudRepository.save(purchaseEntity);
        return new PurchaseBillResponseDto(purchaseEntitySave.getNumberBill());
    }

    /*Cuando tienes una relacion de uno a muchos necesitas por lo general hacer
    este mapper solo en el repositorio por la relacion mencionada
     */

    public PurchaseResponseDto toPurchaseResponseDtoByEntity(PurchaseEntity purchaseEntity){
        PurchaseResponseDto purchaseResponseDto = new PurchaseResponseDto();
        purchaseResponseDto.setNumberBill(purchaseEntity.getNumberBill());
        purchaseResponseDto.setCardIdCustomer(purchaseEntity.getCardIdCustomer());
        purchaseResponseDto.setDate(purchaseEntity.getDate());
        purchaseResponseDto.setTotal(purchaseEntity.getTotal());
        purchaseResponseDto.setPaymentMethod(purchaseEntity.getPaymentMethod());

        List<CarPurchaseResponseDto> carPurchaseResponseDtoList = new ArrayList<>();
        purchaseEntity.getCarPurchase().forEach(carPurchaseEntity -> {
            String reference = carPurchaseEntity.getCarEntity().getReference();
            Integer quantity = carPurchaseEntity.getQuantity();
            Integer total = carPurchaseEntity.getTotalPriceCars();
            carPurchaseResponseDtoList.add(new CarPurchaseResponseDto(reference, quantity, total));

        });

        purchaseResponseDto.setCarPurchase(carPurchaseResponseDtoList);

        return purchaseResponseDto;
    }
}
