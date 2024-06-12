package com.codeyan.WealthWave.Core.repositories;

import com.codeyan.WealthWave.Core.entities.transaction.CreditTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditTransactionRepository
        extends JpaRepository<CreditTransaction, Long> {
    CreditTransaction save(CreditTransaction transaction);
}
