package ru.fDrachen.domain.utility;

import java.util.Objects;

public class ValidationUtility {
    private ValidationUtility() {}

    public static void validateNotEmpty(String variableUnderValidation, String errorMessage) {
        if (Objects.isNull(variableUnderValidation) || variableUnderValidation.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
