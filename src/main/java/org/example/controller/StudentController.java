package org.example.controller;

import org.example.dao.DBFactory;
import org.example.dao.enums.DBType;
import org.example.dao.interfaces.DAOAccess;
import org.example.model.Student;
import java.util.List;

public class StudentController {
    DBFactory factory = DBFactory.getDBFactory(DBType.ORACLE);
    protected final DAOAccess dao =  factory.getDAO();
    protected List<Student> studentList;

    public List<Student> getStudentList() {
        studentList = dao.getStudentList();
        return studentList;
    }

    public Student getStudent(int id) {
        return dao.getStudent(id);
    }

    public void insertStudent(Student student) {
        dao.insertStudent(student);
    }

    public void updateStudent(Student student) {
        dao.updateStudent(student);
    }

    public void deleteStudent(int id) {
        dao.deleteStudent(id);
    }
}
