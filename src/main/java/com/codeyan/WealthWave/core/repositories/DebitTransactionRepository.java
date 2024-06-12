package com.codeyan.WealthWave.Core.repositories;

import com.codeyan.WealthWave.Core.entities.transaction.DebitTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebitTransactionRepository
        extends JpaRepository<DebitTransaction, Long> {
    DebitTransaction save(DebitTransaction transaction);
}
