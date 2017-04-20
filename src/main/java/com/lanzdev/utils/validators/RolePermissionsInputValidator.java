package com.lanzdev.utils.validators;

public class RolePermissionsInputValidator {

    public static boolean validate(Integer roleId, Integer permissionId) {

        return validateId(roleId) && validateId(permissionId);
    }

    private static boolean validateId(Integer id) {

        return (id != null && id > 0);
    }
}
