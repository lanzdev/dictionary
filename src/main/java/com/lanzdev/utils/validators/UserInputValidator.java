package com.lanzdev.utils.validators;

import java.sql.Date;
import java.util.regex.Pattern;

public class UserInputValidator {

    public static boolean validate(String login, String password,
                                   String email, Date date) {

        return validateLogin(login) && validatePassword(password)
                && validateEmail(email) && validateDate(date);
    }

    private static boolean validateLogin(String login) {

        if (login == null || login.equals("")) {
            return false;
        }
        return Pattern.matches(Regex.LOGIN.getExpression(), login);
    }

    private static boolean validatePassword(String password) {

        if (password == null || password.equals("")) {
            return false;
        }
        return Pattern.matches(Regex.PASSWORD.getExpression(), password);
    }

    private static boolean validateEmail(String email) {

        if (email == null || email.equals("")) {
            return false;
        }
        return Pattern.matches(Regex.EMAIL.getExpression(), email);
    }

    private static boolean validateDate(Date date) {

        return date != null;
    }
}
