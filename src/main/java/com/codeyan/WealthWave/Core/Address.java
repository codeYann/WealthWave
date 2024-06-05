package com.codeyan.WealthWave.Core;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "address")
@Getter
@Setter
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false)
    private String streetName;

    @Column(nullable = false)
    private int streetNumber;

    @Column(nullable = false)
    private String locality;

    @Column(length = 20, nullable = false)
    private String postalCode;

    @Column(length = 10, nullable = true)
    private String apartmentNumber;

    @Column(length = 10, nullable = true)
    private String suit;

    @CreationTimestamp
    private Date createdAt;

    private Date updatedAt;
}
