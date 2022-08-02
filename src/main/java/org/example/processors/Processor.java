package org.example.processors;

import org.example.controller.StudentController;
import org.example.model.ProcessorResult;

import javax.servlet.http.HttpServletRequest;

public abstract class Processor {
    protected StudentController sc = new StudentController();
    protected String actionToPerform = null;

    public boolean canProcess(String action) {
        return actionToPerform.equals(action);
    }

    public abstract ProcessorResult process(HttpServletRequest request);
}
