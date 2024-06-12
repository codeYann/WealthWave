package com.codeyan.WealthWave.Core.entities.account;

import com.codeyan.WealthWave.Core.entities.user.User;
import com.codeyan.WealthWave.Core.entities.wallet.Wallet;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "business_account")
@Getter
@Setter
public class BusinessAccount implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

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
}