package com.codeyan.WealthWave.core.exceptions;

public class InvalidTransactionDataException extends RuntimeException {
    public InvalidTransactionDataException(String message) {
        super(message);
    }
}
