package com.lanzdev;

import com.lanzdev.model.entity.Term;
import org.apache.struts.mock.MockServletConfig;
import org.apache.struts.mock.MockServletContext;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;


public class FrontControllerTest extends Mockito {

    private int counter = 100;

    @Test
    public void createTerms( ) throws ServletException, IOException {

        HttpServletRequest  request  = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        MockServletContext context = new MockServletContext();
        MockServletConfig  config  = new MockServletConfig(context);
        FrontController     fc = new FrontController();
        fc.init(config);

        while (counter-- > 0) {
            when(request.getParameter("command")).thenReturn("ListTerms");
//            when(request.getParameter("type")).thenReturn("Term");
            Term term = generateTerm();
//            when(request.getParameter("origin")).thenReturn(term.getOrigin());
            fc.doPost(request, response);

        }
    }

    public Term generateTerm( ) {

        Term term = new Term();
        term.setOrigin(generateOrigin());
        return term;
    }

    private String generateOrigin( ) {

        StringBuilder sb     = new StringBuilder();
        Random        random = new Random();

        int length = random.nextInt(15) + 1;

        while (length-- > 0) {
            sb.append((char) ('A' + random.nextInt('Z' - 'A' + 1)));
        }

        return sb.toString();
    }


}