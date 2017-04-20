package com.lanzdev.utils.validators;

import java.util.regex.Pattern;

public class RoleInputValidator {

    public static boolean validate(String role) {
        return validateRole(role);
    }

    private static boolean validateRole(String role) {

        if (role == null || role.equals("")) {
            return false;
        }
        return Pattern.matches(Regex.ROLE.getExpression(), role);
    }
}
