package com.codeyan.WealthWave.core.repositories;

import com.codeyan.WealthWave.core.entities.wallet.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Wallet save(Wallet wallet);
}
