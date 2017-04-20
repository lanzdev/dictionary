package com.lanzdev.commands;

import com.lanzdev.commands.entity.term.AddTermCommand;
import com.lanzdev.commands.entity.term.ListTermCommand;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {

    private static final Logger LOGGER = Logger.getLogger(CommandInvoker.class);

    private static final Map<String, CommandCreator> commands = new HashMap<>();

    static {
        commands.put("AddTerm", AddTermCommand::new);
        commands.put("ListTerm", ListTermCommand::new);
        commands.put("UnknownCommand", UnknownCommand::new);
    }

    public static FrontCommand getCommand(String commandName) {

        LOGGER.debug("Entering getCommand(commandName = " + commandName + ")");

        FrontCommand command;
        if (commandName == null) {
            LOGGER.warn("getCommand() input value is null.");
            command = commands.get("UnknownCommand").create();
        } else if (!commands.containsKey(commandName)){
            LOGGER.warn("getCommand() cannot find command with such name: "
                    + commandName);
            command = commands.get("UnknownCommand").create();
        } else {
            command = commands.get(commandName).create();
        }

        LOGGER.debug("Leaving getCommand(): " + command.getClass());
        return command;
    }
}
