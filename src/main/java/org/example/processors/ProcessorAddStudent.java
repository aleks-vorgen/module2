package org.example.processors;

import org.example.model.ProcessorResult;

import javax.servlet.http.HttpServletRequest;

public class ProcessorAddStudent extends Processor {
    public ProcessorAddStudent() {
        actionToPerform = "addStudent";
    }

    @Override
    public ProcessorResult process(HttpServletRequest request) {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            int id;
            id = Integer.parseInt(request.getParameter("id"));
            request.getSession().setAttribute("student", sc.getStudent(id));
        }

        return new ProcessorResult("pages/template.jsp", "addStudent.jsp", true);
    }
}
