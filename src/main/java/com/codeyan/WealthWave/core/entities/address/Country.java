package com.codeyan.WealthWave.core.entities.address;

import java.io.Serializable;

import com.codeyan.WealthWave.core.exceptions.InvalidAddressDataException;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "countries")
@Getter
public class Country implements Serializable {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Country(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidAddressDataException("Country name is null or empty");
        }

        this.name = name;
    }

}
