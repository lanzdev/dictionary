package com.lanzdev;

import com.lanzdev.commands.CommandInvoker;
import com.lanzdev.commands.FrontCommand;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controller", urlPatterns = "/controller")
public class FrontController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(FrontController.class);

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        process(request, response, ActionType.POST);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        process(request, response, ActionType.GET);
    }

    private void process(HttpServletRequest request, HttpServletResponse response,
                         ActionType actionType) throws ServletException, IOException {

        LOGGER.debug("Entering execute(request, response, actionType = " + actionType + ")");

        FrontCommand command = getCommand(request);
        command.init(getServletContext(), request, response, actionType);

        String path = command.execute();

        if (path == null) {
            LOGGER.warn("Path is null.");
            LOGGER.debug("Redirecting to " + Path.WELCOME_PAGE);
            response.sendRedirect(Path.WELCOME_PAGE);
        } else if (actionType == ActionType.GET){
            LOGGER.debug("Forwarding to " + path);
            RequestDispatcher disp = request.getRequestDispatcher(path);
            disp.forward(request, response);
        } else {
            LOGGER.debug("Redirecting to " + path);
            response.sendRedirect(path);
        }
    }

    private FrontCommand getCommand(HttpServletRequest request) {

        String commandName = request.getParameter("command");
        return CommandInvoker.getCommand(commandName);
    }
}
