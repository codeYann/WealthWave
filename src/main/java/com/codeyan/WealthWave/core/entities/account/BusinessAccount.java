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
@Table(name = "business_account")
@Getter
public class BusinessAccount implements Serializable {
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

  @Column(length = 50, nullable = false)
  private String companyName;

  @Column(length = 14, nullable = false)
  private String cnpj;

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

  public BusinessAccount() {

  }

  public BusinessAccount(String companyName, String cnpj, Wallet wallet) {
    setPublicId(UUID.randomUUID());
    setAccountType(AccountType.LEGAL_ENTITY);
    setStatus(AccountStatus.ACTIVE);
    setCompanyName(companyName);
    setCnpj(cnpj);
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

  public void setCompanyName(String companyName) {
    if (companyName == null || companyName.trim().isEmpty()) {
      throw new InvalidAccountDataException("companyName is null or empty");
    }
    this.companyName = companyName;
  }

  public void setCnpj(String cnpj) {
    if (cnpj == null || cnpj.length() != 14) {
      throw new InvalidAccountDataException("cnpj is invalid");
    }
    this.cnpj = cnpj;
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
