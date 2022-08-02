package org.example.processors;

import org.example.model.ProcessorResult;
import org.example.model.Student;

import javax.servlet.http.HttpServletRequest;

public class ProcessorSaveStudent extends Processor {
    public ProcessorSaveStudent() {
        actionToPerform = "saveStudent";
    }

    @Override
    public ProcessorResult process(HttpServletRequest request) {
        Student student = (Student) request.getSession().getAttribute("student");
        String name = request.getParameter("nameInput");
        int age = Integer.parseInt(request.getParameter("ageInput"));
        String group = request.getParameter("groupInput");
        if (student == null) {
            int id = Integer.parseInt(request.getParameter("idInput"));
            student = new Student(id, name, age, group);
            sc.insertStudent(student);
        }
        else {
            student.setName(name);
            student.setAge(age);
            student.setGroup(group);
            sc.updateStudent(student);
        }

        request.getSession().setAttribute("student", null);
        request.getSession().setAttribute("studentList", sc.getStudentList());

        return new ProcessorResult("pages/template.jsp", "showAllStudents.jsp", false);
    }
}
