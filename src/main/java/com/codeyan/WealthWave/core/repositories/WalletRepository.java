package com.codeyan.WealthWave.Core.repositories;

import com.codeyan.WealthWave.Core.entities.wallet.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Wallet save(Wallet wallet);
}
