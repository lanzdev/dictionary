package com.lanzdev.commands.entity.term;

import com.lanzdev.Path;
import com.lanzdev.commands.FrontCommand;
import com.lanzdev.controllers.managers.mysql.implementation.MySqlTermManager;
import com.lanzdev.model.entity.Term;
import com.lanzdev.utils.validators.TermInputValidator;
import org.apache.log4j.Logger;

public class AddTermCommand extends FrontCommand {

    private static final Logger LOGGER = Logger.getLogger(AddTermCommand.class);

    protected String doGet( ) {

        LOGGER.debug("Entering doGet()");

        checkOnErrors(LOGGER);

        LOGGER.debug("Leaving doGet()");

        return Path.FORWARD_TO_ADD_TERM_FORM;
    }

    protected String doPost( ) {

        LOGGER.debug("Entering doPost()");

        String path = null;
        String origin = request.getParameter("origin");
        boolean valid = TermInputValidator.validate(origin);

        if (valid) {
            createTerm(origin);
            path = Path.REDIRECT_TO_VIEW_ADD_TERM_FORM;
            LOGGER.info("Parameters are valid");
        } else {
            path = Path.REDIRECT_TO_VIEW_ADD_TERM_FORM + "&error=NotValidParams";
            LOGGER.warn("Parameters have failed validation");
        }

        LOGGER.debug("Leaving doPost()");
        return path;
    }

    private void createTerm(String origin) {

        Term object = new Term();
        object.setOrigin(origin);
        object = new MySqlTermManager().add(object);
        if (object != null) {
            LOGGER.debug("Term with id " + object.getId() + " was created");
        } else {
            LOGGER.warn("Term wasn't created");
        }
    }
}
