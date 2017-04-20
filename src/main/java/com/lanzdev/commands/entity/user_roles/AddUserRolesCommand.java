package com.lanzdev.commands.entity.user_roles;

import com.lanzdev.Path;
import com.lanzdev.commands.FrontCommand;
import com.lanzdev.controllers.managers.mysql.implementation.MySqlUserRolesManager;
import com.lanzdev.model.entity.UserRoles;
import com.lanzdev.utils.validators.UserRolesValidator;
import org.apache.log4j.Logger;

public class AddUserRolesCommand extends FrontCommand {

    private static final Logger LOGGER = Logger.getLogger(AddUserRolesCommand.class);

    @Override
    protected String doGet( ) {

        LOGGER.debug("Entering doGet()");

        checkOnErrors(LOGGER);

        LOGGER.debug("Leaving doGet()");

        return Path.FORWARD_TO_ADD_USER_ROLES_FORM;
    }

    @Override
    protected String doPost( ) {

        LOGGER.debug("Entering doPost()");

        String path = null;
        Integer userId = Integer.parseInt(request.getParameter("user_id"));
        Integer roleId = Integer.parseInt(request.getParameter("role_id"));

        boolean valid = UserRolesValidator.validate(userId, roleId);

        if (valid) {
            createUserRoles(userId, roleId);
            path = Path.REDIRECT_TO_VIEW_ADD_USER_ROLES_FORM;
            LOGGER.info("Parameters are valid");
        } else {
            path = Path.REDIRECT_TO_VIEW_ADD_USER_ROLES_FORM + "&error=NotValidParams";
            LOGGER.warn("Parameters have failed validation");
        }

        LOGGER.debug("Leaving doPost()");

        return path;
    }

    private void createUserRoles(Integer userId, Integer roleId) {

        UserRoles object = new UserRoles();
        object.setUserId(userId);
        object.setRoleId(roleId);
        object = new MySqlUserRolesManager().add(object);
        if (object != null) {
            LOGGER.debug("User roles with id " + object.getId() + " was created");
        } else {
            LOGGER.warn("User wasn't created");
        }
    }
}
