package com.lanzdev.utils.validators;

import java.util.regex.Pattern;

public class TermInputValidator {

    public static boolean validate(String origin) {

        if (origin == null) {
            return false;
        }
        return Pattern.matches(Regex.ORIGIN.getExpression(), origin);
    }
}
