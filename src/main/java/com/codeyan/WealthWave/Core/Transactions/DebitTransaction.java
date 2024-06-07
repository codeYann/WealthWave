package com.codeyan.WealthWave.Core.Transactions;

import com.codeyan.WealthWave.Core.Wallet.Wallet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "debit_transaction")
@Getter
@Setter
public class DebitTransaction implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private UUID publicId;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @Column(nullable = false)
    private long amountCents;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentType paymentType;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "to_wallet_id")
    private Wallet toWalletId;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdAt;
}
