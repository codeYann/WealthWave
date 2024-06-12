package com.codeyan.WealthWave.Core.entities.address;

import com.codeyan.WealthWave.Core.entities.user.User;
import com.codeyan.WealthWave.Core.exceptions.InvalidAddressDataException;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "address")
@Getter
public class Address implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false)
    private String streetName;

    @Column(nullable = false)
    private int residenceNumber;

    @Column(nullable = false)
    private String locality;

    @OneToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(length = 20, nullable = false)
    private String postalCode;

    @Setter
    @Column(length = 10)
    private String apartmentNumber;

    @Setter
    @Column(length = 10)
    private String suit;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    private Date updatedAt;

    public Address() {

    }

    public Address(
            String streetName,
            int residenceNumber,
            String locality,
            String postalCode
    ) {
        setStreetName(streetName);
        setResidenceNumber(residenceNumber);
        setLocality(locality);
        setPostalCode(postalCode);
    }

    private void checkIfNullOrEmpty(String input, String message) throws InvalidAddressDataException {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidAddressDataException(message);
        }
    }

    public void setStreetName(String streetName) {
        checkIfNullOrEmpty(streetName, "Street name cannot be null or empty");
        this.streetName = streetName;
    }

    public void setResidenceNumber(int residenceNumber) {
        if (residenceNumber < 0) {
            throw new InvalidAddressDataException("Residence number cannot be negative");
        }
        this.residenceNumber = residenceNumber;
    }

    public void setLocality(String locality) {
        checkIfNullOrEmpty(locality, "Locality cannot be null or empty");
        this.locality = locality;
    }

    public void setPostalCode(String postalCode) {
        checkIfNullOrEmpty(postalCode, "Postal code cannot be null or empty");

        if (!postalCode.matches("^\\d+$")) {
            throw new InvalidAddressDataException("Postal code is not a valid postal code");
        }

        this.postalCode = postalCode;
    }

    public void setCountry(Country country) {
        if (country == null) {
            throw new InvalidAddressDataException("Country cannot be null");
        }

        this.country = country;
    }


}
