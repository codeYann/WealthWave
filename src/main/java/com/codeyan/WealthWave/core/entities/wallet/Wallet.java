package com.codeyan.WealthWave.core.entities.wallet;

import com.codeyan.WealthWave.core.entities.account.AccountStatus;
import com.codeyan.WealthWave.core.entities.account.BusinessAccount;
import com.codeyan.WealthWave.core.entities.account.IndividualAccount;
import com.codeyan.WealthWave.core.entities.transaction.CreditTransaction;
import com.codeyan.WealthWave.core.entities.transaction.DebitTransaction;
import com.codeyan.WealthWave.core.exceptions.InvalidWalletDataException;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "wallet")
@Getter
public class Wallet implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private BigDecimal balanceCents;

  @Column(nullable = false)
  private BigDecimal creditLimitCents;

  @Column(length = 10, nullable = false)
  private String currency;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private AccountStatus status;

  @Setter
  @CreationTimestamp
  @Column(name = "last_transaction_at")
  private Date lastTransactionAt;

  @Setter
  @OneToOne
  @JoinColumn(unique = true, name = "business_account_id")
  private BusinessAccount businessAccount;

  @Setter
  @OneToOne
  @JoinColumn(unique = true, name = "individual_account_id")
  private IndividualAccount individualAccount;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false)
  private Date createdAt;

  @Setter
  @OneToMany(mappedBy = "wallet")
  private List<DebitTransaction> debitTransactions;

  @Setter
  @OneToMany(mappedBy = "wallet")
  private List<CreditTransaction> creditTransactions;

  @Column(name = "updated_at")
  private Date updatedAt;

  public Wallet() {

  }

  public Wallet(BigDecimal balanceCents, BigDecimal creditLimitCents) {
    setBalanceCents(balanceCents);
    setCreditLimitCents(creditLimitCents);
    setCurrency("BRL");
    setStatus(AccountStatus.ACTIVE);
    setLastTransactionAt(null);
    setBusinessAccount(null);
    setIndividualAccount(null);
    setDebitTransactions(null);
    setCreditTransactions(null);
  }

  public void setBalanceCents(BigDecimal balanceCents) {
    if (balanceCents == null || balanceCents.compareTo(BigDecimal.ZERO) < 0) {
      throw new InvalidWalletDataException("balance can't be less than zero");
    }
    this.balanceCents = balanceCents;
  }

  public void setCreditLimitCents(BigDecimal creditLimitCents) {
    if (creditLimitCents == null || creditLimitCents.compareTo(BigDecimal.ZERO) < 0) {
      throw new InvalidWalletDataException("credit limit can not be null or negative");
    }
    this.creditLimitCents = creditLimitCents;
  }

  public void setCurrency(String currency) {
    if (currency == null || currency.trim().isEmpty()) {
      throw new InvalidWalletDataException("currency can't be null or empty");
    }
    this.currency = currency;
  }

  public void setStatus(AccountStatus status) {
    if (status == null) {
      throw new InvalidWalletDataException("status can't be null");
    }

    this.status = status;
  }

}
