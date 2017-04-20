package com.lanzdev.utils.validators;

public class TermSuitesInputValidator {

    public static boolean validate(Integer termId, Integer suiteId) {

        return validateId(termId) & validateId(suiteId);
    }

    private static boolean validateId(Integer id) {

        return (id != null && id > 0);
    }
}
