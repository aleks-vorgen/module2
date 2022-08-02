package org.example.dao.oracle;

import org.example.dao.interfaces.DAOAccess;
import org.example.model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleDAOImpl implements DAOAccess {
    private static final String GET_STUDENT_LIST = "SELECT * FROM STUDENTS ORDER BY STUDENT_ID";
    private static final String GET_STUDENT = "SELECT * FROM STUDENTS WHERE STUDENT_ID = :1";
    private static final String DELETE_STUDENT = "DELETE STUDENTS WHERE STUDENT_ID = :1";
    private static final String INSERT_STUDENT = "INSERT INTO STUDENTS VALUES (:1, :2, :3, :4)";
    private static final String UPDATE_STUDENT =
            "UPDATE STUDENTS" +
            " SET STUDENT_NAME = :1," +
            " STUDENT_AGE = :2, STUDENT_GROUP = :3" +
            " WHERE STUDENT_ID = :4";

    @Override
    public List<Student> getStudentList() {
        List<Student> studentList = new ArrayList<>();
        try (PreparedStatement ps = OracleFactory.connect()
                .prepareStatement(GET_STUDENT_LIST)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                studentList.add(parseStudent(rs));
            }
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return studentList;
    }

    @Override
    public Student getStudent(int id) {
        Student student = null;

        try (PreparedStatement ps = OracleFactory.connect()
                .prepareStatement(GET_STUDENT)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                student = parseStudent(rs);
            }
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return student;
    }

    @Override
    public void insertStudent(Student student) {
        try (PreparedStatement ps = OracleFactory.connect()
                .prepareStatement(INSERT_STUDENT)) {

            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getGroup());

            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Student student) {
        try (PreparedStatement ps = OracleFactory.connect()
                .prepareStatement(UPDATE_STUDENT)) {

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getGroup());
            ps.setInt(4, student.getId());

            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int id) {
        try (PreparedStatement ps = OracleFactory.connect()
                .prepareStatement(DELETE_STUDENT)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private Student parseStudent(ResultSet rs) {
        Student student = null;

        try {
            int id = rs.getInt("STUDENT_ID");
            String name = rs.getString("STUDENT_NAME");
            int age = rs.getInt("STUDENT_AGE");
            String group = rs.getString("STUDENT_GROUP");

            student = new Student(id, name, age, group);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return student;
    }
}
