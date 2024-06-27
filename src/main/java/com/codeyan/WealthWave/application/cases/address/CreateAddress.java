package com.codeyan.WealthWave.application.cases.address;

import com.codeyan.WealthWave.core.entities.address.Address;
import com.codeyan.WealthWave.core.entities.address.Country;
import com.codeyan.WealthWave.core.repositories.AddressRepository;
import com.codeyan.WealthWave.shared.core.UseCase;

public class CreateAddress implements UseCase<AddressDTO, Address> {

    private AddressRepository addressRepository;

    public CreateAddress(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address execute(AddressDTO input) {
        Address address = new Address(
                input.streetName(),
                input.residenceNumber(),
                input.locality(),
                input.postalCode());

        Country country = this.addressRepository.findByCountryName(input.country());

        if (country == null) {
            country = new Country(input.country());
        }

        address.setCountry(country);

        return this.addressRepository.save(address);
    }
}
