package com.project.coches.persistance.repository;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.repository.ICustomerRepository;
import com.project.coches.persistance.entity.CustomerEntity;
import com.project.coches.persistance.mapper.ICustomerMapper;
import com.project.coches.persistance.repository.crud.ICustomerCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Repository
public class CustomerRepository implements ICustomerRepository {

    public final ICustomerCrudRepository iCustomerCrudRepository;

    public final ICustomerMapper iCustomerMapper;


    @Override
    public List<CustomerDto> getAll() {
        return iCustomerMapper.toCustomerDto(iCustomerCrudRepository.findAll());
    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(String cardId) {
        return iCustomerCrudRepository.findById(cardId)
                .map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerCrudRepository.findByEmail(email)
                .map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public CustomerDto save(CustomerDto newCustomer) {
        CustomerEntity customerEntity = iCustomerMapper.toCustomerEntity(newCustomer);
        return iCustomerMapper.toCustomerDto(iCustomerCrudRepository.save(customerEntity));
    }

    @Override
    public void delete(String cardId) {
        iCustomerCrudRepository.deleteById(cardId);
    }
}
