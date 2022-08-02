package org.example.processors;

import org.example.model.ProcessorResult;

import javax.servlet.http.HttpServletRequest;

public class ProcessorShowAllStudents extends Processor {
    public ProcessorShowAllStudents() {
        actionToPerform = "showAllStudents";
    }

    @Override
    public ProcessorResult process(HttpServletRequest request) {

        request.getSession().setAttribute("studentList", sc.getStudentList());
        request.getSession().setAttribute("student", null);

        return new ProcessorResult("pages/template.jsp", "showAllStudents.jsp", true);
    }
}
