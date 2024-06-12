package com.codeyan.WealthWave.core.entities.account;

import com.codeyan.WealthWave.core.entities.user.User;
import com.codeyan.WealthWave.core.entities.wallet.Wallet;
import com.codeyan.WealthWave.core.exceptions.InvalidAccountDataException;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "individual_account")
@Getter
public class IndividualAccount implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Setter
  @Column(unique = true, nullable = false)
  private UUID publicId;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private AccountType accountType;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private AccountStatus status;

  @Column(length = 11, nullable = false)
  private String cpf;

  @OneToOne
  @JoinColumn(unique = true, name = "wallet_id")
  private Wallet wallet;

  @OneToOne
  @JoinColumn(unique = true, name = "user_id")
  private User user;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false)
  private Date createdAt;

  @Column(name = "updated_at")
  private Date updatedAt;

  public IndividualAccount() {

  }

  public IndividualAccount(String cpf, Wallet wallet) {
    setPublicId(UUID.randomUUID());
    setAccountType(AccountType.PAYMENT);
    setStatus(AccountStatus.ACTIVE);
    setCpf(cpf);
    setWallet(wallet);
  }

  public void setAccountType(AccountType accountType) {
    if (accountType == null) {
      throw new InvalidAccountDataException("accountType is null");
    }
    this.accountType = accountType;
  }

  public void setStatus(AccountStatus status) {
    if (status == null) {
      throw new InvalidAccountDataException("accountStatus is null");
    }
    this.status = status;
  }

  public void setCpf(String cpf) {
    if (cpf == null || cpf.length() != 11) {
      throw new InvalidAccountDataException("CPF should be 11 digits");
    }
    this.cpf = cpf;
  }

  public void setWallet(Wallet wallet) {
    if (wallet == null) {
      throw new InvalidAccountDataException("wallet is null");
    }
    this.wallet = wallet;
  }

  public void setUser(User user) {
    if (user == null) {
      throw new InvalidAccountDataException("user is null");
    }
    this.user = user;
  }
}
