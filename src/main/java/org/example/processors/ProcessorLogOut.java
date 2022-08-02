package org.example.processors;

import org.example.dao.oracle.OracleFactory;
import org.example.model.ProcessorResult;

import javax.servlet.http.HttpServletRequest;

public class ProcessorLogOut extends Processor {
    public ProcessorLogOut() {
        actionToPerform = "logOut";
    }

    @Override
    public ProcessorResult process(HttpServletRequest request) {
        OracleFactory.disconnect();
        return new ProcessorResult("pages/welcome.jsp", null, false);
    }
}
