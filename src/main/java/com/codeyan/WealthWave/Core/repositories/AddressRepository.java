package com.codeyan.WealthWave.Core.repositories;

import com.codeyan.WealthWave.Core.entities.address.Address;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByUserId(Long userId);

    Address save(Address address);
}
