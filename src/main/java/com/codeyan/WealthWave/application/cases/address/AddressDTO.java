package com.codeyan.WealthWave.application.cases.address;

import java.util.Optional;

public record AddressDTO(
        String streetName,
        int residenceNumber,
        String locality,
        String country,
        String postalCode,
        Optional<String> apartmentNumber,
        Optional<String> suit
) {
}
