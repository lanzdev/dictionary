package com.lanzdev.commands.entity.user;

import com.lanzdev.Path;
import com.lanzdev.commands.FrontCommand;
import com.lanzdev.controllers.managers.mysql.implementation.MySqlUserManager;
import com.lanzdev.model.entity.User;
import com.lanzdev.utils.validators.UserInputValidator;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddUserCommand extends FrontCommand {

    private static final Logger LOGGER = Logger.getLogger(AddUserCommand.class);

    @Override
    protected String doGet( ) {

        LOGGER.debug("Entering doGet()");

        checkOnErrors(LOGGER);

        LOGGER.debug("Leaving doGet()");

        return Path.FORWARD_TO_ADD_USER_FORM;
    }

    @Override
    protected String doPost( ) {

        LOGGER.debug("Entering doPost()");

        String path = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Date date = null;

        try {
            java.util.Date tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .parse(request.getParameter("date"));
            date = new Date(tempDate.getTime());
        } catch (ParseException e) {
            LOGGER.error("Cannot parse date");
        }

        boolean valid = UserInputValidator.validate(login, password, email, date);

        if (valid) {
            createUser(login, password, email, date);
            path = Path.REDIRECT_TO_VIEW_ADD_USER_FORM;
            LOGGER.info("Parameters are valid");
        } else {
            path = Path.REDIRECT_TO_VIEW_ADD_USER_FORM + "&error=NotValidParams";
            LOGGER.warn("Parameters have failed validation");
        }

        LOGGER.debug("Leaving doPost()");

        return path;
    }

    private void createUser(String login, String password, String email, Date date) {

        User object = new User();
        object.setLogin(login);
        object.setPassword(password);
        object.setEmail(email);
        object.setDate(date);
        object = new MySqlUserManager().add(object);
        if (object != null) {
            LOGGER.debug("User with id " + object.getId() + " was created");
        } else {
            LOGGER.warn("User wasn't created");
        }
    }
}
