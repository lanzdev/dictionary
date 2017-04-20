package com.lanzdev.commands.entity.antonym;

import com.lanzdev.Path;
import com.lanzdev.commands.FrontCommand;
import com.lanzdev.controllers.managers.mysql.implementation.MySqlAntonymManager;
import com.lanzdev.model.entity.Antonym;
import com.lanzdev.utils.validators.AntonymInputValidator;
import org.apache.log4j.Logger;

public class AddAntonymCommand extends FrontCommand {

    private static final Logger LOGGER = Logger.getLogger(AddAntonymCommand.class);

    @Override
    protected String doGet( ) {

        LOGGER.debug("Entering doGet()");

        checkOnErrors(LOGGER);

        LOGGER.debug("Leaving doGet()");
        return Path.FORWARD_TO_ADD_ANTONYM_FORM;
    }

    @Override
    protected String doPost( ) {

        LOGGER.debug("Entering doPost()");

        String path = null;
        String antonym = request.getParameter("antonym");
        Integer termId = Integer.parseInt(request.getParameter("term_id"));
        boolean valid = AntonymInputValidator.validate(antonym, termId);

        if (valid) {
            createAntonym(antonym, termId);
            path = Path.REDIRECT_TO_VIEW_ADD_ANTONYM_FORM;
            LOGGER.info("Parameters are valid");
        } else {
            path = Path.REDIRECT_TO_VIEW_ADD_ANTONYM_FORM + "&error=notValidParams";
            LOGGER.warn("Parameters have failed validation");
        }

        LOGGER.debug("Leaving doPost()");
        return path;
    }

    private void createAntonym(String antonym, Integer termId) {

        Antonym object = new Antonym();
        object.setAntonym(antonym);
        object.setTermId(termId);
        object = new MySqlAntonymManager().add(object);
        if (object != null) {
            LOGGER.debug("Antonym with id " + object.getId() + " was created");
        } else {
            LOGGER.warn("Antonym wasn't created");
        }

    }
}
