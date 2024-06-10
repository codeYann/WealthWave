package com.codeyan.WealthWave.Core.Address;

import com.codeyan.WealthWave.Core.Users.Users;
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

    @OneToOne
    @JoinColumn(name = "country_id")
    private Countries countries;

    @Column(length = 20, nullable = false)
    private String postalCode;

    @Column(length = 10)
    private String apartmentNumber;

    @Column(length = 10)
    private String suit;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    private Date updatedAt;
}
