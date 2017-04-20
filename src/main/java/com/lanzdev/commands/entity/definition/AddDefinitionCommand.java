package com.lanzdev.commands.entity.definition;

import com.lanzdev.Path;
import com.lanzdev.commands.FrontCommand;
import com.lanzdev.controllers.managers.mysql.implementation.MySqlDefinitionManager;
import com.lanzdev.model.entity.Definition;
import com.lanzdev.utils.validators.DefinitionInputValidator;
import org.apache.log4j.Logger;

public class AddDefinitionCommand extends FrontCommand {

    private static final Logger LOGGER = Logger.getLogger(AddDefinitionCommand.class);

    @Override
    protected String doGet( ) {

        LOGGER.debug("Entering doGet()");

        checkOnErrors(LOGGER);

        LOGGER.debug("Leaving doGet()");

        return Path.FORWARD_TO_ADD_DEFINITION_FORM;
    }

    @Override
    protected String doPost( ) {

        LOGGER.debug("Entering doPost()");

        String path = null;
        String definition = request.getParameter("definition");
        Integer termId = Integer.parseInt(request.getParameter("term_id"));
        boolean valid = DefinitionInputValidator.validate(definition, termId);

        if (valid) {
            createDefinition(definition, termId);
            path = Path.REDIRECT_TO_VIEW_ADD_DEFINITION_FORM;
            LOGGER.info("Parameters are valid");
        } else {
            path = Path.REDIRECT_TO_VIEW_ADD_DEFINITION_FORM + "&error=NotValidParams";
            LOGGER.warn("Parameters have failed validation");
        }

        LOGGER.debug("Leaving doPost()");
        return path;
    }

    private void createDefinition(String definition, Integer termId) {

        Definition object = new Definition();
        object.setDefinition(definition);
        object.setTermId(termId);
        object = new MySqlDefinitionManager().add(object);
        if (object != null) {
            LOGGER.debug("Definition with id " + object.getId() + " was created");
        } else {
            LOGGER.warn("Definition wasn't created");
        }
    }
}
