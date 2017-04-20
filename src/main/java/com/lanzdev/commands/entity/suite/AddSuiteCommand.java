package com.lanzdev.commands.entity.suite;

import com.lanzdev.Path;
import com.lanzdev.commands.FrontCommand;
import com.lanzdev.controllers.managers.mysql.implementation.MySqlSuiteManager;
import com.lanzdev.model.entity.Suite;
import com.lanzdev.utils.validators.SuiteInputValidator;
import org.apache.log4j.Logger;

public class AddSuiteCommand extends FrontCommand{

    private static final Logger LOGGER = Logger.getLogger(AddSuiteCommand.class);

    @Override
    protected String doGet( ) {

        LOGGER.debug("Entering doGet()");

        checkOnErrors(LOGGER);

        LOGGER.debug("Leaving doGet()");

        return Path.FORWARD_TO_ADD_SUITE_FORM;
    }

    @Override
    protected String doPost( ) {

        LOGGER.debug("Entering doPost()");

        String path = null;
        Integer createdBy = Integer.parseInt(request.getParameter("created_by"));
        String privacy = request.getParameter("privacy");
        boolean valid = SuiteInputValidator.validate(createdBy, privacy);

        if (valid) {
            createSuite(createdBy, privacy);
            path = Path.REDIRECT_TO_VIEW_ADD_SUITE_FORM;
            LOGGER.info("Parameters are valid");
        } else {
            path = Path.REDIRECT_TO_VIEW_ADD_SUITE_FORM + "&error=NotValidParams";
            LOGGER.warn("Parameters have failed validation");
        }

        LOGGER.debug("Leaving doPost()");

        return path;
    }

    private void createSuite(Integer createdBy, String privacy) {

        Suite object = new Suite();
        object.setCreatedBy(createdBy);
        object.setPrivacy(privacy);
        object = new MySqlSuiteManager().add(object);
        if (object != null) {
            LOGGER.debug("Role with id " + object.getId() + " was created");
        } else {
            LOGGER.warn("Role wasn't created");
        }
    }
}
