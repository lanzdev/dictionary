package com.lanzdev.utils.validators;

import java.util.regex.Pattern;

public class PermissionInputValidator {

    public static boolean validate(String permission) {

        return validatePermission(permission);
    }

    private static boolean validatePermission(String permission) {

        if (permission == null || permission.equals("")) {
            return false;
        }
        return Pattern.matches(Regex.PERMISSION.getExpression(), permission);
    }
}
