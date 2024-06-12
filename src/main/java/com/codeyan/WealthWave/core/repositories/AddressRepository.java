package com.codeyan.WealthWave.core.repositories;

import com.codeyan.WealthWave.core.entities.address.Address;
import java.util.*;

import com.codeyan.WealthWave.core.entities.address.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByUserId(Long userId);

    Address save(Address address);

    Boolean existsCountryByName(String country);
    Country saveCountries(String country);
}
