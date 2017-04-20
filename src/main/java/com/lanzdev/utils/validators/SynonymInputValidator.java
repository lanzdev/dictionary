package com.lanzdev.utils.validators;

import java.util.regex.Pattern;

public class SynonymInputValidator {

    public static boolean validate(String synonym, Integer termId) {

        return validateSynonym(synonym) && validateTermId(termId);
    }

    private static boolean validateSynonym(String synonym) {

        if (synonym == null || synonym.equals("")) {
            return false;
        }
        return Pattern.matches(Regex.SYNONYM.getExpression(), synonym);
    }

    private static boolean validateTermId(Integer termId) {

        return (termId != null && termId > 0);
    }
}
