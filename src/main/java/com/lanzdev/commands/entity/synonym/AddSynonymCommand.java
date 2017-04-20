package com.lanzdev.commands.entity.synonym;

import com.lanzdev.Path;
import com.lanzdev.commands.FrontCommand;
import com.lanzdev.controllers.managers.mysql.implementation.MySqlSynonymManager;
import com.lanzdev.model.entity.Synonym;
import com.lanzdev.utils.validators.SynonymInputValidator;
import org.apache.log4j.Logger;

public class AddSynonymCommand extends FrontCommand {

    private static final Logger LOGGER = Logger.getLogger(AddSynonymCommand.class);

    @Override
    protected String doGet( ) {

        LOGGER.debug("Entering doGet()");

        checkOnErrors(LOGGER);

        LOGGER.debug("Leaving doGet()");

        return Path.FORWARD_TO_ADD_SYNONYM_FORM;
    }

    @Override
    protected String doPost( ) {

        LOGGER.debug("Entering doPost()");

        String path = null;
        String synonym = request.getParameter("synonym");
        Integer termId = Integer.parseInt(request.getParameter("term_id"));
        boolean valid = SynonymInputValidator.validate(synonym, termId);

        if (valid) {
            createSynonym(synonym, termId);
            path = Path.REDIRECT_TO_VIEW_ADD_SYNONYM_FORM;
            LOGGER.info("Parameters are valid");
        } else {
            path = Path.REDIRECT_TO_VIEW_ADD_SYNONYM_FORM + "&error=NotValidParams";
            LOGGER.warn("Parameters have failed validation");
        }

        LOGGER.debug("Leaving doPost()");

        return path;
    }

    private void createSynonym(String synonym, Integer termId) {

        Synonym object = new Synonym();
        object.setSynonym(synonym);
        object.setTermId(termId);
        object = new MySqlSynonymManager().add(object);
        if (object != null) {
            LOGGER.debug("Synonym with id " + object.getId() + " was created");
        } else {
            LOGGER.warn("Synonym wasn't created");
        }
    }
}
