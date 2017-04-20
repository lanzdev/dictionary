package com.lanzdev.commands.entity.permission;

import com.lanzdev.Path;
import com.lanzdev.commands.FrontCommand;
import com.lanzdev.controllers.managers.mysql.implementation.MySqlPermissionManager;
import com.lanzdev.model.entity.Permission;
import com.lanzdev.utils.validators.PermissionInputValidator;
import org.apache.log4j.Logger;

public class AddPermissionCommand extends FrontCommand {

    private static final Logger LOGGER = Logger.getLogger(AddPermissionCommand.class);

    @Override
    protected String doGet( ) {

        LOGGER.debug("Entering doGet()");

        checkOnErrors(LOGGER);

        LOGGER.debug("Leaving doGet()");

        return Path.FORWARD_TO_ADD_PERMISSION_FORM;
    }

    @Override
    protected String doPost( ) {

        LOGGER.debug("Entering doPost()");

        String path = null;
        String permission = request.getParameter("permission");
        boolean valid = PermissionInputValidator.validate(permission);

        if (valid) {
            createPermission(permission);
            path = Path.REDIRECT_TO_VIEW_ADD_PERMISSION_FORM;
            LOGGER.info("Parameters are valid");
        } else {
            path = Path.REDIRECT_TO_VIEW_ADD_DEFINITION_FORM + "&error=NotValidParams";
            LOGGER.warn("Parameters have failed validation");
        }

        LOGGER.debug("Leaving doPost()");

        return path;
    }

    private void createPermission(String permission) {

        Permission object = new Permission();
        object.setPermission(permission);
        object = new MySqlPermissionManager().add(object);
        if (object != null) {
            LOGGER.debug("Permission with id " + object.getId() + " was created");
        } else {
            LOGGER.warn("Permission wasn't created");
        }
    }
}
