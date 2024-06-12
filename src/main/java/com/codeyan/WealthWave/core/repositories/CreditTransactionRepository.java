package com.codeyan.WealthWave.core.repositories;

import com.codeyan.WealthWave.core.entities.transaction.CreditTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditTransactionRepository
        extends JpaRepository<CreditTransaction, Long> {
    CreditTransaction save(CreditTransaction transaction);
}
