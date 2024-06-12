package com.codeyan.WealthWave.shared.core;

@FunctionalInterface
public interface UseCase<I, O> {
    O execute(I input);
}
