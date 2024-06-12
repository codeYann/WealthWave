package com.codeyan.WealthWave.application.cases.user;

import com.codeyan.WealthWave.core.entities.user.User;
import com.codeyan.WealthWave.shared.core.UseCase;

public class CreateUser implements UseCase<User, Exception> {


    @Override
    public Exception execute(User input) {
        return null;
    }
}
