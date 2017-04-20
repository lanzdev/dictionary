package com.lanzdev.utils.validators;

import java.util.regex.Pattern;

public class DefinitionInputValidator {

    public static boolean validate(String definition, Integer termId) {
        return validateDefinition(definition) && validateTermId(termId);
    }

    private static boolean validateDefinition(String definition) {

        if (definition == null || definition.equals("")) {
            return false;
        }
        return Pattern.matches(Regex.DEFINITION.getExpression(), definition);
    }

    private static boolean validateTermId(Integer termId) {

        return (termId != null && termId > 0);
    }
}
