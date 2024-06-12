package com.codeyan.WealthWave.core.repositories;

import com.codeyan.WealthWave.core.entities.account.IndividualAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualAccountRepository
        extends JpaRepository<IndividualAccount, Long> {
    IndividualAccount save(IndividualAccount account);
}
