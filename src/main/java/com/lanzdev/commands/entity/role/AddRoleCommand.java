package com.lanzdev.commands.entity.role;

import com.lanzdev.Path;
import com.lanzdev.commands.FrontCommand;
import com.lanzdev.controllers.managers.mysql.implementation.MySqlRoleManager;
import com.lanzdev.model.entity.Role;
import com.lanzdev.utils.validators.RoleInputValidator;
import org.apache.log4j.Logger;

public class AddRoleCommand extends FrontCommand {

    private static final Logger LOGGER = Logger.getLogger(AddRoleCommand.class);

    @Override
    protected String doGet( ) {

        LOGGER.debug("Entering doGet()");

        checkOnErrors(LOGGER);

        LOGGER.debug("Leaving doGet()");

        return Path.FORWARD_TO_ADD_ROLE_FORM;
    }

    @Override
    protected String doPost( ) {

        LOGGER.debug("Entering doPost()");

        String path = null;
        String role = request.getParameter("role");
        boolean valid = RoleInputValidator.validate(role);

        if (valid) {
            createRole(role);
            path = Path.REDIRECT_TO_VIEW_ADD_ROLE_FORM;
            LOGGER.info("Parameters are valid");
        } else {
            path = Path.REDIRECT_TO_VIEW_ADD_ROLE_FORM + "&error=NotValidParams";
            LOGGER.warn("Parameters have failed validation");
        }

        LOGGER.debug("Leaving doPost()");

        return path;
    }

    private void createRole(String role) {

        Role object = new Role();
        object.setRole(role);
        object = new MySqlRoleManager().add(object);
        if (object != null) {
            LOGGER.debug("Role with id " + object.getId() + " + was created");
        } else {
            LOGGER.warn("Role wasn't created");
        }
    }
}
