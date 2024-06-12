package com.codeyan.WealthWave.Core.repositories;

import com.codeyan.WealthWave.Core.entities.account.BusinessAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessAccountRepository
        extends JpaRepository<BusinessAccount, Long> {
    BusinessAccount save(BusinessAccount account);
}
