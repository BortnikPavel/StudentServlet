package models.dao;

import models.connector.Connector;
import models.pojo.Student;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDao {

    private static Logger logger = Logger.getLogger(UserDAO.class);

    private static String SQL_STUDENT_BY_ID = "SELECT * FROM students WHERE id = ?";
    private static String SQL_ALL_STUDENTS = "SELECT * FROM students";
    private static final String SQL_UPDATE_STUDENT = "UPDATE students SET name = ?, birthday = ?, sex = ? " +
            "where id = ?";

    //update students set name = "Paha", birthday = "3.4.1988", sex = "man" where id = 1
    public static ArrayList<Student> getAllStudents() {
        ArrayList<Student> studentsList = new ArrayList<>();
        try {
            Connection connection = Connector.getConnectionDB();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_ALL_STUDENTS);

            while (resultSet.next()) {
                logger.debug(resultSet.getString("name"));

                Student student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("birthday"),
                        resultSet.getString("sex")
                );
                studentsList.add(student);
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return studentsList;
    }

    public static Student getStudentById(int id) {
        Student student = new Student();
        Connection connection = Connector.getConnectionDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_STUDENT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setBirthday(resultSet.getString("birthday"));
                student.setSex(resultSet.getString("sex"));
            }
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Student updateStudent(Student student) {
        Connection connection = Connector.getConnectionDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_STUDENT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getBirthday());
            preparedStatement.setString(3, student.getSex());
            preparedStatement.setInt(4, student.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getStudentById(student.getId());
    }

    public static void deleteStudent(int id) {
        Connection connection = Connector.getConnectionDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM students where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}