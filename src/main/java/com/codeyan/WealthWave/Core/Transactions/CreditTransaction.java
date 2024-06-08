package com.codeyan.WealthWave.Core.Transactions;

import com.codeyan.WealthWave.Core.Wallet.Wallet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "credit_transaction")
@Getter
@Setter
public class CreditTransaction implements Serializable {
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
    private BigDecimal amountCents;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentType paymentType;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "to_vendor_wallet_id")
    private Wallet toVendorWalletId;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdAt;
}

