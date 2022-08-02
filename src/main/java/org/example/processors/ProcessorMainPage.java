package org.example.processors;

import org.example.dao.oracle.OracleFactory;
import org.example.model.ProcessorResult;

import javax.servlet.http.HttpServletRequest;

public class ProcessorMainPage extends Processor {
    public ProcessorMainPage() {
        actionToPerform = "mainPage";
    }

    @Override
    public ProcessorResult process(HttpServletRequest request) {
        String user = request.getParameter("username");
        request.getSession().setAttribute("username", user);
        OracleFactory.connect();
        return new ProcessorResult("pages/template.jsp", null, true);
    }
}
