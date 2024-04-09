package com.example.simplefurniture_backend.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.simplefurniture_backend.dto.AddressDTO;
import com.example.simplefurniture_backend.models.Address;

import jakarta.transaction.Transactional;

@Component
public class AddressDAO {
    private final AddressRepository addressRepository;

    public AddressDAO(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return this.addressRepository.findAll();
    }

    @Transactional
    public void createAddress(AddressDTO addressDTO) {
        Address address = new Address(addressDTO.country, addressDTO.city, addressDTO.street, addressDTO.zipCode);
        this.addressRepository.save(address);
    }

    @Transactional
    public void createAddress(Address address) {
        this.addressRepository.save(address);
    }
}
