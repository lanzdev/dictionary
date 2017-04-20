package com.lanzdev.utils.validators;

import java.util.regex.Pattern;

public class AntonymInputValidator  {

    public static boolean validate(String antonym, Integer termId) {

        return validateAntonym(antonym) && validateTermId(termId);
    }

    private static boolean validateAntonym(String antonym) {

        if (antonym == null && antonym.equals("")) {
            return false;
        }
        return Pattern.matches(Regex.ANTONYM.getExpression(), antonym);
    }

    private static boolean validateTermId(Integer termId) {

        return (termId != null && termId > 0);
    }
}
