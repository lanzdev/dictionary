package com.lanzdev.commands.entity.term_suites;

import com.lanzdev.Path;
import com.lanzdev.commands.FrontCommand;
import com.lanzdev.controllers.managers.mysql.implementation.MySqlTermSuitesManager;
import com.lanzdev.model.entity.TermSuites;
import com.lanzdev.utils.validators.TermSuitesInputValidator;
import org.apache.log4j.Logger;

public class AddTermSuitesCommand extends FrontCommand {

    private static final Logger LOGGER = Logger.getLogger(AddTermSuitesCommand.class);

    @Override
    protected String doGet( ) {

        LOGGER.debug("Entering doGet()");

        checkOnErrors(LOGGER);

        LOGGER.debug("Leaving doGet()");

        return Path.FORWARD_TO_ADD_TERM_SUITES_FORM;
    }

    @Override
    protected String doPost( ) {

        LOGGER.debug("Entering doPost()");

        String path = null;
        Integer termId = Integer.parseInt(request.getParameter("term_id"));
        Integer suiteId = Integer.parseInt(request.getParameter("suite_id"));
        boolean valid = TermSuitesInputValidator.validate(termId, suiteId);

        if (valid) {
            createTermSuites(termId, suiteId);
            path = Path.REDIRECT_TO_VIEW_ADD_TERM_SUITES_FORM;
            LOGGER.info("Parameters are valid");
        } else {
            path = Path.REDIRECT_TO_VIEW_ADD_TERM_SUITES_FORM + "&error=NotValidParams";
            LOGGER.warn("Parameters have failed validation");
        }

        LOGGER.debug("Leaving doPost()");

        return path;
    }

    private void createTermSuites(Integer termId, Integer suiteId) {

        TermSuites object = new TermSuites();
        object.setTermId(termId);
        object.setSuiteId(suiteId);
        object = new MySqlTermSuitesManager().add(object);
        if (object != null) {
            LOGGER.debug("Term suites with id " + object.getId() + " was created");
        } else {
            LOGGER.warn("Term suites wasn't created");
        }
    }
}
