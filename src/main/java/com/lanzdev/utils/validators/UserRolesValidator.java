package com.lanzdev.utils.validators;

public class UserRolesValidator {

    public static boolean validate(Integer userId, Integer roleId) {

        return validateId(userId) && validateId(roleId);
    }

    private static boolean validateId(Integer id) {

        return (id != null && id > 0);
    }
}
