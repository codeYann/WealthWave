package com.codeyan.WealthWave.application.cases.account.individual;

import com.codeyan.WealthWave.core.entities.account.IndividualAccount;
import com.codeyan.WealthWave.core.repositories.IndividualAccountRepository;
import com.codeyan.WealthWave.shared.core.UseCase;

public class CreateIndividualAccount implements UseCase<IndividualAccountDTO, IndividualAccount> {
    private IndividualAccountRepository repository;

    public CreateIndividualAccount(IndividualAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public IndividualAccount execute(IndividualAccountDTO account) {
        return new IndividualAccount();
    }
}
