package com.codeyan.WealthWave.core.entities.transaction;

import com.codeyan.WealthWave.core.entities.wallet.Wallet;
import com.codeyan.WealthWave.core.exceptions.InvalidTransactionDataException;
import jakarta.persistence.*;
import jakarta.transaction.InvalidTransactionException;
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

    @Setter
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

    public CreditTransaction() {

    }

    public CreditTransaction(Wallet wallet, BigDecimal amountCents, Wallet toVendorWalletId, String description) {
        setWallet(wallet);
        setPublicId(UUID.randomUUID());
        setAmountCents(amountCents);
        setPaymentType(PaymentType.CREDIT);
        setToVendorWalletId(toVendorWalletId);
        setDescription(description);
    }

    public void setWallet(Wallet wallet) {
        if (wallet == null) {
            throw new InvalidTransactionDataException("wallet is null");
        }
        this.wallet = wallet;
    }

    public void setAmountCents(BigDecimal amountCents) {
        if (amountCents == null || amountCents.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidTransactionDataException("amountCents is null or zero");
        }
        this.amountCents = amountCents;
    }

    public void setPaymentType(PaymentType paymentType) {
        if (paymentType == null) {
            throw new InvalidTransactionDataException("paymentType is null");
        }
        setPaymentType(paymentType);
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new InvalidTransactionDataException("description is null or empty");
        }
        this.description = description;
    }

    public void setToVendorWalletId(Wallet toVendorWalletId) {
        if (toVendorWalletId == null) {
            throw new InvalidTransactionDataException("vendor wallet is null");
        }
        this.toVendorWalletId = toVendorWalletId;
    }
}

