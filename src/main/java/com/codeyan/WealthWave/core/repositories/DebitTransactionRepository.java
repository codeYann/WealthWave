package com.codeyan.WealthWave.core.repositories;

import com.codeyan.WealthWave.core.entities.transaction.DebitTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebitTransactionRepository
        extends JpaRepository<DebitTransaction, Long> {
    DebitTransaction save(DebitTransaction transaction);
}
