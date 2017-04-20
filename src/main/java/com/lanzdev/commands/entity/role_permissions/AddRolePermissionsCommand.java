package com.lanzdev.commands.entity.role_permissions;

import com.lanzdev.Path;
import com.lanzdev.commands.FrontCommand;
import com.lanzdev.controllers.managers.mysql.implementation.MySqlRolePermissionsManager;
import com.lanzdev.model.entity.RolePermissions;
import com.lanzdev.utils.validators.RolePermissionsInputValidator;
import org.apache.log4j.Logger;

public class AddRolePermissionsCommand extends FrontCommand {

    private static final Logger LOGGER = Logger.getLogger(AddRolePermissionsCommand.class);

    @Override
    protected String doGet( ) {

        LOGGER.debug("Entering doGet()");

        checkOnErrors(LOGGER);

        LOGGER.debug("Leaving doGet()");

        return Path.FORWARD_TO_ADD_ROLE_PERMISSIONS_FORM;
    }

    @Override
    protected String doPost( ) {

        LOGGER.debug("Entering doPost()");

        String path = null;
        Integer roleId = Integer.parseInt(request.getParameter("role_id"));
        Integer permissionId = Integer.parseInt(request.getParameter("permission_id"));
        boolean valid = RolePermissionsInputValidator.validate(roleId, permissionId);

        if (valid) {
            createRolePermissions(roleId, permissionId);
            path = Path.REDIRECT_TO_VIEW_ADD_ROLE_PERMISSIONS_FORM;
            LOGGER.info("Parameters are valid");
        } else {
            path = Path.REDIRECT_TO_VIEW_ADD_ROLE_PERMISSIONS_FORM + "&error=NotValidParam";
            LOGGER.warn("Parameters have failed validation");
        }

        LOGGER.debug("Leaving doPost()");

        return path;
    }

    private void createRolePermissions(Integer roleId, Integer permissionId) {

        RolePermissions object = new RolePermissions();
        object.setRoleId(roleId);
        object.setPermissionId(permissionId);
        object = new MySqlRolePermissionsManager().add(object);
        if (object != null) {
            LOGGER.debug("Role permissions with id " + object.getId() + " was created");
        } else {
            LOGGER.warn("Role permissions wasn't created");
        }

    }
}
