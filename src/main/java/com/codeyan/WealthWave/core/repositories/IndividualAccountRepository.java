package com.codeyan.WealthWave.Core.repositories;

import com.codeyan.WealthWave.Core.entities.account.IndividualAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualAccountRepository
        extends JpaRepository<IndividualAccount, Long> {
    IndividualAccount save(IndividualAccount account);
}
