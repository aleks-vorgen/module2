package org.example.dao.interfaces;

import org.example.model.Student;

import java.util.List;

public interface DAOAccess {
    //TODO рефактор названий методов и переменных под модель
    List<Student> getStudentList();
    Student getStudent(int id);
    void insertStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int id);
}
