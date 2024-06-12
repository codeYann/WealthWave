package com.codeyan.WealthWave.core.repositories;

import com.codeyan.WealthWave.core.entities.account.BusinessAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessAccountRepository
        extends JpaRepository<BusinessAccount, Long> {
    BusinessAccount save(BusinessAccount account);
}
