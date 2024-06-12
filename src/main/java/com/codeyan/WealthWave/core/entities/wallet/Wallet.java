package com.codeyan.WealthWave.Core.entities.wallet;

import com.codeyan.WealthWave.Core.entities.account.AccountStatus;
import com.codeyan.WealthWave.Core.entities.account.BusinessAccount;
import com.codeyan.WealthWave.Core.entities.account.IndividualAccount;
import com.codeyan.WealthWave.Core.entities.transaction.CreditTransaction;
import com.codeyan.WealthWave.Core.entities.transaction.DebitTransaction;
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
@Setter
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

  @CreationTimestamp
  @Column(name = "last_transaction_at")
  private Date lastTransactionAt;

  @OneToOne
  @JoinColumn(unique = true, name = "business_account_id")
  private BusinessAccount businessAccount;

  @OneToOne
  @JoinColumn(unique = true, name = "individual_account_id")
  private IndividualAccount individualAccount;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false)
  private Date createdAt;

  @OneToMany(mappedBy = "wallet")
  private List<DebitTransaction> debitTransactions;

  @OneToMany(mappedBy = "wallet")
  private List<CreditTransaction> creditTransactions;

  @Column(name = "updated_at")
  private Date updatedAt;
}
