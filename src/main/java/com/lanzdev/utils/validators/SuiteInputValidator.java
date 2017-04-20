package com.lanzdev.utils.validators;

import java.util.regex.Pattern;

public class SuiteInputValidator {

    public static boolean validate(Integer createdBy, String privacy) {

        return validateCreatedBy(createdBy) && validatePrivacy(privacy);
    }

    private static boolean validateCreatedBy(Integer createdBy) {

        return (createdBy != null && createdBy > 0);
    }

    private static boolean validatePrivacy(String privacy) {

        if (privacy == null || privacy.equals("")) {
            return false;
        }
        return Pattern.matches(Regex.PRIVACY.getExpression(), privacy);
    }
}
