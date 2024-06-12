package com.codeyan.WealthWave.application.cases.address;

import com.codeyan.WealthWave.core.entities.address.Address;
import com.codeyan.WealthWave.core.repositories.AddressRepository;
import com.codeyan.WealthWave.shared.core.UseCase;

public class CreateAddress implements UseCase<AddressDTO, Address> {

    private AddressRepository addressRepository;

    public CreateAddress(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    // @Override
    // Address execute(AddressDTO input) {
    // }
}
