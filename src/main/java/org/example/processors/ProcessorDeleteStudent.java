package org.example.processors;

import org.example.model.ProcessorResult;

import javax.servlet.http.HttpServletRequest;

public class ProcessorDeleteStudent extends Processor {
    public ProcessorDeleteStudent() {
        actionToPerform = "deleteStudent";
    }

    @Override
    public ProcessorResult process(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        sc.deleteStudent(id);
        request.getSession().setAttribute("studentList", sc.getStudentList());
        return new ProcessorResult("pages/template.jsp", "showAllStudents.jsp", false);
    }
}
