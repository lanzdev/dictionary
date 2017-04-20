package com.lanzdev.commands.entity.term;

import com.lanzdev.Path;
import com.lanzdev.commands.FrontCommand;
import com.lanzdev.controllers.managers.entity.TermManager;
import com.lanzdev.controllers.managers.mysql.implementation.MySqlTermManager;
import com.lanzdev.model.entity.Term;
import org.apache.log4j.Logger;

import java.util.List;

public class ListTermCommand extends FrontCommand {

    private static final Logger LOGGER = Logger.getLogger(ListTermCommand.class);

    @Override
    protected String doGet( ) {

        LOGGER.debug("Entering doGet()");
        String path = null;
        TermManager manager = new MySqlTermManager();
        List<Term> terms = manager.getAll();
        if (terms != null) {
            request.setAttribute("terms", terms);
            LOGGER.debug("Added list with " + terms.size()
                    + " elements into request attribute as 'terms'");
            path = Path.FORWARD_TO_VIEW_TERM_LIST;
        } else {
            LOGGER.warn("terms list is null");
            path = Path.WELCOME_PAGE;
        }
        LOGGER.debug("Leaving doGet()");

        return path;
    }

    @Override
    protected String doPost( ) {

        LOGGER.debug("Entering doPost()");
        LOGGER.debug("Leaving doPost()");
        return Path.WELCOME_PAGE;
    }
}
